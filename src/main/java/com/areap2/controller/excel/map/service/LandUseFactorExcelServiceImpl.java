package com.areap2.controller.excel.map.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
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
import com.areap2.controller.excel.map.enity.LandUseFactorExcelEntity;
import com.areap2.controller.excel.map.repo.LandUseFactorExcelEntityRepository;
import com.areap2.entity.AuditLog;
import com.areap2.model.ResponseModel;
import com.areap2.repository.AuditLogRepo;

@Service
public class LandUseFactorExcelServiceImpl {

	Logger log = LoggerFactory.getLogger(LandUseFactorExcelServiceImpl.class);
	long startTime = System.currentTimeMillis();

	@Autowired
	private LandUseFactorExcelEntityRepository repository;

	@Autowired
	private LandOutputService landOutputService;

	@Autowired
	AuditLogRepo auditLogRepo;

	public ResponseModel save(LandUseFactorExcelEntity lufModel) {
		String methodName = "addDistrictMinimum";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to add LandUseFactor Details | District Name: {} | Method: {}",
					lufModel.getDistrict(), methodName);
			// Generate new district code
			Integer maxLufCode = repository.findMaxLandUseFactorCode();
			Integer newmaxLufCodeCode = (maxLufCode == null) ? 10001 : maxLufCode + 1;

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
			lufModel.setCreatedBy(loginId);
			lufModel.setLandUseFactorCode(newmaxLufCodeCode.toString());
			lufModel.setCreatedDtm(LocalDateTime.now());
			lufModel.setRequestStatus(ModelConstant.ADD);

			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				lufModel.setActive(true);
				lufModel.setStatus(ModelConstant.COMPLETE);
				lufModel.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.DC)) {
				lufModel.setActive(true);
				lufModel.setStatus(ModelConstant.COMPLETE);
				lufModel.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.ADC)) {
				lufModel.setActive(false);
				lufModel.setStatus(ModelConstant.PEN_DC);
				lufModel.setStatusCode(ModelConstant.PEN_DC_CODE);
			} else if (userRoles.contains(ModelConstant.CO)) {
				lufModel.setActive(false);
				lufModel.setStatus(ModelConstant.PEN_ADC);
				lufModel.setStatusCode(ModelConstant.PEN_ADC_CODE);
			} else if (userRoles.contains(ModelConstant.LRA)) {
				lufModel.setActive(false);
				lufModel.setStatus(ModelConstant.PEN_CO);
				lufModel.setStatusCode(ModelConstant.PEN_CO_CODE);
			} else {
				lufModel.setActive(false);
				lufModel.setStatus(ModelConstant.PEN_LRA);
				lufModel.setStatusCode(ModelConstant.PEN_LRA_CODE);
			}

			// Save entity
			LandUseFactorExcelEntity savedLufDetails = repository.save(lufModel);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record saved successfully.");
			response.setData(lufModel);

			// return response;

			// Log action

			logAction(loginId, ModelConstant.LAND_USE_FACTOR, ModelConstant.ADD,
					"District: " + savedLufDetails.getDistrict() + ", Rural_Urban: " + savedLufDetails.getRuralUrban()
							+ ", Land Use: " + savedLufDetails.getLandUse() + ", LUF Value: "
							+ savedLufDetails.getLuf(),
					"Land Use Factor added, name: " + savedLufDetails.getLuf(), savedLufDetails.getStatus(),
					savedLufDetails.getStatusCode(), savedLufDetails.getLandUseFactorGenId(),
					savedLufDetails.getLuf(),lufModel.getLuf()
					);
			// Build response
			response.setData(savedLufDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("District Minimum added successfully | District Name: " + savedLufDetails.getDistrict()
					+ ", District Minimum Values: " + savedLufDetails.getLuf());

		} catch (Exception e) {
			log.error("Error occurred while adding District Details | District Name: {} | Method: {}",
					lufModel.getDistrict(), methodName, e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add District Details | District Name: " + lufModel.getDistrict()
					+ ", Error: " + e.getMessage());
		}

		return response;
	}







	public ResponseModel getAll() {

		ResponseModel response = new ResponseModel();

		List<LandUseFactorExcelEntity> list = repository.findByStatus(ModelConstant.COMPLETE);

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(list);

		return response;
	}

	public ResponseModel getById(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<LandUseFactorExcelEntity> optional = repository.findByLandUseFactorGenIdAndStatus(id, ModelConstant.COMPLETE);

		if (optional.isPresent()) {

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record found.");
			response.setData(optional.get());

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Record not found.");
		}

		return response;
	}

	public ResponseModel update(Long id, LandUseFactorExcelEntity request) {

		String methodName = "update LandUseFactor";
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

			Optional<LandUseFactorExcelEntity> optional = repository.findById(id);

			if (!optional.isPresent()) {
				response.setHttpStatus(HttpStatus.NOT_FOUND);
				response.setMessage("Record not found.");
				return response;
			}

			LandUseFactorExcelEntity entity = optional.get();
			BigDecimal oldValue = entity.getLuf();
			entity.setDistrict(entity.getDistrict());
			entity.setRuralUrban(entity.getRuralUrban());
			entity.setLandUse(entity.getLandUse());
			entity.setLuf(request.getLuf());

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
			LandUseFactorExcelEntity updated = repository.save(entity);
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

			logAction(loginId, ModelConstant.LAND_USE_FACTOR, ModelConstant.UPDATE,
					"District: " + updated.getDistrict() + ", Rural_Urban: " + updated.getRuralUrban() + ", Land Use: "
							+ updated.getLandUse() + ", LAND_USE_FACTOR Value: " + updated.getLuf(),
					"District Minimum updated.", updated.getStatus(), updated.getStatusCode(),
					updated.getLandUseFactorGenId(),
					oldValue,updated.getLuf());

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

	public ResponseModel delete(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<LandUseFactorExcelEntity> optional = repository.findByLandUseFactorGenIdAndStatus(id,
				ModelConstant.COMPLETE);

		if (optional.isPresent()) {

			String user = "SYSTEM";

			LandUseFactorExcelEntity record = optional.get();

			record.setStatus("INACTIVE");
			record.setUpdatedBy(user);
			record.setUpdatedDtm(LocalDateTime.now());

			repository.save(record);

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record deleted successfully.");

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Record not found.");
		}

		return response;
	}

}
