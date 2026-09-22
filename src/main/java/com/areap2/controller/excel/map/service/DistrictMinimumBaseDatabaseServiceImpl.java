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
import org.springframework.transaction.annotation.Transactional;

import com.areap2.constant.ModelConstant;
import com.areap2.controller.excel.map.enity.DistrictMinimumBaseDatabase;
import com.areap2.controller.excel.map.repo.DistrictMinimumBaseDatabaseRepository;
import com.areap2.entity.AuditLog;
import com.areap2.model.ResponseModel;
import com.areap2.repository.AuditLogRepo;

@Service
public class DistrictMinimumBaseDatabaseServiceImpl {

	Logger log = LoggerFactory.getLogger(DistrictMinimumBaseDatabaseServiceImpl.class);
	long startTime = System.currentTimeMillis();

	@Autowired
	private LandOutputService landOutputService;

	@Autowired
	private DistrictMinimumBaseDatabaseRepository repository;

	@Autowired
	AuditLogRepo auditLogRepo;

	public ResponseModel getAll() {

		ResponseModel response = new ResponseModel();

		List<DistrictMinimumBaseDatabase> list = repository.findByStatus("ACTIVE");

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(list);

		return response;
	}

	@Transactional(rollbackFor = Exception.class)
	public ResponseModel save(DistrictMinimumBaseDatabase districtDetailsModel) {
		String methodName = "addDistrictMinimum";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to add District Details | District Name: {} | Method: {}",
					districtDetailsModel.getDistrict(), methodName);
			// Generate new district code
			Integer maxDistricMinimumtCode = repository.findMaxDistrictMinimumCode();
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
			districtDetailsModel.setCreatedBy(loginId);
			districtDetailsModel.setDistrictMinimumCode(newDistrictMinimumCode.toString());
			districtDetailsModel.setCreatedDtm(LocalDateTime.now());
			districtDetailsModel.setRequestStatus(ModelConstant.ADD);

			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				districtDetailsModel.setActive(true);
				districtDetailsModel.setStatus(ModelConstant.COMPLETE);
				districtDetailsModel.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.DC)) {
				districtDetailsModel.setActive(true);
				districtDetailsModel.setStatus(ModelConstant.COMPLETE);
				districtDetailsModel.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.ADC)) {
				districtDetailsModel.setActive(false);
				districtDetailsModel.setStatus(ModelConstant.PEN_DC);
				districtDetailsModel.setStatusCode(ModelConstant.PEN_DC_CODE);
			} else if (userRoles.contains(ModelConstant.CO)) {
				districtDetailsModel.setActive(false);
				districtDetailsModel.setStatus(ModelConstant.PEN_ADC);
				districtDetailsModel.setStatusCode(ModelConstant.PEN_ADC_CODE);
			} else if (userRoles.contains(ModelConstant.LRA)) {
				districtDetailsModel.setActive(false);
				districtDetailsModel.setStatus(ModelConstant.PEN_CO);
				districtDetailsModel.setStatusCode(ModelConstant.PEN_CO_CODE);
			} else {
				districtDetailsModel.setActive(false);
				districtDetailsModel.setStatus(ModelConstant.PEN_LRA);
				districtDetailsModel.setStatusCode(ModelConstant.PEN_LRA_CODE);
			}

			// Save entity
			DistrictMinimumBaseDatabase savedDistrictDetails = repository.save(districtDetailsModel);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record saved successfully.");
			response.setData(districtDetailsModel);

			// return response;

			// Log action

			logAction(loginId, ModelConstant.DISTRICT_MINIMUM, ModelConstant.ADD,
					"District: " + savedDistrictDetails.getDistrict() + ", Rural_Urban: "
							+ savedDistrictDetails.getRuralUrban() + ", Land Use: " + savedDistrictDetails.getLandUse()
							+ ", District Minimum Value: " + savedDistrictDetails.getDistrictMinimumValue(),
					"District Minimum added, name: " + savedDistrictDetails.getDistrictMinimumValue(),
					savedDistrictDetails.getStatus(), savedDistrictDetails.getStatusCode(),
					savedDistrictDetails.getDistrictMinimumGenId(), savedDistrictDetails.getDistrictMinimumValue(),
					savedDistrictDetails.getDistrictMinimumValue());
			// Build response
			response.setData(savedDistrictDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage(
					"District Minimum added successfully | District Name: " + savedDistrictDetails.getDistrict()
							+ ", District Minimum Values: " + savedDistrictDetails.getDistrictMinimumValue());

		} catch (Exception e) {
			log.error("Error occurred while adding District Details | District Name: {} | Method: {}",
					districtDetailsModel.getDistrict(), methodName, e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add District Details | District Name: " + districtDetailsModel.getDistrict()
					+ ", Error: " + e.getMessage());
		}

		return response;
	}

	public void logAction(String loginId, String featureName, String actionType, String featureDescription,
			String message, String stat, String statCode, long genId, double oldValue, double newValue) {
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
		log.setOldValue(BigDecimal.valueOf(oldValue));
		log.setNewValue(BigDecimal.valueOf(newValue));
		auditLogRepo.save(log);

	}

	public ResponseModel getById(Long id) {

		ResponseModel response = new ResponseModel();

		try {

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (authentication == null || !authentication.isAuthenticated()
					|| "anonymousUser".equals(authentication.getName())) {
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Token is expired or invalid");
				return response;
			}

			Optional<DistrictMinimumBaseDatabase> optional = repository.findById(id);

			if (optional.isPresent()) {
				response.setHttpStatus(HttpStatus.OK);
				response.setMessage("Record fetched successfully.");
				response.setData(optional.get());
			} else {
				response.setHttpStatus(HttpStatus.NOT_FOUND);
				response.setMessage("Record not found.");
			}

		} catch (Exception e) {
			log.error("Error while fetching record {}", id, e);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	@Transactional(rollbackFor = Exception.class)
	public ResponseModel update(Long id, DistrictMinimumBaseDatabase request) {

		String methodName = "updateDistrictMinimum";
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

			Optional<DistrictMinimumBaseDatabase> optional = repository.findById(id);

			if (!optional.isPresent()) {
				response.setHttpStatus(HttpStatus.NOT_FOUND);
				response.setMessage("Record not found.");
				return response;
			}

			DistrictMinimumBaseDatabase entity = optional.get();
			double oldValue=entity.getDistrictMinimumValue();
			entity.setDistrict(entity.getDistrict());
			entity.setRuralUrban(entity.getRuralUrban());
			entity.setLandUse(entity.getLandUse());
			entity.setDistrictMinimumValue(request.getDistrictMinimumValue());

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
			DistrictMinimumBaseDatabase updated = repository.save(entity);
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

			logAction(loginId, ModelConstant.DISTRICT_MINIMUM, ModelConstant.UPDATE,
					"District: " + updated.getDistrict() + ", Rural_Urban: " + updated.getRuralUrban() + ", Land Use: "
							+ updated.getLandUse() + ", District Minimum Value: " + updated.getDistrictMinimumValue(),
					"District Minimum updated.", updated.getStatus(), updated.getStatusCode(),
					updated.getDistrictMinimumGenId(), oldValue,
					updated.getDistrictMinimumValue());

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

	@Transactional(rollbackFor = Exception.class)
	public ResponseModel delete(Long id) {

		String methodName = "deleteDistrictMinimum";
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

			Optional<DistrictMinimumBaseDatabase> optional = repository.findById(id);

			if (!optional.isPresent()) {
				response.setHttpStatus(HttpStatus.NOT_FOUND);
				response.setMessage("Record not found.");
				return response;
			}

			DistrictMinimumBaseDatabase entity = optional.get();

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

			DistrictMinimumBaseDatabase deleted = repository.save(entity);

			logAction(loginId, ModelConstant.DISTRICT_MINIMUM, ModelConstant.DELETE,
					"District: " + deleted.getDistrict() + ", Rural_Urban: " + deleted.getRuralUrban() + ", Land Use: "
							+ deleted.getLandUse() + ", District Minimum Value: " + deleted.getDistrictMinimumValue(),
					"District Minimum deleted.", deleted.getStatus(), deleted.getStatusCode(),
					deleted.getDistrictMinimumGenId(), entity.getDistrictMinimumValue(),
					deleted.getDistrictMinimumValue());

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
}
