package com.areap2.serviceImpl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
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
import com.areap2.entity.ParameterDetails;
import com.areap2.entity.SubParameterDetails;
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
	public List<?> getRequestsByIdAndMasterAndAction(Long id, String masterType, String masterCode, String action,
			String statusCode) {

		final String methodName = "getRequestsByIdAndMasterAndAction";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={}", methodName, id, masterType, action,
				statusCode);

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
		log.debug("Fetching AuditLog for referenceId={} | featureName={} | statusCode={}", id, masterType, statusCode);

		AuditLog auditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType, statusCode);

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
//		logAction(loginId, masterType, "request", loginId + ":" + action, masterType + " request update",
//				newStatus, newStatusCode, id);
		logAction(loginId, masterType, "Workflow", loginId + ":" + action + "," + masterType + "Code: " + masterCode,
				masterType + ": Workflow request update:" + action, newStatus, newStatusCode, id);

		log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
				id, action, loginId);

		return Collections.singletonList(updatedEntity);
	}

	/**
	 * Updates entity status dynamically based on masterType.
	 */
	private Object updateEntityStatus(String masterType, Long id, String newStatus, String newStatusCode,
			String newRequestStatus, String masterCode) {

		if (ModelConstant.DISTRICT.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(districtDetailsRepo.findByDistrictCode(masterCode), newStatus, newStatusCode,
					newRequestStatus, districtDetailsRepo);

		} else if (ModelConstant.CIRCLE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(circleDetailsRepo.findByCircleGenId(id), newStatus, newStatusCode, circleDetailsRepo);

		} else if (ModelConstant.MAUZA.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(mouzaDetailsRepo.findByMouzaGenId(id), newStatus, newStatusCode, mouzaDetailsRepo);

		} else if (ModelConstant.LOT.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(lotDetailsRepo.findByLotGenId(id), newStatus, newStatusCode, lotDetailsRepo);

		} else if (ModelConstant.VILLAGE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(villageDetailsRepo.findByVillageGenId(id), newStatus, newStatusCode,
					villageDetailsRepo);

		} else if (ModelConstant.LANDSCATEGORY.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(landsCategoryDetailsRepo.findByLandCategoryGenId(id), newStatus, newStatusCode,
					landsCategoryDetailsRepo);

		} else if (ModelConstant.PARAMETER.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(parameterDetailsRepo.findByParameterGenId(id), newStatus, newStatusCode,
					parameterDetailsRepo);

		} else if (ModelConstant.SUBPARAMETER.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(subParameterDetailsRepo.findBySubParameterGenId(id), newStatus, newStatusCode,
					subParameterDetailsRepo);

		} else if (ModelConstant.LANDUSE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(landCategoriesRepo.findByLandCategoryGenId(id), newStatus, newStatusCode,
					landCategoriesRepo);

		} else if (ModelConstant.AREATYPE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(areaTypesRepo.findByAreaTypesGenId(id), newStatus, newStatusCode, areaTypesRepo);

		} else if (ModelConstant.LANDSUBCLASS.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(landSubClassDetailsRepo.findByLandSubClassGenId(id), newStatus, newStatusCode,
					landSubClassDetailsRepo);

		} else {
			log.warn("Unknown masterType provided | masterType={}", masterType);
			return null;
		}

	}

	private Object updateEntityStatus(String masterType, Long id, String status, String statusCode) {

		if (ModelConstant.DISTRICT.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(districtDetailsRepo.findByDistrictGenId(id), status, statusCode,
					districtDetailsRepo);

		} else if (ModelConstant.CIRCLE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(circleDetailsRepo.findByCircleGenId(id), status, statusCode, circleDetailsRepo);

		} else if (ModelConstant.MAUZA.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(mouzaDetailsRepo.findByMouzaGenId(id), status, statusCode, mouzaDetailsRepo);

		} else if (ModelConstant.LOT.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(lotDetailsRepo.findByLotGenId(id), status, statusCode, lotDetailsRepo);

		} else if (ModelConstant.VILLAGE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(villageDetailsRepo.findByVillageGenId(id), status, statusCode,
					villageDetailsRepo);

		} else if (ModelConstant.LANDSCATEGORY.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(landsCategoryDetailsRepo.findByLandCategoryGenId(id), status, statusCode,
					landsCategoryDetailsRepo);

		} else if (ModelConstant.PARAMETER.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(parameterDetailsRepo.findByParameterGenId(id), status, statusCode,
					parameterDetailsRepo);

		} else if (ModelConstant.SUBPARAMETER.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(subParameterDetailsRepo.findBySubParameterGenId(id), status, statusCode,
					subParameterDetailsRepo);

		} else if (ModelConstant.LANDUSE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(landCategoriesRepo.findByLandCategoryGenId(id), status, statusCode,
					landCategoriesRepo);

		} else if (ModelConstant.AREATYPE.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(areaTypesRepo.findByAreaTypesGenId(id), status, statusCode, areaTypesRepo);

		} else if (ModelConstant.LANDSUBCLASS.equalsIgnoreCase(masterType)) {
			return updateAndSaveEntity(landSubClassDetailsRepo.findByLandSubClassGenId(id), status, statusCode,
					landSubClassDetailsRepo);

		} else {
			log.warn("Unknown masterType provided | masterType={}", masterType);
			return null;
		}

	}

	public <T> List<T> updateAndSaveEntity(List<T> entities, String newStatus, String newStatusCode,
	        String newRequestStatus, JpaRepository<T, Long> repository) {

	    if (entities == null || entities.isEmpty()) {
	        return Collections.emptyList();
	    }

	    try {
	        // Find entity with highest updated_dtm
	        T latestEntity = Collections.max(entities, Comparator.comparingLong(this::getUpdatedDtmMillis));
	        Timestamp now = new Timestamp(System.currentTimeMillis());

	        for (T entity : entities) {

	            boolean isLatest = (entity == latestEntity);

	            // ----------------------------
	            // APPROVE: original behaviour
	            // ----------------------------
	            if (ModelConstant.APPROVE.equalsIgnoreCase(newStatus)) {

	                // latest -> active=true, others -> active=false
	                entity.getClass().getMethod("setActive", Boolean.class).invoke(entity, isLatest);

	                // request_status = COMPLETE (for all)
	                entity.getClass().getMethod("setRequestStatus", String.class)
	                        .invoke(entity, ModelConstant.COMPLETE);

	                // status_code = COMPLETE_CODE (for all)
	                entity.getClass().getMethod("setStatusCode", String.class)
	                        .invoke(entity, ModelConstant.COMPLETE_CODE);

	                // status = COMPLETE (for all)
	                entity.getClass().getMethod("setStatus", String.class).invoke(entity, ModelConstant.COMPLETE);

	                // updated_dtm = now (only for latest entity)
	                if (isLatest) {
	                    entity.getClass().getMethod("setUpdatedDtm", Timestamp.class).invoke(entity, now);
	                }

	            // ----------------------------
	            // REJECT: all active = false, mark REJECTED
	            // ----------------------------
	            } else if (ModelConstant.REJECT.equalsIgnoreCase(newStatus)) {

	                // all -> active = false
	              //  entity.getClass().getMethod("setActive", Boolean.class).invoke(entity, false);

	                // request_status = REJECTED (for all)
	                entity.getClass().getMethod("setRequestStatus", String.class)
	                        .invoke(entity, ModelConstant.REJECTED);

	                // status_code = COMPLETE_CODE (for all) — keep same as your original
	                entity.getClass().getMethod("setStatusCode", String.class)
	                        .invoke(entity, ModelConstant.COMPLETE_CODE);

	                // status = COMPLETE (for all)
	                entity.getClass().getMethod("setStatus", String.class).invoke(entity, ModelConstant.COMPLETE);

	                // updated_dtm = now (only for latest entity)
	                if (isLatest) {
	                    entity.getClass().getMethod("setUpdatedDtm", Timestamp.class).invoke(entity, now);
	                }

	            // ----------------------------
	            // DEFAULT: if caller passed custom values (fallback)
	            // ----------------------------
	            } else {

	                // default behaviour: keep latest=true, others=false (same as original)
	                entity.getClass().getMethod("setActive", Boolean.class).invoke(entity, isLatest);

	                // apply provided request/status/statusCode if passed, otherwise fallback to COMPLETE
	                String reqStatusToSet = (newRequestStatus != null && !newRequestStatus.isEmpty())
	                        ? newRequestStatus
	                        : ModelConstant.COMPLETE;
	                String statusCodeToSet = (newStatusCode != null && !newStatusCode.isEmpty())
	                        ? newStatusCode
	                        : ModelConstant.COMPLETE_CODE;
	                String statusToSet = (newStatus != null && !newStatus.isEmpty())
	                        ? newStatus
	                        : ModelConstant.COMPLETE;

	                entity.getClass().getMethod("setRequestStatus", String.class).invoke(entity, reqStatusToSet);
	                entity.getClass().getMethod("setStatusCode", String.class).invoke(entity, statusCodeToSet);
	                entity.getClass().getMethod("setStatus", String.class).invoke(entity, statusToSet);

	                if (isLatest) {
	                    entity.getClass().getMethod("setUpdatedDtm", Timestamp.class).invoke(entity, now);
	                }
	            }
	        }

	        return repository.saveAll(entities);

	    } catch (Exception e) {
	        log.error("Failed to update entity list | entityClass={} | error={}",
	                entities.get(0).getClass().getSimpleName(), e.getMessage(), e);
	        return Collections.emptyList();
	    }
	}

	private <T> T updateAndSaveEntity(T entity, String status, String statusCode, JpaRepository<T, Long> repository) {
		if (entity == null)
			return null;
		try {
			// Use reflection to call setStatus and setStatusCode dynamically
			entity.getClass().getMethod("setStatus", String.class).invoke(entity, status);
			entity.getClass().getMethod("setStatusCode", String.class).invoke(entity, statusCode);
			// entity.getClass().getMethod("setStatusCode", String.class).invoke(entity,
			// statusCode);
			return repository.save(entity);
		} catch (Exception e) {
			log.error("Failed to update entity | entityClass={} | error={}", entity.getClass().getSimpleName(),
					e.getMessage(), e);
			return null;
		}
	}

	private long getUpdatedDtmMillis(Object entity) {
		try {
			Object obj = entity.getClass().getMethod("getUpdatedDtm").invoke(entity);
			if (obj instanceof Timestamp) {
				return ((Timestamp) obj).getTime();
			}
		} catch (NoSuchMethodException nsme) {
			log.debug("No getUpdatedDtm method on {}: {}", entity.getClass().getSimpleName(), nsme.getMessage());
		} catch (Exception e) {
			log.warn("Error reading updatedDtm from {}: {}", entity.getClass().getSimpleName(), e.getMessage());
		}
		return 0L;
	}

	public void logAction(String loginId, String featureName, String actionType, String featureId, String message,
			String stat, String statCode, long genId) {
		AuditLog log = new AuditLog();
		log.setLoginId(loginId);
		log.setFeatureName(featureName);
		log.setActionType(actionType);
		log.setActionDatetime(new Timestamp(System.currentTimeMillis()));
		log.setFeatureDescription(featureId);
		log.setMessage(message);
		log.setStatus(stat);
		log.setStatusCode(statCode);
		log.setReferenceId(genId);
		auditLogRepo.save(log);

	}

	@Override
	public List<?> getRequestsByIdAndMasterAndActionMan(Long id, String masterType, String masterCode, String action,
			String currentStatusCode) {

		final String methodName = "getRequestsByIdAndMasterAndAction";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={}", methodName, id, masterType, action,
				currentStatusCode);

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
				currentStatusCode);

		AuditLog auditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType,
				currentStatusCode);

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
		logAction(loginId, masterType, "Workflow", loginId + ":" + action + "," + masterType + "Code: " + masterCode,
				masterType + ": Workflow request update:" + action, newStatus, newStatusCode, id);

		log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
				id, action, loginId);

		return Collections.singletonList(updatedEntity);
	}

	@Override
	public List<?> getRequestsByIdAndMasterAndActionSeniorMan(Long id, String masterType, String masterCode,
			String action, String statusCode, String requestType) {

		final String methodName = "getRequestsByIdAndMasterAndActionSeniorMan";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={} | requestType={}", methodName, id,
				masterType, action, statusCode, requestType);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()
				|| "anonymousUser".equals(authentication.getName())) {
			log.warn("Returning empty list due to invalid token.");
			return Collections.emptyList();
		}

		String loginId = authentication.getName();

		// --------------------------------------------
		// 1️⃣ NEW LOGIC: If requestType = DELETE → special behaviour
		// --------------------------------------------
		if (ModelConstant.DELETE.equalsIgnoreCase(requestType)) {

			log.info("Handling DELETE requestType → setting ALL active=false");

			Object result = performDeleteAction(masterType, masterCode,action);

			log.info("[SUCCESS] Delete operation completed");

			return result == null ? Collections.emptyList() : Collections.singletonList(result);
		}
		// --------------------------------------------
		// 2️⃣ Normal workflow (Approve / Reject / Refer Back)
		// --------------------------------------------

		String newStatus;
		String newStatusCode;
		String newRequestStatus = null;

		if (ModelConstant.APPROVE.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.COMPLETE;
			newStatusCode = ModelConstant.COMPLETE_CODE;
			newRequestStatus = ModelConstant.COMPLETE;

		} else if (ModelConstant.REJECT.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.REJECT;
			newStatusCode = ModelConstant.REJECT_CODE;

		} else {
			newStatus = ModelConstant.REFER_BACK_TO_M;
			newStatusCode = ModelConstant.PEN_M_CODE;
		}

		Object updatedEntity = updateEntityStatus(masterType, id, newStatus, newStatusCode, newRequestStatus,
				masterCode);
		// Update related audit log
				log.debug("Fetching AuditLog for referenceId={} | featureName={} | statusCode={}", id, masterType, statusCode);

				List<AuditLog> auditLogs = auditLogRepo.findByReferenceIdAndFeatureName(id, masterType);

				if (auditLogs != null && !auditLogs.isEmpty()) {

					for (AuditLog logEntry : auditLogs) {
						logEntry.setStatusCode(ModelConstant.COMPLETE_CODE);
						logEntry.setStatus(ModelConstant.COMPLETE);
						logEntry.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
						logEntry.setUpdatedBy(loginId);
					}

					auditLogRepo.saveAll(auditLogs);

					log.info("AuditLog updated successfully | referenceId={} | count={}", id, auditLogs.size());
				} else {
					log.warn("No AuditLog found for referenceId={} | masterType={}", id, masterType);
				}

				// Log action for traceability
