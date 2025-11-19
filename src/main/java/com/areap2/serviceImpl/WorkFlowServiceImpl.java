package com.areap2.serviceImpl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.areap2.constant.ModelConstant;
import com.areap2.entity.AreaTypes;
import com.areap2.entity.AuditLog;
import com.areap2.entity.CircleDetails;
import com.areap2.entity.DistrictDetails;
import com.areap2.entity.LandCategories;
import com.areap2.entity.LandSubClassDetails;
import com.areap2.entity.LotDetails;
import com.areap2.entity.MouzaDetails;
import com.areap2.entity.VillageDetails;
import com.areap2.service.WorkFlowService;

@Service
public class WorkFlowServiceImpl extends AbstractMasterRepository implements WorkFlowService {

	Logger log = LoggerFactory.getLogger(WorkFlowServiceImpl.class);

	@Override
	public List<AuditLog> getRequestsByStatusCode(String statusCode) {
		List<AuditLog> listOfAuditLog = auditLogRepo.findAllByStatusCode(statusCode);
		return listOfAuditLog;
	}

	@Override
	public List<?> getRequestsByStatusCodeAndMaster(String statusCode, String masterType) {
		final String methodName = "getRequestsByStatusCodeAndMaster";
		log.info("Fetching records | statusCode={} | masterType={} | method={} | class={}", statusCode, masterType,
				methodName, this.getClass().getSimpleName());

		if (masterType == null || masterType.isBlank()) {
			log.warn("Invalid masterType provided | masterType={} | method={}", masterType, methodName);
			return Collections.emptyList();
		}

		List<?> result;
		if (ModelConstant.DISTRICT.equalsIgnoreCase(masterType)) {
			result = districtDetailsRepo.findByStatusCode(statusCode);
		} else if (ModelConstant.CIRCLE.equalsIgnoreCase(masterType)) {
			result = circleDetailsRepo.findByStatusCode(statusCode);
		} else if (ModelConstant.VILLAGE.equalsIgnoreCase(masterType)) {
			result = villageDetailsRepo.findByStatusCode(statusCode);
		} else if (ModelConstant.MAUZA.equalsIgnoreCase(masterType)) {
			result = mouzaDetailsRepo.findByStatusCode(statusCode);
		} else if (ModelConstant.LANDUSE.equalsIgnoreCase(masterType)) {
			result = landCategoriesRepo.findByStatusCode(statusCode);
		} else if (ModelConstant.AREATYPE.equalsIgnoreCase(masterType)) {
			result = areaTypesRepo.findByStatusCode(statusCode);
		} else if (ModelConstant.LOT.equalsIgnoreCase(masterType)) {
			result = lotDetailsRepo.findByStatusCode(statusCode);
		} else if (ModelConstant.LANDSUBCLASS.equalsIgnoreCase(masterType)) {
			result = landSubClassDetailsRepo.findByStatusCode(statusCode);
		} else {
			log.warn("Unknown masterType provided | masterType={} | method={}", masterType, methodName);
			result = Collections.emptyList();
		}

		log.info("Fetched {} records | statusCode={} | masterType={} | method={}", (result != null ? result.size() : 0),
				statusCode, masterType, methodName);

		return result;
	}

	@Override
	public List<DistrictDetails> getDistrictRequestsByStatusCode(String statusCode) {
		List<DistrictDetails> listOfDistrict = districtDetailsRepo.findAllByStatusCode(statusCode);
		return listOfDistrict;
	}

