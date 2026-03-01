package com.areap2.excel.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.areap2.excel.dto.SlabRangeDTO;
import com.areap2.excel.dto.SlabRequestDTO;
import com.areap2.excel.dto.SlabResponseDTO;
import com.areap2.excel.entity.DistanceType;
import com.areap2.excel.entity.SlabDetail;
import com.areap2.excel.entity.SlabGroup;
import com.areap2.excel.repository.DistanceTypeRepository;
import com.areap2.excel.repository.SlabDetailRepository;
import com.areap2.excel.repository.SlabGroupRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class SlabService {

	private final SlabGroupRepository slabGroupRepository;
	private final SlabDetailRepository slabDetailRepository;
	private final DistanceTypeRepository distanceTypeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	// ===============================
	// CREATE + APPLY SLAB
	// ===============================
	public String applySlabFromJson(SlabRequestDTO request) {

		log.info("=========== SLAB CREATION STARTED ===========");
		log.info("District: {}, DistanceType: {}, SlabCount: {}", request.getDistrict(), request.getDistanceTypeCode(),
				request.getSlabs() != null ? request.getSlabs().size() : 0);

		validateRequest(request);

		DistanceType type = distanceTypeRepository.findByCodeIgnoreCaseAndActiveTrue(request.getDistanceTypeCode())
				.orElseGet(() -> {

					log.warn("Distance type not found. Creating new entry for code: {}", request.getDistanceTypeCode());

					DistanceType newType = new DistanceType();
					newType.setCode(request.getDistanceTypeCode());
					newType.setColumnName(generateColumnName(request.getDistanceTypeCode()));
					newType.setActive(true);

					return distanceTypeRepository.save(newType);
				});

		deactivateOldSlab(request.getDistrict(), type);

		int newVersion = createNewSlabGroup(request, type);

		saveSlabDetails(request);

		int updatedRows = updateDynamicSlab(request);

		log.info("=========== SLAB CREATION COMPLETED ===========");
		log.info("Version: {} | Records Updated: {}", newVersion, updatedRows);

		return "Slab Created Successfully | Version: " + newVersion + " | Records Updated: " + updatedRows;
	}

	// ===============================
	// VALIDATION
	// ===============================
	private void validateRequest(SlabRequestDTO request) {

		if (request.getSlabs() == null || request.getSlabs().isEmpty()) {
			throw new RuntimeException("Slab list cannot be empty");
		}

		request.getSlabs().sort(Comparator.comparing(SlabRangeDTO::getMinValue));

		for (int i = 0; i < request.getSlabs().size() - 1; i++) {
			SlabRangeDTO current = request.getSlabs().get(i);
			SlabRangeDTO next = request.getSlabs().get(i + 1);

			if (current.getMaxValue() >= next.getMinValue()) {
				throw new RuntimeException("Slabs overlapping detected");
			}
		}

		log.info("Slab validation passed");
	}

	// ===============================
	// DEACTIVATE OLD VERSION
	// ===============================
	private void deactivateOldSlab(String district, DistanceType type) {

		slabGroupRepository.findByDistrictAndDistanceTypeAndActiveTrue(district, type).ifPresent(old -> {
			log.info("Deactivating old slab version: {}", old.getVersionNo());
			old.setActive(false);
			slabGroupRepository.save(old);
		});
	}

	// ===============================
	// CREATE NEW SLAB GROUP
	// ===============================
	private int createNewSlabGroup(SlabRequestDTO request, DistanceType type) {

		Integer maxVersion = slabGroupRepository.findMaxVersion(request.getDistrict(), type);

		if (maxVersion == null)
			maxVersion = 0;

		int newVersion = maxVersion + 1;

		SlabGroup group = new SlabGroup();
		group.setDistrict(request.getDistrict());
		group.setDistanceType(type);
		group.setParameterName(request.getParameterName());
		group.setAreaType(request.getAreaType());
		group.setPerpetual(request.getPerpetual());
		group.setBand(request.getBand());
		group.setVersionNo(newVersion);
		group.setActive(true);
		group.setCreatedBy(request.getCreatedBy());
		group.setCreatedDtm(LocalDateTime.now());

		slabGroupRepository.save(group);

		log.info("New slab group created with ID: {} Version: {}", group.getId(), newVersion);

		return newVersion;
	}

	// ===============================
	// SAVE SLAB DETAILS
	// ===============================
	private void saveSlabDetails(SlabRequestDTO request) {

		SlabGroup activeGroup = slabGroupRepository
				.findByDistrictAndDistanceTypeAndActiveTrue(request.getDistrict(),
						distanceTypeRepository.findByCodeAndActiveTrue(request.getDistanceTypeCode()).orElseThrow())
				.orElseThrow();

		for (SlabRangeDTO slab : request.getSlabs()) {

			SlabDetail detail = new SlabDetail();
			detail.setSlabGroup(activeGroup);
			detail.setMinValue(slab.getMinValue());
			detail.setMaxValue(slab.getMaxValue());
			detail.setSlabLabel(slab.getMinValue() + "-" + slab.getMaxValue());
			detail.setPriceValue(slab.getPriceValue());

			slabDetailRepository.save(detail);

			log.info("Saved Slab: {}-{} Price: {}", slab.getMinValue(), slab.getMaxValue(), slab.getPriceValue());
		}
	}

	// ===============================
	// COLUMN MAPPING
	// ===============================
	private Map<String, String[]> getColumnMapping() {

		Map<String, String[]> map = new HashMap<>();

		map.put("CBD", new String[] { "d_rl_cbd", "d_rl_cbd_slab", "d_rl_cbd_price_value" });

		map.put("DISSWGPL", new String[] { "dis_swg_pl", "dis_swg_pl_slab", "dis_swg_pl_price_value" });

		return map;
	}

	// ===============================
	// DYNAMIC UPDATE
	// ===============================
	private int updateDynamicSlab(SlabRequestDTO request) {

		Map<String, String[]> mapping = getColumnMapping();

		if (!mapping.containsKey(request.getDistanceTypeCode())) {
			throw new RuntimeException("Invalid Distance Type Code");
		}

		String[] columns = mapping.get(request.getDistanceTypeCode());

		String sourceColumn = columns[0];
		String slabColumn = columns[1];
		String priceColumn = columns[2];

		int totalUpdated = 0;

		for (SlabRangeDTO slab : request.getSlabs()) {

			String sql = """
					UPDATE areap2landvaluation.areap2_land_data_excel
					SET %s = :slabLabel,
					    %s = :priceValue
					WHERE %s BETWEEN :minVal AND :maxVal
					AND district = :district
					""".formatted(slabColumn, priceColumn, sourceColumn);

			var query = entityManager.createNativeQuery(sql);
			query.setParameter("slabLabel", slab.getMinValue() + "-" + slab.getMaxValue());
			query.setParameter("priceValue", slab.getPriceValue());
			query.setParameter("minVal", slab.getMinValue());
			query.setParameter("maxVal", slab.getMaxValue());
			query.setParameter("district", request.getDistrict());

			int updated = query.executeUpdate();
			totalUpdated += updated;

			log.info("Updated rows for slab {}-{}: {}", slab.getMinValue(), slab.getMaxValue(), updated);
		}

		return totalUpdated;
	}

	public SlabResponseDTO getActiveSlabs(String district, String distanceTypeCode) {

		log.info("Fetching active slabs for District = {}, DistanceType = {}", district, distanceTypeCode);

		DistanceType type = distanceTypeRepository.findByCodeAndActiveTrue(distanceTypeCode)
				.orElseThrow(() -> new RuntimeException("Distance Type not found"));

		SlabGroup group = slabGroupRepository.findByDistrictAndDistanceTypeAndActiveTrue(district, type)
				.orElseThrow(() -> new RuntimeException("Active slab not found"));

		List<SlabDetail> slabDetails = slabDetailRepository.findBySlabGroup(group);

		List<SlabRangeDTO> slabDTOs = slabDetails.stream()
				.map(detail -> new SlabRangeDTO(detail.getMinValue(), detail.getMaxValue(), detail.getPriceValue()))
				.toList();

		SlabResponseDTO response = new SlabResponseDTO();
		response.setDistrict(group.getDistrict());
		response.setDistanceTypeCode(distanceTypeCode);
		response.setParameterName(group.getParameterName());
		response.setAreaType(group.getAreaType());
		response.setPerpetual(group.isPerpetual());
		response.setBand(group.getBand());
		response.setVersion(group.getVersionNo());
		response.setSlabs(slabDTOs);

		log.info("Active slab version {} fetched successfully", group.getVersionNo());

		return response;
	}

	private String generateColumnName(String code) {
		return switch (code.toUpperCase()) {
		case "DISSWGPL" -> "dis_swg_pl";
		case "CBD" -> "d_rl_cbd";
		default -> code.toLowerCase();
		};
	}
}