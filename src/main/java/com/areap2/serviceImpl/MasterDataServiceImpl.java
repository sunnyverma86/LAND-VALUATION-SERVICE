package com.areap2.serviceImpl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.areap2.constant.ModelConstant;
import com.areap2.entity.AreaTypes;
import com.areap2.entity.AuditLog;
import com.areap2.entity.CircleDetails;
import com.areap2.entity.DistrictDetails;
import com.areap2.entity.LandCategories;
import com.areap2.entity.LandSubClassDetails;
import com.areap2.entity.LandsCategoryDetails;
import com.areap2.entity.LotDetails;
import com.areap2.entity.MouzaDetails;
import com.areap2.entity.ParamDetails;
import com.areap2.entity.ParameterDetails;
import com.areap2.entity.SubParameterDetails;
import com.areap2.entity.VillageDetails;
import com.areap2.entity.ZonalValues;
import com.areap2.model.AreaTypesModelRequest;
import com.areap2.model.BasePriceUpdateDetailsModelRequest;
import com.areap2.model.CircleDetailsModelRequest;
import com.areap2.model.CircleDetailsModelUpdateRequest;
import com.areap2.model.DistrictDetailsModelRequest;
import com.areap2.model.LandCategoriesModelRequest;
import com.areap2.model.LandSubClassDetailsModelRequest;
import com.areap2.model.LandSubClassDetailsModelUpdateRequest;
import com.areap2.model.LotDetailsModelRequest;
import com.areap2.model.LotDetailsModelUpdateRequest;
import com.areap2.model.MouzaDetailsModelRequest;
import com.areap2.model.MouzaDetailsModelUpdateRequest;
import com.areap2.model.ParameterDetailsModelRequest;
import com.areap2.model.ParameterDetailsModelUpdateRequest;
import com.areap2.model.ResponseModel;
import com.areap2.model.SroDetailsModelRequest;
import com.areap2.model.SroDetailsModelUpdateRequest;
import com.areap2.model.SubParameterDetailsModelRequest;
import com.areap2.model.SubParameterDetailsModelUpdateRequest;
import com.areap2.model.VillageDetailsModelRequest;
import com.areap2.model.VillageDetailsModelUpdateRequest;
import com.areap2.service.MasterDataService;

@Service
public class MasterDataServiceImpl extends AbstractMasterRepository implements MasterDataService {

	Logger log = LoggerFactory.getLogger(MasterDataServiceImpl.class);

	@Override
	public ResponseModel getAllDistrictDetails() {
		String methodName = "getAllDistrictDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding All District Details " + "  Method Name" + methodName + " Class : "
					+ this.getClass());
			String Status = ModelConstant.COMPLETE;
			// Log repository invocation
			log.debug("PROCESSING | [{}] | Invoking repository: districtDetailsRepo.findAllByActiveTrueAndStatus",
					methodName);
			List<DistrictDetails> districtList = districtDetailsRepo.findAllByActiveTrueAndStatus(Status);