//				logAction(loginId, masterType, "request", loginId + ":" + action, masterType + " request update",
//						newStatus, newStatusCode, id);
				logAction(loginId, masterType, "Workflow", loginId + ":" + action + "," + masterType + "Code: " + masterCode,
						masterType + ": Workflow request update:" + action, newStatus, newStatusCode, id);

				log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
						id, action, loginId);


		if (updatedEntity == null)
			return Collections.emptyList();

		return Collections.singletonList(updatedEntity);
	}

//	private Object performDeleteActionOkd(String masterType, String masterCode) {
//
//	    List<?> list;
//
//	    // ---------------- Querying based on master type ----------------
//	    if (ModelConstant.DISTRICT.equalsIgnoreCase(masterType)) {
//	        list = districtDetailsRepo.findByDistrictCode(masterCode);
//
//	    } else if (ModelConstant.CIRCLE.equalsIgnoreCase(masterType)) {
//	        list = circleDetailsRepo.findByCircleCode(masterCode);
//
//	    } else if (ModelConstant.MAUZA.equalsIgnoreCase(masterType)) {
//	        list = mouzaDetailsRepo.findByMouzaCode(masterCode);
//
//	    } else if (ModelConstant.LOT.equalsIgnoreCase(masterType)) {
//	        list = lotDetailsRepo.findByLotCode(masterCode);
//
//	    } else if (ModelConstant.VILLAGE.equalsIgnoreCase(masterType)) {
//	        list = villageDetailsRepo.findByVillageCode(masterCode);
//
//	    } else if (ModelConstant.LANDSCATEGORY.equalsIgnoreCase(masterType)) {
//	        list = landsCategoryDetailsRepo.findByLandCategoryCode(masterCode);
//
//	    } else if (ModelConstant.PARAMETER.equalsIgnoreCase(masterType)) {
//	        list = parameterDetailsRepo.findByParameterCode(masterCode);
//
//	    } else if (ModelConstant.SUBPARAMETER.equalsIgnoreCase(masterType)) {
//	        list = subParameterDetailsRepo.findBySubParameterCode(masterCode);
//
//	    } else if (ModelConstant.LANDUSE.equalsIgnoreCase(masterType)) {
//	        list = landCategoriesRepo.findByLandCategoryGenId(masterCode);  
//	        // NOTE: This should probably be findByLandCategoryCode(masterCode)
//
//	    } else if (ModelConstant.AREATYPE.equalsIgnoreCase(masterType)) {
//	        list = areaTypesRepo.findByAreaTypesGenId(masterCode);  
//	        // NOTE: Same — normally should be findByAreaTypeCode(masterCode)
//
//	    } else if (ModelConstant.LANDSUBCLASS.equalsIgnoreCase(masterType)) {
//	        list = landSubClassDetailsRepo.findByLandSubClassCode(masterCode);
//
//	    } else {
//	        log.warn("Unknown masterType={}", masterType);
//	        return null;
//	    }
//
//	    if (list == null || list.isEmpty())
//	        return null;
//
//	    Timestamp now = new Timestamp(System.currentTimeMillis());
//
//	    // ---------------- Update all entities ----------------
//	    for (Object obj : list) {
//	        try {
//	            obj.getClass().getMethod("setActive", Boolean.class).invoke(obj, false);
//	            obj.getClass().getMethod("setRequestStatus", String.class).invoke(obj, ModelConstant.COMPLETE);
//	            obj.getClass().getMethod("setStatus", String.class).invoke(obj, ModelConstant.COMPLETE);
//	            obj.getClass().getMethod("setStatusCode", String.class).invoke(obj, ModelConstant.COMPLETE_CODE);
//	            obj.getClass().getMethod("setUpdatedDtm", Timestamp.class).invoke(obj, now);
//
//	        } catch (Exception e) {
//	            log.error("Error updating fields for delete operation: {}", e.getMessage(), e);
//	        }
//	    }
//
//	    // ----------- SAVE BASED ON REPOSITORY TYPE ------------
//	    Object first = list.get(0);
//
//	    if (first instanceof DistrictDetails)
//	        return districtDetailsRepo.saveAll((List<DistrictDetails>) list);
//
//	    if (first instanceof CircleDetails)
//	        return circleDetailsRepo.saveAll((List<CircleDetails>) list);
//
//	    if (first instanceof MouzaDetails)
//	        return mouzaDetailsRepo.saveAll((List<MouzaDetails>) list);
//
//	    if (first instanceof LotDetails)
//	        return lotDetailsRepo.saveAll((List<LotDetails>) list);
//
//	    if (first instanceof VillageDetails)
//	        return villageDetailsRepo.saveAll((List<VillageDetails>) list);
//
//
//	    if (first instanceof ParameterDetails)
//	        return parameterDetailsRepo.saveAll((List<ParameterDetails>) list);
//
//	    if (first instanceof SubParameterDetails)
//	        return subParameterDetailsRepo.saveAll((List<SubParameterDetails>) list);
//
//	    if (first instanceof LandCategories)
//	        return landCategoriesRepo.saveAll((List<LandCategories>) list);
//
//	    if (first instanceof AreaTypes)
//	        return areaTypesRepo.saveAll((List<AreaTypes>) list);
//
//	    if (first instanceof LandSubClassDetails)
//	        return landSubClassDetailsRepo.saveAll((List<LandSubClassDetails>) list);
//
//	    return null;
//	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> performDeleteAction(String masterType, String masterCode, String action) {

	    List<T> list = null;

	    // Fetch based on masterType
	    if (masterType.equalsIgnoreCase(ModelConstant.DISTRICT)) {
	        list = (List<T>) districtDetailsRepo.findByDistrictCode(masterCode);

	    } else if (masterType.equalsIgnoreCase(ModelConstant.CIRCLE)) {
	        list = (List<T>) circleDetailsRepo.findByCircleCode(masterCode);

	    } else if (masterType.equalsIgnoreCase(ModelConstant.MAUZA)) {
	        list = (List<T>) mouzaDetailsRepo.findByMouzaCode(masterCode);

	    } else if (masterType.equalsIgnoreCase(ModelConstant.LOT)) {
	        list = (List<T>) lotDetailsRepo.findByLotCode(masterCode);

	    } else if (masterType.equalsIgnoreCase(ModelConstant.VILLAGE)) {
	        list = (List<T>) villageDetailsRepo.findByVillageCode(masterCode);

	    } else if (masterType.equalsIgnoreCase(ModelConstant.LANDSCATEGORY)) {
	        list = (List<T>) landsCategoryDetailsRepo.findByLandCategoryCode(masterCode);

	    } else if (masterType.equalsIgnoreCase(ModelConstant.PARAMETER)) {
	        list = (List<T>) parameterDetailsRepo.findByParameterCode(masterCode);

	    } else if (masterType.equalsIgnoreCase(ModelConstant.SUBPARAMETER)) {
	        list = (List<T>) subParameterDetailsRepo.findBySubParameterCode(masterCode);

	    } else if (masterType.equalsIgnoreCase(ModelConstant.LANDSUBCLASS)) {
	        list = (List<T>) landSubClassDetailsRepo.findByLandSubClassCode(masterCode);

	    } else {
	        log.warn("Unknown masterType={}", masterType);
	        return null;
	    }

	    if (list == null || list.isEmpty())
	        return null;

	    Timestamp now = new Timestamp(System.currentTimeMillis());

	    // -------------------------------------------------------
	    // ACTION-BASED PROCESSING
	    // -------------------------------------------------------
	    for (T obj : list) {
	        try {

	            if (action.equalsIgnoreCase(ModelConstant.APPROVE)) {

	                obj.getClass().getMethod("setActive", Boolean.class).invoke(obj, false);
	                obj.getClass().getMethod("setRequestStatus", String.class).invoke(obj, ModelConstant.COMPLETE);
	                obj.getClass().getMethod("setStatus", String.class).invoke(obj, ModelConstant.COMPLETE);
	                obj.getClass().getMethod("setStatusCode", String.class).invoke(obj, ModelConstant.COMPLETE_CODE);

	            } else if (action.equalsIgnoreCase(ModelConstant.REJECT)) {

	                obj.getClass().getMethod("setActive", Boolean.class).invoke(obj, true);
	                obj.getClass().getMethod("setRequestStatus", String.class).invoke(obj, ModelConstant.REJECTED);
	                obj.getClass().getMethod("setStatus", String.class).invoke(obj, ModelConstant.COMPLETE);
	                obj.getClass().getMethod("setStatusCode", String.class).invoke(obj, ModelConstant.COMPLETE_CODE);

	            } else if (action.equalsIgnoreCase(ModelConstant.REFER_BACK)) {

	                obj.getClass().getMethod("setActive", Boolean.class).invoke(obj, true);
	                obj.getClass().getMethod("setRequestStatus", String.class).invoke(obj, ModelConstant.REFER_BACK);
	                obj.getClass().getMethod("setStatus", String.class).invoke(obj, ModelConstant.PEN_M);
	                obj.getClass().getMethod("setStatusCode", String.class).invoke(obj, ModelConstant.PEN_M_CODE);

	            } else {
	                log.warn("Unknown action passed: {}", action);
	            }

	            obj.getClass().getMethod("setUpdatedDtm", Timestamp.class).invoke(obj, now);

	        } catch (Exception e) {
	            log.error("Error updating fields for delete operation: {}", e.getMessage(), e);
	        }
	    }

	    // Save using correct repo
	    T first = list.get(0);

	    if (first instanceof DistrictDetails)
	        return (List<T>) districtDetailsRepo.saveAll((List<DistrictDetails>) list);
	    if (first instanceof CircleDetails)
	        return (List<T>) circleDetailsRepo.saveAll((List<CircleDetails>) list);
	    if (first instanceof MouzaDetails)
	        return (List<T>) mouzaDetailsRepo.saveAll((List<MouzaDetails>) list);
	    if (first instanceof LotDetails)
	        return (List<T>) lotDetailsRepo.saveAll((List<LotDetails>) list);
	    if (first instanceof VillageDetails)
	        return (List<T>) villageDetailsRepo.saveAll((List<VillageDetails>) list);
	    if (first instanceof ParameterDetails)
	        return (List<T>) parameterDetailsRepo.saveAll((List<ParameterDetails>) list);
	    if (first instanceof SubParameterDetails)
	        return (List<T>) subParameterDetailsRepo.saveAll((List<SubParameterDetails>) list);
	    if (first instanceof LandCategories)
	        return (List<T>) landCategoriesRepo.saveAll((List<LandCategories>) list);
	    if (first instanceof AreaTypes)
	        return (List<T>) areaTypesRepo.saveAll((List<AreaTypes>) list);
	    if (first instanceof LandSubClassDetails)
	        return (List<T>) landSubClassDetailsRepo.saveAll((List<LandSubClassDetails>) list);

	    return null;
	}



	@Override
	public List<?> getRequestsByIdAndMasterAndActionAdmin(Long id, String masterType, String masterCode, String action,
			String statusCode) {

		final String methodName = "getRequestsByIdAndMasterAndActionSeniorMan";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={}", methodName, id, masterType, action,
				statusCode);

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
		String newRequestStatus = null;
		if (ModelConstant.APPROVE.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.COMPLETE;
			newRequestStatus = ModelConstant.COMPLETE;
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
		Object updatedEntity = updateEntityStatus(type, id, newStatus, newStatusCode, newRequestStatus, masterCode);
		if (updatedEntity == null) {
			log.warn("No record found for | masterType={} | id={} | method={}", masterType, id, methodName);
			return Collections.emptyList();
		}

		// Update related audit log
		log.debug("Fetching AuditLog for referenceId={} | featureName={} | statusCode={}", id, masterType, statusCode);

		List<AuditLog> auditLogs = auditLogRepo.findByReferenceIdAndFeatureName(id, masterType);

		if (auditLogs != null && !auditLogs.isEmpty()) {

			for (AuditLog logEntry : auditLogs) {
				logEntry.setStatusCode(ModelConstant.COMPLETE_CODE);
				logEntry.setStatus(ModelConstant.COMPLETE);
				logEntry.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
				logEntry.setUpdatedBy(loginId);
			}

			auditLogRepo.saveAll(auditLogs);

			log.info("AuditLog updated successfully | referenceId={} | count={}", id, auditLogs.size());
		} else {
			log.warn("No AuditLog found for referenceId={} | masterType={}", id, masterType);
		}

		// Log action for traceability
//		logAction(loginId, masterType, "request", loginId + ":" + action, masterType + " request update",
//				newStatus, newStatusCode, id);
		logAction(loginId, masterType, "Workflow", loginId + ":" + action + "," + masterType + "Code: " + masterCode,
				masterType + ": Workflow request update:" + action, newStatus, newStatusCode, id);

		log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
				id, action, loginId);

		return Collections.singletonList(updatedEntity);
	}
	
	////
	@Override
	public List<?> getRequestsByIdAndMasterAndActionLra(Long id, String masterType, String masterCode, String action,
			String statusCode) {

		final String methodName = "getRequestsByIdAndMasterAndActionLra";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={}", methodName, id, masterType, action,
				statusCode);

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
			newStatus = ModelConstant.PEN_CO;
			newStatusCode = ModelConstant.PEN_CO_CODE;
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
		log.debug("Fetching AuditLog for referenceId={} | featureName={} | statusCode={}", id, masterType, statusCode);

		AuditLog auditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType, statusCode);

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
		logAction(loginId, masterType, "Workflow", loginId + ":" + action + "," + masterType + "Code: " + masterCode,
				masterType + ": Workflow request update:" + action, newStatus, newStatusCode, id);

		log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
				id, action, loginId);

		return Collections.singletonList(updatedEntity);
	}
	
	@Override
	public List<?> getRequestsByIdAndMasterAndActionCo(Long id, String masterType, String masterCode, String action,
			String statusCode) {

		final String methodName = "getRequestsByIdAndMasterAndActionCo";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={}", methodName, id, masterType, action,
				statusCode);

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
			newStatus = ModelConstant.PEN_ADC;
			newStatusCode = ModelConstant.PEN_ADC_CODE;
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
		log.debug("Fetching AuditLog for referenceId={} | featureName={} | statusCode={}", id, masterType, statusCode);

		AuditLog auditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType, statusCode);

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
		logAction(loginId, masterType, "Workflow", loginId + ":" + action + "," + masterType + "Code: " + masterCode,
				masterType + ": Workflow request update:" + action, newStatus, newStatusCode, id);

		log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
				id, action, loginId);

		return Collections.singletonList(updatedEntity);
	}
	
	@Override
	public List<?> getRequestsByIdAndMasterAndActionAdc(Long id, String masterType, String masterCode, String action,
			String currentStatusCode) {

		final String methodName = "getRequestsByIdAndMasterAndActionAdc";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={}", methodName, id, masterType, action,
				currentStatusCode);

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
			newStatus = ModelConstant.PEN_DC;
			newStatusCode = ModelConstant.PEN_DC_CODE;
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
				currentStatusCode);

