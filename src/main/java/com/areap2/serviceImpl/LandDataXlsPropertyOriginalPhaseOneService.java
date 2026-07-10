package com.areap2.serviceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.areap2.entity.excel.external.DistrictMinimumEntity;
import com.areap2.entity.excel.external.GeographicalFactorEntity;
import com.areap2.entity.excel.external.LandDataXlsParameter;
import com.areap2.entity.excel.external.LandDataXlsPropertyMeasurement;
import com.areap2.entity.excel.external.LandDataXlsPropertyOriginal;
import com.areap2.entity.excel.external.LandUseFactorEntity;
import com.areap2.repository.excel.external.DistrictMinimumRepository;
import com.areap2.repository.excel.external.GeographicalFactorRepository;
import com.areap2.repository.excel.external.LandDataExcelParameterRepository;
import com.areap2.repository.excel.external.LandDataXlsPropertyMeasurementRepository;
import com.areap2.repository.excel.external.LandDataXlsPropertyOriginalRepository;
import com.areap2.repository.excel.external.LandUseFactorRepository;

import jakarta.transaction.Transactional;

@Service
public class LandDataXlsPropertyOriginalPhaseOneService {

	private static final Logger log = LoggerFactory.getLogger(LandDataXlsPropertyOriginalPhaseOneService.class);

	private static final int PAGE_SIZE = 25000;
	private static final int BATCH_SIZE = 25000;

	@Autowired
	private LandDataXlsPropertyMeasurementRepository measurementRepository;

	@Autowired
	private LandDataExcelParameterRepository landDataExcelParameterRepository;

	@Autowired
	private LandDataXlsPropertyOriginalRepository originalRepository;

	@Autowired
	private DistrictMinimumRepository districtMinimumRepository;

	@Autowired
	private GeographicalFactorRepository geographicalFactorRepository;

	@Autowired
	private LandUseFactorRepository landUseFactorRepository;