	@Override
	public DistrictDetails handleJuniorManagerAction(Long id, String action) {
		DistrictDetails dataDistrictDetails = districtDetailsRepo.findByDistrictGenId(id);

		dataDistrictDetails.setStatusCode(action);
		dataDistrictDetails.setStatus(action);
		if (action.equalsIgnoreCase("accept")) {
			dataDistrictDetails.setStatusCode(ModelConstant.PEN_M);
			dataDistrictDetails.setStatus(ModelConstant.PEN_M_CODE);
		} else if (action.equalsIgnoreCase("reject")) {
			dataDistrictDetails.setStatusCode(ModelConstant.REJECT);
			dataDistrictDetails.setStatus(ModelConstant.REJECT_CODE);
		} else if (action.equalsIgnoreCase("updateAndApprove")) {
			dataDistrictDetails.setStatusCode(ModelConstant.PEN_M);
			dataDistrictDetails.setStatus(ModelConstant.PEN_M_CODE);

		}
		// below line will execute on two cases if action accept or rejecct it will not
		// execute
		if (!action.equalsIgnoreCase("updateAndApprove")) {
			String featName;
			featName = ModelConstant.DISTRICT;
			String statCode = ModelConstant.PEN_J_M_CODE;
			// String idString = String.valueOf(id);
			AuditLog dataAuditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, featName, statCode);
			dataAuditLog.setStatus(ModelConstant.PEN_M);
			dataAuditLog.setStatusCode(ModelConstant.PEN_M_CODE);
			dataAuditLog.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		}
		return null;
	}

	public List<?> getRequestsByIdAndMasterAndActionold(String loginId, Long id, String masterType, String action,
			String statusCode) {
		final String methodName = "getRequestsByStatusCodeAndMaster";
		log.info("Fetching records | statusCode={} | masterType={} | method={} | class={}", id, masterType, methodName,
				this.getClass().getSimpleName());

		if (masterType == null || masterType.isBlank()) {
			log.warn("Invalid masterType provided | masterType={} | method={}", masterType, methodName);
			return Collections.emptyList();
		}

		List<?> result = null;
		switch (masterType.toUpperCase()) {
		case ModelConstant.DISTRICT:
			String stat = null;
			DistrictDetails all = districtDetailsRepo.findByDistrictGenId(id);
			if (action.equalsIgnoreCase(ModelConstant.APPROVE)) {
				all.setStatus(ModelConstant.PEN_M);
				all.setStatusCode(ModelConstant.PEN_M_CODE);
			} else if (action.equalsIgnoreCase(ModelConstant.REJECT)) {
				all.setStatus(ModelConstant.REJECT);
				all.setStatusCode(ModelConstant.REJECT_CODE);
			} else {// referBack
				all.setStatus(ModelConstant.REFER_BACK);
				all.setStatusCode(ModelConstant.REFER_BACK_CODE);
			}
			DistrictDetails objDistrictDetails = districtDetailsRepo.save(all);
			// String idString = String.valueOf(id);
			AuditLog dataAuditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType,
					ModelConstant.PEN_J_M);
			dataAuditLog.setStatusCode(ModelConstant.HALF_COMPLETE);
			dataAuditLog.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
			dataAuditLog.setUpdatedBy(loginId);

			// Log action
			logAction(loginId, masterType, "approval-request", loginId + ":" + action,
					masterType + " approval, name: " + masterType, objDistrictDetails.getStatus(),
					objDistrictDetails.getStatusCode(), dataAuditLog.getReferenceId());

			break;
		case ModelConstant.CIRCLE:
			CircleDetails cd = circleDetailsRepo.findByCircleGenId(id);
			break;
		case ModelConstant.VILLAGE:
			VillageDetails vd = villageDetailsRepo.findByVillageGenId(id);
			break;
		case ModelConstant.MAUZA:
			MouzaDetails md = mouzaDetailsRepo.findByMouzaGenId(id);
			break;
		case ModelConstant.LANDUSE:
			LandCategories lc = landCategoriesRepo.findByLandCategoryGenId(id);
			break;
		case ModelConstant.AREATYPE:
			AreaTypes at = areaTypesRepo.findByAreaTypesGenId(id);
			break;
		case ModelConstant.LOT:
			LotDetails ld = lotDetailsRepo.findByLotGenId(id);
			break;
		case ModelConstant.LANDSUBCLASS:
			LandSubClassDetails lsc = landSubClassDetailsRepo.findByLandSubClassGenId(id);
			break;
		default:
			log.warn("Unknown masterType provided | masterType={} | method={}", masterType, methodName);
			result = Collections.emptyList();
		}

		log.info("Fetched {} records | statusCode={} | masterType={} | method={}", (result != null ? result.size() : 0),
				statusCode, masterType, methodName);

		return result;
	}

