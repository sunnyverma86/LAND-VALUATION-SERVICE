package com.areap2.serviceImpl;

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

import com.areap2.entity.excel.external.LandDataXlsParameter;
import com.areap2.entity.excel.external.LandDataXlsPropertyMeasurement;
import com.areap2.entity.excel.external.LandDataXlsPropertyOriginal;
import com.areap2.repository.excel.external.LandDataExcelParameterRepository;
import com.areap2.repository.excel.external.LandDataXlsPropertyMeasurementRepository;
import com.areap2.repository.excel.external.LandDataXlsPropertyOriginalRepository;

import jakarta.transaction.Transactional;

@Service
public class LandDataXlsPropertyOriginalPhaseOneService {

	private static final Logger log = LoggerFactory.getLogger(LandDataXlsPropertyOriginalPhaseOneService.class);

	private static final int PAGE_SIZE = 15000;

	@Autowired
	private LandDataXlsPropertyMeasurementRepository measurementRepository;

	@Autowired
	private LandDataExcelParameterRepository landDataExcelParameterRepository;

	@Autowired
	private LandDataXlsPropertyOriginalRepository originalRepository;

	@Transactional
	public void migrateData() {

		log.info("Land Data Migration Started");

		int pageNumber = 0;
		long totalProcessed = 0;

		try {

			Page<LandDataXlsPropertyMeasurement> page;

			do {

				Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
				page = measurementRepository.findAll(pageable);

				List<LandDataXlsPropertyOriginal> batchList = new ArrayList<>();

				for (LandDataXlsPropertyMeasurement src : page.getContent()) {

					try {

						LandDataXlsPropertyOriginal dest = transform(src);

						if (dest != null) {
							batchList.add(dest);
						}

					} catch (Exception e) {

						log.error("Error processing NIC Code: {}", src.getNicCode(), e);
					}
				}

				if (!batchList.isEmpty()) {

					originalRepository.saveAll(batchList);

					totalProcessed += batchList.size();

					log.info("Batch saved. Records processed so far: {}", totalProcessed);
				}

				pageNumber++;

			} while (page.hasNext());

			log.info("Land Data Migration Completed. Total Records Inserted: {}", totalProcessed);

		} catch (Exception e) {

			log.error("Migration failed due to unexpected error", e);

			throw new RuntimeException("Land data migration failed", e);
		}
	}

