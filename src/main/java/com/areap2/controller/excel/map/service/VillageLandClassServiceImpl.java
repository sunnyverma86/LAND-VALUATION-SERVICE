package com.areap2.controller.excel.map.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
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
import com.areap2.controller.excel.map.enity.VillageLandClassEntity;
import com.areap2.controller.excel.map.repo.VillageLandClassRepository;
import com.areap2.entity.AuditLog;
import com.areap2.model.ResponseModel;
import com.areap2.repository.AuditLogRepo;

@Service
public class VillageLandClassServiceImpl {

	Logger log = LoggerFactory.getLogger(DistrictMinimumBaseDatabaseServiceImpl.class);
	long startTime = System.currentTimeMillis();

	@Autowired
	private VillageLandClassRepository repository;

	@Autowired
	private LandOutputService landOutputService;

	@Autowired
	AuditLogRepo auditLogRepo;

	public ResponseModel save(VillageLandClassEntity request) {
		String methodName = "addVillageFactor";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to add Village Details | District Name: {} | Method: {}", request.getVillage(),
					methodName);
			// Generate new district code
			Integer maxDistricMinimumtCode = repository.findMaxVillageFactorCode();
			Integer newDistrictMinimumCode = (maxDistricMinimumtCode == null) ? 10001 : maxDistricMinimumtCode + 1;

			// Get logged-in user

