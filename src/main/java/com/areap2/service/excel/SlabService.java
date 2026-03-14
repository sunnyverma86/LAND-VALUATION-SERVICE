package com.areap2.service.excel;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.areap2.constant.ModelConstant;
import com.areap2.dto.excel.SlabRangeDTO;
import com.areap2.dto.excel.SlabRequestDTO;
import com.areap2.entity.excel.external.DistanceType;
import com.areap2.entity.excel.external.SlabAudit;
import com.areap2.entity.excel.external.SlabDetail;
import com.areap2.entity.excel.external.SlabGroup;
import com.areap2.model.ResponseModel;
import com.areap2.repository.excel.external.DistanceTypeRepository;
import com.areap2.repository.excel.external.SlabAuditRepository;
import com.areap2.repository.excel.external.SlabDetailRepository;
import com.areap2.repository.excel.external.SlabGroupRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor

public class SlabService {

	private static final Logger log = LoggerFactory.getLogger(SlabService.class);

	@Autowired
	private SlabGroupRepository slabGroupRepository;
	@Autowired
	private SlabDetailRepository slabDetailRepository;
	@Autowired
	private SlabAuditRepository slabAuditRepository;
	@Autowired
	private DistanceTypeRepository distanceTypeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	private static final String TABLE_NAME = "areap2landvaluation.areap2_land_data_excel";

	private static final Map<String, ColumnMapping> COLUMN_MAPPING = Map.of("CBD",
			new ColumnMapping("d_rl_cbd", "d_rl_cbd_slab", "d_rl_cbd_price_value"), "DISSWGPL",
			new ColumnMapping("dis_swg_pl", "dis_swg_pl_slab", "dis_swg_pl_price_value"));

	// ============================================================
	// 1️⃣ CREATE SLAB (ROLE BASED)
	// ============================================================
	public ResponseModel createSlab(SlabRequestDTO request) {

		ResponseModel response = new ResponseModel();
		String loginId = getLoggedInUser();
		Set<String> roles = getUserRoles();

		validateRequest(request);

		DistanceType distanceType = getOrCreateDistanceType(request.getDistanceTypeCode());

		SlabGroup group = buildSlabGroup(request, distanceType, loginId);
		applyRoleBasedStatus(group, roles);

		slabGroupRepository.saveAndFlush(group);
		saveSlabDetails(group, request.getSlabs());

		saveAudit(group, "ADD", loginId, "Slab Created");

		if (Boolean.TRUE.equals(group.getIsActive())) {
			applySlabToLandTable(group);
		}

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Slab Created Successfully | Version: " + group.getVersionNo());
		response.setData(group);

		return response;
	}

	// ============================================================
	// 2️⃣ APPROVE / REJECT SLAB
	// ============================================================
	public ResponseModel approveSlab(Long slabGroupId, boolean approve) {

		ResponseModel response = new ResponseModel();
		String loginId = getLoggedInUser();

		SlabGroup group = slabGroupRepository.findById(slabGroupId)
				.orElseThrow(() -> new RuntimeException("Slab not found"));

		if (approve) {

			deactivateOldVersion(group);

			group.setActive(true);
			group.setStatus(ModelConstant.COMPLETE);
			group.setStatusCode(ModelConstant.COMPLETE_CODE);

			slabGroupRepository.save(group);

			applySlabToLandTable(group);

			saveAudit(group, "APPROVE", loginId, "Slab Approved");
			sendNotification("NEXT_ROLE", "Slab Approved for District: " + group.getDistrict());

			response.setMessage("Slab Approved Successfully");

		} else {

			group.setActive(false);
			group.setStatus(ModelConstant.REJECTED);
			group.setStatusCode("REJ");

			slabGroupRepository.save(group);

			rollbackLandTable(group);

			saveAudit(group, "REJECT", loginId, "Slab Rejected");
			sendNotification("CREATOR", "Slab Rejected for District: " + group.getDistrict());

			response.setMessage("Slab Rejected & Rolled Back");
		}

		response.setHttpStatus(HttpStatus.OK);
		response.setData(group);

		return response;
	}

	// ============================================================
	// 3️⃣ REVERT VERSION
	// ============================================================
	public ResponseModel revertVersion(Long slabGroupId) {

		SlabGroup target = slabGroupRepository.findById(slabGroupId).orElseThrow();

		deactivateOldVersion(target);

		target.setActive(true);
		slabGroupRepository.save(target);

		applySlabToLandTable(target);

		saveAudit(target, "REVERT", getLoggedInUser(), "Version Reverted");

		return new ResponseModel(HttpStatus.OK, "Version Reverted Successfully", target);
	}

	// ============================================================
	// 4️⃣ VERSION HISTORY
	// ============================================================
	public List<SlabGroup> getHistory(String district, String distanceTypeCode) {

		DistanceType type = distanceTypeRepository.findByCodeAndActiveTrue(distanceTypeCode).orElseThrow();

		return slabGroupRepository.findByDistrictAndDistanceTypeOrderByVersionNoDesc(district, type);
	}

	// ============================================================
	// INTERNAL METHODS
	// ============================================================

	private void applySlabToLandTable(SlabGroup group) {

		ColumnMapping mapping = COLUMN_MAPPING.get(group.getDistanceType().getCode());

		List<SlabDetail> slabs = slabDetailRepository.findBySlabGroup(group);

		for (SlabDetail slab : slabs) {

			String sql = """
					UPDATE %s
					SET %s = :band,
					    %s = :weightage
					WHERE %s BETWEEN :minVal AND :maxVal
					AND district = :district
					""".formatted(TABLE_NAME, mapping.slabColumn(), mapping.priceColumn(), mapping.sourceColumn());

			entityManager.createNativeQuery(sql).setParameter("band", slab.getBandNameStr())
					.setParameter("weightage", slab.getWeightage()).setParameter("minVal", slab.getMinValue())
					.setParameter("maxVal", slab.getMaxValue()).setParameter("district", group.getDistrict())
					.executeUpdate();
		}
	}

