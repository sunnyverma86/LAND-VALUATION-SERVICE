package com.areap2.controller.excel.map.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.areap2.constant.ModelConstant;
import com.areap2.controller.excel.map.enity.LandUseMaster;
import com.areap2.controller.excel.map.repo.LandUseMasterRepository;
import com.areap2.entity.AuditLog;
import com.areap2.model.ResponseModel;
import com.areap2.repository.AuditLogRepo;

@Service
public class LandUseMasterService {

	@Autowired
	private LandUseMasterRepository repository;

	@Autowired
	private AuditLogRepo auditLogRepo;

	@Transactional(rollbackFor = Exception.class)
	public ResponseModel save(LandUseMaster landUseMaster) {

		String methodName = "addLandUse";
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

			landUseMaster.setCreatedBy(loginId);
			landUseMaster.setRequestStatus(ModelConstant.ADD);

			if (userRoles.contains(ModelConstant.ADMIN) || userRoles.contains(ModelConstant.DC)) {

				landUseMaster.setActive(true);
				landUseMaster.setStatus(ModelConstant.COMPLETE);
				landUseMaster.setStatusCode(ModelConstant.COMPLETE_CODE);

			} else if (userRoles.contains(ModelConstant.ADC)) {

				landUseMaster.setActive(false);
				landUseMaster.setStatus(ModelConstant.PEN_DC);
				landUseMaster.setStatusCode(ModelConstant.PEN_DC_CODE);

			} else if (userRoles.contains(ModelConstant.CO)) {

				landUseMaster.setActive(false);
				landUseMaster.setStatus(ModelConstant.PEN_ADC);
				landUseMaster.setStatusCode(ModelConstant.PEN_ADC_CODE);

			} else if (userRoles.contains(ModelConstant.LRA)) {

				landUseMaster.setActive(false);
				landUseMaster.setStatus(ModelConstant.PEN_CO);
				landUseMaster.setStatusCode(ModelConstant.PEN_CO_CODE);

			} else {

				landUseMaster.setActive(false);
				landUseMaster.setStatus(ModelConstant.PEN_LRA);
				landUseMaster.setStatusCode(ModelConstant.PEN_LRA_CODE);
			}

			LandUseMaster saved = repository.save(landUseMaster);

			logAction(loginId, ModelConstant.LANDUSE, ModelConstant.ADD, "Land Use : " + saved.getLandUseName(),
					"Land Use added", saved.getStatus(), saved.getStatusCode(), saved.getId());

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Land Use added successfully.");
			response.setData(saved);

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	@Transactional(rollbackFor = Exception.class)
	public ResponseModel update(Long id, LandUseMaster request) {

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

			LandUseMaster entity = repository.findById(id)
					.orElseThrow(() -> new RuntimeException("Land Use not found"));

			entity.setLandUseName(request.getLandUseName());
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

			LandUseMaster updated = repository.save(entity);

			logAction(loginId, ModelConstant.LANDUSE, ModelConstant.UPDATE, "Land Use : " + updated.getLandUseName(),
					"Land Use updated", updated.getStatus(), updated.getStatusCode(), updated.getId());

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Land Use updated successfully.");
			response.setData(updated);

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	public ResponseModel getAll() {

		ResponseModel response = new ResponseModel();

		List<LandUseMaster> list = repository.findByStatus("ACTIVE");

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(list);

		return response;
	}

	public ResponseModel getById(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<LandUseMaster> optional = repository.findById(id);

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

	@Transactional(rollbackFor = Exception.class)
	public ResponseModel delete(Long id) {

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

			LandUseMaster entity = repository.findById(id)
					.orElseThrow(() -> new RuntimeException("Land Use not found"));

			entity.setRequestStatus(ModelConstant.DELETE);
			entity.setUpdatedBy(loginId);
			entity.setUpdatedDtm(LocalDateTime.now());

			if (userRoles.contains(ModelConstant.ADMIN) || userRoles.contains(ModelConstant.DC)) {

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

			LandUseMaster deleted = repository.save(entity);

			logAction(loginId, ModelConstant.LANDUSE, ModelConstant.DELETE, "Land Use : " + deleted.getLandUseName(),
					"Land Use deleted", deleted.getStatus(), deleted.getStatusCode(), deleted.getId());

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Land Use deleted successfully.");
			response.setData(deleted);

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	public void logAction(String loginId, String featureName, String actionType, String featureDescription,
			String message, String stat, String statCode, long genId) {
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
		auditLogRepo.save(log);

	}

}