//	@Override
//	public List<?> getRequestsByIdAndMasterAndAction(String loginId, Long id, String masterType, String action,
//			String statusCode) {
//		final String methodName = "getRequestsByIdAndMasterAndAction";
//		log.info("Fetching records | id={} | masterType={} | action={} | method={} | class={}", id, masterType, action,
//				methodName, this.getClass().getSimpleName());
//
//		// Get logged-in user
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication == null || !authentication.isAuthenticated()
//				|| "anonymousUser".equals(authentication.getName())) {
//			response.setHttpStatus(HttpStatus.UNAUTHORIZED);
//			response.setMessage("Token is expired or invalid");
//			return response;
//		}
//		String loginId = authentication.getName();
//
//		// Extract roles
//		Set<String> userRoles = authentication.getAuthorities().stream()
//				.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());
//
//		log.info("User '{}' has roles: {}", loginId, userRoles);
//
//		if (masterType == null || masterType.isBlank()) {
//			log.warn("Invalid masterType provided | masterType={} | method={}", masterType, methodName);
//			return Collections.emptyList();
//		}
//
//		// Normalize master type to uppercase for switch
//		String type = masterType.toUpperCase();
//
//		// Common variables
//		String newStatus;
//		String newStatusCode;
//
//		// Determine status and code based on action
//		if (ModelConstant.APPROVE.equalsIgnoreCase(action)) {
//			newStatus = ModelConstant.PEN_M;
//			newStatusCode = ModelConstant.PEN_M_CODE;
//
//		} else if (ModelConstant.REJECT.equalsIgnoreCase(action)) {
//			newStatus = ModelConstant.REJECT;
//			newStatusCode = ModelConstant.REJECT_CODE;
//
//		} else {
//			newStatus = ModelConstant.REFER_BACK;
//			newStatusCode = ModelConstant.REFER_BACK_CODE;
//		}
//
//		// Process entity by type
//		Object updatedEntity = updateEntityStatus(type, id, newStatus, newStatusCode);
//		if (updatedEntity == null) {
//			log.warn("No record found for | masterType={} | id={} | method={}", masterType, id, methodName);
//			return Collections.emptyList();
//		}
//
//		// Update related audit log
//		System.out.println(id);
//		//String idString = String.valueOf(id);
//		AuditLog auditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType,
//				ModelConstant.PEN_J_M_CODE);
//		if (auditLog != null) {
//			auditLog.setStatusCode(ModelConstant.HALF_COMPLETE);
//			auditLog.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
//			auditLog.setUpdatedBy(loginId);
//			auditLogRepo.save(auditLog);
//		} else {
//			log.warn("No AuditLog found for referenceId={} | masterType={}", id, masterType);
//		}
//
//		// Log action for traceability
//		logAction(loginId, masterType, "approval-request", loginId + ":" + action, masterType + " approval update",
//				newStatus, newStatusCode, id);
//
//		log.info("Processed record successfully | masterType={} | id={} | action={} | method={}", masterType, id,
//				action, methodName);
//		return Collections.singletonList(updatedEntity);
//	}
	@Override
	public List<?> getRequestsByIdAndMasterAndAction( Long id, String masterType, String action,
			String statusCode) {

		final String methodName = "getRequestsByIdAndMasterAndAction";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={}", methodName,
				 id, masterType, action, statusCode);

		// -------------------- Get Logged-in User --------------------
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()
				|| "anonymousUser".equals(authentication.getName())) {

			log.error("Unauthorized access attempt | method={} | class={}", methodName,
					this.getClass().getSimpleName());
			// Return empty list with log message (since return type is List<?>)
			log.warn("Returning empty list due to invalid/expired token.");
			return Collections.emptyList();
		}

		String loginId = authentication.getName(); // ✅ renamed to avoid conflict with parameter
		Set<String> userRoles = authentication.getAuthorities().stream()
				.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());

		log.info("Authenticated user='{}' | roles={}", loginId, userRoles);
		// -------------------- End Logged-in User --------------------

		// Validate masterType
		if (masterType == null || masterType.isBlank()) {
			log.warn("Invalid masterType provided | masterType={} | method={}", masterType, methodName);
			return Collections.emptyList();
		}

		// Normalize masterType
		String type = masterType.toUpperCase();

		// Determine status and code based on action
		String newStatus;
		String newStatusCode;
		if (ModelConstant.APPROVE.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.PEN_M;
			newStatusCode = ModelConstant.PEN_M_CODE;
		} else if (ModelConstant.REJECT.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.REJECT;
			newStatusCode = ModelConstant.REJECT_CODE;
		} else {
			newStatus = ModelConstant.REFER_BACK;
			newStatusCode = ModelConstant.REFER_BACK_CODE;
		}

		log.debug("Action resolved | action={} | newStatus={} | newStatusCode={}", action, newStatus, newStatusCode);

		// Process entity update
		Object updatedEntity = updateEntityStatus(type, id, newStatus, newStatusCode);
		if (updatedEntity == null) {
			log.warn("No record found for | masterType={} | id={} | method={}", masterType, id, methodName);
			return Collections.emptyList();
		}

		// Update related audit log
		log.debug("Fetching AuditLog for referenceId={} | featureName={} | statusCode={}", id, masterType,
				statusCode);

		AuditLog auditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType,
				statusCode);

		if (auditLog != null) {
			auditLog.setStatus(ModelConstant.HALF_COMPLETE);
			auditLog.setStatusCode(ModelConstant.HALF_COMPLETE_CODE);
			auditLog.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
			auditLog.setUpdatedBy(loginId);
			auditLogRepo.save(auditLog);
			log.info("AuditLog updated successfully | referenceId={} | newStatusCode={}", id,
					ModelConstant.HALF_COMPLETE);
		} else {
			log.warn("No AuditLog found for referenceId={} | masterType={}", id, masterType);
		}

		// Log action for traceability
		logAction(loginId, masterType, "request", loginId + ":" + action, masterType + " request update",
				newStatus, newStatusCode, id);

		log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
				id, action, loginId);

		return Collections.singletonList(updatedEntity);
	}

	/**
	 * Updates entity status dynamically based on masterType.
	 */
	private Object updateEntityStatus(String masterType, Long id, String status, String statusCode) {
		if (ModelConstant.DISTRICT.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(districtDetailsRepo.findByDistrictGenId(id), status, statusCode,
					districtDetailsRepo);

		} else if (ModelConstant.CIRCLE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(circleDetailsRepo.findByCircleGenId(id), status, statusCode, circleDetailsRepo);

		} else if (ModelConstant.VILLAGE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(villageDetailsRepo.findByVillageGenId(id), status, statusCode,
					villageDetailsRepo);

		} else if (ModelConstant.MAUZA.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(mouzaDetailsRepo.findByMouzaGenId(id), status, statusCode, mouzaDetailsRepo);

		} else if (ModelConstant.LANDUSE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(landCategoriesRepo.findByLandCategoryGenId(id), status, statusCode,
					landCategoriesRepo);

		} else if (ModelConstant.AREATYPE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(areaTypesRepo.findByAreaTypesGenId(id), status, statusCode, areaTypesRepo);

		} else if (ModelConstant.LOT.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(lotDetailsRepo.findByLotGenId(id), status, statusCode, lotDetailsRepo);

		} else if (ModelConstant.LANDSUBCLASS.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(landSubClassDetailsRepo.findByLandSubClassGenId(id), status, statusCode,
					landSubClassDetailsRepo);

		} else {
			log.warn("Unknown masterType provided | masterType={}", masterType);
			return null;
		}

	}

	/**
	 * Generic helper to update status and persist entity.
	 */
	private <T> T updateAndSaveEntity(T entity, String status, String statusCode, JpaRepository<T, Long> repository) {
		if (entity == null)
			return null;
		try {
			// Use reflection to call setStatus and setStatusCode dynamically
			entity.getClass().getMethod("setStatus", String.class).invoke(entity, status);
			entity.getClass().getMethod("setStatusCode", String.class).invoke(entity, statusCode);
			return repository.save(entity);
		} catch (Exception e) {
			log.error("Failed to update entity | entityClass={} | error={}", entity.getClass().getSimpleName(),
					e.getMessage(), e);
			return null;
		}
	}

	public void logAction(String loginId, String featureName, String actionType, String featureId, String message,
			String stat, String statCode, long genId) {
		AuditLog log = new AuditLog();
		log.setLoginId(loginId);
		log.setFeatureName(featureName);
		log.setActionType(actionType);
		log.setActionDatetime(new Timestamp(System.currentTimeMillis()));
		log.setFeatureId(featureId);
		log.setMessage(message);
		log.setStatus(stat);
		log.setStatusCode(statCode);
		log.setReferenceId(genId);
		auditLogRepo.save(log);

	}

	@Override
	public List<?> getRequestsByIdAndMasterAndActionMan(Long id, String masterType, String action, String statusCode) {

		final String methodName = "getRequestsByIdAndMasterAndAction";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={}", methodName,
				 id, masterType, action, statusCode);

		// -------------------- Get Logged-in User --------------------
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()
				|| "anonymousUser".equals(authentication.getName())) {

			log.error("Unauthorized access attempt | method={} | class={}", methodName,
					this.getClass().getSimpleName());
			// Return empty list with log message (since return type is List<?>)
			log.warn("Returning empty list due to invalid/expired token.");
			return Collections.emptyList();
		}

		String loginId = authentication.getName(); // ✅ renamed to avoid conflict with parameter
		Set<String> userRoles = authentication.getAuthorities().stream()
				.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());

		log.info("Authenticated user='{}' | roles={}", loginId, userRoles);
		// -------------------- End Logged-in User --------------------

		// Validate masterType
		if (masterType == null || masterType.isBlank()) {
			log.warn("Invalid masterType provided | masterType={} | method={}", masterType, methodName);
			return Collections.emptyList();
		}

		// Normalize masterType
		String type = masterType.toUpperCase();

		// Determine status and code based on action
		String newStatus;
		String newStatusCode;
		if (ModelConstant.APPROVE.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.PEN_S_M;
			newStatusCode = ModelConstant.PEN_S_M_CODE;
		} else if (ModelConstant.REJECT.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.REJECT;
			newStatusCode = ModelConstant.REJECT_CODE;
		} else {
			newStatus = ModelConstant.REFER_BACK_TO_J_M;
			newStatusCode = ModelConstant.PEN_J_M_CODE;
		}

		log.debug("Action resolved | action={} | newStatus={} | newStatusCode={}", action, newStatus, newStatusCode);

		// Process entity update
		Object updatedEntity = updateEntityStatus(type, id, newStatus, newStatusCode);
		if (updatedEntity == null) {
			log.warn("No record found for | masterType={} | id={} | method={}", masterType, id, methodName);
			return Collections.emptyList();
		}

		// Update related audit log
		log.debug("Fetching AuditLog for referenceId={} | featureName={} | statusCode={}", id, masterType,
				statusCode);

		AuditLog auditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType,
				statusCode);

		if (auditLog != null) {
			auditLog.setStatus(ModelConstant.HALF_COMPLETE);
			auditLog.setStatusCode(ModelConstant.HALF_COMPLETE_CODE);
			auditLog.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
			auditLog.setUpdatedBy(loginId);
			auditLogRepo.save(auditLog);
			log.info("AuditLog updated successfully | referenceId={} | newStatusCode={}", id,
					ModelConstant.HALF_COMPLETE);
		} else {
			log.warn("No AuditLog found for referenceId={} | masterType={}", id, masterType);
		}

		// Log action for traceability
		logAction(loginId, masterType, "request", loginId + ":" + action, masterType + " request update",
				newStatus, newStatusCode, id);

		log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
				id, action, loginId);

		return Collections.singletonList(updatedEntity);
	}

	@Override
	public List<?> getRequestsByIdAndMasterAndActionSeniorMan(Long id, String masterType, String action,
			String statusCode) {

		final String methodName = "getRequestsByIdAndMasterAndActionSeniorMan";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={}", methodName,
				 id, masterType, action, statusCode);

		// -------------------- Get Logged-in User --------------------
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()
				|| "anonymousUser".equals(authentication.getName())) {

			log.error("Unauthorized access attempt | method={} | class={}", methodName,
					this.getClass().getSimpleName());
			// Return empty list with log message (since return type is List<?>)
			log.warn("Returning empty list due to invalid/expired token.");
			return Collections.emptyList();
		}

		String loginId = authentication.getName(); // ✅ renamed to avoid conflict with parameter
		Set<String> userRoles = authentication.getAuthorities().stream()
				.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());

		log.info("Authenticated user='{}' | roles={}", loginId, userRoles);
		// -------------------- End Logged-in User --------------------

		// Validate masterType
		if (masterType == null || masterType.isBlank()) {
			log.warn("Invalid masterType provided | masterType={} | method={}", masterType, methodName);
			return Collections.emptyList();
		}

		// Normalize masterType
		String type = masterType.toUpperCase();

		// Determine status and code based on action
		String newStatus;
		String newStatusCode;
		if (ModelConstant.APPROVE.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.COMPLETE;
			newStatusCode = ModelConstant.COMPLETE_CODE;
		} else if (ModelConstant.REJECT.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.REJECT;
			newStatusCode = ModelConstant.REJECT_CODE;
		} else {
			newStatus = ModelConstant.REFER_BACK_TO_M;
			newStatusCode = ModelConstant.PEN_M_CODE;
		}

		log.debug("Action resolved | action={} | newStatus={} | newStatusCode={}", action, newStatus, newStatusCode);

		// Process entity update
		Object updatedEntity = updateEntityStatus(type, id, newStatus, newStatusCode);
		if (updatedEntity == null) {
			log.warn("No record found for | masterType={} | id={} | method={}", masterType, id, methodName);
			return Collections.emptyList();
		}

		// Update related audit log
		log.debug("Fetching AuditLog for referenceId={} | featureName={} | statusCode={}", id, masterType,
				statusCode);

		AuditLog auditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType,
				statusCode);

		if (auditLog != null) {
			auditLog.setStatusCode(ModelConstant.COMPLETE_CODE);
			auditLog.setStatus(ModelConstant.COMPLETE);
			auditLog.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
			auditLog.setUpdatedBy(loginId);
			auditLogRepo.save(auditLog);
			log.info("AuditLog updated successfully | referenceId={} | newStatusCode={}", id,
					ModelConstant.HALF_COMPLETE);
		} else {
			log.warn("No AuditLog found for referenceId={} | masterType={}", id, masterType);
		}

		// Log action for traceability
		logAction(loginId, masterType, "request", loginId + ":" + action, masterType + " request update",
				newStatus, newStatusCode, id);

		log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
				id, action, loginId);

		return Collections.singletonList(updatedEntity);
	}

	@Override
	public List<?> getRequestsByIdAndMasterAndActionAdmin(Long id, String masterType, String action,
			String statusCode) {

		final String methodName = "getRequestsByIdAndMasterAndActionSeniorMan";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={}", methodName,
				 id, masterType, action, statusCode);

		// -------------------- Get Logged-in User --------------------
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()
				|| "anonymousUser".equals(authentication.getName())) {

			log.error("Unauthorized access attempt | method={} | class={}", methodName,
					this.getClass().getSimpleName());
			// Return empty list with log message (since return type is List<?>)
			log.warn("Returning empty list due to invalid/expired token.");
			return Collections.emptyList();
		}

		String loginId = authentication.getName(); // ✅ renamed to avoid conflict with parameter
		Set<String> userRoles = authentication.getAuthorities().stream()
				.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());

		log.info("Authenticated user='{}' | roles={}", loginId, userRoles);
		// -------------------- End Logged-in User --------------------

		// Validate masterType
		if (masterType == null || masterType.isBlank()) {
			log.warn("Invalid masterType provided | masterType={} | method={}", masterType, methodName);
			return Collections.emptyList();
		}

		// Normalize masterType
		String type = masterType.toUpperCase();

		// Determine status and code based on action
		String newStatus;
		String newStatusCode;
		if (ModelConstant.APPROVE.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.COMPLETE;
			newStatusCode = ModelConstant.COMPLETE_CODE;
		} else if (ModelConstant.REJECT.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.REJECT;
			newStatusCode = ModelConstant.REJECT_CODE;
		} else {
			newStatus = ModelConstant.REFER_BACK_TO_M;
			newStatusCode = ModelConstant.PEN_M_CODE;
		}

		log.debug("Action resolved | action={} | newStatus={} | newStatusCode={}", action, newStatus, newStatusCode);

		// Process entity update
		Object updatedEntity = updateEntityStatus(type, id, newStatus, newStatusCode);
		if (updatedEntity == null) {
			log.warn("No record found for | masterType={} | id={} | method={}", masterType, id, methodName);
			return Collections.emptyList();
		}

		// Update related audit log
		log.debug("Fetching AuditLog for referenceId={} | featureName={} | statusCode={}", id, masterType,
				statusCode);

		AuditLog auditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType,
				statusCode);

		if (auditLog != null) {
			auditLog.setStatusCode(ModelConstant.COMPLETE_CODE);
			auditLog.setStatus(ModelConstant.COMPLETE);
			auditLog.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
			auditLog.setUpdatedBy(loginId);
			auditLogRepo.save(auditLog);
			log.info("AuditLog updated successfully | referenceId={} | newStatusCode={}", id,
					ModelConstant.HALF_COMPLETE);
		} else {
			log.warn("No AuditLog found for referenceId={} | masterType={}", id, masterType);
		}

		// Log action for traceability
		logAction(loginId, masterType, "request", loginId + ":" + action, masterType + " request update",
				newStatus, newStatusCode, id);

		log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
				id, action, loginId);

		return Collections.singletonList(updatedEntity);
	}

}