	/**
	 * Convert source entity to destination entity
	 */
	private LandDataXlsPropertyOriginal transform(LandDataXlsPropertyMeasurement src) {

		String nic = src.getNicCode();

		if (nic == null || nic.length() < 14) {

			log.warn("Invalid NIC code found: {}", nic);
			return null;
		}

		LandDataXlsPropertyOriginal dest = new LandDataXlsPropertyOriginal();

		dest.setNicCode(nic);
		dest.setTextParcel(src.getTextParcel());
		dest.setLandArea(src.getLandArea());
		dest.setRuralUrban(src.getRuralUrban());

		try {

			dest.setVillageCode(nic.substring(nic.length() - 5));
			dest.setLotCode(nic.substring(nic.length() - 7, nic.length() - 5));
			dest.setMouzaCode(nic.substring(nic.length() - 9, nic.length() - 7));
			dest.setCircleCode(nic.substring(nic.length() - 11, nic.length() - 9));
			dest.setSubDivisionCode(nic.substring(nic.length() - 13, nic.length() - 11));
			dest.setDistrictCode(nic.substring(0, nic.length() - 13));

		} catch (Exception e) {

			log.error("Error extracting codes from NIC: {}", nic, e);
			return null;
		}

		dest.setCreatedBy("SYSTEM");
		dest.setUpdatedBy("SYSTEM");
		dest.setCreateDtm(LocalDateTime.now());
		dest.setUpdateDtm(LocalDateTime.now());
		dest.setStatus("ACTIVE");

		return dest;
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
	                .collect(Collectors.toMap(
	                        p -> p.getNicCode().trim() + "_" + p.getTextParcel().trim(),
	                        p -> p,
	                        (existing, replacement) -> existing
	                ));

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
	                    log.warn("Skipping record due to NULL values | NIC: {} | TextParcel: {}", 
	                             orig.getNicCode(), orig.getTextParcel());
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
	
	@Transactional
	public void migrateLandDataPhaseii() {
	    log.info("========== START :: Phase II Update ==========");

	    int pageNumber = 0;
	    long totalProcessed = 0;
	    long totalUpdated = 0;

	    try {
	        // 1️⃣ Load parameter table into memory with normalized keys
	        log.info("Loading parameter table into memory...");

	        Map<String, LandDataXlsParameter> parameterMap = landDataExcelParameterRepository.findAll().stream()
	            .filter(p -> p.getNicCode() != null && p.getTextParcel() != null)
	            .collect(Collectors.toMap(
	                p -> normalizeKey(p.getNicCode(), p.getTextParcel()),
	                p -> p,
	                (existing, replacement) -> existing // keep first if duplicates
	            ));

	        log.info("Parameter Map Loaded Successfully. Total Records: {}", parameterMap.size());

	        // 2️⃣ Paging through original records
	        Page<LandDataXlsPropertyOriginal> page;
	        List<LandDataXlsPropertyOriginal> batchList = new ArrayList<>();

	        do {
	            Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
	            page = originalRepository.findAll(pageable);

	            log.info("Processing Page: {} | Records in page: {}", pageNumber, page.getNumberOfElements());

	            for (LandDataXlsPropertyOriginal orig : page.getContent()) {
	                totalProcessed++;

	                try {
	                    if (orig.getNicCode() == null || orig.getTextParcel() == null) {
	                        log.warn("Skipping record due to NULL values | NIC: {} | TextParcel: {}",
	                                 orig.getNicCode(), orig.getTextParcel());
	                        continue;
	                    }

	                    // 3️⃣ Normalize and check for match
	                    String key = normalizeKey(orig.getNicCode(), orig.getTextParcel());
	                    LandDataXlsParameter param = parameterMap.get(key);

	                    if (param != null) {
	                        // 4️⃣ Update attributes
	                        orig.setDistPwd(param.getDistPwd());
	                        orig.setDistTr(param.getDistTr());
	                        orig.setDistPrk(param.getDistPrk());
	                        orig.setDisWtrLg(param.getDisWtrLg());
	                        orig.setdUrMjcbd(param.getdUrMjcbd());
	                        orig.setdUrMncbd(param.getdUrMncbd());
	                        orig.setdRlMjcbd(param.getdRlMjcbd());

	                        batchList.add(orig);
	                        totalUpdated++;
	                    } else {
	                        log.debug("No parameter found for key: {}", key);
	                    }

	                    // 5️⃣ Batch insert/update
	                    if (batchList.size() >= 10000) {
	                        originalRepository.saveAll(batchList);
	                        originalRepository.flush();
	                        batchList.clear();
	                        log.info("Batch Updated | Total Updated: {}", totalUpdated);
	                    }

	                } catch (Exception e) {
	                    log.error("Error processing NIC: {}", orig.getNicCode(), e);
	                }
	            }

	            pageNumber++;

	        } while (page.hasNext());

	        // 6️⃣ Final batch update
	        if (!batchList.isEmpty()) {
	            originalRepository.saveAll(batchList);
	            originalRepository.flush();
	            log.info("Final Batch Updated: {}", batchList.size());
	        }

	        log.info("========== END :: Phase II Update ==========");
	        log.info("Total Processed Records: {}", totalProcessed);
	        log.info("Total Records Updated: {}", totalUpdated);

	    } catch (Exception e) {
	        log.error("Phase II Update Failed", e);
	        throw new RuntimeException("Phase II Update Failed", e);
	    }
	}

	/**
	 * Normalizes NIC and TextParcel to build a reliable key.
	 */
	private String normalizeKey(String nicCode, String textParcel) {
	    if (nicCode == null || textParcel == null) return null;
	    
	    // Remove .0 suffix and trim spaces
	    String parcelNormalized = textParcel.replaceAll("\\.0+$", "").trim();
	    String nicNormalized = nicCode.trim();
	    
	    return nicNormalized + "_" + parcelNormalized;
	}
}