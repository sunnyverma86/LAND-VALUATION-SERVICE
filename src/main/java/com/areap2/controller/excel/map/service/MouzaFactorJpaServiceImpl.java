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
import com.areap2.controller.excel.map.enity.MouzaFactorBaseDatabase;
import com.areap2.controller.excel.map.repo.MouzaFactorJpaRepository;
import com.areap2.entity.AuditLog;
import com.areap2.model.ResponseModel;
import com.areap2.repository.AuditLogRepo;

@Service

public class MouzaFactorJpaServiceImpl {

	Logger log = LoggerFactory.getLogger(MouzaFactorJpaServiceImpl.class);

	long startTime = System.currentTimeMillis();

	@Autowired
	private LandOutputService landOutputService;

	@Autowired
	private MouzaFactorJpaRepository repository;

	@Autowired
	private AuditLogRepo auditLogRepo;

	public ResponseModel save(MouzaFactorBaseDatabase request) {
		String methodName = "addDistrictMinimum";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to add LandUseFactor Details | District Name: {} | Method: {}",
					request.getDistrict(), methodName);
			// Generate new district code
			Integer maxMouzaFactorCode = repository.findMaxMouzaFactorCode();
			Integer newmaxMouzaFactorCode = (maxMouzaFactorCode == null) ? 10001 : maxMouzaFactorCode + 1;

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
			request.setMouzaFactorCode(newmaxMouzaFactorCode.toString());
			request.setCurrent(request.getCurrent());
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
			MouzaFactorBaseDatabase savedMouzaFactorDetails = repository.save(request);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record saved successfully.");
			response.setData(request);

			// return response;

			// Log action

			logAction(loginId, ModelConstant.MOUZA_FACTOR_CALCULATION, ModelConstant.ADD,
					"District: " + savedMouzaFactorDetails.getDistrict() + ", Rural_Urban: "
							+ savedMouzaFactorDetails.getRuralUrban() + ", Mouza: " + savedMouzaFactorDetails.getMouza()
							+ ", Mouza Factor Value: " + savedMouzaFactorDetails.getCurrent(),
					"Mouza Factor added, name: " + savedMouzaFactorDetails.getMouza(),
					savedMouzaFactorDetails.getStatus(), savedMouzaFactorDetails.getStatusCode(),
					savedMouzaFactorDetails.getMouzaFactorGenId(), savedMouzaFactorDetails.getCurrent(),
					request.getCurrent());
			// Build response
			response.setData(savedMouzaFactorDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Mouza Factor added successfully | Mouza Name: " + savedMouzaFactorDetails.getMouza()
					+ ", Mouza Factor Values: " + savedMouzaFactorDetails.getCurrent());

		} catch (Exception e) {
			log.error("Error occurred while adding Mouza Factor Details | Mouza Name: {} | Method: {}",
					request.getMouza(), methodName, e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add Mouza Factor Details | Mouza Name: " + request.getMouza() + ", Error: "
					+ e.getMessage());
		}

		return response;
	}

	public ResponseModel getAllWithInactive() {

		ResponseModel response = new ResponseModel();

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(repository.findAll());

		return response;
	}

	public ResponseModel getAll() {

		ResponseModel response = new ResponseModel();

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(repository.findByStatus("ACTIVE"));

		return response;
	}

	public ResponseModel getById(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<MouzaFactorBaseDatabase> optional = repository.findByMouzaFactorGenIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			response.setHttpStatus(HttpStatus.OK);
			response.setData(optional.get());

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Active record not found.");
		}

		return response;
	}

	public ResponseModel update(Long id, MouzaFactorBaseDatabase request) {

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

			MouzaFactorBaseDatabase entity = repository.findById(id)
					.orElseThrow(() -> new RuntimeException("Land Use not found"));
			BigDecimal oldValues = entity.getCurrent();
			entity.setCurrent(request.getCurrent());
			entity.setUpdatedBy(loginId);
			entity.setUpdatedDtm(LocalDateTime.now());
			entity.setRequestStatus(ModelConstant.UPDATE);

			if (userRoles.contains(ModelConstant.ADMIN) || userRoles.contains(ModelConstant.DC)) {

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

			MouzaFactorBaseDatabase updated = repository.save(entity);
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

			logAction(loginId, ModelConstant.MOUZA_FACTOR_CALCULATION, ModelConstant.UPDATE,
					"Mouza : " + updated.getMouza() + " ,CurrentValue: " + updated.getCurrent(), "Mouza Factor updated",
					updated.getStatus(), updated.getStatusCode(), updated.getMouzaFactorGenId(), oldValues,
					updated.getCurrent());

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Mouza Factor updated successfully.");
			response.setData(updated);

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	public ResponseModel delete(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<MouzaFactorBaseDatabase> optional = repository.findByMouzaFactorGenIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			String user = "SYSTEM";

			MouzaFactorBaseDatabase record = optional.get();

			record.setStatus("INACTIVE");
			record.setUpdatedBy(user);
			record.setUpdatedDtm(LocalDateTime.now());

			repository.save(record);

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record deleted successfully.");

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Active record not found.");
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