	private void rollbackLandTable(SlabGroup group) {

		ColumnMapping mapping = COLUMN_MAPPING.get(group.getDistanceType().getCode());

		String sql = """
				UPDATE %s
				SET %s = NULL,
				    %s = NULL
				WHERE district = :district
				""".formatted(TABLE_NAME, mapping.slabColumn(), mapping.priceColumn());

		entityManager.createNativeQuery(sql).setParameter("district", group.getDistrict()).executeUpdate();
	}

	private void deactivateOldVersion(SlabGroup group) {

		slabGroupRepository.findByDistrictAndDistanceTypeAndActiveTrue(group.getDistrict(), group.getDistanceType())
				.ifPresent(old -> {
					old.setActive(false);
					slabGroupRepository.save(old);
				});
	}

	private SlabGroup buildSlabGroup(SlabRequestDTO request, DistanceType type, String loginId) {
		// Optional<SlabGroup> kk =
		// slabGroupRepository.findByDistrictAndDistanceTypeAndActiveTrue(request.getDistrict(),
		// type);
		slabGroupRepository.findByDistrictAndDistanceTypeAndActiveTrue(request.getDistrict(), type).ifPresent(old -> {
			old.setActive(false);
			slabGroupRepository.save(old);
		});// temp code
		Integer maxVersion = slabGroupRepository.findMaxVersion(request.getDistrict(), type);
		int version = (maxVersion == null ? 0 : maxVersion) + 1;

		SlabGroup group = new SlabGroup();

		group.setDistrict(request.getDistrict());
		group.setDistanceType(type);
		group.setVersionNo(version);
		group.setCreatedBy(loginId);
		group.setAreaType(request.getAreaType());//
		group.setEffectiveTill(request.getEffectiveTill());//
		group.setParameterName(request.getParameterName());//
		group.setCreatedDtm(LocalDateTime.now());
		group.setRequestStatus(ModelConstant.ADD);

		return group;
	}

	private void saveSlabDetails(SlabGroup group, List<SlabRangeDTO> slabs) {

		slabs.sort(Comparator.comparing(SlabRangeDTO::getMinValue));

		List<SlabDetail> details = slabs.stream().map(s -> {
			SlabDetail d = new SlabDetail();
			d.setSlabGroup(group);
			d.setMinValue(s.getMinValue());
			d.setMaxValue(s.getMaxValue());
			// d.setBandNameStr(s.getMinValue() + "-" + s.getMaxValue());
			d.setBandNameStr(s.getBand());
			d.setWeightage(s.getWeightage());
			return d;
		}).toList();

		slabDetailRepository.saveAll(details);
	}

	private void saveAudit(SlabGroup group, String action, String loginId, String remarks) {

		SlabAudit audit = new SlabAudit();
		audit.setSlabGroupId(group.getId());
		audit.setAction(action);
		audit.setActionBy(loginId);
		audit.setActionDtm(LocalDateTime.now());
		audit.setOldStatus(group.getStatus());
		audit.setNewStatus(group.getStatus());
		audit.setRemarks(remarks);

		slabAuditRepository.save(audit);
	}

	private void applyRoleBasedStatus(SlabGroup group, Set<String> roles) {

		if (roles.contains(ModelConstant.ADMIN) || roles.contains(ModelConstant.DC)) {
			group.setActive(true);
			group.setStatus(ModelConstant.COMPLETE);
			group.setStatusCode(ModelConstant.COMPLETE_CODE);
		} else {
			group.setActive(false);
			group.setStatus(ModelConstant.PEN_DC_CODE);
			group.setStatusCode("PEN");
		}
	}

	private DistanceType getOrCreateDistanceType(String code) {

		return distanceTypeRepository.findByCodeIgnoreCaseAndActiveTrue(code).orElseGet(() -> {
			DistanceType type = new DistanceType();
			type.setCode(code.toUpperCase());
			type.setActive(true);
			// type.setActive(false);
			return distanceTypeRepository.save(type);
		});
	}

	private void validateRequest(SlabRequestDTO request) {

		if (request.getSlabs() == null || request.getSlabs().isEmpty())
			throw new RuntimeException("Slab list empty");
	}

	private String getLoggedInUser() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getName())) {
			throw new RuntimeException("Unauthorized");
		}

		return auth.getName();
	}

	private Set<String> getUserRoles() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		return auth.getAuthorities().stream().map(a -> a.getAuthority().replace("ROLE_", "").toLowerCase())
				.collect(Collectors.toSet());
	}

	private void sendNotification(String role, String message) {
		log.info("Notification -> {} : {}", role, message);
	}

	private record ColumnMapping(String sourceColumn, String slabColumn, String priceColumn) {
	}

	public ResponseModel getActiveSlabs(String district, String distanceTypeCode) {

		ResponseModel response = new ResponseModel();

		try {

			List<SlabGroup> slabs = slabGroupRepository.findByDistrictAndDistanceType_CodeAndActiveTrue(district,
					distanceTypeCode);

			response.setHttpStatus(HttpStatus.OK);
			response.setData(slabs);
			response.setMessage(slabs.isEmpty() ? "No active slabs found" : "Active slabs fetched successfully");

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("Error fetching active slabs");
		}

		return response;
	}
}