			// Get logged-in user
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || !authentication.isAuthenticated()
					|| "anonymousUser".equals(authentication.getName())) {
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Token is expired or invalid");
				return response;
			}
			String loginId = authentication.getName();

			// Extract roles
			Set<String> userRoles = authentication.getAuthorities().stream()
					.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());

			log.info("User '{}' has roles: {}", loginId, userRoles);

			// Prepare entity
			request.setCreatedBy(loginId);
			request.setVillageFactorCode(newDistrictMinimumCode.toString());
			request.setCreatedDtm(LocalDateTime.now());
			request.setRequestStatus(ModelConstant.ADD);

			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				request.setActive(true);
				request.setStatus(ModelConstant.COMPLETE);
				request.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.DC)) {
				request.setActive(true);
				request.setStatus(ModelConstant.COMPLETE);
				request.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.ADC)) {
				request.setActive(false);
				request.setStatus(ModelConstant.PEN_DC);
				request.setStatusCode(ModelConstant.PEN_DC_CODE);
			} else if (userRoles.contains(ModelConstant.CO)) {
				request.setActive(false);
				request.setStatus(ModelConstant.PEN_ADC);
				request.setStatusCode(ModelConstant.PEN_ADC_CODE);
			} else if (userRoles.contains(ModelConstant.LRA)) {
				request.setActive(false);
				request.setStatus(ModelConstant.PEN_CO);
				request.setStatusCode(ModelConstant.PEN_CO_CODE);
			} else {
				request.setActive(false);
				request.setStatus(ModelConstant.PEN_LRA);
				request.setStatusCode(ModelConstant.PEN_LRA_CODE);
			}

			// Save entity
			VillageLandClassEntity savedDistrictDetails = repository.save(request);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record saved successfully.");
			response.setData(request);

			// return response;

			// Log action

			logAction(loginId, ModelConstant.VILLAGE_FACTOR_CALCULATION, ModelConstant.ADD,
					"District: " + savedDistrictDetails.getDistrict() + ", Rural_Urban: "
							+ savedDistrictDetails.getRuralUrban() + ", Mouza: " + savedDistrictDetails.getMouzaName()
							+ ", Band Ratio: " + savedDistrictDetails.getBandRatio(),
					"Village added, name: " + savedDistrictDetails.getVillage(), savedDistrictDetails.getStatus(),
					savedDistrictDetails.getStatusCode(), savedDistrictDetails.getVillageFactorGenId(),
					savedDistrictDetails.getBandRatio(), request.getBandRatio());
			// Build response
			response.setData(savedDistrictDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Village Factor added successfully | Village Name: " + savedDistrictDetails.getVillage()
					+ ", Village Band Ratio: " + savedDistrictDetails.getBandRatio());

		} catch (Exception e) {
			log.error("Error occurred while adding Village Details | Village Name: {} | Method: {}",
					request.getVillage(), methodName, e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add Village Details | Village Name: " + request.getVillage() + ", Error: "
					+ e.getMessage());
		}

		return response;
	}

	public ResponseModel getAll() {

		ResponseModel response = new ResponseModel();

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(repository.findByStatus("ACTIVE"));

		return response;
	}

	public ResponseModel getAllWithInactive() {

		ResponseModel response = new ResponseModel();

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(repository.findAll());

		return response;
	}

	public ResponseModel getById(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<VillageLandClassEntity> optional = repository.findByVillageFactorGenIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			response.setHttpStatus(HttpStatus.OK);
			response.setData(optional.get());

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Active record not found.");
		}

		return response;
	}

	public ResponseModel update(Long id, VillageLandClassEntity request) {

		String methodName = "updateVillageFactor";
		ResponseModel response = new ResponseModel();

		try {

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (authentication == null || !authentication.isAuthenticated()
					|| "anonymousUser".equals(authentication.getName())) {
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Token is expired or invalid");
				return response;
			}

			String loginId = authentication.getName();

			Set<String> userRoles = authentication.getAuthorities().stream()
					.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());

			Optional<VillageLandClassEntity> optional = repository.findById(id);

			if (!optional.isPresent()) {
				response.setHttpStatus(HttpStatus.NOT_FOUND);
				response.setMessage("Record not found.");
				return response;
			}

			VillageLandClassEntity entity = optional.get();
			BigDecimal oldValues = entity.getBandRatio();
			entity.setDistrict(entity.getDistrict());
			entity.setRuralUrban(entity.getRuralUrban());
			entity.setMouzaName(entity.getMouzaName());
			entity.setBandRatio(request.getBandRatio());

			entity.setUpdatedBy(loginId);
			entity.setUpdatedDtm(LocalDateTime.now());
			entity.setRequestStatus(ModelConstant.UPDATE);

			if (userRoles.contains(ModelConstant.ADMIN)) {
				entity.setActive(true);
				entity.setStatus(ModelConstant.COMPLETE);
				entity.setStatusCode(ModelConstant.COMPLETE_CODE);

			} else if (userRoles.contains(ModelConstant.DC)) {
				entity.setActive(true);
				entity.setStatus(ModelConstant.COMPLETE);
				entity.setStatusCode(ModelConstant.COMPLETE_CODE);

			} else if (userRoles.contains(ModelConstant.ADC)) {
				entity.setActive(false);
				entity.setStatus(ModelConstant.PEN_DC);
				entity.setStatusCode(ModelConstant.PEN_DC_CODE);

			} else if (userRoles.contains(ModelConstant.CO)) {
				entity.setActive(false);
				entity.setStatus(ModelConstant.PEN_ADC);
				entity.setStatusCode(ModelConstant.PEN_ADC_CODE);

			} else if (userRoles.contains(ModelConstant.LRA)) {
				entity.setActive(false);
				entity.setStatus(ModelConstant.PEN_CO);
				entity.setStatusCode(ModelConstant.PEN_CO_CODE);

			} else {
				entity.setActive(false);
				entity.setStatus(ModelConstant.PEN_LRA);
				entity.setStatusCode(ModelConstant.PEN_LRA_CODE);
			}
//write the code
			VillageLandClassEntity updated = repository.save(entity);
			if (userRoles.contains(ModelConstant.ADMIN)) {
				long totalRecords = landOutputService.generateOutputTable();
				long executionTime = (System.currentTimeMillis() - startTime) / 1000;

				log.info("========================================");
				log.info("Land Output Generation Completed");
				log.info("Total Records Processed : {}", totalRecords);
				log.info("Execution Time : {} sec", executionTime);
				log.info("========================================");

			} else if (userRoles.contains(ModelConstant.DC)) {
				long totalRecords = landOutputService.generateOutputTable();
				long executionTime = (System.currentTimeMillis() - startTime) / 1000;

				log.info("========================================");
				log.info("Land Output Generation Completed");
				log.info("Total Records Processed : {}", totalRecords);
				log.info("Execution Time : {} sec", executionTime);
				log.info("========================================");
			}

			logAction(loginId, ModelConstant.VILLAGE_FACTOR_CALCULATION, ModelConstant.UPDATE,
					"District: " + updated.getDistrict() + ", Rural_Urban: " + updated.getRuralUrban() + ", Village: "
							+ updated.getVillage() + ", Band Ratio Value: " + updated.getBandRatio(),
					"District Minimum updated.", updated.getStatus(), updated.getStatusCode(),
					updated.getVillageFactorGenId(),

					oldValues, updated.getBandRatio());

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record updated successfully.");
			response.setData(updated);

		} catch (Exception e) {

			log.error("Error in {} ", methodName, e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	public ResponseModel delete(Long id) {

		String methodName = "deleteVillageFactor";
		ResponseModel response = new ResponseModel();

		try {

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (authentication == null || !authentication.isAuthenticated()
					|| "anonymousUser".equals(authentication.getName())) {
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Token is expired or invalid");
				return response;
			}

			String loginId = authentication.getName();

			Set<String> userRoles = authentication.getAuthorities().stream()
					.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());

			Optional<VillageLandClassEntity> optional = repository.findById(id);

			if (!optional.isPresent()) {
				response.setHttpStatus(HttpStatus.NOT_FOUND);
				response.setMessage("Record not found.");
				return response;
			}

			VillageLandClassEntity entity = optional.get();

			entity.setRequestStatus(ModelConstant.DELETE);
			entity.setUpdatedBy(loginId);
			entity.setUpdatedDtm(LocalDateTime.now());

			if (userRoles.contains(ModelConstant.ADMIN)) {
				entity.setActive(false);
				entity.setStatus(ModelConstant.COMPLETE);
				entity.setStatusCode(ModelConstant.COMPLETE_CODE);

			} else if (userRoles.contains(ModelConstant.DC)) {
				entity.setActive(false);
				entity.setStatus(ModelConstant.COMPLETE);
				entity.setStatusCode(ModelConstant.COMPLETE_CODE);

			} else if (userRoles.contains(ModelConstant.ADC)) {
				entity.setActive(true);
				entity.setStatus(ModelConstant.PEN_DC);
				entity.setStatusCode(ModelConstant.PEN_DC_CODE);

			} else if (userRoles.contains(ModelConstant.CO)) {
				entity.setActive(true);
				entity.setStatus(ModelConstant.PEN_ADC);
				entity.setStatusCode(ModelConstant.PEN_ADC_CODE);

			} else if (userRoles.contains(ModelConstant.LRA)) {
				entity.setActive(true);
				entity.setStatus(ModelConstant.PEN_CO);
				entity.setStatusCode(ModelConstant.PEN_CO_CODE);

			} else {
				entity.setActive(true);
				entity.setStatus(ModelConstant.PEN_LRA);
				entity.setStatusCode(ModelConstant.PEN_LRA_CODE);
			}

			VillageLandClassEntity deleted = repository.save(entity);

			logAction(loginId, ModelConstant.VILLAGE_FACTOR_CALCULATION, ModelConstant.DELETE,
					"District: " + deleted.getDistrict() + ", Rural_Urban: " + deleted.getRuralUrban() + ", Village: "
							+ deleted.getVillage() + ", Village Band Ratio: " + deleted.getBandRatio(),
					"Village Factor deleted.", deleted.getStatus(), deleted.getStatusCode(),
					deleted.getVillageFactorGenId(),

					deleted.getBandRatio(), deleted.getBandRatio());

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record deleted successfully.");
			response.setData(deleted);

		} catch (Exception e) {

			log.error("Error in {} ", methodName, e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	public void logAction(String loginId, String featureName, String actionType, String featureDescription,
			String message, String stat, String statCode, long genId, BigDecimal oldValue, BigDecimal newValue) {
		AuditLog log = new AuditLog();
		log.setLoginId(loginId);
		log.setFeatureName(featureName);
		log.setActionType(actionType);
		log.setActionDatetime(new Timestamp(System.currentTimeMillis()));
		log.setFeatureDescription(featureDescription);
		log.setMessage(message);
		log.setStatus(stat);
		log.setStatusCode(statCode);
		log.setReferenceId(genId);
		log.setOldValue(oldValue);
		log.setNewValue(newValue);
		auditLogRepo.save(log);

	}
}