//		AuditLog auditLog = auditLogRepo.findByReferenceIdAndFeatureNameAndStatusCode(id, masterType,
//				currentStatusCode);
		
		AuditLog auditLog = auditLogRepo.findTopByReferenceIdAndFeatureNameAndStatusCodeOrderByIdDesc(id, masterType,
				currentStatusCode);

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
		logAction(loginId, masterType, "Workflow", loginId + ":" + action + "," + masterType + "Code: " + masterCode,
				masterType + ": Workflow request update:" + action, newStatus, newStatusCode, id);

		log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
				id, action, loginId);

		return Collections.singletonList(updatedEntity);
	}
	
	@Override
	public List<?> getRequestsByIdAndMasterAndActionDeputyCom(Long id, String masterType, String masterCode,
			String action, String statusCode, String requestType) {

		final String methodName = "getRequestsByIdAndMasterAndActionDeputyCom";
		log.info("[START] {}  | id={} | masterType={} | action={} | statusCode={} | requestType={}", methodName, id,
				masterType, action, statusCode, requestType);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()
				|| "anonymousUser".equals(authentication.getName())) {
			log.warn("Returning empty list due to invalid token.");
			return Collections.emptyList();
		}

		String loginId = authentication.getName();

		// --------------------------------------------
		// 1️⃣ NEW LOGIC: If requestType = DELETE → special behaviour
		// --------------------------------------------
		if (ModelConstant.DELETE.equalsIgnoreCase(requestType)) {

			log.info("Handling DELETE requestType → setting ALL active=false");

			Object result = performDeleteAction(masterType, masterCode,action);

			log.info("[SUCCESS] Delete operation completed");

			return result == null ? Collections.emptyList() : Collections.singletonList(result);
		}
		// --------------------------------------------
		// 2️⃣ Normal workflow (Approve / Reject / Refer Back)
		// --------------------------------------------

		String newStatus;
		String newStatusCode;
		String newRequestStatus = null;

		if (ModelConstant.APPROVE.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.COMPLETE;
			newStatusCode = ModelConstant.COMPLETE_CODE;
			newRequestStatus = ModelConstant.COMPLETE;

		} else if (ModelConstant.REJECT.equalsIgnoreCase(action)) {
			newStatus = ModelConstant.REJECT;
			newStatusCode = ModelConstant.REJECT_CODE;

		} else {
			newStatus = ModelConstant.REFER_BACK_TO_M;
			newStatusCode = ModelConstant.PEN_M_CODE;
		}

		Object updatedEntity = updateEntityStatus(masterType, id, newStatus, newStatusCode, newRequestStatus,
				masterCode);
		// Update related audit log
				log.debug("Fetching AuditLog for referenceId={} | featureName={} | statusCode={}", id, masterType, statusCode);

				List<AuditLog> auditLogs = auditLogRepo.findByReferenceIdAndFeatureName(id, masterType);

				if (auditLogs != null && !auditLogs.isEmpty()) {

					for (AuditLog logEntry : auditLogs) {
						logEntry.setStatusCode(ModelConstant.COMPLETE_CODE);
						logEntry.setStatus(ModelConstant.COMPLETE);
						logEntry.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
						logEntry.setUpdatedBy(loginId);
					}

					auditLogRepo.saveAll(auditLogs);

					log.info("AuditLog updated successfully | referenceId={} | count={}", id, auditLogs.size());
				} else {
					log.warn("No AuditLog found for referenceId={} | masterType={}", id, masterType);
				}

				// Log action for traceability
				logAction(loginId, masterType, "Workflow", loginId + ":" + action + "," + masterType + "Code: " + masterCode,
						masterType + ": Workflow request update:" + action, newStatus, newStatusCode, id);

				log.info("[SUCCESS] {} completed | masterType={} | id={} | action={} | performedBy={}", methodName, masterType,
						id, action, loginId);


		if (updatedEntity == null)
			return Collections.emptyList();

		return Collections.singletonList(updatedEntity);
	}





}