			if (districtList == null || districtList.isEmpty()) {
				log.info("Respond: No Data Found - All District Details " + "  Method Name" + methodName + " Class : "
						+ this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(districtList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully All District Details " + "  Method Name" + methodName
					+ " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding  All District Details " + "  Method Name" + methodName
					+ " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"An error occurred while Finding  All District Details ,error : " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel getCircleByDistrict(String districtCode) {
		String methodName = "getCircleByDistrict";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding Circle By District code :  " + districtCode + "  Method Name" + methodName
					+ " Class : " + this.getClass());

			// List<Map<String, String>> circleList =
			// circleDetailsRepo.findCircleByDistrictCode(districtCode);
			String status = ModelConstant.COMPLETE;
			// Log repository invocation
			log.debug(
					"PROCESSING | [{}] | Invoking repository: circleDetailsRepo.findCircleByDistrictCodeAndActiveTrueAndStatus",
					methodName);
			List<CircleDetails> circleList = circleDetailsRepo
					.findCircleByDistrictCodeAndActiveTrueAndStatus(districtCode, status);
			if (circleList == null || circleList.isEmpty()) {
				log.info("Respond: No Data Found for Circle By District code :  " + districtCode + "  Method Name"
						+ methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(circleList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully - Circle By District code : " + districtCode + "  Method Name"
					+ methodName + " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding  Circle By District code : " + districtCode + "  Method Name"
					+ methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"An error occurred while Finding  Circle By District code ,error : " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel getVillageByDistrictAndCircle(String districtCode, String circleCode) {
		String methodName = "getVillageByDistrictAndCircle";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding Village By District code : " + districtCode + " and circleCode : " + circleCode
					+ "  Method Name" + methodName + " Class : " + this.getClass());
//
//			List<Map<String, String>> villageList = villageDetailsRepo
//					.findVillageByDistrictCodeAndCircleCode(districtCode, circleCode);
			String status = ModelConstant.COMPLETE;
			// Log repository invocation
			log.debug(
					"PROCESSING | [{}] | Invoking repository: villageDetailsRepo.findVillageByDistrictCodeAndCircleCodeAndActiveTrueAndStatus",
					methodName);
			List<VillageDetails> villageList = villageDetailsRepo
					.findVillageByDistrictCodeAndCircleCodeAndActiveTrueAndStatus(districtCode, circleCode, status);

			if (villageList == null || villageList.isEmpty()) {
				log.info("Respond: No Data Found for Village By District code :  " + districtCode + " and circleCode : "
						+ circleCode + "  Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(villageList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully - Village By District code : " + districtCode
					+ " and circleCode : " + circleCode + "  Method Name" + methodName + " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding  Village By District code : " + districtCode
					+ " and circleCode : " + circleCode + "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding  Village By District code and circleCode ,error : "
					+ e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel getMouzaDetails(String districtCode, String circleCode) {
		String methodName = "getMouzaDetails";
		ResponseModel response = new ResponseModel();
		try {
			if (((districtCode == null || districtCode.trim().equals(""))
					&& (circleCode == null || circleCode.trim().equals("")))
					|| ((districtCode == null || districtCode.trim().equals("")) && circleCode != null)) {
				log.info("Respond : Invalid Parameters " + "Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.BAD_REQUEST);
				response.setMessage("Invalid Parameter");
				return response;
			} else if ((districtCode != null && !districtCode.trim().equals(""))
					&& (circleCode != null && !circleCode.trim().equals(""))) {

				log.info("Request: Finding Mouza By District code :  " + districtCode + "  Method Name" + methodName
						+ " Class : " + this.getClass());

				// List<Map<String, Object>> mouzaList =
				// mouzaDetailsRepo.findMouzaByDistrictCode(districtCode);
				String status = ModelConstant.COMPLETE;
				log.debug(
						"PROCESSING | [{}] | Invoking repository: mouzaDetailsRepo.findMouzaByDistrictCodeAndCircleCodeAndActiveTrueAndStatus",
						methodName);
				List<MouzaDetails> mouzaList = mouzaDetailsRepo
						.findMouzaByDistrictCodeAndCircleCodeAndActiveTrueAndStatus(districtCode, circleCode, status);

				if (mouzaList == null || mouzaList.isEmpty()) {
					log.info("Respond: No Data Found for Mouza By District code :  " + districtCode + "  Method Name"
							+ methodName + " Class : " + this.getClass());
					response.setHttpStatus(HttpStatus.NO_CONTENT);
					response.setMessage("No Data Found");
					return response;
				}

				response.setData(mouzaList);

				log.info("Respond : data Fetched successfully - Mouza By District code : " + districtCode
						+ "  Method Name" + methodName + " Class : " + this.getClass());
			} else {
				log.info("Request: Finding Mouza By District code :  " + districtCode + " and  circle Code : "
						+ circleCode + "  Method Name" + methodName + " Class : " + this.getClass());

				List<Map<String, Object>> mouzaList = mouzaDetailsRepo
						.findMouzaByDistrictCodeAndCircleCode(districtCode, circleCode);

				if (mouzaList == null || mouzaList.isEmpty()) {
					log.info("Respond: No Data Found for Mouza By District code :  " + districtCode
							+ " and  circle Code : " + circleCode + "  Method Name" + methodName + " Class : "
							+ this.getClass());
					response.setHttpStatus(HttpStatus.NO_CONTENT);
					response.setMessage("No Data Found");
					return response;
				}

				response.setData(mouzaList);

				log.info("Respond : data Fetched successfully - Mouza By District code : " + districtCode
						+ " and  circle Code : " + circleCode + "  Method Name" + methodName + " Class : "
						+ this.getClass());
			}

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

		} catch (Exception e) {
			log.error("An error occurred while Finding  Mouza details " + "  Method Name" + methodName + " Class : "
					+ this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding  Mouza Details ,error : " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel getAllLandCategories() {
		String methodName = "getAllLandCategories";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding All Land Categories " + "  Method Name" + methodName + " Class : "
					+ this.getClass());

			// List<Map<String, Object>> landCategoriesList =
			// landCategoriesRepo.findAllLandCategories();

			String status = ModelConstant.COMPLETE;
			log.debug("PROCESSING | [{}] | Invoking repository: landCategoriesRepo.findAllByActiveTrueAndStatus",
					methodName);
			List<LandCategories> landCategoriesList = landCategoriesRepo.findAllByActiveTrueAndStatus(status);

			if (landCategoriesList == null || landCategoriesList.isEmpty()) {
				log.info("Respond: No Data Found - Land Categories " + "  Method Name" + methodName + " Class : "
						+ this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(landCategoriesList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully Land Categories " + "  Method Name" + methodName + " Class : "
					+ this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding Land Categories  " + "  Method Name" + methodName + " Class : "
					+ this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"An error occurred while Finding  Land Categories  ,error : " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel getAreaType() {
		String methodName = "getAreaType";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding All Area Type " + "  Method Name" + methodName + " Class : " + this.getClass());

			// List<Map<String, Object>> areaTypeList = areaTypesRepo.findAllAreaType();
			String status = ModelConstant.COMPLETE;
			// Log repository invocation
			log.debug("PROCESSING | [{}] | Invoking repository: areaTypesRepo.findAllByActiveTrueAndStatus",
					methodName);
			List<AreaTypes> areaTypeList = areaTypesRepo.findAllByActiveTrueAndStatus(status);
			if (areaTypeList == null || areaTypeList.isEmpty()) {
				log.info("Respond: No Data Found - Area Type " + "  Method Name" + methodName + " Class : "
						+ this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(areaTypeList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully Area Type " + "  Method Name" + methodName + " Class : "
					+ this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding Area Type  " + "  Method Name" + methodName + " Class : "
					+ this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding  Area Type  ,error : " + e.getLocalizedMessage());
		}
		return response;
	}

//	@Override
//	public ResponseModel getZonalValues(String districtCode, String circleCode, String villageCode) {
//		String methodName = "getZonalValues";
//		ResponseModel response = new ResponseModel();
//		try {
//			log.info("Request: Finding ZonalValues by districtCode : " + districtCode + " ,circleCode :  " + circleCode
//					+ " and villageCode : " + villageCode + "  Method Name" + methodName + " Class : "
//					+ this.getClass());
//
//			if ((districtCode == null || districtCode.trim().equals(""))
//					|| (circleCode == null || circleCode.trim().equals(""))
//					|| (villageCode == null || villageCode.trim().equals(""))) {
//
//				response.setHttpStatus(HttpStatus.BAD_REQUEST);
//				response.setMessage("Invalid paramater");
//				return response;
//			}
//			List<Map<String, Object>> zoneValueList = zonalValuesRepo
//					.findMouzaByDistrictCodeAndCircleCodeAndVillageCode(districtCode, circleCode, villageCode);
//
//			if (zoneValueList == null || zoneValueList.isEmpty()) {
//				log.info("Respond: No Data Found -ZonalValue by districtCode : " + districtCode + " ,circleCode :  "
//						+ circleCode + " and villageCode : " + villageCode + "  Method Name" + methodName + " Class : "
//						+ this.getClass());
//				response.setHttpStatus(HttpStatus.NO_CONTENT);
//				response.setMessage("No Data Found");
//				return response;
//			}
//
//			response.setData(zoneValueList);
//			response.setHttpStatus(HttpStatus.OK);
//			response.setMessage("Data Fetched Successfully");
//
//			log.info("Respond : data Fetched successfully ZonalValue by districtCode : " + districtCode
//					+ " ,circleCode :  " + circleCode + " and villageCode : " + villageCode + "  Method Name"
//					+ methodName + " Class : " + this.getClass());
//		} catch (Exception e) {
//			log.error("An error occurred while Finding ZonalValue by districtCode :  "+ districtCode + " ,circleCode :  " + circleCode + " and villageCode : " + villageCode + "  Method Name" + methodName + " Class : "
//					+ this.getClass());
//			e.printStackTrace();
//			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
//			response.setMessage("An error occurred while Finding  ZonalValue  ,error : " + e.getLocalizedMessage());
//		}
//		return response;
//	}

	@Override
	public ResponseModel getZonalValues(String districtCode, String circleCode, String mouzaCode) {
		String methodName = "getZonalValues";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding ZonalValues by districtCode : " + districtCode + " ,circleCode :  " + circleCode
					+ " and mouzaCode : " + mouzaCode + "  Method Name" + methodName + " Class : " + this.getClass());

			if ((districtCode == null || districtCode.trim().equals(""))
					|| (circleCode == null || circleCode.trim().equals(""))
					|| (mouzaCode == null || mouzaCode.trim().equals(""))) {

				response.setHttpStatus(HttpStatus.BAD_REQUEST);
				response.setMessage("Invalid paramater");
				return response;
			}
			// List<Map<String, Object>> zoneValueList = zonalValuesRepo
			// .findMouzaByDistrictCodeAndCircleCodeAndMouzaCode(districtCode, circleCode,
			// mouzaCode);
			String status = ModelConstant.COMPLETE;
			// Log repository invocation
			log.debug(
					"PROCESSING | [{}] | Invoking repository: zonalValuesRepo.findMouzaByDistrictCodeAndCircleCodeAndMouzaCodeAndStatusAndActiveTrue",
					methodName);
			List<ZonalValues> zoneValueList = zonalValuesRepo
					.findMouzaByDistrictCodeAndCircleCodeAndMouzaCodeAndStatusAndActiveTrue(districtCode, circleCode,
							mouzaCode, status);

			if (zoneValueList == null || zoneValueList.isEmpty()) {
				log.info("Respond: No Data Found -ZonalValue by districtCode : " + districtCode + " ,circleCode :  "
						+ circleCode + " and mouzaCode : " + mouzaCode + "  Method Name" + methodName + " Class : "
						+ this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(zoneValueList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully ZonalValue by districtCode : " + districtCode
					+ " ,circleCode :  " + circleCode + " and mouzaCode : " + mouzaCode + "  Method Name" + methodName
					+ " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding ZonalValue by districtCode :  " + districtCode
					+ " ,circleCode :  " + circleCode + " and mouzaCode : " + mouzaCode + "  Method Name" + methodName
					+ " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding  ZonalValue  ,error : " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel getParameterDetails(BigDecimal minRange, BigDecimal maxRange) {
		String methodName = "getParameterDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding Parameter Details for minRange : " + minRange + " ,maxRange : " + maxRange
					+ "  Method Name" + methodName + " Class : " + this.getClass());
//
//			List<Map<String, Object>> parameterList = parameterDetailsRepo.findParameterDetailsByRange(minRange,
//					maxRange);
			String status = ModelConstant.COMPLETE;
			// Log repository invocation
			log.debug(
					"PROCESSING | [{}] | Invoking repository: parameterDetailsRepo.findMouzaByDistrictCodeAndCircleCodeAndMouzaCodeAndStatusAndActiveTrue",
					methodName);
			List<ParamDetails> parameterList = paramDetailsRepo
					.findByMinRangeInMetersGreaterThanEqualAndMaxRangeInMetersLessThanEqualAndActiveTrueAndStatus(
							minRange, maxRange, status);

			if (parameterList == null || parameterList.isEmpty()) {
				log.info("Respond: No Data Found - Parameter Details for minRange :  " + minRange + " ,maxRange : "
						+ maxRange + "  Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(parameterList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully -  Parameter Details for minRange : " + minRange
					+ " ,maxRange : " + maxRange + "  Method Name" + methodName + " Class : " + this.getClass());
		} catch (Exception e) {

			log.error("Respond :An error occurred while Finding Parameter Details for minRange : " + minRange
					+ " ,maxRange : " + maxRange + "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"An error occurred while Finding  Parameter Details ,error : " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseModel addDistrictDetails(DistrictDetailsModelRequest districtDetailsModel) {
		String methodName = "addDistrictDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to add District Details | District Name: {} | Method: {}",
					districtDetailsModel.getDistrictName(), methodName);

			// Generate new district code
			Integer maxDistrictCode = districtDetailsRepo.findMaxDistrictCode();
			Integer newDistrictCode = (maxDistrictCode == null) ? 10001 : maxDistrictCode + 1;

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
			DistrictDetails districtDetails = new DistrictDetails();
			districtDetails.setDistrictCode(newDistrictCode.toString());
			districtDetails.setDistrictName(districtDetailsModel.getDistrictName());
			districtDetails.setCreatedBy(loginId);
			districtDetails.setActive(true);

			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				districtDetails.setStatus(ModelConstant.COMPLETE);
				districtDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				districtDetails.setStatus(ModelConstant.COMPLETE);
				districtDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				districtDetails.setStatus(ModelConstant.PEN_S_M);
				districtDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				districtDetails.setStatus(ModelConstant.PEN_M);
				districtDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				districtDetails.setStatus(ModelConstant.PEN_J_M);
				districtDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			// Save entity
			DistrictDetails savedDistrictDetails = districtDetailsRepo.saveAndFlush(districtDetails);

			// Log action
			logAction(loginId, ModelConstant.DISTRICT, ModelConstant.ADD,
					"District Code: " + savedDistrictDetails.getDistrictCode(),
					"District added, name: " + savedDistrictDetails.getDistrictName(), savedDistrictDetails.getStatus(),
					savedDistrictDetails.getStatusCode(), savedDistrictDetails.getDistrictGenId());

			// Build response
			response.setData(savedDistrictDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("District added successfully | District Name: " + savedDistrictDetails.getDistrictName()
					+ ", District Code: " + savedDistrictDetails.getDistrictCode());

		} catch (Exception e) {
			log.error("Error occurred while adding District Details | District Name: {} | Method: {}",
					districtDetailsModel.getDistrictName(), methodName, e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add District Details | District Name: "
					+ districtDetailsModel.getDistrictName() + ", Error: " + e.getMessage());
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseModel updateDistrictDetails(DistrictDetailsModelRequest districtDetailsModel) {
		String methodName = "updateDistrictDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update District Details | District Name: {} | District Code: {} | Method: {} | Class: {}",
					districtDetailsModel.getDistrictName(), districtDetailsModel.getDistrictCode(), methodName,
					this.getClass().getSimpleName());

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

			// Fetch existing district
			DistrictDetails existingDistrict = districtDetailsRepo
					.findByDistrictCodeAndActiveTrue(districtDetailsModel.getDistrictCode());

			if (existingDistrict == null) {
				log.info("No active District found for District Code: {} | Method: {} | Class: {}",
						districtDetailsModel.getDistrictCode(), methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found for District Code: " + districtDetailsModel.getDistrictCode());
				return response;
			}

			// Deactivate old record
			existingDistrict.setActive(false);
			existingDistrict.setUpdatedBy(loginId);// we can think about this
			existingDistrict.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));// we can think about this
			districtDetailsRepo.save(existingDistrict);

			// Create new record with updated details
			DistrictDetails districtDetails = new DistrictDetails();
			districtDetails.setDistrictCode(districtDetailsModel.getDistrictCode());
			districtDetails.setDistrictName(districtDetailsModel.getDistrictName());
			districtDetails.setActive(true);
			districtDetails.setCreatedBy(existingDistrict.getCreatedBy());
			districtDetails.setCreatedDtm(existingDistrict.getCreatedDtm());
			districtDetails.setUpdatedBy(loginId);
			districtDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				districtDetails.setStatus(ModelConstant.COMPLETE);
				districtDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				districtDetails.setStatus(ModelConstant.COMPLETE);
				districtDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				districtDetails.setStatus(ModelConstant.PEN_S_M);
				districtDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				districtDetails.setStatus(ModelConstant.PEN_M);
				districtDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				districtDetails.setStatus(ModelConstant.PEN_J_M);
				districtDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			DistrictDetails savedDistrict = districtDetailsRepo.save(districtDetails);

			logAction(loginId, ModelConstant.DISTRICT, ModelConstant.UPDATE,
					"District Code: " + savedDistrict.getDistrictCode(),
					"District updated, name: " + savedDistrict.getDistrictName(), savedDistrict.getStatus(),
					savedDistrict.getStatusCode(), savedDistrict.getDistrictGenId());

			response.setData(savedDistrict);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("District Updated Successfully | District Name: " + savedDistrict.getDistrictName()
					+ ", District Code: " + savedDistrict.getDistrictCode());

			log.info(
					"District updated successfully | District Name: {} | District Code: {} | Updated By: {} | Method: {} | Class: {}",
					savedDistrict.getDistrictName(), savedDistrict.getDistrictCode(), loginId, methodName,
					this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while updating District Details | District Name: {} | District Code: {} | Method: {} | Class: {}",
					districtDetailsModel.getDistrictName(), districtDetailsModel.getDistrictCode(), methodName,
					this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to update District Details | District Name: "
					+ districtDetailsModel.getDistrictName() + ", District Code: "
					+ districtDetailsModel.getDistrictCode() + ", Error: " + e.getMessage());
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseModel deleteDistrictDetails(String districtCode) {
		String methodName = "deleteDistrictDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to delete District Details | District Code: {} | Method: {} | Class: {}",
					districtCode, methodName, this.getClass().getSimpleName());

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

			// Fetch existing district
			DistrictDetails districtDetails = districtDetailsRepo.findByDistrictCodeAndActiveTrue(districtCode);

			if (districtDetails == null) {
				log.info("No active District found for District Code: {} | Method: {} | Class: {}", districtCode,
						methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found for District Code: " + districtCode);
				return response;
			}

			// Mark as inactive
			districtDetails.setActive(false);
			districtDetails.setUpdatedBy(loginId);
			districtDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				districtDetails.setStatus(ModelConstant.COMPLETE);
				districtDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				districtDetails.setStatus(ModelConstant.COMPLETE);
				districtDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				districtDetails.setStatus(ModelConstant.PEN_S_M);
				districtDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				districtDetails.setStatus(ModelConstant.PEN_M);
				districtDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				districtDetails.setStatus(ModelConstant.PEN_J_M);
				districtDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}
			DistrictDetails savedDistrict = districtDetailsRepo.save(districtDetails);

			logAction(loginId, ModelConstant.DISTRICT, ModelConstant.DELETE,
					"District Code: " + savedDistrict.getDistrictCode(),
					"District deleted (set active=false) , name: " + savedDistrict.getDistrictName(),
					savedDistrict.getStatus(), savedDistrict.getStatusCode(), savedDistrict.getDistrictGenId());

			response.setData(savedDistrict);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("District Deleted Successfully | District Code: " + districtCode);

			log.info(
					"District deleted means Active is FALSE Successfully | District Code: {} | Updated By: {} | Method: {} | Class: {}",
					districtCode, loginId, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error occurred while deleting District Details | District Code: {} | Method: {} | Class: {}",
					districtCode, methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to delete District Details | District Code: " + districtCode + ", Error: "
					+ e.getMessage());
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseModel addCircleDetails(CircleDetailsModelRequest circleDetailsModel) {
		String methodName = "addCircleDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to add Circle Details | Circle Name: {} | District Code: {} | Method: {} | Class: {}",
					circleDetailsModel.getCircleName(), circleDetailsModel.getDistrictCode(), methodName,
					this.getClass().getSimpleName());

			// Generate new circle code
			Integer maxCircleCode = circleDetailsRepo.findMaxCircleCode();
			Integer newCircleCode = (maxCircleCode == null) ? 10001 : maxCircleCode + 1;

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
			CircleDetails circleDetails = new CircleDetails();
			circleDetails.setCircleCode(newCircleCode.toString());
			circleDetails.setCircleName(circleDetailsModel.getCircleName());
			circleDetails.setDistrictCode(circleDetailsModel.getDistrictCode());
			circleDetails.setCreatedBy(loginId);
			circleDetails.setActive(true);
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				circleDetails.setStatus(ModelConstant.COMPLETE);
				circleDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				circleDetails.setStatus(ModelConstant.COMPLETE);
				circleDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				circleDetails.setStatus(ModelConstant.PEN_S_M);
				circleDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				circleDetails.setStatus(ModelConstant.PEN_M);
				circleDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				circleDetails.setStatus(ModelConstant.PEN_J_M);
				circleDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			// Save entity
			CircleDetails savedCircle = circleDetailsRepo.saveAndFlush(circleDetails);

			// Log action
			logAction(loginId, ModelConstant.CIRCLE, ModelConstant.ADD,
					"District Code: " + savedCircle.getDistrictCode() + ", Circle Code:" + savedCircle.getCircleCode(),
					"Circle  added, name: " + savedCircle.getCircleName(), savedCircle.getStatus(),
					savedCircle.getStatusCode(), savedCircle.getCircleGenId());

			response.setData(savedCircle);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage(
					"Circle added successfully | Circle Name: " + savedCircle.getCircleName() + ", Circle Code: "
							+ savedCircle.getCircleCode() + ", District Code: " + savedCircle.getDistrictCode());

			log.info(
					"Circle added successfully | Circle Name: {} | Circle Code: {} | District Code: {} | Created By: {} | Method: {} | Class: {}",
					savedCircle.getCircleName(), savedCircle.getCircleCode(), savedCircle.getDistrictCode(), loginId,
					methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while adding Circle Details | Circle Name: {} | District Code: {} | Method: {} | Class: {}",
					circleDetailsModel.getCircleName(), circleDetailsModel.getDistrictCode(), methodName,
					this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add Circle Details | Circle Name: " + circleDetailsModel.getCircleName()
					+ ", District Code: " + circleDetailsModel.getDistrictCode() + ", Error: " + e.getMessage());
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseModel updateCircleDetails(CircleDetailsModelUpdateRequest circleDetailsModel) {
		String methodName = "updateCircleDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update Circle Details | Circle Name: {} | Circle Code: {} | District Code: {} | Method: {} | Class: {}",
					circleDetailsModel.getCircleName(), circleDetailsModel.getCircleCode(),
					circleDetailsModel.getDistrictCode(), methodName, this.getClass().getSimpleName());

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

			// Fetch existing circle
			CircleDetails existingCircle = circleDetailsRepo
					.findByCircleCodeAndActiveTrue(circleDetailsModel.getCircleCode());

			if (existingCircle == null) {
				log.info("No active Circle found for Circle Code: {} | Method: {} | Class: {}",
						circleDetailsModel.getCircleCode(), methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found for Circle Code: " + circleDetailsModel.getCircleCode());
				return response;
			}

			// Deactivate old record
			existingCircle.setActive(false);
			existingCircle.setUpdatedBy(loginId);
			existingCircle.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			circleDetailsRepo.save(existingCircle);

			// Create new record with updated details
			CircleDetails circleDetails = new CircleDetails();

			circleDetails.setCircleCode(circleDetailsModel.getCircleCode());
			circleDetails.setCircleName(circleDetailsModel.getCircleName());
			circleDetails.setDistrictCode(circleDetailsModel.getDistrictCode());
			circleDetails.setActive(true);
			circleDetails.setCreatedBy(existingCircle.getCreatedBy());
			circleDetails.setCreatedDtm(existingCircle.getCreatedDtm());
			circleDetails.setUpdatedBy(loginId);
			circleDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				circleDetails.setStatus(ModelConstant.COMPLETE);
				circleDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				circleDetails.setStatus(ModelConstant.COMPLETE);
				circleDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				circleDetails.setStatus(ModelConstant.PEN_S_M);
				circleDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				circleDetails.setStatus(ModelConstant.PEN_M);
				circleDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				circleDetails.setStatus(ModelConstant.PEN_J_M);
				circleDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			CircleDetails savedCircle = circleDetailsRepo.save(circleDetails);

			// Log action
			logAction(loginId, ModelConstant.CIRCLE, ModelConstant.UPDATE,
					"District Code: " + savedCircle.getDistrictCode() + ", Circle Code:" + savedCircle.getCircleCode(),
					"Circle updated, name: " + savedCircle.getCircleName(), savedCircle.getStatus(),
					savedCircle.getStatusCode(), savedCircle.getCircleGenId());

			response.setData(savedCircle);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage(
					"Circle Updated Successfully | Circle Name: " + savedCircle.getCircleName() + ", Circle Code: "
							+ savedCircle.getCircleCode() + ", District Code: " + savedCircle.getDistrictCode());

			log.info(
					"Circle updated successfully | Circle Name: {} | Circle Code: {} | District Code: {} | Updated By: {} | Method: {} | Class: {}",
					savedCircle.getCircleName(), savedCircle.getCircleCode(), savedCircle.getDistrictCode(), loginId,
					methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while updating Circle Details | Circle Name: {} | Circle Code: {} | District Code: {} | Method: {} | Class: {}",
					circleDetailsModel.getCircleName(), circleDetailsModel.getCircleCode(),
					circleDetailsModel.getDistrictCode(), methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to update Circle Details | Circle Name: " + circleDetailsModel.getCircleName()
					+ ", Circle Code: " + circleDetailsModel.getCircleCode() + ", District Code: "
					+ circleDetailsModel.getDistrictCode() + ", Error: " + e.getMessage());
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseModel deleteCircleDetails(String circleCode) {
		String methodName = "deleteCircleDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to delete Circle Details | Circle Code: {} | Method: {} | Class: {}", circleCode,
					methodName, this.getClass().getSimpleName());

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

			// Fetch active circle
			CircleDetails circleDetails = circleDetailsRepo.findByCircleCodeAndActiveTrue(circleCode);

			if (circleDetails == null) {
				log.info("No active Circle found for Circle Code: {} | Method: {} | Class: {}", circleCode, methodName,
						this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found for Circle Code: " + circleCode);
				return response;
			}

			// Mark as inactive
			circleDetails.setActive(false);
			circleDetails.setUpdatedBy(loginId);
			circleDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				circleDetails.setStatus(ModelConstant.COMPLETE);
				circleDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				circleDetails.setStatus(ModelConstant.COMPLETE);
				circleDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				circleDetails.setStatus(ModelConstant.PEN_S_M);
				circleDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				circleDetails.setStatus(ModelConstant.PEN_M);
				circleDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				circleDetails.setStatus(ModelConstant.PEN_J_M);
				circleDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}
			CircleDetails savedCircle = circleDetailsRepo.save(circleDetails);

			// Log action
			logAction(loginId, ModelConstant.CIRCLE, ModelConstant.DELETE,
					"District Code: " + savedCircle.getDistrictCode() + ", Circle Code:" + savedCircle.getCircleCode(),
					"Circle  deleted (set active=false) with name: " + savedCircle.getCircleName(),
					savedCircle.getStatus(), savedCircle.getStatusCode(), savedCircle.getCircleGenId());

			response.setData(savedCircle);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Circle Deleted Successfully | Circle Code: " + circleCode);

			log.info("Circle deleted successfully | Circle Code: {} | Updated By: {} | Method: {} | Class: {}",
					circleCode, loginId, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error occurred while deleting Circle Details | Circle Code: {} | Method: {} | Class: {}",
					circleCode, methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"Failed to delete Circle Details | Circle Code: " + circleCode + ", Error: " + e.getMessage());
		}

		return response;
	}

	@Override
	@Transactional
	public ResponseModel addVillageDetails(VillageDetailsModelRequest villageDetailsModel) {
		String methodName = "addVillageDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request: Add Village Details | DistrictCode: {} | CircleCode: {} | MouzaCode: {} | LotCode: {} | VillageName: {} | AreaType: {} | Method: {} | Class: {}",
					villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
					villageDetailsModel.getMouzaCode(), villageDetailsModel.getLotCode(),
					villageDetailsModel.getVillageName(), villageDetailsModel.getAreaType(), methodName,
					this.getClass().getSimpleName());

			// Fetch max village code
			Integer villageCode = villageDetailsRepo.findMaxVillageCode();
			villageCode = (villageCode == null) ? 10001 : villageCode + 1;

			// Validate authentication
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || !authentication.isAuthenticated()
					|| "anonymousUser".equals(authentication.getName())) {
				log.warn("Unauthorized access attempt while adding village | Method: {} | Class: {}", methodName,
						this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Token is expired or invalid");
				return response;
			}

			String loginId = authentication.getName();
			Set<String> userRoles = authentication.getAuthorities().stream()
					.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());

			log.info("User '{}' authenticated | Roles: {} | Method: {} | Class: {}", loginId, userRoles, methodName,
					this.getClass().getSimpleName());

			// Create village details
			VillageDetails villageDetails = new VillageDetails();
			villageDetails.setVillageCode(villageCode.toString());
			villageDetails.setDistrictCode(villageDetailsModel.getDistrictCode());
			villageDetails.setCircleCode(villageDetailsModel.getCircleCode());
			villageDetails.setMouzaCode(villageDetailsModel.getMouzaCode());
			villageDetails.setLotCode(villageDetailsModel.getLotCode());
			villageDetails.setVillageName(villageDetailsModel.getVillageName());
			villageDetails.setAreaType(villageDetailsModel.getAreaType());
			villageDetails.setCreatedBy(loginId);
			villageDetails.setActive(true);

			// Set status based on role
			if (userRoles.contains(ModelConstant.ADMIN) || userRoles.contains(ModelConstant.SMAN)) {
				villageDetails.setStatus(ModelConstant.COMPLETE);
				villageDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				villageDetails.setStatus(ModelConstant.PEN_S_M);
				villageDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				villageDetails.setStatus(ModelConstant.PEN_M);
				villageDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				villageDetails.setStatus(ModelConstant.PEN_J_M);
				villageDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			// Save record
			VillageDetails savedVillageDetails = villageDetailsRepo.saveAndFlush(villageDetails);

			// Log action
			logAction(loginId, ModelConstant.VILLAGE, ModelConstant.ADD, String.format(
					"DistrictCode: %s | CircleCode: %s | MouzaCode: %s | LotCode: %s | AreaType: %s | VillageCode: %s",
					savedVillageDetails.getDistrictCode(), savedVillageDetails.getCircleCode(),
					savedVillageDetails.getMouzaCode(), savedVillageDetails.getLotCode(),
					savedVillageDetails.getAreaType(), savedVillageDetails.getVillageCode()),
					"Village added | Name: " + savedVillageDetails.getVillageName(), savedVillageDetails.getStatus(),
					savedVillageDetails.getStatusCode(), savedVillageDetails.getVillageGenId());

			response.setData(savedVillageDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Village Added Successfully");

			log.info(
					"Respond: Village Added Successfully | DistrictCode: {} | CircleCode: {} | VillageName: {} | VillageCode: {} | Method: {} | Class: {}",
					savedVillageDetails.getDistrictCode(), savedVillageDetails.getCircleCode(),
					savedVillageDetails.getVillageName(), savedVillageDetails.getVillageCode(), methodName,
					this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error while Adding Village Details | DistrictCode: {} | CircleCode: {} | VillageName: {} | Method: {} | Class: {} | Error: {}",
					villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
					villageDetailsModel.getVillageName(), methodName, this.getClass().getSimpleName(), e.getMessage(),
					e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while adding Village Details, VillageName: "
					+ villageDetailsModel.getVillageName() + ", Error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	@Transactional
	public ResponseModel updateVillageDetails(VillageDetailsModelUpdateRequest villageDetailsModel) {
		final String methodName = "updateVillageDetails";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info(
				"[START] [{}] - Invoked in [{}] | VillageCode: {} | VillageName: {} | District: {} | Circle: {} | Mauza: {} | Lot: {} | AreaType: {}",
				methodName, className, villageDetailsModel.getVillageCode(), villageDetailsModel.getVillageName(),
				villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
				villageDetailsModel.getMouzaCode(), villageDetailsModel.getLotCode(),
				villageDetailsModel.getAreaType());

		long startTime = System.currentTimeMillis();

		try {
			// --- Authentication Check ---
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || !authentication.isAuthenticated()
					|| "anonymousUser".equals(authentication.getName())) {
				log.warn("[SECURITY] [{}] - Unauthorized access attempt | VillageCode: {}", methodName,
						villageDetailsModel.getVillageCode());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Token is expired or invalid");
				return response;
			}

			String loginId = authentication.getName();
			Set<String> userRoles = authentication.getAuthorities().stream()
					.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());

			log.debug("[AUTH] [{}] - User '{}' authenticated with roles: {}", methodName, loginId, userRoles);

			// --- Fetch existing village record ---
			log.debug("[PROCESS] [{}] - Fetching active record for VillageCode: {}", methodName,
					villageDetailsModel.getVillageCode());
			VillageDetails oldVillage = villageDetailsRepo
					.findByVillageCodeAndActiveTrue(villageDetailsModel.getVillageCode());

			if (oldVillage == null) {
				log.warn("[END] [{}] - No active record found for VillageCode: {}", methodName,
						villageDetailsModel.getVillageCode());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			// --- Mark old record inactive ---
			oldVillage.setActive(false);
			oldVillage.setUpdatedBy(loginId);
			oldVillage.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			villageDetailsRepo.save(oldVillage);

			log.debug("[PROCESS] [{}] - Old record marked inactive for VillageCode: {}", methodName,
					villageDetailsModel.getVillageCode());

			// --- Create and save new record ---
			VillageDetails villageDetails = new VillageDetails();
			villageDetails.setVillageCode(villageDetailsModel.getVillageCode());
			villageDetails.setVillageName(villageDetailsModel.getVillageName());
			villageDetails.setAreaType(villageDetailsModel.getAreaType());
			villageDetails.setDistrictCode(villageDetailsModel.getDistrictCode());
			villageDetails.setCircleCode(villageDetailsModel.getCircleCode());
			villageDetails.setMouzaCode(villageDetailsModel.getMouzaCode());
			villageDetails.setLotCode(villageDetailsModel.getLotCode());
			villageDetails.setActive(true);
			villageDetails.setCreatedBy(oldVillage.getCreatedBy());
			villageDetails.setCreatedDtm(oldVillage.getCreatedDtm());
			villageDetails.setUpdatedBy(loginId);
			villageDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			// --- Role-based status handling ---
			if (userRoles.contains(ModelConstant.ADMIN) || userRoles.contains(ModelConstant.SMAN)) {
				villageDetails.setStatus(ModelConstant.COMPLETE);
				villageDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				villageDetails.setStatus(ModelConstant.PEN_S_M);
				villageDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				villageDetails.setStatus(ModelConstant.PEN_M);
				villageDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				villageDetails.setStatus(ModelConstant.PEN_J_M);
				villageDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			VillageDetails savedVillage = villageDetailsRepo.save(villageDetails);
			log.info("[PROCESS] [{}] - New village record saved | VillageCode: {} | Status: {} | StatusCode: {}",
					methodName, savedVillage.getVillageCode(), savedVillage.getStatus(), savedVillage.getStatusCode());

			// --- Log Action (Audit Trail) ---
			logAction(loginId, ModelConstant.VILLAGE, ModelConstant.UPDATE, String.format(
					"DistrictCode: %s, CircleCode: %s, MauzaCode: %s, LotCode: %s, AreaType: %s, VillageCode: %s",
					savedVillage.getDistrictCode(), savedVillage.getCircleCode(), savedVillage.getMouzaCode(),
					savedVillage.getLotCode(), savedVillage.getAreaType(), savedVillage.getVillageCode()),
					"Village updated, name: " + savedVillage.getVillageName(), savedVillage.getStatus(),
					savedVillage.getStatusCode(), savedVillage.getVillageGenId());

			response.setData(savedVillage);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Village Updated Successfully");

			log.info(
					"[SUCCESS] [{}] - Village updated successfully | VillageCode: {} | VillageName: {} | UpdatedBy: {}",
					methodName, savedVillage.getVillageCode(), savedVillage.getVillageName(), loginId);

		} catch (Exception e) {
			log.error("[ERROR] [{}] - Exception while updating village | VillageCode: {} | VillageName: {} | Error: {}",
					methodName, villageDetailsModel.getVillageCode(), villageDetailsModel.getVillageName(),
					e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(String.format("An error occurred while updating Village '%s'. Reason: %s",
					villageDetailsModel.getVillageName(), e.getLocalizedMessage()));
		}

		long endTime = System.currentTimeMillis();
		log.info("[END] [{}] - Completed in [{}] | Duration: {} ms | VillageCode: {}", methodName, className,
				(endTime - startTime), villageDetailsModel.getVillageCode());

		return response;
	}

	@Override
	@Transactional
	public ResponseModel deleteVillageDetails(String villageCode) {
		String methodName = "deleteVillageDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete Village Details | VillageCode: {} | Method: {} | Class: {}", villageCode,
					methodName, this.getClass().getSimpleName());

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

			VillageDetails villageDetails = villageDetailsRepo.findByVillageCodeAndActiveTrue(villageCode);

			if (villageDetails == null) {
				log.info("Respond: No Data Found | VillageCode: {} | Method: {} | Class: {}", villageCode, methodName,
						this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			// Soft delete → mark inactive
			villageDetails.setActive(false);
			villageDetails.setUpdatedBy(loginId);
			villageDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				villageDetails.setStatus(ModelConstant.COMPLETE);
				villageDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				villageDetails.setStatus(ModelConstant.COMPLETE);
				villageDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				villageDetails.setStatus(ModelConstant.PEN_S_M);
				villageDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				villageDetails.setStatus(ModelConstant.PEN_M);
				villageDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				villageDetails.setStatus(ModelConstant.PEN_J_M);
				villageDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			VillageDetails savedVillageDetails = villageDetailsRepo.save(villageDetails);
			logAction(loginId, ModelConstant.VILLAGE, ModelConstant.DELETE, String.format(
					"DistrictCode: %s | CircleCode: %s | MouzaCode: %s | LotCode: %s | AreaType: %s | VillageCode: %s",
					savedVillageDetails.getDistrictCode(), savedVillageDetails.getCircleCode(),
					savedVillageDetails.getMouzaCode(), savedVillageDetails.getLotCode(),
					savedVillageDetails.getAreaType(), savedVillageDetails.getVillageCode()),
					"District deleted (set active=false successfully with name: "
							+ savedVillageDetails.getVillageName(),
					savedVillageDetails.getStatus(), savedVillageDetails.getStatusCode(),
					savedVillageDetails.getVillageGenId());
			response.setData(savedVillageDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Village Deleted Successfully");

			log.info("Respond: Village Deleted Successfully | VillageCode: {} | UpdatedBy: {} | Method: {} | Class: {}",
					villageCode, loginId, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while deleting Village Details | VillageCode: {} | Method: {} | Class: {} | Error: {}",
					villageCode, methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while deleting Village Details | VillageCode: " + villageCode
					+ ", error: " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	@Transactional
	public ResponseModel addMouzaDetails(MouzaDetailsModelRequest mouzaDetailsModel) {
		String methodName = "addMouzaDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Add Mouza Details | MouzaName: {} | AreaTypeId: {} | DistrictCode: {} | CircleCode: {} | BasePriceMouza: {} | Method: {} | Class: {}",
					mouzaDetailsModel.getMouzaName(), mouzaDetailsModel.getAreaTypeId(),
					mouzaDetailsModel.getDistrictCode(), mouzaDetailsModel.getCircleCode(),
					mouzaDetailsModel.getBPMouza(), methodName, this.getClass().getSimpleName());

			Integer mouzaCode = mouzaDetailsRepo.findMaxMouzaCode();
			if (mouzaCode == null) {
				mouzaCode = 10001;
			} else {
				mouzaCode = mouzaCode + 1;
			}
			final String finalMouzaCode = mouzaCode.toString();
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

			MouzaDetails mouzaDetails = new MouzaDetails();
			mouzaDetails.setMouzaCode(mouzaCode.toString());
			mouzaDetails.setMouzaName(mouzaDetailsModel.getMouzaName());
			mouzaDetails.setDistrictCode(mouzaDetailsModel.getDistrictCode());
			mouzaDetails.setCircleCode(mouzaDetailsModel.getCircleCode());
			mouzaDetails.setAreaTypeId(mouzaDetailsModel.getAreaTypeId());
			// mouzaDetails.setBasePriceMouza(mouzaDetailsModel.getBPMouza());
			if (mouzaDetailsModel.getBPMouza() == null || mouzaDetailsModel.getBPMouza() == 0) {
				mouzaDetails.setBasePriceMouza(ModelConstant.DEFAULT_BASE_PRICE_MOUZA);
			} else {
				mouzaDetails.setBasePriceMouza(mouzaDetailsModel.getBPMouza());
			}

			mouzaDetails.setCreatedBy(loginId);
			mouzaDetails.setActive(true);
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				mouzaDetails.setStatus(ModelConstant.COMPLETE);
				mouzaDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				mouzaDetails.setStatus(ModelConstant.COMPLETE);
				mouzaDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				mouzaDetails.setStatus(ModelConstant.PEN_S_M);
				mouzaDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				mouzaDetails.setStatus(ModelConstant.PEN_M);
				mouzaDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				mouzaDetails.setStatus(ModelConstant.PEN_J_M);
				mouzaDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			MouzaDetails savedMouzaDetails = mouzaDetailsRepo.saveAndFlush(mouzaDetails);
			// default values update in master for area Type and Land Use details
			List<Map.Entry<String, Long>> landCategoryList = List.of(Map.entry(ModelConstant.AGRICULTURAL, 11L),
					Map.entry(ModelConstant.RESIDENTIAL, 12L), Map.entry(ModelConstant.INDUSTRIAL, 13L),
					Map.entry(ModelConstant.COMMERCIAL, 14L), Map.entry(ModelConstant.OTHERS, 15L));

			Timestamp currentTime = new Timestamp(System.currentTimeMillis());

			landCategoryList.forEach(entry -> {
				LandCategories landCategory = new LandCategories();
				landCategory.setLandCategoryGenId(null); // ✅ ensure fresh insert
				landCategory.setActive(true);
				landCategory.setCreatedBy(loginId);
				landCategory.setCreatedDtm(currentTime);
				landCategory.setStatus(ModelConstant.COMPLETE);
				landCategory.setStatusCode(ModelConstant.COMPLETE_CODE);
				landCategory.setMouzaCode(finalMouzaCode);
				landCategory.setDistrictCode(mouzaDetailsModel.getDistrictCode());
				landCategory.setCircleCode(mouzaDetailsModel.getCircleCode());
				landCategory.setLandCategoryName(entry.getKey());
				landCategory.setBasePriceIncreaseLandUse(entry.getValue());
				landCategoriesRepo.save(landCategory);
				log.info("Saved LandCategory: {} with BasePriceIncreaseLandUse: {}", entry.getKey(), entry.getValue());
			});

			List<Map.Entry<String, Long>> areaTypesList = List.of(Map.entry(ModelConstant.RURAL, 1L),
					Map.entry(ModelConstant.URBAN, 2L));

			Timestamp currentTimer = new Timestamp(System.currentTimeMillis());
			areaTypesList.forEach(entry -> {
				AreaTypes areaTypes = new AreaTypes();
				areaTypes.setActive(true);
				areaTypes.setCreatedBy(loginId);
				areaTypes.setCreatedDtm(currentTimer);
				areaTypes.setStatus(ModelConstant.COMPLETE);
				areaTypes.setStatusCode(ModelConstant.COMPLETE_CODE);
				areaTypes.setMouzaCode(finalMouzaCode);
				areaTypes.setDistrictCode(mouzaDetailsModel.getDistrictCode());
				areaTypes.setCircleCode(mouzaDetailsModel.getCircleCode());
				areaTypes.setAreaType(entry.getKey());
				areaTypes.setBasePriceIncreaseAreaType(entry.getValue());
				areaTypesRepo.save(areaTypes);
				log.info("Saved AreaTypes: {} with BasePriceIncreaseAreaTypes: {}", entry.getKey(), entry.getValue());
			});
			System.out.println("noOneCanDoTHis");
			// Log action
			logAction(loginId, ModelConstant.MAUZA, ModelConstant.ADD,
					"District Code: " + savedMouzaDetails.getDistrictCode() + ", Circle Code: "
							+ savedMouzaDetails.getCircleCode() + ", Area Type Id Code: "
							+ savedMouzaDetails.getAreaTypeId() + ", Mauza Code: " + savedMouzaDetails.getMouzaCode(),
					"Mauza added, name: " + savedMouzaDetails.getMouzaName(), savedMouzaDetails.getStatus(),
					savedMouzaDetails.getStatusCode(), savedMouzaDetails.getMouzaGenId());

			response.setData(savedMouzaDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Mouza Added Successfully");

			log.info(
					"Respond: Mouza Added Successfully | MouzaCode: {} | MouzaName: {} | DistrictCode: {} | CircleCode: {} || BasePriceMouza: {}  Method: {} | Class: {}",
					savedMouzaDetails.getMouzaCode(), savedMouzaDetails.getMouzaName(),
					savedMouzaDetails.getDistrictCode(), savedMouzaDetails.getCircleCode(),
					savedMouzaDetails.getBasePriceMouza(), methodName, this.getClass().getSimpleName());
		} catch (Exception e) {
			log.error(
					"Error while Adding Mouza Details | MouzaName: {} | DistrictCode: {} | CircleCode: {} | Method: {} | Class: {} | Error: {}",
					mouzaDetailsModel.getMouzaName(), mouzaDetailsModel.getDistrictCode(),
					mouzaDetailsModel.getCircleCode(), methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while adding Mouza Details | MouzaName: "
					+ mouzaDetailsModel.getMouzaName() + ", error: " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	@Transactional
	public ResponseModel updateMouzaDetails(MouzaDetailsModelUpdateRequest mouzaDetailsModel) {
		String methodName = "updateMouzaDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Update Mouza Details [MouzaCode: {}, MouzaName: {}, DistrictCode: {}, CircleCode: {}, BasePriceMouza: {}, AreaTypeId: {}], Method: {}, Class: {}",
					mouzaDetailsModel.getMouzaCode(), mouzaDetailsModel.getMouzaName(),
					mouzaDetailsModel.getDistrictCode(), mouzaDetailsModel.getCircleCode(),
					mouzaDetailsModel.getBPMouza(), mouzaDetailsModel.getAreaTypeId(), methodName,
					this.getClass().getSimpleName());

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

			MouzaDetails existingMouza = mouzaDetailsRepo
					.findByMouzaCodeAndActiveTrue(mouzaDetailsModel.getMouzaCode());

			if (existingMouza == null) {
				log.warn("Respond: No active Mouza found for MouzaCode: {}, Method: {}, Class: {}",
						mouzaDetailsModel.getMouzaCode(), methodName, this.getClass().getSimpleName());

				response.setHttpStatus(HttpStatus.NOT_FOUND);
				response.setMessage("No active Mouza found for code: " + mouzaDetailsModel.getMouzaCode());
				return response;
			}

			// Deactivate old entry
			existingMouza.setActive(false);
			existingMouza.setUpdatedBy(loginId);
			existingMouza.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			mouzaDetailsRepo.save(existingMouza);

			// Create new entry with updated details
			MouzaDetails mouzaDetails = new MouzaDetails();
			mouzaDetails.setMouzaCode(mouzaDetailsModel.getMouzaCode());
			mouzaDetails.setMouzaName(mouzaDetailsModel.getMouzaName());
			mouzaDetails.setDistrictCode(mouzaDetailsModel.getDistrictCode());
			mouzaDetails.setCircleCode(mouzaDetailsModel.getCircleCode());
			// mouzaDetails.setBasePriceMouza(mouzaDetailsModel.getBPMouza());
			if (mouzaDetailsModel.getBPMouza() == null || mouzaDetailsModel.getBPMouza() == 0) {
				mouzaDetails.setBasePriceMouza(ModelConstant.DEFAULT_BASE_PRICE_MOUZA);
			} else {
				mouzaDetails.setBasePriceMouza(mouzaDetailsModel.getBPMouza());
			}
			mouzaDetails.setAreaTypeId(mouzaDetailsModel.getAreaTypeId());
			mouzaDetails.setActive(true);
			mouzaDetails.setCreatedBy(existingMouza.getCreatedBy());
			mouzaDetails.setCreatedDtm(existingMouza.getCreatedDtm());
			mouzaDetails.setUpdatedBy(loginId);
			mouzaDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				mouzaDetails.setStatus(ModelConstant.COMPLETE);
				mouzaDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				mouzaDetails.setStatus(ModelConstant.COMPLETE);
				mouzaDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				mouzaDetails.setStatus(ModelConstant.PEN_S_M);
				mouzaDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				mouzaDetails.setStatus(ModelConstant.PEN_M);
				mouzaDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				mouzaDetails.setStatus(ModelConstant.PEN_J_M);
				mouzaDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}
			MouzaDetails savedMouzaDetails = mouzaDetailsRepo.save(mouzaDetails);
			// Log action
			logAction(loginId, ModelConstant.MAUZA, ModelConstant.UPDATE,
					"District Code: " + savedMouzaDetails.getDistrictCode() + ", Circle Code: "
							+ savedMouzaDetails.getCircleCode() + ", Area Type Id Code: "
							+ savedMouzaDetails.getAreaTypeId() + ", Mauza Code: " + savedMouzaDetails.getMouzaCode(),
					"Mauza updated, name: " + savedMouzaDetails.getMouzaName(), savedMouzaDetails.getStatus(),
					savedMouzaDetails.getStatusCode(), savedMouzaDetails.getMouzaGenId());

			response.setData(savedMouzaDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Mouza updated successfully");

			log.info(
					"Respond: Mouza updated successfully [MouzaCode: {}, MouzaName: {}, DistrictCode: {}, CircleCode: {}, BasePriceMouza: {}, AreaTypeId: {}], Method: {}, Class: {}",
					savedMouzaDetails.getMouzaCode(), savedMouzaDetails.getMouzaName(),
					savedMouzaDetails.getDistrictCode(), savedMouzaDetails.getCircleCode(),
					savedMouzaDetails.getBasePriceMouza(), savedMouzaDetails.getAreaTypeId(), methodName,
					this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while updating Mouza Details [MouzaCode: {}, MouzaName: {}, DistrictCode: {}, CircleCode: {}, BasePriceMouza: {}, AreaTypeId: {}], Method: {}, Class: {}",
					mouzaDetailsModel.getMouzaCode(), mouzaDetailsModel.getMouzaName(),
					mouzaDetailsModel.getDistrictCode(), mouzaDetailsModel.getCircleCode(),
					mouzaDetailsModel.getBPMouza(), mouzaDetailsModel.getAreaTypeId(), methodName,
					this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while updating Mouza Details, MouzaCode: "
					+ mouzaDetailsModel.getMouzaCode() + ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	@Transactional
	public ResponseModel deleteMouzaDetails(String mouzaCode) {
		String methodName = "deleteMouzaDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete Mouza Details | MouzaCode: {} | Method: {} | Class: {}", mouzaCode, methodName,
					this.getClass().getSimpleName());

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

			MouzaDetails mouzaDetails = mouzaDetailsRepo.findByMouzaCodeAndActiveTrue(mouzaCode);

			if (mouzaDetails == null) {
				log.info("Respond: No Data Found | MouzaCode: {} | Method: {} | Class: {}", mouzaCode, methodName,
						this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			mouzaDetails.setActive(false);
			mouzaDetails.setUpdatedBy(loginId);
			mouzaDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			// Log action// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				mouzaDetails.setStatus(ModelConstant.COMPLETE);
				mouzaDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				mouzaDetails.setStatus(ModelConstant.COMPLETE);
				mouzaDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				mouzaDetails.setStatus(ModelConstant.PEN_S_M);
				mouzaDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				mouzaDetails.setStatus(ModelConstant.PEN_M);
				mouzaDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				mouzaDetails.setStatus(ModelConstant.PEN_J_M);
				mouzaDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}
			MouzaDetails savedMouzaDetails = mouzaDetailsRepo.save(mouzaDetails);
			logAction(loginId, ModelConstant.MAUZA, ModelConstant.DELETE,
					"District Code: " + savedMouzaDetails.getDistrictCode() + ", Circle Code: "
							+ savedMouzaDetails.getCircleCode() + ", Area Type Id Code: "
							+ savedMouzaDetails.getAreaTypeId() + ", Mauza Code: " + savedMouzaDetails.getMouzaCode(),
					"Mauza deleted (set active=false successfully with name: " + savedMouzaDetails.getMouzaName(),
					savedMouzaDetails.getStatus(), savedMouzaDetails.getStatusCode(),
					savedMouzaDetails.getMouzaGenId());

			response.setData(savedMouzaDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Mouza Deleted Successfully");

			log.info("Respond: Mouza Deleted Successfully | MouzaCode: {} | UpdatedBy: {} | Method: {} | Class: {}",
					savedMouzaDetails.getMouzaCode(), loginId, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while Deleting Mouza Details | MouzaCode: {} | Method: {} | Class: {} | Error: {}",
					mouzaCode, methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting Mouza Details | MouzaCode: " + mouzaCode + ", error: "
					+ e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	@Transactional
	public ResponseModel addLandCategory(LandCategoriesModelRequest landCategoriesModel) {
		String methodName = "addLandCategory";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request: Add LandCategory, Name: {}, Method: {}, Class: {}",
					landCategoriesModel.getLandCategoryName(), methodName, this.getClass().getSimpleName());

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

			LandCategories landCategories = new LandCategories();
			landCategories.setLandCategoryName(landCategoriesModel.getLandCategoryName());
			landCategories.setBasePriceIncreaseLandUse(landCategoriesModel.getBasePriceIncreaseLandUse());
			landCategories.setCircleCode(landCategoriesModel.getCircleCode());
			landCategories.setCreatedBy(loginId);
			landCategories.setActive(true);
			// Log action// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				landCategories.setStatus(ModelConstant.COMPLETE);
				landCategories.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				landCategories.setStatus(ModelConstant.COMPLETE);
				landCategories.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				landCategories.setStatus(ModelConstant.PEN_S_M);
				landCategories.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				landCategories.setStatus(ModelConstant.PEN_M);
				landCategories.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				landCategories.setStatus(ModelConstant.PEN_J_M);
				landCategories.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			LandCategories savedLandCategory = landCategoriesRepo.saveAndFlush(landCategories);
			// Log action
			logAction(loginId, ModelConstant.LANDUSE, ModelConstant.ADD, "Land Code: Not defined"// +
																									// savedLandCategory.getDistrictCode(),
					, "LandUse added, name: " + savedLandCategory.getLandCategoryName(), savedLandCategory.getStatus(),
					savedLandCategory.getStatusCode(), savedLandCategory.getLandCategoryGenId());

			response.setData(savedLandCategory);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("LandCategory Added Successfully");

			log.info("Respond: LandCategory added successfully, Name: {}, Method: {}, Class: {}",
					savedLandCategory.getLandCategoryName(), methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while adding LandCategory, Name: {}, Method: {}, Class: {}",
					landCategoriesModel.getLandCategoryName(), methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while adding LandCategory, Name: "
					+ landCategoriesModel.getLandCategoryName() + ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	@Transactional
	public ResponseModel deleteLandsCategory(String landCategoryCode) {
		String methodName = "deleteLandsCategory";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete LandsCategory Details , landCategoryCode " + landCategoryCode + "  Method Name"
					+ methodName + " Class : " + this.getClass());

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

			LandsCategoryDetails landCategories = landsCategoryDetailsRepo
					.findByLandCategoryCodeAndActiveTrue(landCategoryCode);
			if (landCategories == null) {
				log.info("Respond: No Data Found - LandsCategoryDetails Details by landCategoryCode" + landCategoryCode
						+ "  Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			landCategories.setActive(false);
			landCategories.setUpdatedBy(loginId);
			landCategories.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Log action// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				landCategories.setStatus(ModelConstant.COMPLETE);
				landCategories.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				landCategories.setStatus(ModelConstant.COMPLETE);
				landCategories.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				landCategories.setStatus(ModelConstant.PEN_S_M);
				landCategories.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				landCategories.setStatus(ModelConstant.PEN_M);
				landCategories.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				landCategories.setStatus(ModelConstant.PEN_J_M);
				landCategories.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}
			LandsCategoryDetails landCategoriesSaved = landsCategoryDetailsRepo.save(landCategories);
			// Log action
			logAction(loginId, ModelConstant.LANDCATEGORY, ModelConstant.DELETE,
					"Land Category Name: " + landCategoriesSaved.getLandCategoryName() + ", Land Category Code: "
							+ landCategoriesSaved.getLandCategoryCode(),
					// savedLandCategory.getDistrictCode(),

					"LandsCategoryDetails deleted (set active=false) successfully with name: "
							+ landCategoriesSaved.getLandCategoryName(),
					landCategoriesSaved.getStatus(), landCategoriesSaved.getStatusCode(),
					landCategoriesSaved.getLandCategoryGenId());

			response.setData(landCategoriesSaved);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("LandsCategoryDetails Delete Successfully");

			log.info("Respond : LandsCategoryDetails Deleted successfully LandsCategoryDetails Details, areaTypesGenId"
					+ landCategoriesSaved.getLandCategoryGenId() + "  Method Name" + methodName + " Class : "
					+ this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Deleting LandCategory Details, landCategoryCode " + landCategoryCode
					+ "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting LandCategory Details , landCategoryCode "
					+ landCategoryCode + ",error : " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	@Transactional
	public ResponseModel addAreaType(AreaTypesModelRequest areaTypesModel) {
		String methodName = "addAreaType";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: add AreaType Details , AreaType Name " + areaTypesModel.getAreaType() + "  Method Name"
					+ methodName + " Class : " + this.getClass());

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

			AreaTypes areaTypes = new AreaTypes();
			areaTypes.setAreaType(areaTypesModel.getAreaType());
			areaTypes.setCreatedBy(loginId);
			areaTypes.setActive(true);
			// Log action// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				areaTypes.setStatus(ModelConstant.COMPLETE);
				areaTypes.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				areaTypes.setStatus(ModelConstant.COMPLETE);
				areaTypes.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				areaTypes.setStatus(ModelConstant.PEN_S_M);
				areaTypes.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				areaTypes.setStatus(ModelConstant.PEN_M);
				areaTypes.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				areaTypes.setStatus(ModelConstant.PEN_J_M);
				areaTypes.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			AreaTypes savedAreaType = areaTypesRepo.saveAndFlush(areaTypes);
			// Log action
			logAction(loginId, ModelConstant.AREATYPE, ModelConstant.ADD, "Area Type: Not defined",
					"AreaType added, name: " + savedAreaType.getAreaType(), savedAreaType.getStatus(),
					savedAreaType.getStatusCode(), savedAreaType.getAreaTypesGenId());

			response.setData(savedAreaType);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("AreaType Added Successfully");

			log.info("Respond : data add successfully AreaType Details, AreaType Name " + savedAreaType.getAreaType()
					+ "  Method Name" + methodName + " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while adding AreaType Details, AreaType Name " + areaTypesModel.getAreaType()
					+ "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while adding AreaType Details , AreaType Name "
					+ areaTypesModel.getAreaType() + ",error : " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	@Transactional
	public ResponseModel deleteAreaType(Long areaTypesGenId) {
		String methodName = "deleteAreaType";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request: Delete AreaType, ID: {}, Method: {}, Class: {}", areaTypesGenId, methodName,
					this.getClass().getSimpleName());

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

			AreaTypes areaTypes = areaTypesRepo.findByAreaTypesGenIdAndActiveTrue(areaTypesGenId);
			if (areaTypes == null) {
				log.warn("Respond: No AreaType found for ID: {}, Method: {}, Class: {}", areaTypesGenId, methodName,
						this.getClass().getSimpleName());

				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found for AreaType ID: " + areaTypesGenId);
				return response;
			}

			// Soft delete

			areaTypes.setActive(false);
			areaTypes.setUpdatedBy(loginId);
			areaTypes.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Log action// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				areaTypes.setStatus(ModelConstant.COMPLETE);
				areaTypes.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				areaTypes.setStatus(ModelConstant.COMPLETE);
				areaTypes.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				areaTypes.setStatus(ModelConstant.PEN_S_M);
				areaTypes.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				areaTypes.setStatus(ModelConstant.PEN_M);
				areaTypes.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				areaTypes.setStatus(ModelConstant.PEN_J_M);
				areaTypes.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}
			AreaTypes updatedAreaType = areaTypesRepo.save(areaTypes);
			// Log action

			logAction(loginId, ModelConstant.AREATYPE, ModelConstant.DELETE, updatedAreaType.getAreaType(),
					"Area Type deleted (set active=false successfully with name: " + updatedAreaType.getAreaType(),
					updatedAreaType.getStatus(), updatedAreaType.getStatusCode(), updatedAreaType.getAreaTypesGenId());
			response.setData(updatedAreaType);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("AreaType deleted successfully");

			log.info("Respond: AreaType deleted successfully, ID: {}, UpdatedBy: {}, Method: {}, Class: {}",
					updatedAreaType.getAreaTypesGenId(), loginId, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while deleting AreaType, ID: {}, Method: {}, Class: {}", areaTypesGenId, methodName,
					this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while deleting AreaType, ID: " + areaTypesGenId + ", error: "
					+ e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	@Transactional
	public ResponseModel getLotDetails(String districtCode, String circleCode) {
		String methodName = "getLotDetails";
		ResponseModel response = new ResponseModel();
		try {
			if (((districtCode == null || districtCode.trim().equals(""))
					&& (circleCode == null || circleCode.trim().equals("")))
					|| ((districtCode == null || districtCode.trim().equals("")) && circleCode != null)) {
				log.info("Respond : Invalid Parameters " + "Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.BAD_REQUEST);
				response.setMessage("Invalid Parameter");
				return response;
			} else if ((districtCode != null && !districtCode.trim().equals(""))
					&& (circleCode != null && !circleCode.trim().equals(""))) {

				log.info("Request: Finding Lot By District code :  " + districtCode + "  Method Name" + methodName
						+ " Class : " + this.getClass());

				List<LotDetails> lotList = lotDetailsRepo.findByDistrictCodeAndActiveTrue(districtCode);

				if (lotList == null || lotList.isEmpty()) {
					log.info("Respond: No Data Found for Lot By District code :  " + districtCode + "  Method Name"
							+ methodName + " Class : " + this.getClass());
					response.setHttpStatus(HttpStatus.NO_CONTENT);
					response.setMessage("No Data Found");
					return response;
				}

				response.setData(lotList);

				log.info("Respond : data Fetched successfully - Lot By District code : " + districtCode
						+ "  Method Name" + methodName + " Class : " + this.getClass());
			} else {
				log.info("Request: Finding Lot By District code :  " + districtCode + " and  circle Code : "
						+ circleCode + "  Method Name" + methodName + " Class : " + this.getClass());

				List<LotDetails> lotList = lotDetailsRepo.findByDistrictCodeAndCircleCodeAndActiveTrue(districtCode,
						circleCode);

				if (lotList == null || lotList.isEmpty()) {
					log.info("Respond: No Data Found for Lot By District code :  " + districtCode
							+ " and  circle Code : " + circleCode + "  Method Name" + methodName + " Class : "
							+ this.getClass());
					response.setHttpStatus(HttpStatus.NO_CONTENT);
					response.setMessage("No Data Found");
					return response;
				}

				response.setData(lotList);

				log.info("Respond : data Fetched successfully - Lot By District code : " + districtCode
						+ " and  circle Code : " + circleCode + "  Method Name" + methodName + " Class : "
						+ this.getClass());
			}

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

		} catch (Exception e) {
			log.error("An error occurred while Finding  Lot details " + "  Method Name" + methodName + " Class : "
					+ this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding  Lot Details ,error : " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	@Transactional
	public ResponseModel addLotDetails(LotDetailsModelRequest lotDetailsModel) {
		String methodName = "addLotDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request: Add Lot, Name: {}, DistrictCode: {}, CircleCode: {}, AreaTypeId: {}, Method: {}, Class: {}",
					lotDetailsModel.getLotName(), lotDetailsModel.getDistrictCode(), lotDetailsModel.getCircleCode(),
					lotDetailsModel.getAreaTypeId(), methodName, this.getClass().getSimpleName());

			// Generate next lot code
			Integer lotCode = Optional.ofNullable(lotDetailsRepo.findMaxLotCode()).orElse(10000) + 1;

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

			LotDetails lotDetails = new LotDetails();
			lotDetails.setLotCode(lotCode.toString());
			lotDetails.setLotName(lotDetailsModel.getLotName());
			lotDetails.setDistrictCode(lotDetailsModel.getDistrictCode());
			lotDetails.setCircleCode(lotDetailsModel.getCircleCode());
			lotDetails.setMouzaCode(lotDetailsModel.getMouzaCode());
			lotDetails.setAreaTypeId(lotDetailsModel.getAreaTypeId());
			lotDetails.setCreatedBy(loginId);
			lotDetails.setActive(true);
			// Log action// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				lotDetails.setStatus(ModelConstant.COMPLETE);
				lotDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				lotDetails.setStatus(ModelConstant.COMPLETE);
				lotDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				lotDetails.setStatus(ModelConstant.PEN_S_M);
				lotDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				lotDetails.setStatus(ModelConstant.PEN_M);
				lotDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				lotDetails.setStatus(ModelConstant.PEN_J_M);
				lotDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			LotDetails savedLotDetails = lotDetailsRepo.saveAndFlush(lotDetails);
			// Log action
			logAction(loginId, ModelConstant.LOT, ModelConstant.ADD,
					"District Code: " + savedLotDetails.getDistrictCode() + ", Circle Code: "
							+ savedLotDetails.getCircleCode() + ", Mauza Code: " + savedLotDetails.getMouzaCode()
							+ ", AreaTypeId Code: " + savedLotDetails.getAreaTypeId() + ", Lot Code: "
							+ savedLotDetails.getLotCode(),
					"Lot added, name: " + savedLotDetails.getLotName(), savedLotDetails.getStatus(),
					savedLotDetails.getStatusCode(), savedLotDetails.getLotGenId());
			response.setData(savedLotDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Lot added successfully");

			log.info(
					"Respond: Lot added successfully, LotCode: {}, Name: {}, DistrictCode: {}, CircleCode: {}, AreaTypeId: {}, CreatedBy: {}, Method: {}, Class: {}",
					savedLotDetails.getLotCode(), savedLotDetails.getLotName(), savedLotDetails.getDistrictCode(),
					savedLotDetails.getCircleCode(), savedLotDetails.getAreaTypeId(), savedLotDetails.getCreatedBy(),
					methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error while adding Lot, Name: {}, DistrictCode: {}, CircleCode: {}, AreaTypeId: {}, Method: {}, Class: {}",
					lotDetailsModel.getLotName(), lotDetailsModel.getDistrictCode(), lotDetailsModel.getCircleCode(),
					lotDetailsModel.getAreaTypeId(), methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while adding Lot. Name: " + lotDetailsModel.getLotName()
					+ ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	@Transactional
	public ResponseModel updateLotDetails(LotDetailsModelUpdateRequest lotDetailsModel) {
		String methodName = "updateLotDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request: Update Lot Details [lotCode={}, lotName={}, districtCode={}, circleCode={}, areaTypeId={}] Method Name {} Class: {}",
					lotDetailsModel.getLotCode(), lotDetailsModel.getLotName(), lotDetailsModel.getDistrictCode(),
					lotDetailsModel.getCircleCode(), lotDetailsModel.getAreaTypeId(), methodName,
					this.getClass().getName());

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

			LotDetails existingLot = lotDetailsRepo.findByLotCodeAndActiveTrue(lotDetailsModel.getLotCode());
			if (existingLot == null) {
				log.info("Respond: No Data Found - Lot Details by LotCode {} Method Name {} Class: {}",
						lotDetailsModel.getLotCode(), methodName, this.getClass().getName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			// Deactivate old entry
			existingLot.setActive(false);
			existingLot.setUpdatedBy(loginId);
			existingLot.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			lotDetailsRepo.save(existingLot);

			// Create new entry with updated values
			LotDetails lotDetails = new LotDetails();
			lotDetails.setLotCode(lotDetailsModel.getLotCode());
			lotDetails.setLotName(lotDetailsModel.getLotName());
			lotDetails.setDistrictCode(lotDetailsModel.getDistrictCode());
			lotDetails.setCircleCode(lotDetailsModel.getCircleCode());
			lotDetails.setMouzaCode(lotDetailsModel.getMouzaCode());
			lotDetails.setAreaTypeId(lotDetailsModel.getAreaTypeId());
			lotDetails.setActive(true);
			lotDetails.setCreatedBy(existingLot.getCreatedBy()); // keep original
			lotDetails.setCreatedDtm(existingLot.getCreatedDtm()); // keep original
			lotDetails.setUpdatedBy(loginId);
			lotDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Log action
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				lotDetails.setStatus(ModelConstant.COMPLETE);
				lotDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				lotDetails.setStatus(ModelConstant.COMPLETE);
				lotDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				lotDetails.setStatus(ModelConstant.PEN_S_M);
				lotDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				lotDetails.setStatus(ModelConstant.PEN_M);
				lotDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				lotDetails.setStatus(ModelConstant.PEN_J_M);
				lotDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			LotDetails savedLotDetails = lotDetailsRepo.save(lotDetails);
			// Log action
			logAction(loginId, ModelConstant.LOT, ModelConstant.UPDATE,
					"District Code: " + savedLotDetails.getDistrictCode() + ", Circle Code: "
							+ savedLotDetails.getCircleCode() + ", Mauza Code: " + savedLotDetails.getMouzaCode()
							+ ", AreaTypeId Code: " + savedLotDetails.getAreaTypeId() + ", Lot Code: "
							+ savedLotDetails.getLotCode(),
					"Lot updated, name: " + savedLotDetails.getLotName(), savedLotDetails.getStatus(),
					savedLotDetails.getStatusCode(), savedLotDetails.getLotGenId());

			response.setData(savedLotDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Lot Updated Successfully");

			log.info(
					"Respond: Lot Updated successfully [lotCode={}, lotName={}, districtCode={}, circleCode={}, areaTypeId={}] Method Name {} Class: {}",
					savedLotDetails.getLotCode(), savedLotDetails.getLotName(), savedLotDetails.getDistrictCode(),
					savedLotDetails.getCircleCode(), savedLotDetails.getAreaTypeId(), methodName,
					this.getClass().getName());

		} catch (Exception e) {
			log.error(
					"An error occurred while updating Lot Details [lotCode={}, lotName={}, districtCode={}, circleCode={}, areaTypeId={}] Method Name {} Class: {}",
					lotDetailsModel.getLotCode(), lotDetailsModel.getLotName(), lotDetailsModel.getDistrictCode(),
					lotDetailsModel.getCircleCode(), lotDetailsModel.getAreaTypeId(), methodName,
					this.getClass().getName(), e);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while updating Lot Details, Lot Name " + lotDetailsModel.getLotName()
					+ ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	@Transactional
	public ResponseModel deleteLotDetails(String lotCode) {
		String methodName = "deleteLotDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete Lot Details , LotCode " + lotCode + "  Method Name" + methodName + " Class : "
					+ this.getClass());

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

			LotDetails lotDetails = lotDetailsRepo.findByLotCodeAndActiveTrue(lotCode);

			if (lotDetails == null) {
				log.info("Respond: No Data Found - Lot Details by LotCode" + lotCode + "  Method Name" + methodName
						+ " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			lotDetails.setActive(false);
			lotDetails.setUpdatedBy(loginId);
			lotDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				lotDetails.setStatus(ModelConstant.COMPLETE);
				lotDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				lotDetails.setStatus(ModelConstant.COMPLETE);
				lotDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				lotDetails.setStatus(ModelConstant.PEN_S_M);
				lotDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				lotDetails.setStatus(ModelConstant.PEN_M);
				lotDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				lotDetails.setStatus(ModelConstant.PEN_J_M);
				lotDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			LotDetails savedLotDetails = lotDetailsRepo.save(lotDetails);
			// Log action

			logAction(loginId, ModelConstant.LOT, ModelConstant.DELETE,
					"District Code: " + savedLotDetails.getDistrictCode() + ", Circle Code: "
							+ savedLotDetails.getCircleCode() + ", Mauza Code: " + savedLotDetails.getMouzaCode()
							+ ", AreaTypeId Code: " + savedLotDetails.getAreaTypeId() + ", Lot Code: "
							+ savedLotDetails.getLotCode(),
					"Lot deleted (set active=false successfully with name: " + savedLotDetails.getLotName(),
					savedLotDetails.getStatus(), savedLotDetails.getStatusCode(), savedLotDetails.getLotGenId());
			response.setData(savedLotDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Lot Delete Successfully");

			log.info("Respond : Lot Deleted successfully Lot Details, Lot code " + savedLotDetails.getLotCode()
					+ "  Method Name" + methodName + " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Deleting Lot Details, Lot code " + lotCode + "  Method Name" + methodName
					+ " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting Lot Details , Lot code " + lotCode + ",error : "
					+ e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel addSroDetails(SroDetailsModelRequest sroDetailsModel) {
		return null;
	}

	@Override
	public ResponseModel updateSroDetails(SroDetailsModelUpdateRequest sroDetailsModel) {
		return null;
	}

	@Override
	public ResponseModel deleteSroDetails(String sroCode) {

		return null;
	}

	@Override
	public ResponseModel getLotByDistrictAndCircle(String districtCode, String circleCode) {
		String methodName = "getLotByDistrictAndCircle";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding Lot By District code : " + districtCode + " and circleCode : " + circleCode
					+ "  Method Name" + methodName + " Class : " + this.getClass());
//
//			List<Map<String, String>> lotList = lotDetailsRepo
//					.findLotByDistrictCodeAndCircleCode(districtCode, circleCode);
			String status = ModelConstant.COMPLETE;
			List<LotDetails> lotList = lotDetailsRepo
					.findLotByDistrictCodeAndCircleCodeAndActiveTrueAndStatus(districtCode, circleCode, status);
			// List<LotDetails> lotList = lotDetailsRepo.findByDistrictCode(districtCode);

			if (lotList == null || lotList.isEmpty()) {
				log.info("Respond: No Data Found for Lot By District code :  " + districtCode + " and circleCode : "
						+ circleCode + "  Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(lotList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully - Lot By District code : " + districtCode
					+ " and circleCode : " + circleCode + "  Method Name" + methodName + " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding  Lot By District code : " + districtCode + " and circleCode : "
					+ circleCode + "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding  Lot By District code and circleCode ,error : "
					+ e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel getLandSubClassByLandClassName(String landClassName) {
		String methodName = "getLandSubClassByLandClass";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding Land Sub Class By Land Class Name : " + landClassName + "  Method Name"
					+ methodName + " Class : " + this.getClass());
//
//			List<Map<String, String>> landSubClassList = landSubClassRepo
//					.findLandSubClassByLandClassNameAndActiveTrue(landClassName);
			String status = ModelConstant.COMPLETE;
			List<LandSubClassDetails> landSubClassList = landSubClassDetailsRepo
					.findLandSubClassByLandClassNameAndActiveTrueAndStatus(landClassName, status);

			if (landSubClassList == null || landSubClassList.isEmpty()) {
				log.info("Respond: No Data Found for Land Sub Class By Land Class Name :  " + landClassName
						+ "  Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(landSubClassList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully - Land Sub Class By Land Class Name :  " + landClassName
					+ "  Method Name" + methodName + " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding  Land Sub Class By Land Class Name :  " + landClassName
					+ "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding  Land Sub Class By Land Class Name ,error : "
					+ e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel addLandSubClassDetails(LandSubClassDetailsModelRequest landSubClassDetailsModel) {

		String methodName = "addLandSubClassDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request: Add LandSubClass, Name: {}, LandClassName: {}, Method: {}, Class: {}",
					landSubClassDetailsModel.getLandSubClassName(), landSubClassDetailsModel.getLandClassName(),
					methodName, this.getClass().getSimpleName());

			// Generate next landSubClass code
			Integer landSubClassCode = Optional.ofNullable(landSubClassDetailsRepo.findMaxLandSubClassCode())
					.orElse(10000) + 1;

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

			LandSubClassDetails landSubClassDetails = new LandSubClassDetails();
			landSubClassDetails.setLandSubClassCode(landSubClassCode.toString());
			landSubClassDetails.setLandSubClassName(landSubClassDetailsModel.getLandSubClassName());
			landSubClassDetails.setLandClassName(landSubClassDetailsModel.getLandClassName());
			landSubClassDetails.setCreatedBy(loginId);
			landSubClassDetails.setActive(true);
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				landSubClassDetails.setStatus(ModelConstant.COMPLETE);
				landSubClassDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				landSubClassDetails.setStatus(ModelConstant.COMPLETE);
				landSubClassDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				landSubClassDetails.setStatus(ModelConstant.PEN_S_M);
				landSubClassDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				landSubClassDetails.setStatus(ModelConstant.PEN_M);
				landSubClassDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				landSubClassDetails.setStatus(ModelConstant.PEN_J_M);
				landSubClassDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			LandSubClassDetails savedLandSubClassDetails = landSubClassDetailsRepo.saveAndFlush(landSubClassDetails);
			// Log action
			logAction(loginId, ModelConstant.LANDSUBCLASS, ModelConstant.ADD,
					"Land Class Name: " + savedLandSubClassDetails.getLandClassName() + ", Land Sub Class Code: "
							+ savedLandSubClassDetails.getLandSubClassCode(),
					"Land Sub Class added, name: " + savedLandSubClassDetails.getLandSubClassName(),
					savedLandSubClassDetails.getStatus(), savedLandSubClassDetails.getStatusCode(),
					savedLandSubClassDetails.getLandSubClassGenId());

			response.setData(savedLandSubClassDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("LandSubClass added successfully");

			log.info(
					"Respond: LandSubClass added successfully, LandSubClassCode: {}, Name: {}, LandClassName: {}, CreatedBy: {}, Method: {}, Class: {}",
					savedLandSubClassDetails.getLandSubClassCode(), savedLandSubClassDetails.getLandSubClassName(),
					savedLandSubClassDetails.getLandClassName(), savedLandSubClassDetails.getCreatedBy(), methodName,
					this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while adding LandSubClass, Name: {}, LandClassName: {}, Method: {}, Class: {}",
					landSubClassDetailsModel.getLandSubClassName(), landSubClassDetailsModel.getLandClassName(),
					methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while adding LandSubClass. Name: "
					+ landSubClassDetailsModel.getLandSubClassName() + ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	public ResponseModel updateLandSubClassDetails(LandSubClassDetailsModelUpdateRequest landSubClassDetailsModel) {
		String methodName = "updateLandSubClassDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request: Updating LandSubClassDetails [landSubClassName={}, landClassName={}] | Method={} | Class={}",
					landSubClassDetailsModel.getLandSubClassName(), landSubClassDetailsModel.getLandClassName(),
					methodName, this.getClass().getSimpleName());

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

			// Fetch existing details
			LandSubClassDetails existingLandSubClassDetails = landSubClassDetailsRepo
					.findByLandSubClassNameAndActiveTrue(landSubClassDetailsModel.getLandSubClassName());

			if (existingLandSubClassDetails == null) {
				log.info("No active LandSubClassDetails found for [landSubClassName={}] | Method={} | Class={}",
						landSubClassDetailsModel.getLandSubClassName(), methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage(
						"No Data Found for Land Sub Class: " + landSubClassDetailsModel.getLandSubClassName());
				return response;
			}

			// Deactivate old entry
			existingLandSubClassDetails.setActive(false);
			existingLandSubClassDetails.setUpdatedBy(loginId);
			existingLandSubClassDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			landSubClassDetailsRepo.save(existingLandSubClassDetails);

			// Create new entry with updated values
			LandSubClassDetails landSubClassDetails = new LandSubClassDetails();
			landSubClassDetails.setLandSubClassCode(landSubClassDetailsModel.getLandSubClassCode());
			landSubClassDetails.setLandSubClassName(landSubClassDetailsModel.getLandSubClassName());
			landSubClassDetails.setLandClassName(landSubClassDetailsModel.getLandClassName());
			landSubClassDetails.setActive(true);
			landSubClassDetails.setCreatedBy(existingLandSubClassDetails.getCreatedBy());
			landSubClassDetails.setCreatedDtm(existingLandSubClassDetails.getCreatedDtm());
			landSubClassDetails.setUpdatedBy(loginId);
			landSubClassDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				landSubClassDetails.setStatus(ModelConstant.COMPLETE);
				landSubClassDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				landSubClassDetails.setStatus(ModelConstant.COMPLETE);
				landSubClassDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				landSubClassDetails.setStatus(ModelConstant.PEN_S_M);
				landSubClassDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				landSubClassDetails.setStatus(ModelConstant.PEN_M);
				landSubClassDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				landSubClassDetails.setStatus(ModelConstant.PEN_J_M);
				landSubClassDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}
			LandSubClassDetails savedLandSubClassDetails = landSubClassDetailsRepo.save(landSubClassDetails);

			logAction(loginId, ModelConstant.LANDSUBCLASS, ModelConstant.UPDATE,
					"Land Class Name: " + savedLandSubClassDetails.getLandClassName() + ", Land Sub Class Code: "
							+ savedLandSubClassDetails.getLandSubClassCode(),
					"Land Sub Class updated, name: " + savedLandSubClassDetails.getLandSubClassName(),
					savedLandSubClassDetails.getStatus(), savedLandSubClassDetails.getStatusCode(),
					savedLandSubClassDetails.getLandSubClassGenId());

			response.setData(savedLandSubClassDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("LandSubClassDetails Updated Successfully");

			log.info(
					"Response: LandSubClassDetails updated successfully [landSubClassName={}, landClassName={}] | UpdatedBy={} | Method={} | Class={}",
					savedLandSubClassDetails.getLandSubClassName(), savedLandSubClassDetails.getLandClassName(),
					loginId, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error updating LandSubClassDetails [landSubClassName={}, landClassName={}] | Method={} | Class={} | Error={}",
					landSubClassDetailsModel.getLandSubClassName(), landSubClassDetailsModel.getLandClassName(),
					methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while updating LandSubClassDetails: "
					+ landSubClassDetailsModel.getLandSubClassName() + ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	public ResponseModel deleteLandSubClassDetails(String landSubClass) {

		String methodName = "deleteLandSubClassDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete Land Sub Class Details , LandSubClass " + landSubClass + "  Method Name"
					+ methodName + " Class : " + this.getClass());

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
			String status = ModelConstant.COMPLETE;
			LandSubClassDetails landSubClassDetails = landSubClassDetailsRepo
					.findByLandSubClassNameAndActiveTrueAndStatus(landSubClass, status);

			if (landSubClassDetails == null) {
				log.info("Respond: No Data Found - LandSubClass Details by Land Sub Class" + landSubClass
						+ "  Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			landSubClassDetails.setActive(false);
			landSubClassDetails.setUpdatedBy(loginId);
			landSubClassDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				landSubClassDetails.setStatus(ModelConstant.COMPLETE);
				landSubClassDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				landSubClassDetails.setStatus(ModelConstant.COMPLETE);
				landSubClassDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				landSubClassDetails.setStatus(ModelConstant.PEN_S_M);
				landSubClassDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				landSubClassDetails.setStatus(ModelConstant.PEN_M);
				landSubClassDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				landSubClassDetails.setStatus(ModelConstant.PEN_J_M);
				landSubClassDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			LandSubClassDetails savedLandSubClassDetails = landSubClassDetailsRepo.save(landSubClassDetails);

			// Log action

			logAction(loginId, ModelConstant.LANDSUBCLASS, ModelConstant.DELETE,
					savedLandSubClassDetails.getLandSubClassCode(),
					"LandSubClassDetails deleted (set active=false successfully with name: "
							+ savedLandSubClassDetails.getLandSubClassName(),
					savedLandSubClassDetails.getStatus(), savedLandSubClassDetails.getStatusCode(),
					savedLandSubClassDetails.getLandSubClassGenId());

			response.setData(savedLandSubClassDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("LandSubClass Delete Successfully");

			log.info("Respond : LandSubClass Deleted successfully LandSubClass Details, LandSubClass "
					+ savedLandSubClassDetails.getLandSubClassName() + "  Method Name" + methodName + " Class : "
					+ this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Deleting LandSubClass Details, LandSubClass " + landSubClass
					+ "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting LandSubClass Details , LandSubClass " + landSubClass
					+ ",error : " + e.getLocalizedMessage());
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

	@Override
	// public ResponseModel
	// updateBasePriceDetails(BasePriceUpdateDetailsModelRequest bPRequest) {}
	public ResponseModel updateBasePriceDetails(BasePriceUpdateDetailsModelRequest bPRequest) {
		String methodName = "updateBasePriceDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update Base Prices | District/Circle/Mouza Price: {} | Lot Price : {} | LandUse Price : {} | Urban/Rural Price : {} | Method: {} | Class: {}",
					bPRequest.getBasePriceMouza(), bPRequest.getBasePriceMouzaIncreaseLot(),
					bPRequest.getBasePriceMouzaIncreaseLandUse(), bPRequest.getBasePriceMouzaIncreaseAreaUrbanOrRural(),
					methodName, this.getClass().getSimpleName());

			// --- Authentication check ---
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
			log.info("User '{}' has roles: {}", loginId, userRoles);

			String status = ModelConstant.COMPLETE;
			String districtCode = bPRequest.getDistrictCode();
			String circleCode = bPRequest.getCircleCode();
			String mouzaCode = bPRequest.getMouzaCode();

			// --- Example: update Mouza Base Price ---
			if (bPRequest.getBasePriceMouza() != null) {
				MouzaDetails mouza = mouzaDetailsRepo
						.findMouzaByDistrictCodeAndCircleCodeAndMouzaCodeAndActiveTrueAndStatus(districtCode,
								circleCode, mouzaCode, status);
				if (mouza != null) {
					mouza.setBasePriceMouza(bPRequest.getBasePriceMouza());
					mouza.setUpdatedBy(loginId);
					mouza.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
					mouzaDetailsRepo.save(mouza);
					log.info("Mouza base price updated successfully for MouzaCode: {}", mouzaCode);
				} else {
					log.warn("Mouza not found for District: {}, Circle: {}, Mouza: {}", districtCode, circleCode,
							mouzaCode);
				}
			}

			// --- Example: update Lot Base Price ---
			if (bPRequest.getBasePriceMouzaIncreaseLot() != null) {
				LotDetails lot = lotDetailsRepo.findLotByDistrictCodeAndCircleCodeAndStatusAndActiveTrue(districtCode,
						circleCode, status);
				// LotDetails lot = lotDetailsRepo.findByStatus(status);

				if (lot != null) {
					lot.setBasePriceIncreaseLot(bPRequest.getBasePriceMouzaIncreaseLot());
					lot.setUpdatedBy(loginId);
					lot.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
					lotDetailsRepo.save(lot);
					log.info("Lot base price updated successfully for Circle: {}", circleCode);
				} else {
					log.warn("Lot details not found for Circle: {}", circleCode);
				}
			}

			// --- Example: update Land Use Base Price ---
			if (bPRequest.getBasePriceMouzaIncreaseLandUse() != null) {
				LandCategories landUse = landCategoriesRepo
						.findByDistrictCodeAndCircleCodeAndActiveTrueAndStatus(districtCode, circleCode, status);
				if (landUse != null) {
					landUse.setBasePriceIncreaseLandUse(bPRequest.getBasePriceMouzaIncreaseLandUse());
					landUse.setUpdatedBy(loginId);
					landUse.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
					landCategoriesRepo.save(landUse);
					log.info("Land use base price updated successfully for Circle: {}", circleCode);
				} else {
					log.warn("Land use details not found for Circle: {}", circleCode);
				}
			}

			// --- Example: update Area Urban/Rural Base Price ---
			if (bPRequest.getBasePriceMouzaIncreaseAreaUrbanOrRural() != null) {
				AreaTypes areaType = areaTypesRepo.findByDistrictCodeAndCircleCodeAndMouzaCodeAndStatusAndActiveTrue(
						districtCode, circleCode, mouzaCode, status);
				// AreaTypes areaType = areaTypesRepo.findByStatus(status);
				if (areaType != null) {
					areaType.setBasePriceIncreaseAreaType(bPRequest.getBasePriceMouzaIncreaseAreaUrbanOrRural());
					areaType.setUpdatedBy(loginId);
					areaType.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
					areaTypesRepo.save(areaType);
					log.info("Area Urban/Rural base price updated successfully for Circle: {}", circleCode);
				} else {
					log.warn("Area type details not found for Circle: {}", circleCode);
				}
			}

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Base prices updated successfully (where applicable).");
			return response;

		} catch (Exception ex) {
			log.error("Exception occurred in {} | Message: {} | Class: {}", methodName, ex.getMessage(),
					this.getClass().getSimpleName(), ex);
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("Error occurred while updating base price details: " + ex.getMessage());
			return response;
		}
	}

	@Override
	public ResponseModel getParameterDetailsDynamic() {
		String methodName = "getParameterDetailsDynamic";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding Parameter Details of All : " + methodName + " Class : " + this.getClass());
//
//			List<Map<String, Object>> parameterList = parameterDetailsRepo.findParameterDetailsByRange(minRange,
//					maxRange);
			String status = ModelConstant.COMPLETE;
			List<ParamDetails> parameterList = paramDetailsRepo.findAllByActiveTrueAndStatus(status);

			if (parameterList == null || parameterList.isEmpty()) {
				log.info("Respond: No Data Found - Parameter Details of All : " + methodName + " Class : "
						+ this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(parameterList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully -  Parameter Details of All :   Method Name" + methodName
					+ " Class : " + this.getClass());
		} catch (Exception e) {

			log.error("Respond :An error occurred while Finding Parameter Details for minRange :    Method Name"
					+ methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"An error occurred while Finding  Parameter Details ,error : " + e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel getAllLandCategoriesByMouza(String mouzaCode) {
		String methodName = "getAllLandCategoriesByMouza";
		ResponseModel response = new ResponseModel();

		log.info("START | {} | Fetching Land Categories for mouzaCode: {}", methodName, mouzaCode);

		try {
			String status = ModelConstant.COMPLETE;

			log.debug("Executing repository call: findAllByActiveTrueAndStatusAndMouzaCode(status={}, mouzaCode={})",
					status, mouzaCode);
			List<LandCategories> landCategoriesList = landCategoriesRepo
					.findAllByActiveTrueAndStatusAndMouzaCode(status, mouzaCode);

			if (landCategoriesList == null || landCategoriesList.isEmpty()) {
				log.warn("NO DATA | {} | No Land Categories found for mouzaCode: {}", methodName, mouzaCode);
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(landCategoriesList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("SUCCESS | {} | {} Land Categories fetched successfully for mouzaCode: {}", methodName,
					landCategoriesList.size(), mouzaCode);

		} catch (Exception e) {
			log.error("ERROR | {} | Exception while fetching Land Categories for mouzaCode: {} | Error: {}", methodName,
					mouzaCode, e.getMessage(), e);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching Land Categories: " + e.getLocalizedMessage());
		}

		log.info("END | {} | Response: status={}, message={}", methodName, response.getHttpStatus(),
				response.getMessage());
		return response;
	}

	@Override
	public ResponseModel getAreaTypeByMouza(String mouzaCode) {
		String methodName = "getAreaTypeByMouza";
		ResponseModel response = new ResponseModel();

		log.info("START | {} | Fetching Area Types for mouzaCode: {}", methodName, mouzaCode);

		try {
			String status = ModelConstant.COMPLETE;

			log.debug("Executing repository call: findAllByActiveTrueAndStatusAndMouzaCode(status={}, mouzaCode={})",
					status, mouzaCode);
			List<AreaTypes> areaTypeList = areaTypesRepo.findAllByActiveTrueAndStatusAndMouzaCode(status, mouzaCode);

			if (areaTypeList == null || areaTypeList.isEmpty()) {
				log.warn("NO DATA | {} | No Area Types found for mouzaCode: {}", methodName, mouzaCode);
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(areaTypeList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("SUCCESS | {} | {} Area Types fetched successfully for mouzaCode: {}", methodName,
					areaTypeList.size(), mouzaCode);

		} catch (Exception e) {
			log.error("ERROR | {} | Exception while fetching Area Types for mouzaCode: {} | Error: {}", methodName,
					mouzaCode, e.getMessage(), e);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while finding Area Types: " + e.getLocalizedMessage());
		}

		log.info("END | {} | Response: status={}, message={}", methodName, response.getHttpStatus(),
				response.getMessage());
		return response;
	}

	@Override
	public ResponseModel getParameterDetailsDynamicByMasterCode(String masterCode) {
		final String methodName = "getParameterDetailsDynamicByMasterCode";
		ResponseModel response = new ResponseModel();

		log.info("START | [{}] | Fetching Parameter Details for masterCode: {}", methodName, masterCode);

		try {
			// Log repository invocation
			log.debug(
					"PROCESSING | [{}] | Invoking repository: parameterDetailsRepo.findAllByActiveTrueAndStatusAndMasterCode()",
					methodName);

			String status = ModelConstant.COMPLETE;
			List<ParamDetails> parameterList = paramDetailsRepo.findAllByActiveTrueAndStatusAndMasterCode(status,
					masterCode);

			// Check for no data
			if (parameterList == null || parameterList.isEmpty()) {
				log.warn("NO DATA | [{}] | No Parameter Details found for masterCode: {}", methodName, masterCode);
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			// Success scenario
			response.setData(parameterList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data fetched successfully");

			log.info("SUCCESS | [{}] | Parameter Details fetched successfully for masterCode: {} | Records: {}",
					methodName, masterCode, parameterList.size());

		} catch (Exception e) {
			log.error("EXCEPTION | [{}] | Error while fetching Parameter Details for masterCode: {} | Exception: {}",
					methodName, masterCode, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching Parameter Details: " + e.getLocalizedMessage());
		}

		log.info("END | [{}] | masterCode: {} | Response Status: {} | Message: {}", methodName, masterCode,
				response.getHttpStatus(), response.getMessage());

		return response;
	}

	@Override
	public ResponseModel getParameterDetailsDynamicByMasterSubCode(String masterSubCode) {
		final String methodName = "getParameterDetailsDynamicByMasterSubCode";
		ResponseModel response = new ResponseModel();

		log.info("START | [{}] | Fetching Parameter Details for masterSubCode: {}", methodName, masterSubCode);

		try {
			// Log repository invocation
			log.debug(
					"PROCESSING | [{}] | Invoking repository: parameterDetailsRepo.findAllByActiveTrueAndStatusAndMasterSubCode()",
					methodName);

			String status = ModelConstant.COMPLETE;
			List<ParamDetails> parameterList = paramDetailsRepo.findAllByActiveTrueAndStatusAndMasterSubCode(status,
					masterSubCode);

			// Check for no data
			if (parameterList == null || parameterList.isEmpty()) {
				log.warn("NO DATA | [{}] | No Parameter Details found for masterSubCode: {}", methodName,
						masterSubCode);
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			// Success scenario
			response.setData(parameterList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data fetched successfully");

			log.info("SUCCESS | [{}] | Parameter Details fetched successfully for masterSubCode: {} | Records: {}",
					methodName, masterSubCode, parameterList.size());

		} catch (Exception e) {
			log.error("EXCEPTION | [{}] | Error while fetching Parameter Details for masterSubCode: {} | Exception: {}",
					methodName, masterSubCode, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching Parameter Details: " + e.getLocalizedMessage());
		}

		log.info("END | [{}] | masterSubCode: {} | Response Status: {} | Message: {}", methodName, masterSubCode,
				response.getHttpStatus(), response.getMessage());

		return response;
	}

	@Override
	public ResponseModel getVillageByDistrictAndCircleAndMauzaAndLot(String districtCode, String circleCode,
			String mauza, String lot) {

		final String methodName = "getVillageByDistrictAndCircleAndMauzaAndLot";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Fetching villages | District: {} | Circle: {} | Mauza: {} | Lot: {}", methodName,
				districtCode, circleCode, mauza, lot);

		try {
			final String status = ModelConstant.COMPLETE;

			log.debug(
					"[PROCESS] [{}] - Invoking repository: findVillageByDistrictCodeAndCircleCodeAndMauzaAndLotAndActiveTrueAndStatus | Params: districtCode={}, circleCode={}, mauza={}, lot={}, status={}",
					methodName, districtCode, circleCode, mauza, lot, status);

			List<VillageDetails> villageList = villageDetailsRepo
					.findVillageByDistrictCodeAndCircleCodeAndMouzaCodeAndLotCodeAndActiveTrueAndStatus(districtCode,
							circleCode, mauza, lot, status);

			if (villageList == null || villageList.isEmpty()) {
				log.warn("[END] [{}] - No villages found | District: {} | Circle: {} | Mauza: {} | Lot: {}", methodName,
						districtCode, circleCode, mauza, lot);

				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(villageList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info(
					"[END] [{}] - Villages fetched successfully | Count: {} | District: {} | Circle: {} | Mauza: {} | Lot: {}",
					methodName, villageList.size(), districtCode, circleCode, mauza, lot);

		} catch (Exception e) {
			log.error(
					"[ERROR] [{}] - Exception occurred while fetching villages | District: {} | Circle: {} | Mauza: {} | Lot: {} | Error: {}",
					methodName, districtCode, circleCode, mauza, lot, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching village details: " + e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	public ResponseModel getLotByDistrictAndCircleAndMouza(String districtCode, String circleCode, String mouzaCode) {
		String methodName = "getLotByDistrictAndCircleAndMouza";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding Lot By District code : " + districtCode + " and circleCode : " + circleCode
					+ "  Method Name" + methodName + " Class : " + this.getClass());

			String status = ModelConstant.COMPLETE;
			List<LotDetails> lotList = lotDetailsRepo
					.findLotByDistrictCodeAndCircleCodeAndMouzaCodeAndActiveTrueAndStatus(districtCode, circleCode,
							mouzaCode, status);

			if (lotList == null || lotList.isEmpty()) {
				log.info("Respond: No Data Found for Lot By District code :  " + districtCode + " and circleCode : "
						+ circleCode + "  Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(lotList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully - Lot By District code : " + districtCode
					+ " and circleCode : " + circleCode + "  Method Name" + methodName + " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding  Lot By District code : " + districtCode + " and circleCode : "
					+ circleCode + "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding  Lot By District code and circleCode ,error : "
					+ e.getLocalizedMessage());
		}
		return response;
	}

	@Override
	public ResponseModel addParameterDetails(ParameterDetailsModelRequest parameterDetailsModel) {
		String methodName = "addParameterDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to add Parameter Details | Parameter Name: {} | Method: {}",
					parameterDetailsModel.getParameterName(), methodName);

			// Generate new parameter code
			Integer maxParameterCode = parameterDetailsRepo.findMaxParameterCode();
			Integer newParameterCode = (maxParameterCode == null) ? 10001 : maxParameterCode + 1;

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
			ParameterDetails parameterDetails = new ParameterDetails();
			parameterDetails.setParameterCode(newParameterCode.toString());
			parameterDetails.setParameterName(parameterDetailsModel.getParameterName());
			parameterDetails.setCreatedBy(loginId);
			parameterDetails.setActive(true);

			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				parameterDetails.setStatus(ModelConstant.COMPLETE);
				parameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				parameterDetails.setStatus(ModelConstant.COMPLETE);
				parameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				parameterDetails.setStatus(ModelConstant.PEN_S_M);
				parameterDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				parameterDetails.setStatus(ModelConstant.PEN_M);
				parameterDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				parameterDetails.setStatus(ModelConstant.PEN_J_M);
				parameterDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			// Save entity
			ParameterDetails savedParameterDetails = parameterDetailsRepo.saveAndFlush(parameterDetails);

			// Log action
			logAction(loginId, ModelConstant.PARAMETER, ModelConstant.ADD,
					"Parameter Code: " + savedParameterDetails.getParameterCode(),
					"Parameter added, name: " + savedParameterDetails.getParameterName(),
					savedParameterDetails.getStatus(), savedParameterDetails.getStatusCode(),
					savedParameterDetails.getParameterGenId());

			// Build response
			response.setData(savedParameterDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage(
					"Parameter added successfully | Parameter Name: " + savedParameterDetails.getParameterName()
							+ ", Parameter Code: " + savedParameterDetails.getParameterCode());

		} catch (Exception e) {
			log.error("Error occurred while adding Parameter Details | Parameter Name: {} | Method: {}",
					parameterDetailsModel.getParameterName(), methodName, e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add Parameter Details | Parameter Name: "
					+ parameterDetailsModel.getParameterName() + ", Error: " + e.getMessage());
		}

		return response;
	}

	@Override
	public ResponseModel updateParameterDetails(ParameterDetailsModelUpdateRequest parameterDetailsModel) {
		String methodName = "updateParameterDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update Parameter Details | Parameter Name: {} | Parameter Code: {} | Method: {} | Class: {}",
					parameterDetailsModel.getParameterName(), parameterDetailsModel.getParameterCode(), methodName,
					this.getClass().getSimpleName());

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

			// Fetch existing parameter
			ParameterDetails existingParameter = parameterDetailsRepo
					.findByParameterCodeAndActiveTrue(parameterDetailsModel.getParameterCode());

			if (existingParameter == null) {
				log.info("No active Parameter found for Parameter Code: {} | Method: {} | Class: {}",
						parameterDetailsModel.getParameterCode(), methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found for Parameter Code: " + parameterDetailsModel.getParameterCode());
				return response;
			}

			// Deactivate old record
			existingParameter.setActive(false);
			existingParameter.setUpdatedBy(loginId);// we can think about this
			existingParameter.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));// we can think about this
			parameterDetailsRepo.save(existingParameter);

			// Create new record with updated details
			ParameterDetails parameterDetails = new ParameterDetails();
			parameterDetails.setParameterCode(parameterDetailsModel.getParameterCode());
			parameterDetails.setParameterName(parameterDetailsModel.getParameterName());
			parameterDetails.setActive(true);
			parameterDetails.setCreatedBy(existingParameter.getCreatedBy());
			parameterDetails.setCreatedDtm(existingParameter.getCreatedDtm());
			parameterDetails.setUpdatedBy(loginId);
			parameterDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				parameterDetails.setStatus(ModelConstant.COMPLETE);
				parameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				parameterDetails.setStatus(ModelConstant.COMPLETE);
				parameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				parameterDetails.setStatus(ModelConstant.PEN_S_M);
				parameterDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				parameterDetails.setStatus(ModelConstant.PEN_M);
				parameterDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				parameterDetails.setStatus(ModelConstant.PEN_J_M);
				parameterDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			ParameterDetails savedParameter = parameterDetailsRepo.save(parameterDetails);

			logAction(loginId, ModelConstant.PARAMETER, ModelConstant.UPDATE,
					"Parameter Code: " + savedParameter.getParameterCode(),
					"Parameter updated, name: " + savedParameter.getParameterName(), savedParameter.getStatus(),
					savedParameter.getStatusCode(), savedParameter.getParameterGenId());

			response.setData(savedParameter);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Parameter Updated Successfully | Parameter Name: " + savedParameter.getParameterName()
					+ ", Parameter Code: " + savedParameter.getParameterCode());

			log.info(
					"Parameter updated successfully | Parameter Name: {} | Parameter Code: {} | Updated By: {} | Method: {} | Class: {}",
					savedParameter.getParameterName(), savedParameter.getParameterCode(), loginId, methodName,
					this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while updating Parameter Details | Parameter Name: {} | Parameter Code: {} | Method: {} | Class: {}",
					parameterDetailsModel.getParameterName(), parameterDetailsModel.getParameterCode(), methodName,
					this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to update Parameter Details | Parameter Name: "
					+ parameterDetailsModel.getParameterName() + ", Parameter Code: "
					+ parameterDetailsModel.getParameterCode() + ", Error: " + e.getMessage());
		}

		return response;
	}

	@Override
	public ResponseModel deleteParameterDetails(String parameterCode) {
		String methodName = "deleteParameterDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to delete Parameter Details | Parameter Code: {} | Method: {} | Class: {}",
					parameterCode, methodName, this.getClass().getSimpleName());

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

			// Fetch existing parameter
			ParameterDetails parameterDetails = parameterDetailsRepo.findByParameterCodeAndActiveTrue(parameterCode);

			if (parameterDetails == null) {
				log.info("No active Parameter found for Parameter Code: {} | Method: {} | Class: {}", parameterCode,
						methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found for Parameter Code: " + parameterCode);
				return response;
			}

			// Mark as inactive
			parameterDetails.setActive(false);
			parameterDetails.setUpdatedBy(loginId);
			parameterDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				parameterDetails.setStatus(ModelConstant.COMPLETE);
				parameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				parameterDetails.setStatus(ModelConstant.COMPLETE);
				parameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				parameterDetails.setStatus(ModelConstant.PEN_S_M);
				parameterDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				parameterDetails.setStatus(ModelConstant.PEN_M);
				parameterDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				parameterDetails.setStatus(ModelConstant.PEN_J_M);
				parameterDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}
			ParameterDetails savedParameter = parameterDetailsRepo.save(parameterDetails);

			logAction(loginId, ModelConstant.PARAMETER, ModelConstant.DELETE,
					"Parameter Code: " + savedParameter.getParameterCode(),
					"Parameter deleted (set active=false) , name: " + savedParameter.getParameterName(),
					savedParameter.getStatus(), savedParameter.getStatusCode(), savedParameter.getParameterGenId());

			response.setData(savedParameter);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Parameter Deleted Successfully | Parameter Code: " + parameterCode);

			log.info(
					"Parameter deleted means Active is FALSE Successfully | Parameter Code: {} | Updated By: {} | Method: {} | Class: {}",
					parameterCode, loginId, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error occurred while deleting Parameter Details | Parameter Code: {} | Method: {} | Class: {}",
					parameterCode, methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to delete Parameter Details | Parameter Code: " + parameterCode + ", Error: "
					+ e.getMessage());
		}

		return response;
	}

	@Override
	public ResponseModel addSubParameterDetails(SubParameterDetailsModelRequest subParameterDetailsModel) {
		String methodName = "addSubParameterDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to add SubParameter Details | SubParameter Name: {} | Method: {}",
					subParameterDetailsModel.getSubParameterName(), methodName);

			// Generate new subParameter code
			Integer maxSubParameterCode = subParameterDetailsRepo.findMaxSubParameterCode();
			Integer newSubParameterCode = (maxSubParameterCode == null) ? 10001 : maxSubParameterCode + 1;

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
			SubParameterDetails subParameterDetails = new SubParameterDetails();
			subParameterDetails.setSubParameterCode(newSubParameterCode.toString());
			subParameterDetails.setSubParameterName(subParameterDetailsModel.getSubParameterName());
			subParameterDetails.setParameterCode(subParameterDetailsModel.getParameterCode());
			subParameterDetails.setBasePriceIncreaseSubParameter(subParameterDetailsModel.getWeightage());
			subParameterDetails.setEffectiveFrom(subParameterDetailsModel.getEffectiveFrom());
			subParameterDetails.setCreatedBy(loginId);
			subParameterDetails.setActive(true);

			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				subParameterDetails.setStatus(ModelConstant.COMPLETE);
				subParameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				subParameterDetails.setStatus(ModelConstant.COMPLETE);
				subParameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				subParameterDetails.setStatus(ModelConstant.PEN_S_M);
				subParameterDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				subParameterDetails.setStatus(ModelConstant.PEN_M);
				subParameterDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				subParameterDetails.setStatus(ModelConstant.PEN_J_M);
				subParameterDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			// Save entity
			SubParameterDetails savedSubParameterDetails = subParameterDetailsRepo.saveAndFlush(subParameterDetails);

			// Log action
			logAction(loginId, ModelConstant.SUBPARAMETER, ModelConstant.ADD,
					"SubParameter Code: " + savedSubParameterDetails.getSubParameterCode(),
					"SubParameter added, name: " + savedSubParameterDetails.getSubParameterName() + ", Parameter Code: "
							+ savedSubParameterDetails.getParameterCode() + ",Base Price: "
							+ savedSubParameterDetails.getBasePriceIncreaseSubParameter() + ", Effective From: "
							+ savedSubParameterDetails.getEffectiveFrom(),
					savedSubParameterDetails.getStatus(), savedSubParameterDetails.getStatusCode(),
					savedSubParameterDetails.getSubParameterGenId());

			// Build response
			response.setData(savedSubParameterDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("SubParameter added successfully | SubParameter Name: "
					+ savedSubParameterDetails.getSubParameterName() + ", SubParameter Code: "
					+ savedSubParameterDetails.getSubParameterCode());

		} catch (Exception e) {
			log.error("Error occurred while adding SubParameter Details | SubParameter Name: {} | Method: {}",
					subParameterDetailsModel.getSubParameterName(), methodName, e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add SubParameter Details | SubParameter Name: "
					+ subParameterDetailsModel.getSubParameterName() + ", Error: " + e.getMessage());
		}

		return response;
	}

	@Override
	public ResponseModel updateSubParameterDetails(SubParameterDetailsModelUpdateRequest subParameterDetailsModel) {
		String methodName = "updateSubParameterDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update SubParameter Details | SubParameter Name: {} | SubParameter Code: {} | Parameter Code: {} | Method: {} | Class: {}",
					subParameterDetailsModel.getSubParameterName(), subParameterDetailsModel.getSubParameterCode(),
					subParameterDetailsModel.getWeightage(), subParameterDetailsModel.getEffectiveFrom(),
					subParameterDetailsModel.getParameterCode(), methodName, this.getClass().getSimpleName());

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

			// Fetch existing subParameter
			SubParameterDetails existingSubParameter = subParameterDetailsRepo
					.findBySubParameterCodeAndActiveTrue(subParameterDetailsModel.getSubParameterCode());

			if (existingSubParameter == null) {
				log.info("No active SubParameter found for SubParameter Code: {} | Method: {} | Class: {}",
						subParameterDetailsModel.getSubParameterCode(), methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage(
						"No Data Found for SubParameter Code: " + subParameterDetailsModel.getSubParameterCode());
				return response;
			}

			// Deactivate old record
			existingSubParameter.setActive(false);
			existingSubParameter.setUpdatedBy(loginId);
			existingSubParameter.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			subParameterDetailsRepo.save(existingSubParameter);

			// Create new record with updated details
			SubParameterDetails subParameterDetails = new SubParameterDetails();

			subParameterDetails.setSubParameterCode(subParameterDetailsModel.getSubParameterCode());
			subParameterDetails.setSubParameterName(subParameterDetailsModel.getSubParameterName());
			subParameterDetails.setEffectiveFrom(subParameterDetailsModel.getEffectiveFrom());
			subParameterDetails.setBasePriceIncreaseSubParameter(subParameterDetailsModel.getWeightage());
			subParameterDetails.setParameterCode(subParameterDetailsModel.getParameterCode());
			subParameterDetails.setActive(true);
			subParameterDetails.setCreatedBy(existingSubParameter.getCreatedBy());
			subParameterDetails.setCreatedDtm(existingSubParameter.getCreatedDtm());
			subParameterDetails.setUpdatedBy(loginId);
			subParameterDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				subParameterDetails.setStatus(ModelConstant.COMPLETE);
				subParameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				subParameterDetails.setStatus(ModelConstant.COMPLETE);
				subParameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				subParameterDetails.setStatus(ModelConstant.PEN_S_M);
				subParameterDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				subParameterDetails.setStatus(ModelConstant.PEN_M);
				subParameterDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				subParameterDetails.setStatus(ModelConstant.PEN_J_M);
				subParameterDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			SubParameterDetails savedSubParameter = subParameterDetailsRepo.save(subParameterDetails);

			// Log action
			logAction(loginId, ModelConstant.SUBPARAMETER, ModelConstant.UPDATE,
					"Sub Parameter Code: " + savedSubParameter.getParameterCode() + ", SubParameter Code:"
							+ savedSubParameter.getSubParameterCode(),
					"SubParameter updated, name: " + savedSubParameter.getSubParameterName(),
					savedSubParameter.getStatus(), savedSubParameter.getStatusCode(),
					savedSubParameter.getSubParameterGenId());

			response.setData(savedSubParameter);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage(
					"SubParameter Updated Successfully | SubParameter Name: " + savedSubParameter.getSubParameterName()
							+ ", SubParameter Code: " + savedSubParameter.getSubParameterCode() + ", Parameter Code: "
							+ savedSubParameter.getParameterCode());

			log.info(
					"SubParameter updated successfully | SubParameter Name: {} | SubParameter Code: {} | Parameter Code: {} | Updated By: {} | Method: {} | Class: {}",
					savedSubParameter.getSubParameterName(), savedSubParameter.getSubParameterCode(),
					savedSubParameter.getParameterCode(), loginId, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while updating SubParameter Details | SubParameter Name: {} | SubParameter Code: {} | Parameter Code: {} | Method: {} | Class: {}",
					subParameterDetailsModel.getSubParameterName(), subParameterDetailsModel.getSubParameterCode(),
					subParameterDetailsModel.getParameterCode(), methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to update SubParameter Details | SubParameter Name: "
					+ subParameterDetailsModel.getSubParameterName() + ", SubParameter Code: "
					+ subParameterDetailsModel.getSubParameterCode() + ", Parameter Code: "
					+ subParameterDetailsModel.getParameterCode() + ", Error: " + e.getMessage());
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseModel deleteSubParameterDetails(String subParameterCode) {
		String methodName = "deleteSubParameterDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to delete SubParameter Details | SubParameter Code: {} | Method: {} | Class: {}",
					subParameterCode, methodName, this.getClass().getSimpleName());

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

			// Fetch active subParameter
			SubParameterDetails subParameterDetails = subParameterDetailsRepo
					.findBySubParameterCodeAndActiveTrue(subParameterCode);

			if (subParameterDetails == null) {
				log.info("No active SubParameter found for SubParameter Code: {} | Method: {} | Class: {}",
						subParameterCode, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found for SubParameter Code: " + subParameterCode);
				return response;
			}

			// Mark as inactive
			subParameterDetails.setActive(false);
			subParameterDetails.setUpdatedBy(loginId);
			subParameterDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));
			// Determine status based on roles
			if (userRoles.contains(ModelConstant.ADMIN)) {
				subParameterDetails.setStatus(ModelConstant.COMPLETE);
				subParameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				subParameterDetails.setStatus(ModelConstant.COMPLETE);
				subParameterDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				subParameterDetails.setStatus(ModelConstant.PEN_S_M);
				subParameterDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				subParameterDetails.setStatus(ModelConstant.PEN_M);
				subParameterDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				subParameterDetails.setStatus(ModelConstant.PEN_J_M);
				subParameterDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}
			SubParameterDetails savedSubParameter = subParameterDetailsRepo.save(subParameterDetails);

			// Log action
			logAction(loginId, ModelConstant.SUBPARAMETER, ModelConstant.DELETE,
					"SubParameter Code:" + savedSubParameter.getSubParameterCode(),
					"SubParameter  deleted (set active=false) with name: " + savedSubParameter.getSubParameterName(),
					savedSubParameter.getStatus(), savedSubParameter.getStatusCode(),
					savedSubParameter.getSubParameterGenId());

			response.setData(savedSubParameter);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("SubParameter Deleted Successfully | SubParameter Code: " + subParameterCode);

			log.info(
					"SubParameter deleted successfully | SubParameter Code: {} | Updated By: {} | Method: {} | Class: {}",
					subParameterCode, loginId, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while deleting SubParameter Details | SubParameter Code: {} | Method: {} | Class: {}",
					subParameterCode, methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to delete SubParameter Details | SubParameter Code: " + subParameterCode
					+ ", Error: " + e.getMessage());
		}

		return response;
	}

	@Override
	public ResponseModel getParameterDetailsAll() {
		final String methodName = "getParameterDetailsAll";
		ResponseModel response = new ResponseModel();

		log.info("START | [{}] | Fetching Parameter Details All: {}", methodName);

		try {
			// Log repository invocation
			log.debug("PROCESSING | [{}] | Invoking repository: parameterDetailsRepo.findAllByActiveTrueAndStatus()",
					methodName);

			String status = ModelConstant.COMPLETE;
			List<ParameterDetails> parameterList = parameterDetailsRepo.findAllByActiveTrueAndStatus(status);

			// Check for no data
			if (parameterList == null || parameterList.isEmpty()) {
				log.warn("NO DATA | [{}] | No Parameter Details found for All: {}", methodName);
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			// Success scenario
			response.setData(parameterList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data fetched successfully");

			log.info("SUCCESS | [{}] | Parameter Details fetched successfully for  | Records: {}", methodName,
					parameterList.size());

		} catch (Exception e) {
			log.error("EXCEPTION | [{}] | Error while fetching Parameter Details for: {} | Exception: {}", methodName,
					e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching Parameter Details: " + e.getLocalizedMessage());
		}

		log.info("END | [{}]  | Response Status: {} | Message: {}", methodName, response.getHttpStatus(),
				response.getMessage());

		return response;
	}

	@Override
	public ResponseModel getSubParameterDetailsAllByParameterCode(String parameterCode) {
		final String methodName = "getSubParameterDetailsAllByMasterCode";
		ResponseModel response = new ResponseModel();

		log.info("START | [{}] | Fetching SubParameter Details by parameterCode: {}", methodName, parameterCode);

		try {
			// Log repository invocation
			log.debug(
					"PROCESSING | [{}] | Invoking repository: subParameterDetailsRepo.findAllByActiveTrueAndStatusAndParameterCode()",
					methodName);

			String status = ModelConstant.COMPLETE;
			List<SubParameterDetails> parameterList = subParameterDetailsRepo
					.findAllByActiveTrueAndStatusAndParameterCode(status, parameterCode);

			// Check for no data
			if (parameterList == null || parameterList.isEmpty()) {
				log.warn("NO DATA | [{}] | No SubParameter Details found for parameterCode: {}", methodName,
						parameterCode);
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			// Success scenario
			response.setData(parameterList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data fetched successfully");

			log.info("SUCCESS | [{}] | SubParameter Details fetched successfully by parameterCode: {} | Records: {}",
					methodName, parameterCode, parameterList.size());

		} catch (Exception e) {
			log.error(
					"EXCEPTION | [{}] | Error while fetching SubParameter Details by parameterCode: {} | Exception: {}",
					methodName, parameterCode, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching SubParameter Details: " + e.getLocalizedMessage());
		}

		log.info("END | [{}] | masterCode: {} | Response Status: {} | Message: {}", methodName, parameterCode,
				response.getHttpStatus(), response.getMessage());

		return response;
	}

	@Override
	public ResponseModel addLandsCategory(String landCategoryName) {
		String methodName = "addLandsCategory";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] | Request to add Land Category | Name: {}", methodName, landCategoryName);

		LandsCategoryDetails savedLandsCategoryDetails = null;

		try {
			// Fetch max Land Category Code
			Integer maxLandCategoryCode = landsCategoryDetailsRepo.findMaxLandCategoryCode();
			Integer newLandCategoryCode = (maxLandCategoryCode == null) ? 10001 : maxLandCategoryCode + 1;

			log.info("Generated new LandCategoryCode: {}", newLandCategoryCode);

			// Check authentication
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || !authentication.isAuthenticated()
					|| "anonymousUser".equals(authentication.getName())) {

				log.warn("Authentication failed or token expired for method: {}", methodName);

				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Token is expired or invalid");
				return response;
			}

			String loginId = authentication.getName();

			// Extract roles
			Set<String> userRoles = authentication.getAuthorities().stream()
					.map(auth -> auth.getAuthority().replace("ROLE_", "").toLowerCase()).collect(Collectors.toSet());

			log.info("User '{}' authenticated with roles: {}", loginId, userRoles);

			// Prepare entity
			LandsCategoryDetails landsCategoryDetails = new LandsCategoryDetails();
			landsCategoryDetails.setLandCategoryCode(newLandCategoryCode.toString());
			landsCategoryDetails.setLandCategoryName(landCategoryName);
			landsCategoryDetails.setCreatedBy(loginId);
			landsCategoryDetails.setActive(true);

			// Role-based status assignment
			if (userRoles.contains(ModelConstant.ADMIN)) {
				landsCategoryDetails.setStatus(ModelConstant.COMPLETE);
				landsCategoryDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.SMAN)) {
				landsCategoryDetails.setStatus(ModelConstant.COMPLETE);
				landsCategoryDetails.setStatusCode(ModelConstant.COMPLETE_CODE);
			} else if (userRoles.contains(ModelConstant.MAN)) {
				landsCategoryDetails.setStatus(ModelConstant.PEN_S_M);
				landsCategoryDetails.setStatusCode(ModelConstant.PEN_S_M_CODE);
			} else if (userRoles.contains(ModelConstant.JMAN)) {
				landsCategoryDetails.setStatus(ModelConstant.PEN_M);
				landsCategoryDetails.setStatusCode(ModelConstant.PEN_M_CODE);
			} else {
				landsCategoryDetails.setStatus(ModelConstant.PEN_J_M);
				landsCategoryDetails.setStatusCode(ModelConstant.PEN_J_M_CODE);
			}

			log.info("Saving LandCategory with Code: {} and Name: {}", landsCategoryDetails.getLandCategoryCode(),
					landsCategoryDetails.getLandCategoryName());

			// Save entity
			savedLandsCategoryDetails = landsCategoryDetailsRepo.saveAndFlush(landsCategoryDetails);

			log.info("LandCategory saved successfully with GenId: {}",
					savedLandsCategoryDetails.getLandCategoryGenId());

			// Log action
			logAction(loginId, ModelConstant.LANDCATEGORY, ModelConstant.ADD,
					"LandCategory Code: " + savedLandsCategoryDetails.getLandCategoryCode(),
					"LandCategory added, Name: " + savedLandsCategoryDetails.getLandCategoryName(),
					savedLandsCategoryDetails.getStatus(), savedLandsCategoryDetails.getStatusCode(),
					savedLandsCategoryDetails.getLandCategoryGenId());

			// Prepare response
			response.setData(savedLandsCategoryDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage(
					"LandCategory added successfully | Name: " + savedLandsCategoryDetails.getLandCategoryName()
							+ ", Code: " + savedLandsCategoryDetails.getLandCategoryCode());

			log.info("END - [{}] | LandCategory added successfully", methodName);

		} catch (Exception e) {

			log.error("ERROR - [{}] | Failed to add LandCategory | Name: {} | Reason: {}", methodName, landCategoryName,
					e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);

			String name = (savedLandsCategoryDetails != null) ? savedLandsCategoryDetails.getLandCategoryName()
					: landCategoryName;

			response.setMessage("Failed to add LandCategory | Name: " + name + ", Error: " + e.getMessage());
		}

		return response;
	}

//	@Override
//	public void autoCreateLotsForAllMouzas() {
//
//		List<MouzaDetails> allMouzas = mouzaDetailsRepo.findAll();
//
//		for (MouzaDetails mouza : allMouzas) {
//
//			LotDetails req = new LotDetails();
//			req.setLotName("testLot" + mouza.getMouzaName());
//			req.setDistrictCode(mouza.getDistrictCode());
//			req.setCircleCode(mouza.getCircleCode());
//			req.setMouzaCode(mouza.getMouzaCode());
//			req.setAreaTypeId(mouza.getAreaTypeId());
//			req.setStatus("Complete");
//			req.setBasePriceIncreaseLot(null);
//			req.setStatusCode("23-4");
//			req.setActive(true);
//			req.setCreatedBy("SYSTEM");
//			req.setCreatedDtm(new Timestamp(System.currentTimeMillis()));
//
//			// IMPORTANT: SAVE USING JPA
//			lotDetailsRepo.save(req);
//
//			log.info("Lot created for Mouza: {} ({})", mouza.getMouzaName(), mouza.getMouzaCode());
//		}
//	}
	@Override
	public void autoCreateLotsForAllMouzas() {

		List<MouzaDetails> allMouzas = mouzaDetailsRepo.findAll();

		Integer lotCode = Optional.ofNullable(lotDetailsRepo.findMaxLotCode()).orElse(10000);

		BigDecimal maxIncrease = Optional.ofNullable(lotDetailsRepo.findMaxIncreaseLot()).orElse(BigDecimal.ZERO);

		for (MouzaDetails mouza : allMouzas) {

			// Increase lot code by 1
			lotCode++;

			// Increase base price by 0.5
			maxIncrease = maxIncrease.add(new BigDecimal("0.1"));

			LotDetails req = new LotDetails();
			req.setLotName("testThreeLot" + mouza.getMouzaName());
			req.setLotCode(lotCode.toString()); // ← USE HERE
			req.setDistrictCode(mouza.getDistrictCode());
			req.setCircleCode(mouza.getCircleCode());
			req.setMouzaCode(mouza.getMouzaCode());
			req.setAreaTypeId(mouza.getAreaTypeId());
			req.setStatus("Complete");
			req.setStatusCode("23-4");
			req.setActive(true);
			req.setCreatedBy("SYSTEM");
			req.setCreatedDtm(new Timestamp(System.currentTimeMillis()));

			req.setBasePriceIncreaseLot(maxIncrease);

			lotDetailsRepo.save(req);

			log.info("Lot created: Mouza={}, MouzaCode={}, LotCode={}, BasePriceIncrease={}", mouza.getMouzaName(),
					mouza.getMouzaCode(), lotCode, maxIncrease);
		}
	}

	@Override
	public void autoCreateVillageForAllLots() {

		List<LotDetails> allLots = lotDetailsRepo.findAll();

		Integer villageCode = Optional.ofNullable(villageDetailsRepo.findMaxVillageCode()).orElse(10000);

		BigDecimal maxIncrease = Optional.ofNullable(villageDetailsRepo.findMaxIncreaseLot()).orElse(BigDecimal.ZERO);

		for (LotDetails lot : allLots) {

			// Increase lot code by 1
			villageCode++;

			// Increase base price by 0.5
			maxIncrease = maxIncrease.add(new BigDecimal("0.3"));

			VillageDetails req = new VillageDetails();
			req.setVillageName("testThreeVillage" + lot.getLotName());
			req.setVillageCode(villageCode.toString()); // ← USE HERE
			req.setDistrictCode(lot.getDistrictCode());
			req.setCircleCode(lot.getCircleCode());
			req.setMouzaCode(lot.getMouzaCode());
			req.setLotCode(lot.getLotCode());
			req.setAreaType("Urban");
			req.setStatus("Complete");
			req.setStatusCode("23-4");
			req.setActive(true);
			req.setCreatedBy("SYSTEM");
			req.setCreatedDtm(new Timestamp(System.currentTimeMillis()));

			req.setBasePriceVillage(maxIncrease);

			villageDetailsRepo.save(req);

			log.info("Lot created: LotName={}, MouzaCode={}, VillageCode={}, BasePriceIncrease={}", lot.getLotName(),
					lot.getMouzaCode(), villageCode, maxIncrease);
		}
	}

	@Override
	public ResponseModel getAllLandsCategoryDetails() {
		String methodName = "getAllLandsCategoryDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding All LandsCategory Details " + "  Method Name" + methodName + " Class : "
					+ this.getClass());
			String Status = ModelConstant.COMPLETE;
			// Log repository invocation
			log.debug("PROCESSING | [{}] | Invoking repository: landsCategoryDetailsRepo.findAllByActiveTrueAndStatus",
					methodName);
			List<LandsCategoryDetails> landsCategoryList = landsCategoryDetailsRepo
					.findAllByActiveTrueAndStatus(Status);

			if (landsCategoryList == null || landsCategoryList.isEmpty()) {
				log.info("Respond: No Data Found - All LandsCategory Details " + "  Method Name" + methodName
						+ " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(landsCategoryList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully All LandsCategory Details " + "  Method Name" + methodName
					+ " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding  All LandsCategory Details " + "  Method Name" + methodName
					+ " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"An error occurred while Finding  All LandsCategory Details ,error : " + e.getLocalizedMessage());
		}
		return response;
	}

}