	public void migrateData() {

		log.info("🚀 Land Data Migration Started");

		int pageNumber = 0;
		long totalProcessed = 0;

		List<LandDataXlsPropertyOriginal> batchList = new ArrayList<>(BATCH_SIZE);

		Page<LandDataXlsPropertyMeasurement> page;

		try {
			do {
				Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);

				// 🔥 FETCH PAGE (fast read-only query recommended)
				page = measurementRepository.findAll(pageable);

				List<LandDataXlsPropertyMeasurement> content = page.getContent();

				// 🚀 FAST LOOP (NO parallelStream)
				for (int i = 0; i < content.size(); i++) {

					LandDataXlsPropertyMeasurement src = content.get(i);

					try {
						LandDataXlsPropertyOriginal dest = transform(src);

						if (dest != null) {
							batchList.add(dest);
						}

					} catch (Exception e) {
						log.error("Error processing NIC: {}", src.getNicCode(), e);
					}

					// 🔥 Batch insert condition
					if (batchList.size() >= BATCH_SIZE) {
						totalProcessed += saveBatch(batchList);
						batchList.clear();

						log.info("✅ Batch committed. Total processed: {}", totalProcessed);
					}
				}

				pageNumber++;

			} while (page.hasNext());

			// 🔥 Final flush
			if (!batchList.isEmpty()) {
				totalProcessed += saveBatch(batchList);
			}

			log.info("🎯 Migration Completed. Total Records: {}", totalProcessed);

		} catch (Exception e) {
			log.error("❌ Migration failed", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 🔥 BULK SAVE OPTIMIZED
	 */
	@Transactional
	public long saveBatch(List<LandDataXlsPropertyOriginal> batch) {

		originalRepository.saveAll(batch);

		// flush only per batch (important for performance)
		originalRepository.flush();

		return batch.size();
	}

	/**
	 * 🔥 FAST TRANSFORMATION
	 */
	private LandDataXlsPropertyOriginal transform(LandDataXlsPropertyMeasurement src) {

		String nic = normalizeNicCode(src.getNicCode());
		if (nic == null)
			return null;

		LandDataXlsPropertyOriginal dest = new LandDataXlsPropertyOriginal();

		dest.setNicCode(nic);
		dest.setTextParcel(src.getTextParcel());
		dest.setLandArea(src.getLandArea());
		dest.setRuralUrban(src.getRuralUrban());
		dest.setDistrict(src.getDist());

		// 🔥 FAST substring (avoid repeated length calls)
		int len = nic.length();

		dest.setVillageCode(nic.substring(len - 5));
		dest.setLotCode(nic.substring(len - 7, len - 5));
		dest.setMouzaCode(nic.substring(len - 9, len - 7));
		dest.setCircleCode(nic.substring(len - 11, len - 9));
		dest.setSubDivisionCode(nic.substring(len - 13, len - 11));
		dest.setDistrictCode(nic.substring(0, len - 13));

		dest.setTotalLandArea(convertToBigha(src.getLandArea()));

		dest.setLandUse(src.getLanduse());
		dest.setCreatedBy("SYSTEM");
		dest.setUpdatedBy("SYSTEM");

		// 🔥 reuse same timestamp for speed
		LocalDateTime now = LocalDateTime.now();
		dest.setCreateDtm(now);
		dest.setUpdateDtm(now);

		dest.setStatus("ACTIVE");

		return dest;
	}

	/**
	 * 🔥 FAST NIC NORMALIZATION
	 */
	private String normalizeNicCode(String nic) {

		if (nic == null)
			return null;

		nic = nic.trim();
		int len = nic.length();

		if (len == 15)
			return nic;
		if (len == 14)
			return "0" + nic;

		if (len == 13) {
			return null; // avoid fake string (better skip)
		}

		return null;
	}

	/**
	 * 🔥 FAST LAND CONVERSION
	 */
	private BigDecimal convertToBigha(String landArea) {

		if (landArea == null || landArea.isEmpty()) {
			return BigDecimal.ZERO;
		}

		try {
			String cleaned = landArea.toLowerCase().replace("b", "").replace("k", "").replace("lc", "");

			String[] parts = cleaned.split("-");

			if (parts.length != 3)
				return BigDecimal.ZERO;

			BigDecimal bigha = new BigDecimal(parts[0]);
			BigDecimal katha = new BigDecimal(parts[1]);
			BigDecimal lecha = new BigDecimal(parts[2]);

			return bigha.add(katha.multiply(new BigDecimal("0.05"))).add(lecha.multiply(new BigDecimal("0.0025")))
					.setScale(8, RoundingMode.HALF_UP);

		} catch (Exception e) {
			return BigDecimal.ZERO;
		}
	}

	private BigDecimal OldconvertToBigha(String landArea) {

		if (landArea == null || landArea.isEmpty()) {
			return BigDecimal.ZERO;
		}

		try {
			// Example: "6b-0k-11.0000lc"
			String cleaned = landArea.toLowerCase().replace("b", "").replace("k", "").replace("lc", "");

			String[] parts = cleaned.split("-");

			BigDecimal bigha = new BigDecimal(parts[0]);
			BigDecimal katha = new BigDecimal(parts[1]);
			BigDecimal lecha = new BigDecimal(parts[2]);

			// Conversion constants
			BigDecimal KATHA_TO_BIGHA = new BigDecimal("0.05"); // 1/20
			BigDecimal LECHA_TO_BIGHA = new BigDecimal("0.0025"); // 1/400

			// Convert
			BigDecimal kathaInBigha = katha.multiply(KATHA_TO_BIGHA);
			BigDecimal lechaInBigha = lecha.multiply(LECHA_TO_BIGHA);

			BigDecimal totalBigha = bigha.add(kathaInBigha).add(lechaInBigha);

			// ✅ Precision handling (important for accuracy)
			totalBigha = totalBigha.setScale(8, RoundingMode.HALF_UP);

			// ✅ Logging
			log.info("Original: {}", landArea);
			log.info("Parsed -> Bigha: {}, Katha: {}, Lecha: {}", bigha, katha, lecha);
			log.info("Converted -> Katha in Bigha: {}", kathaInBigha);
			log.info("Converted -> Lecha in Bigha: {}", lechaInBigha);
			log.info("Total Bigha: {}", totalBigha);

			return totalBigha;

		} catch (Exception e) {
			log.error("Error parsing landArea: {}", landArea, e);
			return BigDecimal.ZERO;
		}
	}

	@Transactional
	public void migrateLandDataPhaseiiOld() {
		log.info("========== START :: Phase II Update ==========");

		int pageNumber = 0;
		long totalProcessed = 0;
		long totalUpdated = 0;

		try {
			log.info("Loading parameter table into memory...");

			// Load all parameters in memory for fast lookup
			Map<String, LandDataXlsParameter> parameterMap = landDataExcelParameterRepository.findAll().stream()
					.filter(p -> p.getNicCode() != null && p.getTextParcel() != null)
					.collect(Collectors.toMap(p -> p.getNicCode().trim() + "_" + p.getTextParcel().trim(), p -> p,
							(existing, replacement) -> existing));

			log.info("Parameter Map Loaded Successfully. Total Records: {}", parameterMap.size());

			Page<LandDataXlsPropertyOriginal> page;
			List<LandDataXlsPropertyOriginal> batchList = new ArrayList<>();

			do {
				Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
				page = originalRepository.findAll(pageable); // Fetch from land_data_original

				log.info("Processing Page: {} | Records in page: {}", pageNumber, page.getNumberOfElements());

				for (LandDataXlsPropertyOriginal orig : page.getContent()) {
					totalProcessed++;

					if (orig.getNicCode() == null || orig.getTextParcel() == null) {
						log.warn("Skipping record due to NULL values | NIC: {} | TextParcel: {}", orig.getNicCode(),
								orig.getTextParcel());
						continue;
					}

					String key = orig.getNicCode().trim() + "_" + orig.getTextParcel().trim();
					LandDataXlsParameter param = parameterMap.get(key);

					if (param != null) {
						// Update only the required fields
						orig.setDistPwd(param.getDistPwd());
						orig.setDistTr(param.getDistTr());
						orig.setDistPrk(param.getDistPrk());
						orig.setDisWtrLg(param.getDisWtrLg());
						orig.setdUrMjcbd(param.getdUrMjcbd());
						orig.setdUrMncbd(param.getdUrMncbd());
						orig.setdRlMjcbd(param.getdRlMjcbd());

						// Update audit fields
						orig.setUpdatedBy("SYSTEM");
						orig.setUpdateDtm(LocalDateTime.now());

						batchList.add(orig);
						totalUpdated++;
					}

					// Batch save every 1000 records
					if (batchList.size() >= 1000) {
						originalRepository.saveAll(batchList);
						originalRepository.flush();
						log.info("Batch Updated | Total Updated: {}", totalUpdated);
						batchList.clear();
					}
				}

				pageNumber++;

			} while (page.hasNext());

			// Final batch save
			if (!batchList.isEmpty()) {
				originalRepository.saveAll(batchList);
				originalRepository.flush();
				log.info("Final Batch Updated | Records: {}", batchList.size());
			}

			log.info("========== END :: Phase II Update ==========");
			log.info("Total Processed Records: {}", totalProcessed);
			log.info("Total Records Updated: {}", totalUpdated);

		} catch (Exception e) {
			log.error("Phase II Update Failed", e);
			throw new RuntimeException("Phase II Update Failed", e);
		}
	}

//	@Transactional
//	public void migrateLandDataPhaseii() {
//		log.info("========== START :: Phase II Update ==========");
//
//		int pageNumber = 0;
//		long totalProcessed = 0;
//		long totalUpdated = 0;
//
//		try {
//			// 1️⃣ Load parameter table into memory with normalized keys
//			log.info("Loading parameter table into memory...");
//
//			Map<String, LandDataXlsParameter> parameterMap = landDataExcelParameterRepository.findAll().stream()
//					.filter(p -> p.getNicCode() != null && p.getTextParcel() != null)
//					.collect(Collectors.toMap(p -> normalizeKey(p.getNicCode(), p.getTextParcel()), p -> p,
//							(existing, replacement) -> existing // keep first if duplicates
//					));
//
//			log.info("Parameter Map Loaded Successfully. Total Records: {}", parameterMap.size());
//
//			// 2️⃣ Paging through original records
//			Page<LandDataXlsPropertyOriginal> page;
//			List<LandDataXlsPropertyOriginal> batchList = new ArrayList<>();
//
//			do {
//				Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
//				page = originalRepository.findAll(pageable);
//
//				log.info("Processing Page: {} | Records in page: {}", pageNumber, page.getNumberOfElements());
//
//				for (LandDataXlsPropertyOriginal orig : page.getContent()) {
//					totalProcessed++;
//
//					try {
//						if (orig.getNicCode() == null || orig.getTextParcel() == null) {
//							log.warn("Skipping record due to NULL values | NIC: {} | TextParcel: {}", orig.getNicCode(),
//									orig.getTextParcel());
//							continue;
//						}
//
//						// 3️⃣ Normalize and check for match
//						String key = normalizeKey(orig.getNicCode(), orig.getTextParcel());
//						LandDataXlsParameter param = parameterMap.get(key);
//
//						if (param != null) {
//							// 4️⃣ Update attributes
//							orig.setDistPwd(param.getDistPwd());
//							orig.setDistTr(param.getDistTr());
//							orig.setDistPrk(param.getDistPrk());
//							orig.setDisWtrLg(param.getDisWtrLg());
//							orig.setdUrMjcbd(param.getdUrMjcbd());
//							orig.setdUrMncbd(param.getdUrMncbd());
//							orig.setdRlMjcbd(param.getdRlMjcbd());
//							
//							String nicCodeForMouza = extractNicCodeForMouza(orig.getNicCode());
//							orig.setNicCodeForMouza(nicCodeForMouza);
//
//							String nicCodeForDistrict = extractNicCodeForDistrict(orig.getNicCode());
//							orig.setNicCodeForDistrict(nicCodeForMouza);
//							
//							String nicForPlotCode = generateNicForPlotCode(orig.getNicCode(), orig.getTextParcel());
//							orig.setNicForPlotCode(nicForPlotCode);
//
//							List<DistrictMinimumEntity> listDistrictMinimumEntity = districtMinimumRepository.findAll();
//							for (DistrictMinimumEntity dme : listDistrictMinimumEntity) {
//								dme.getNicCodeForDistrict().equalsIgnoreCase(key);
//							}
//
////							List<LandUseFactorEntity> listLandUseFactorEntity = landUseFactorRepository.findAll();
////							for (LandUseFactorEntity ll : listLandUseFactorEntity) {
////								ll.getLandUse();
////								;
////								ll.getRuralUrban();
////								// match with both values with
////								orig.getLandUse();
////								orig.getRuralUrban();
////								// if both are same than insert the value
////								orig.setDistrictMinimum(BigDecimal.valueOf(ll.getFactor()));
////
////							}
////							orig.setDistrictMinimum(null);
//
//							Map<String, LandUseFactorEntity> landUseMap = landUseFactorRepository.findAll().stream()
//									.filter(l -> l.getLandUse() != null && l.getRuralUrban() != null)
//									.collect(Collectors.toMap(l -> normalizeKey(l.getLandUse(), l.getRuralUrban()),
//											l -> l, (existing, replacement) -> existing));
//
//							String nicCodeForDistrictVa = extractNicCodeForDistrict(orig.getNicCode());
//							orig.setNicCodeForDistrict(nicCodeForDistrict);
//
//							BigDecimal districtMin = getDistrictMinimumValue(
//							        orig.getNicCodeForDistrict(),
//							        orig.getRuralUrban(),
//							        districtMap
//							);
//
//							orig.setDistrictMinimum(districtMin);
//
//							log.info("LandUse Map Loaded Successfully. Size: {}", landUseMap.size());
//
//							batchList.add(orig);
//							totalUpdated++;
//						} else {
//							log.debug("No parameter found for key: {}", key);
//						}
//
//						// 5️⃣ Batch insert/update
//						if (batchList.size() >= 10000) {
//							originalRepository.saveAll(batchList);
//							originalRepository.flush();
//							batchList.clear();
//							log.info("Batch Updated | Total Updated: {}", totalUpdated);
//						}
//
//					} catch (Exception e) {
//						log.error("Error processing NIC: {}", orig.getNicCode(), e);
//					}
//				}
//
//				pageNumber++;
//
//			} while (page.hasNext());
//
//			// 6️⃣ Final batch update
//			if (!batchList.isEmpty()) {
//				originalRepository.saveAll(batchList);
//				originalRepository.flush();
//				log.info("Final Batch Updated: {}", batchList.size());
//			}
//
//			log.info("========== END :: Phase II Update ==========");
//			log.info("Total Processed Records: {}", totalProcessed);
//			log.info("Total Records Updated: {}", totalUpdated);
//
//		} catch (Exception e) {
//			log.error("Phase II Update Failed", e);
//			throw new RuntimeException("Phase II Update Failed", e);
//		}
//	}

	@Transactional
	public void migrateLandDataPhaseii() {

		log.info("========== START :: Phase II Update ==========");

		int pageNumber = 0;
		long totalProcessed = 0;
		long totalUpdated = 0;

		try {

			// ================================
			// 1️⃣ Load All Maps (ONE TIME)
			// ================================
			log.info("Loading all master tables into memory...");

			Map<String, LandDataXlsParameter> parameterMap = landDataExcelParameterRepository.findAll().stream()
					.filter(p -> p.getNicCode() != null && p.getTextParcel() != null).collect(Collectors
							.toMap(p -> normalizeKey(p.getNicCode(), p.getTextParcel()), p -> p, (a, b) -> a));

			Map<String, DistrictMinimumEntity> districtMap = districtMinimumRepository.findAll().stream()
					.filter(d -> d.getNicCodeForDistrict() != null && d.getRuralUrban() != null)
					.collect(Collectors.toMap(d -> normalizeKey(d.getNicCodeForDistrict(), d.getRuralUrban()), d -> d,
							(a, b) -> a));

			Map<String, LandUseFactorEntity> landUseMap = landUseFactorRepository.findAll().stream()
					.filter(l -> l.getLandUse() != null && l.getRuralUrban() != null).collect(Collectors
							.toMap(l -> normalizeKey(l.getLandUse(), l.getRuralUrban()), l -> l, (a, b) -> a));

			Map<String, GeographicalFactorEntity> geoMap = geographicalFactorRepository.findAll().stream()
					.filter(g -> g.getNicCodeForMouza() != null && g.getRuralUrban() != null).collect(Collectors
							.toMap(g -> normalizeKey(g.getNicCodeForMouza(), g.getRuralUrban()), g -> g, (a, b) -> a));

			log.info("Maps Loaded | Param: {} | District: {} | LandUse: {} | Geo: {}", parameterMap.size(),
					districtMap.size(), landUseMap.size(), geoMap.size());

			// ================================
			// 2️⃣ Paging Loop
			// ================================
			Page<LandDataXlsPropertyOriginal> page;
			List<LandDataXlsPropertyOriginal> batchList = new ArrayList<>();

			do {

				Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
				page = originalRepository.findAll(pageable);

				log.info("Processing Page: {} | Records: {}", pageNumber, page.getNumberOfElements());

				for (LandDataXlsPropertyOriginal orig : page.getContent()) {

					totalProcessed++;

					try {

						if (orig.getNicCode() == null || orig.getTextParcel() == null) {
							continue;
						}

						// ================================
						// Parameter Matching
						// ================================
						String key = normalizeKey(orig.getNicCode(), orig.getTextParcel());
						LandDataXlsParameter param = parameterMap.get(key);

						if (param == null) {
							continue;
						}

						// ================================
						// Basic Updates
						// ================================
						updateBasicFields(orig, param);//working

						// ================================
						// Derived Fields
						// ================================
						populateDerivedFields(orig);

						// ================================
						// Factor Calculations
						// ================================
						BigDecimal districtMin = getDistrictMinimumValue(orig.getNicCodeForDistrict(),
								orig.getRuralUrban(), districtMap);

						BigDecimal landUseFactor = getLandUseFactor(orig.getLandUse(), orig.getRuralUrban(),
								landUseMap);

						BigDecimal geoFactor = getGeoFactor(orig.getNicCodeForMouza(), orig.getRuralUrban(), geoMap);

						// ================================
						// Set Values
						// ================================
						orig.setDistrictMinimum(districtMin);
						orig.setLandUseFactor(landUseFactor);
						orig.setGeographicalFactor(geoFactor);

						// ================================
						// Final Calculation (Optional)
						// ================================
						if (districtMin != null && landUseFactor != null && geoFactor != null) {
							BigDecimal finalValue = districtMin.multiply(landUseFactor).multiply(geoFactor);

							orig.setPlotBase(finalValue);
						}

						batchList.add(orig);
						totalUpdated++;

						// ================================
						// Batch Save
						// ================================
						if (batchList.size() >= 10000) {
							saveBatch(batchList, totalUpdated);
							batchList.clear();
						}

					} catch (Exception e) {
						log.error("Error processing NIC: {}", orig.getNicCode(), e);
					}
				}

				pageNumber++;

			} while (page.hasNext());

			// Final Save
			if (!batchList.isEmpty()) {
				saveBatch(batchList, totalUpdated);
			}

			log.info("========== END :: Phase II Update ==========");
			log.info("Total Processed: {}", totalProcessed);
			log.info("Total Updated: {}", totalUpdated);

		} catch (Exception e) {
			log.error("Phase II Update Failed", e);
			throw new RuntimeException(e);
		}
	}

	private void saveBatch(List<LandDataXlsPropertyOriginal> batchList, long totalUpdated) {
		originalRepository.saveAll(batchList);
		originalRepository.flush();
		log.info("Batch saved successfully | Total Updated: {}", totalUpdated);
	}

	private void updateBasicFields(LandDataXlsPropertyOriginal orig, LandDataXlsParameter param) {

		orig.setDistPwd(param.getDistPwd());//slab1
		orig.setDistTr(param.getDistTr());//slab1
		orig.setDistPrk(param.getDistPrk());//slab1
		orig.setDisWtrLg(param.getDisWtrLg());//slab1
		orig.setdUrMjcbd(param.getdUrMjcbd());//slab1
		orig.setdUrMncbd(param.getdUrMncbd());//slab1
		orig.setdRlMjcbd(param.getdRlMjcbd());//slab1
		orig.setDistrict(param.getDistrict());
	}

	private BigDecimal getGeoFactor(String mouzaCode, String ruralUrban, Map<String, GeographicalFactorEntity> geoMap) {

		if (mouzaCode == null || ruralUrban == null) {
			return null;
		}

		String key = normalizeKey(mouzaCode, ruralUrban);

		GeographicalFactorEntity entity = geoMap.get(key);

		if (entity == null || entity.getFactor() == null) {
			return null;
		}

		return BigDecimal.valueOf(entity.getFactor());
	}

	private void populateDerivedFields(LandDataXlsPropertyOriginal orig) {

		String mouza = extractNicCodeForMouza(orig.getNicCode());
		String district = extractNicCodeForDistrict(orig.getNicCode());
		String plot = generateNicForPlotCode(orig.getNicCode(), orig.getTextParcel());
		BigDecimal totalWeightParameter = calculateTotalWeight(orig);
		BigDecimal valueOfParameters = calculateValueOfParameters(totalWeightParameter, orig.getDistrictMinimum());
		BigDecimal perBighaValueOfPlot = calculatePerBighaValueOfPlot(valueOfParameters, orig.getDistrictMinimum());
		BigDecimal finalValueOfPlot = calculateFinalValueOfPlot(perBighaValueOfPlot, orig.getTotalLandArea());

		orig.setNicCodeForMouza(mouza);
		orig.setNicCodeForDistrict(district);
		orig.setNicForPlotCode(plot);
		orig.setTotalWeightParameters(totalWeightParameter);
		orig.setValueOfParameters(valueOfParameters);
		orig.setPerBighaValueOfPlot(perBighaValueOfPlot);
		orig.setFinalValueOfPlot(finalValueOfPlot);
	}

	private BigDecimal calculateFinalValueOfPlot(BigDecimal perBighaValueOfPlot, BigDecimal totalLandArea) {
		if (perBighaValueOfPlot == null || totalLandArea == null) {
			return BigDecimal.ZERO; // or return null based on your business logic
		}

		return perBighaValueOfPlot.multiply(totalLandArea);
	}

	private BigDecimal calculateValueOfParameters(BigDecimal totalWeightParameter, BigDecimal districtMinimum) {

		if (totalWeightParameter == null || districtMinimum == null) {
			return BigDecimal.ZERO; // or return null based on your business logic
		}

		return totalWeightParameter.multiply(districtMinimum);
	}

	private BigDecimal calculatePerBighaValueOfPlot(BigDecimal valueOfParameters, BigDecimal districtMinimum) {

		if (valueOfParameters == null || districtMinimum == null) {
			return BigDecimal.ZERO; // or return null based on your business logic
		}

		return valueOfParameters.multiply(districtMinimum);
	}

	private String extractNicCodeForMouza(String nicCode) {
		if (nicCode == null || nicCode.length() <= 7)
			return null;
		return nicCode.substring(0, nicCode.length() - 7);
	}

	private String extractNicCodeForDistrict(String nicCode) {

		if (nicCode == null || nicCode.length() <= 13) {
			return null;
		}

		// Step 1: remove last 13 digits
		String prefix = nicCode.substring(0, nicCode.length() - 13);

		// Step 2: convert to integer to remove leading zeros safely
		int value = Integer.parseInt(prefix);

		// Step 3: always return 2-digit format
		return String.format("%02d", value);
	}

	private BigDecimal getDistrictMinimumValue(String districtCode, String ruralUrban,
			Map<String, DistrictMinimumEntity> districtMap) {

		if (districtCode == null || ruralUrban == null) {
			return null;
		}

		DistrictMinimumEntity entity = districtMap.get(normalizeKey(districtCode, ruralUrban));

		return (entity != null) ? entity.getDistrictMinimumValue() : null;
	}

	/**
	 * Normalizes NIC and TextParcel to build a reliable key.
	 */
	private String normalizeKey(String nicCode, String textParcel) {
		if (nicCode == null || textParcel == null)
			return null;

		// Remove .0 suffix and trim spaces
		String parcelNormalized = textParcel.replaceAll("\\.0+$", "").trim();
		String nicNormalized = nicCode.trim();

		return nicNormalized + "_" + parcelNormalized;
	}

	private String generateNicForPlotCode(String nicCode, String textParcel) {
		if (nicCode == null || textParcel == null)
			return null;
		return nicCode.trim() + textParcel.trim();
	}

	private BigDecimal getLandUseFactor(String landUse, String ruralUrban,
			Map<String, LandUseFactorEntity> landUseMap) {

		if (landUse == null || ruralUrban == null) {
			return null;
		}

		LandUseFactorEntity entity = landUseMap.get(normalizeKey(landUse, ruralUrban));

		return (entity != null && entity.getFactor() != null) ? BigDecimal.valueOf(entity.getFactor()) : null;
	}

	private BigDecimal calculateTotalWeight(LandDataXlsPropertyOriginal param) {
		return (param.getDistPwdWeightage() != null ? param.getDistPwdWeightage() : BigDecimal.ZERO)
				.add(param.getDistTrWeightage() != null ? param.getDistTrWeightage() : BigDecimal.ZERO)
				.add(param.getDistPrkWeightage() != null ? param.getDistPrkWeightage() : BigDecimal.ZERO)
				.add(param.getDisWtrLgWeightage() != null ? param.getDisWtrLgWeightage() : BigDecimal.ZERO)
				.add(param.getdUrMjcbdWeightage() != null ? param.getdUrMjcbdWeightage() : BigDecimal.ZERO)
				.add(param.getdUrMncbdWeightage() != null ? param.getdUrMncbdWeightage() : BigDecimal.ZERO)
				.add(param.getdRlMjcbdWeightage() != null ? param.getdRlMjcbdWeightage() : BigDecimal.ZERO);
	}

}