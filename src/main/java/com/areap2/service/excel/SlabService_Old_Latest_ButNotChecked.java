package com.areap2.service.excel;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.areap2.dto.excel.SlabRangeDTO;
import com.areap2.dto.excel.SlabRequestDTO;
import com.areap2.dto.excel.SlabResponseDTO;
import com.areap2.entity.excel.external.DistanceType;
import com.areap2.entity.excel.external.SlabDetail;
import com.areap2.entity.excel.external.SlabGroup;
import com.areap2.repository.excel.external.DistanceTypeRepository;
import com.areap2.repository.excel.external.SlabDetailRepository;
import com.areap2.repository.excel.external.SlabGroupRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SlabService_Old_Latest_ButNotChecked {

	private static final Logger log = LoggerFactory.getLogger(SlabService_Old_Latest_ButNotChecked.class);

	@Autowired
	private SlabGroupRepository slabGroupRepository;
	@Autowired
	private SlabDetailRepository slabDetailRepository;
	@Autowired
	private DistanceTypeRepository distanceTypeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	private static final String TABLE_NAME = "areap2landvaluation.areap2_land_data_excel";

	private static final Map<String, ColumnMapping> COLUMN_MAPPING = Map.of("CBD",
			new ColumnMapping("d_rl_cbd", "d_rl_cbd_slab", "d_rl_cbd_price_value"), "DISSWGPL",
			new ColumnMapping("dis_swg_pl", "dis_swg_pl_slab", "dis_swg_pl_price_value"));

	// ============================================================
	// CREATE + APPLY SLAB
	// ============================================================
	public String applySlabFromJson(SlabRequestDTO request) {

		log.info("========== SLAB CREATION STARTED ==========");

		validateRequest(request);

		DistanceType distanceType = getOrCreateDistanceType(request.getDistanceTypeCode());

		deactivateOldSlab(request.getDistrict(), distanceType);

		SlabGroup newGroup = createNewSlabGroup(request, distanceType);

		saveSlabDetails(newGroup, request.getSlabs());

		int updatedRows = updateDynamicSlab(request, request.getSlabs());

		log.info("========== SLAB CREATION COMPLETED ==========");
		log.info("Version: {} | Records Updated: {}", newGroup.getVersionNo(), updatedRows);

		return String.format("Slab Created Successfully | Version: %d | Records Updated: %d", newGroup.getVersionNo(),
				updatedRows);
	}

	// ============================================================
	// VALIDATION
	// ============================================================
	private void validateRequest(SlabRequestDTO request) {

		if (request.getSlabs() == null || request.getSlabs().isEmpty()) {
			throw new IllegalArgumentException("Slab list cannot be empty");
		}

		request.getSlabs().sort(Comparator.comparing(SlabRangeDTO::getMinValue));

		for (int i = 0; i < request.getSlabs().size() - 1; i++) {
			SlabRangeDTO current = request.getSlabs().get(i);
			SlabRangeDTO next = request.getSlabs().get(i + 1);

			if (current.getMaxValue() >= next.getMinValue()) {
				throw new IllegalArgumentException("Slabs overlapping detected");
			}
		}

		log.info("Slab validation passed");
	}

	// ============================================================
	// DISTANCE TYPE
	// ============================================================
	private DistanceType getOrCreateDistanceType(String code) {

		return distanceTypeRepository.findByCodeIgnoreCaseAndActiveTrue(code).orElseGet(() -> {
			log.warn("Distance type not found. Creating new entry for code: {}", code);

			DistanceType newType = new DistanceType();
			newType.setCode(code.toUpperCase());
			newType.setColumnName(generateColumnName(code));
			newType.setActive(true);

			return distanceTypeRepository.save(newType);
		});
	}

	// ============================================================
	// VERSION MANAGEMENT
	// ============================================================
	private void deactivateOldSlab(String district, DistanceType type) {

		slabGroupRepository.findByDistrictAndDistanceTypeAndActiveTrue(district, type).ifPresent(existing -> {
			existing.setActive(false);
			slabGroupRepository.save(existing);
			log.info("Deactivated old slab version: {}", existing.getVersionNo());
		});
	}

	private SlabGroup createNewSlabGroup(SlabRequestDTO request, DistanceType type) {

		Integer maxVersion = slabGroupRepository.findMaxVersion(request.getDistrict(), type);
		int newVersion = (maxVersion == null ? 0 : maxVersion) + 1;

		SlabGroup group = new SlabGroup();
		group.setDistrict(request.getDistrict());
		group.setDistanceType(type);
		group.setParameterName(request.getParameterName());
		group.setAreaType(request.getAreaType());
		group.setPerpetual(request.getPerpetual());
		group.setEffectiveTill(request.getEffectiveTill());
		group.setVersionNo(newVersion);
		group.setActive(true);
		group.setCreatedBy(request.getCreatedBy());
		group.setCreatedDtm(LocalDateTime.now());

		slabGroupRepository.save(group);

		log.info("New slab group created | ID: {} | Version: {}", group.getId(), newVersion);

		return group;
	}

	// ============================================================
	// SAVE SLAB DETAILS (Batch Optimized)
	// ============================================================
	private void saveSlabDetails(SlabGroup group, List<SlabRangeDTO> slabs) {

		List<SlabDetail> details = slabs.stream().map(slab -> {
			SlabDetail detail = new SlabDetail();
			detail.setSlabGroup(group);
			detail.setMinValue(slab.getMinValue());
			detail.setMaxValue(slab.getMaxValue());
			detail.setBandNameStr(slab.getMinValue() + "-" + slab.getMaxValue());
			detail.setWeightage(slab.getWeightage());
			return detail;
		}).toList();

		slabDetailRepository.saveAll(details);

		log.info("{} slab details saved successfully", details.size());
	}

	// ============================================================
	// DYNAMIC UPDATE
	// ============================================================
	private int updateDynamicSlab(SlabRequestDTO request, List<SlabRangeDTO> slabs) {

		ColumnMapping mapping = COLUMN_MAPPING.get(request.getDistanceTypeCode().toUpperCase());

		if (mapping == null) {
			throw new IllegalArgumentException("Invalid Distance Type Code");
		}

		int totalUpdated = 0;

		for (SlabRangeDTO slab : slabs) {

			String sql = """
					UPDATE %s
					SET %s = :slabLabel,
					    %s = :priceValue
					WHERE %s BETWEEN :minVal AND :maxVal
					AND district = :district
					""".formatted(TABLE_NAME, mapping.slabColumn(), mapping.priceColumn(), mapping.sourceColumn());

			int updated = entityManager.createNativeQuery(sql)
					.setParameter("slabLabel", slab.getMinValue() + "-" + slab.getMaxValue())
					.setParameter("priceValue", slab.getWeightage()).setParameter("minVal", slab.getMinValue())
					.setParameter("maxVal", slab.getMaxValue()).setParameter("district", request.getDistrict())
					.executeUpdate();

			totalUpdated += updated;
		}

		log.info("Total updated rows: {}", totalUpdated);

		return totalUpdated;
	}

	// ============================================================
	// FETCH ACTIVE SLABS
	// ============================================================
	public SlabResponseDTO getActiveSlabs(String district, String distanceTypeCode) {

		DistanceType type = distanceTypeRepository.findByCodeAndActiveTrue(distanceTypeCode)
				.orElseThrow(() -> new IllegalArgumentException("Distance Type not found"));

		SlabGroup group = slabGroupRepository.findByDistrictAndDistanceTypeAndActiveTrue(district, type)
				.orElseThrow(() -> new IllegalArgumentException("Active slab not found"));

		List<SlabRangeDTO> slabDTOs = slabDetailRepository.findBySlabGroup(group).stream()
				.map(detail -> new SlabRangeDTO(detail.getBandNameStr(), detail.getMinValue(), detail.getMaxValue(),
						detail.getWeightage()))
				.toList();

		SlabResponseDTO response = new SlabResponseDTO();
		response.setDistrict(group.getDistrict());
		response.setDistanceTypeCode(distanceTypeCode);
		response.setParameterName(group.getParameterName());
		response.setAreaType(group.getAreaType());
		response.setPerpetual(group.isPerpetual());
		response.setBand(group.getEffectiveTill());
		response.setVersion(group.getVersionNo());
		response.setSlabs(slabDTOs);

		log.info("Active slab version {} fetched", group.getVersionNo());

		return response;
	}

	// ============================================================
	// UTIL
	// ============================================================
	private String generateColumnName(String code) {
		return switch (code.toUpperCase()) {
		case "DISSWGPL" -> "dis_swg_pl";
		case "CBD" -> "d_rl_cbd";
		default -> code.toLowerCase();
		};
	}

	private record ColumnMapping(String sourceColumn, String slabColumn, String priceColumn) {
	}
}