package com.areap2.serviceImpl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.areap2.entity.AreaTypes;
import com.areap2.entity.AuditLog;
import com.areap2.entity.CircleDetails;
import com.areap2.entity.DistrictDetails;
import com.areap2.entity.LandCategories;
import com.areap2.entity.LandSubClassDetails;
import com.areap2.entity.LotDetails;
import com.areap2.entity.MouzaDetails;
import com.areap2.entity.ParameterDetails;
import com.areap2.entity.VillageDetails;
import com.areap2.entity.ZonalValues;
import com.areap2.model.AreaTypesModelRequest;
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
import com.areap2.model.ResponseModel;
import com.areap2.model.SroDetailsModelRequest;
import com.areap2.model.SroDetailsModelUpdateRequest;
import com.areap2.model.VillageDetailsModelRequest;
import com.areap2.model.VillageDetailsModelUpdateRequest;
import com.areap2.service.MasterDataService;

@Service
public class MasterDataServiceImpl extends AbstractMasterRepository implements MasterDataService {

	Logger log = LoggerFactory.getLogger(MasterDataServiceImpl.class);

	@Override
	public ResponseModel getAllDistrictDetails() {
		String methodName = "getInsurerAllDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding All District Details " + "  Method Name" + methodName + " Class : "
					+ this.getClass());

			List<DistrictDetails> districtList = districtDetailsRepo.findAllByActiveTrue();

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
			List<CircleDetails> circleList = circleDetailsRepo.findCircleByDistrictCodeAndActiveTrue(districtCode);
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
			List<VillageDetails> villageList = villageDetailsRepo
					.findVillageByDistrictCodeAndCircleCodeAndActiveTrue(districtCode, circleCode);

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

				List<MouzaDetails> mouzaList = mouzaDetailsRepo
						.findMouzaByDistrictCodeAndCircleCodeAndActiveTrue(districtCode, circleCode);

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
			List<LandCategories> landCategoriesList = landCategoriesRepo.findAllByActiveTrue();

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
			List<AreaTypes> areaTypeList = areaTypesRepo.findAllByActiveTrue();
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

			List<ZonalValues> zoneValueList = zonalValuesRepo
					.findMouzaByDistrictCodeAndCircleCodeAndMouzaCodeAndActiveTrue(districtCode, circleCode, mouzaCode);

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

			List<ParameterDetails> parameterList = parameterDetailsRepo
					.findByMinRangeInMetersGreaterThanEqualAndMaxRangeInMetersLessThanEqualAndActiveTrue(minRange,
							maxRange);

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
			log.info(
					"Request received to add District Details | District Name: {} | District Code: (to be generated) | Method: {} | Class: {}",
					districtDetailsModel.getDistrictName(), methodName, this.getClass().getSimpleName());

			// Generate new district code
			Integer maxDistrictCode = districtDetailsRepo.findMaxDistrictCode();
			Integer newDistrictCode = (maxDistrictCode == null) ? 10001 : maxDistrictCode + 1;

			// Get logged-in user
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = (authentication != null) ? authentication.getName() : "SYSTEM";
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			// Prepare entity
			DistrictDetails districtDetails = new DistrictDetails();
			districtDetails.setDistrictCode(newDistrictCode.toString());
			districtDetails.setDistrictName(districtDetailsModel.getDistrictName());
			districtDetails.setCreatedBy(loginId);
			districtDetails.setActive(true);

			log.info(
					"Saving District Details | District Name: {} | District Code: {} | Created By: {} | Method: {} | Class: {}",
					districtDetails.getDistrictName(), districtDetails.getDistrictCode(), loginId, methodName,
					this.getClass().getSimpleName());

			// Save entity
			DistrictDetails savedDistrictDetails = districtDetailsRepo.saveAndFlush(districtDetails);

			// Log action
			logAction(loginId, "District", "ADD", "District Code: " + savedDistrictDetails.getDistrictCode(),
					"District added successfully with name: " + savedDistrictDetails.getDistrictName());

			// Build response
			response.setData(savedDistrictDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("District added successfully | District Name: " + savedDistrictDetails.getDistrictName()
					+ ", District Code: " + savedDistrictDetails.getDistrictCode());

			log.info(
					"District added successfully | District Name: {} | District Code: {} | Created By: {} | Method: {} | Class: {}",
					savedDistrictDetails.getDistrictName(), savedDistrictDetails.getDistrictCode(), loginId, methodName,
					this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while adding District Details | District Name: {} | District Code: {} | Method: {} | Class: {}",
					districtDetailsModel.getDistrictName(),
					(districtDetailsModel.getDistrictCode() != null ? districtDetailsModel.getDistrictCode() : "N/A"),
					methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add District Details | District Name: "
					+ districtDetailsModel.getDistrictName() + ", District Code: "
					+ (districtDetailsModel.getDistrictCode() != null ? districtDetailsModel.getDistrictCode() : "N/A")
					+ ", Error: " + e.getMessage());
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
			String loginId = (authentication != null) ? authentication.getName() : "SYSTEM";

			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

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
			DistrictDetails updatedDistrict = new DistrictDetails();
			updatedDistrict.setDistrictCode(districtDetailsModel.getDistrictCode());
			updatedDistrict.setDistrictName(districtDetailsModel.getDistrictName());
			updatedDistrict.setActive(true);
			updatedDistrict.setCreatedBy(existingDistrict.getCreatedBy());
			updatedDistrict.setCreatedDtm(existingDistrict.getCreatedDtm());
			updatedDistrict.setUpdatedBy(loginId);
			updatedDistrict.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			DistrictDetails savedDistrict = districtDetailsRepo.save(updatedDistrict);

			logAction(loginId, "District", "UPDATE", "District Code: " + savedDistrict.getDistrictCode(),
					"District updated successfully with name: " + savedDistrict.getDistrictName());

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
			String loginId = (authentication != null) ? authentication.getName() : "SYSTEM";
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

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
			DistrictDetails savedDistrict = districtDetailsRepo.save(districtDetails);

			logAction(loginId, "District", "DELETE", "District Code: " + savedDistrict.getDistrictCode(),
					"District deleted (set active=false) , name: " + savedDistrict.getDistrictName());

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
			String loginId = (authentication != null) ? authentication.getName() : "SYSTEM";
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			// Prepare entity
			CircleDetails circleDetails = new CircleDetails();
			circleDetails.setCircleCode(newCircleCode.toString());
			circleDetails.setCircleName(circleDetailsModel.getCircleName());
			circleDetails.setDistrictCode(circleDetailsModel.getDistrictCode());
			circleDetails.setCreatedBy(loginId);
			circleDetails.setActive(true);

			// Save entity
			CircleDetails savedCircle = circleDetailsRepo.saveAndFlush(circleDetails);

			// Log action
			logAction(loginId, "Circle", "ADD",
					"District Code: " + savedCircle.getDistrictCode() + ", Circle Code:" + savedCircle.getCircleCode(),
					"Circle  added successfully with name: " + savedCircle.getCircleName());

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
			String loginId = (authentication != null) ? authentication.getName() : "SYSTEM";

			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

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
			CircleDetails updatedCircle = new CircleDetails();
			updatedCircle.setCircleCode(circleDetailsModel.getCircleCode());
			updatedCircle.setCircleName(circleDetailsModel.getCircleName());
			updatedCircle.setDistrictCode(circleDetailsModel.getDistrictCode());
			updatedCircle.setActive(true);
			updatedCircle.setCreatedBy(existingCircle.getCreatedBy());
			updatedCircle.setCreatedDtm(existingCircle.getCreatedDtm());
			updatedCircle.setUpdatedBy(loginId);
			updatedCircle.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			CircleDetails savedCircle = circleDetailsRepo.save(updatedCircle);

			// Log action
			logAction(loginId, "Circle", "UPDATE",
					"District Code: " + savedCircle.getDistrictCode() + ", Circle Code:" + savedCircle.getCircleCode(),
					"Circle updated successfully with name: " + savedCircle.getCircleName());

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
			String loginId = (authentication != null) ? authentication.getName() : "SYSTEM";

			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

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
			CircleDetails savedCircle = circleDetailsRepo.save(circleDetails);

			// Log action
			logAction(loginId, "Circle", "DELETE", "Circle Code:" + savedCircle.getCircleCode(),
					"Circle  deleted (set active=false) with name: " + savedCircle.getCircleName());

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
					"Request: Add Village Details | DistrictCode: {} | CircleCode: {} | VillageName: {} | Method: {} | Class: {}",
					villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
					villageDetailsModel.getVillageName(), methodName, this.getClass().getSimpleName());

			Integer villageCode = villageDetailsRepo.findMaxVillageCode();

			if (villageCode == null) {
				villageCode = 10001;
			} else {
				villageCode = villageCode + 1;
			}

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			VillageDetails villageDetails = new VillageDetails();
			villageDetails.setVillageCode(villageCode.toString());
			villageDetails.setVillageName(villageDetailsModel.getVillageName());
			villageDetails.setDistrictCode(villageDetailsModel.getDistrictCode());
			villageDetails.setCircleCode(villageDetailsModel.getCircleCode());
			villageDetails.setCreatedBy(loginId);
			villageDetails.setActive(true);

			VillageDetails savedVillageDetails = villageDetailsRepo.saveAndFlush(villageDetails);
			// Log action
			logAction(loginId, "Village", "ADD",
					"District Code: " + savedVillageDetails.getDistrictCode() + ", Circle Code: "
							+ savedVillageDetails.getCircleCode() + ", Village Code: "
							+ savedVillageDetails.getVillageCode(),
					"Village added successfully with name: " + savedVillageDetails.getVillageName());

			response.setData(savedVillageDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Village Added Successfully");

			log.info(
					"Respond: Village Added Successfully | DistrictCode: {} | CircleCode: {} | VillageName: {} | Method: {} | Class: {}",
					villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
					villageDetailsModel.getVillageName(), methodName, this.getClass().getSimpleName());

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
		String methodName = "updateVillageDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Update Village Details , Village Code {} , Village Name {} , Method Name {} , Class : {}",
					villageDetailsModel.getVillageCode(), villageDetailsModel.getVillageName(), methodName,
					this.getClass().getSimpleName());

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			// Fetch active village record
			VillageDetails oldVillage = villageDetailsRepo
					.findByVillageCodeAndActiveTrue(villageDetailsModel.getVillageCode());

			if (oldVillage == null) {
				log.info("Respond: No Data Found for VillageCode {} , Method Name {} , Class : {}",
						villageDetailsModel.getVillageCode(), methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			// Mark old record inactive
			oldVillage.setActive(false);
			oldVillage.setUpdatedBy(loginId);
			oldVillage.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			// Create new active record
			VillageDetails newVillage = new VillageDetails();
			newVillage.setVillageCode(villageDetailsModel.getVillageCode());
			newVillage.setVillageName(villageDetailsModel.getVillageName());
			newVillage.setDistrictCode(villageDetailsModel.getDistrictCode());
			newVillage.setCircleCode(villageDetailsModel.getCircleCode());
			newVillage.setActive(true);
			newVillage.setCreatedBy(oldVillage.getCreatedBy());
			newVillage.setCreatedDtm(oldVillage.getCreatedDtm());
			newVillage.setUpdatedBy(loginId);
			newVillage.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			// Save both (old + new) in one go
			villageDetailsRepo.saveAll(Arrays.asList(oldVillage, newVillage));
			// Log action
			logAction(loginId, "Village", "UPDATE",
					"District Code: " + newVillage.getDistrictCode() + ", Circle Code: " + newVillage.getCircleCode()
							+ ", Village Code: " + newVillage.getVillageCode(),
					"Village updated successfully with name: " + newVillage.getVillageName());

			response.setData(newVillage);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Village Updated Successfully");

			log.info(
					"Respond: Village Updated Successfully , Village Code {} , Village Name {} , Method Name {} , Class : {}",
					villageDetailsModel.getVillageCode(), villageDetailsModel.getVillageName(), methodName,
					this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error while updating Village Details , Village Code {} , Village Name {} , Method Name {} , Class : {} , Error : {}",
					villageDetailsModel.getVillageCode(), villageDetailsModel.getVillageName(), methodName,
					this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while updating Village Details , Village Name "
					+ villageDetailsModel.getVillageName() + ", error : " + e.getLocalizedMessage());
		}
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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

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

			VillageDetails savedVillageDetails = villageDetailsRepo.save(villageDetails);
			logAction(loginId, "District", "DELETE", savedVillageDetails.getVillageCode(),
					"District deleted (set active=false successfully with name: "
							+ savedVillageDetails.getVillageName());
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
					"Request: Add Mouza Details | MouzaName: {} | AreaTypeId: {} | DistrictCode: {} | CircleCode: {} | Method: {} | Class: {}",
					mouzaDetailsModel.getMouzaName(), mouzaDetailsModel.getAreaTypeId(),
					mouzaDetailsModel.getDistrictCode(), mouzaDetailsModel.getCircleCode(), methodName,
					this.getClass().getSimpleName());

			Integer mouzaCode = mouzaDetailsRepo.findMaxMouzaCode();
			if (mouzaCode == null) {
				mouzaCode = 10001;
			} else {
				mouzaCode = mouzaCode + 1;
			}

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			MouzaDetails mouzaDetails = new MouzaDetails();
			mouzaDetails.setMouzaCode(mouzaCode.toString());
			mouzaDetails.setMouzaName(mouzaDetailsModel.getMouzaName());
			mouzaDetails.setDistrictCode(mouzaDetailsModel.getDistrictCode());
			mouzaDetails.setCircleCode(mouzaDetailsModel.getCircleCode());
			mouzaDetails.setAreaTypeId(mouzaDetailsModel.getAreaTypeId());
			mouzaDetails.setCreatedBy(loginId);
			mouzaDetails.setActive(true);

			MouzaDetails savedMouzaDetails = mouzaDetailsRepo.saveAndFlush(mouzaDetails);
			// Log action
			logAction(loginId, "Mauza", "ADD",
					"District Code: " + savedMouzaDetails.getDistrictCode() + ", Circle Code: "
							+ savedMouzaDetails.getCircleCode() + ", Area Type Id Code: "
							+ savedMouzaDetails.getAreaTypeId() + ", Mauza Code: " + savedMouzaDetails.getMouzaCode(),
					"Mauza added successfully with name: " + savedMouzaDetails.getMouzaName());

			response.setData(savedMouzaDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Mouza Added Successfully");

			log.info(
					"Respond: Mouza Added Successfully | MouzaCode: {} | MouzaName: {} | DistrictCode: {} | CircleCode: {} | Method: {} | Class: {}",
					savedMouzaDetails.getMouzaCode(), savedMouzaDetails.getMouzaName(),
					savedMouzaDetails.getDistrictCode(), savedMouzaDetails.getCircleCode(), methodName,
					this.getClass().getSimpleName());
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
					"Request: Update Mouza Details [MouzaCode: {}, MouzaName: {}, DistrictCode: {}, CircleCode: {}, AreaTypeId: {}], Method: {}, Class: {}",
					mouzaDetailsModel.getMouzaCode(), mouzaDetailsModel.getMouzaName(),
					mouzaDetailsModel.getDistrictCode(), mouzaDetailsModel.getCircleCode(),
					mouzaDetailsModel.getAreaTypeId(), methodName, this.getClass().getSimpleName());

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication != null ? authentication.getName() : "SYSTEM";
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

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
			MouzaDetails updatedMouza = new MouzaDetails();
			updatedMouza.setMouzaCode(mouzaDetailsModel.getMouzaCode());
			updatedMouza.setMouzaName(mouzaDetailsModel.getMouzaName());
			updatedMouza.setDistrictCode(mouzaDetailsModel.getDistrictCode());
			updatedMouza.setCircleCode(mouzaDetailsModel.getCircleCode());
			updatedMouza.setAreaTypeId(mouzaDetailsModel.getAreaTypeId());
			updatedMouza.setActive(true);
			updatedMouza.setCreatedBy(existingMouza.getCreatedBy());
			updatedMouza.setCreatedDtm(existingMouza.getCreatedDtm());
			updatedMouza.setUpdatedBy(loginId);
			updatedMouza.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			MouzaDetails savedMouzaDetails = mouzaDetailsRepo.save(updatedMouza);
			// Log action
			logAction(loginId, "Mauza", "UPDATE",
					"District Code: " + savedMouzaDetails.getDistrictCode() + ", Circle Code: "
							+ savedMouzaDetails.getCircleCode() + ", Area Type Id Code: "
							+ savedMouzaDetails.getAreaTypeId() + ", Mauza Code: " + savedMouzaDetails.getMouzaCode(),
					"Mauza updated successfully with name: " + savedMouzaDetails.getMouzaName());

			response.setData(savedMouzaDetails);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Mouza updated successfully");

			log.info(
					"Respond: Mouza updated successfully [MouzaCode: {}, MouzaName: {}, DistrictCode: {}, CircleCode: {}, AreaTypeId: {}], Method: {}, Class: {}",
					savedMouzaDetails.getMouzaCode(), savedMouzaDetails.getMouzaName(),
					savedMouzaDetails.getDistrictCode(), savedMouzaDetails.getCircleCode(),
					savedMouzaDetails.getAreaTypeId(), methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while updating Mouza Details [MouzaCode: {}, MouzaName: {}, DistrictCode: {}, CircleCode: {}, AreaTypeId: {}], Method: {}, Class: {}",
					mouzaDetailsModel.getMouzaCode(), mouzaDetailsModel.getMouzaName(),
					mouzaDetailsModel.getDistrictCode(), mouzaDetailsModel.getCircleCode(),
					mouzaDetailsModel.getAreaTypeId(), methodName, this.getClass().getSimpleName(), e);

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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

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

			MouzaDetails savedMouzaDetails = mouzaDetailsRepo.save(mouzaDetails);
			// Log action

			logAction(loginId, "Mauza", "DELETE", savedMouzaDetails.getMouzaCode(),
					"District deleted (set active=false successfully with name: " + savedMouzaDetails.getMouzaName());

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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			LandCategories landCategories = new LandCategories();
			landCategories.setLandCategoryName(landCategoriesModel.getLandCategoryName());
			landCategories.setCreatedBy(loginId);
			landCategories.setActive(true);

			LandCategories savedLandCategory = landCategoriesRepo.saveAndFlush(landCategories);
			// Log action
			logAction(loginId, "LandUse", "ADD", "Land Code: Not defined"// + savedLandCategory.getDistrictCode(),
					, "LandUse added successfully with name: " + savedLandCategory.getLandCategoryName());

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
	public ResponseModel deleteLandCategory(Long landCategoryGenId) {
		String methodName = "deleteLandCategory";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete LandCategory Details , landCategoryGenId " + landCategoryGenId + "  Method Name"
					+ methodName + " Class : " + this.getClass());

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			LandCategories landCategories = landCategoriesRepo.findByLandCategoryGenIdAndActiveTrue(landCategoryGenId);

			if (landCategories == null) {
				log.info("Respond: No Data Found - LandCategory Details by landCategoryGenId" + landCategoryGenId
						+ "  Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			landCategories.setActive(false);
			landCategories.setUpdatedBy(loginId);
			landCategories.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			LandCategories landCategoriesSaved = landCategoriesRepo.save(landCategories);
			// Log action
			logAction(loginId, "LandUse", "DELETE", "Land Code: Not defined"// + savedLandCategory.getDistrictCode(),
					, "LandUse deleted (set active=false) successfully with name: "
							+ landCategoriesSaved.getLandCategoryName());

			response.setData(landCategoriesSaved);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("LandCategory Delete Successfully");

			log.info("Respond : LandCategory Deleted successfully LandCategory Details, areaTypesGenId"
					+ landCategoriesSaved.getLandCategoryGenId() + "  Method Name" + methodName + " Class : "
					+ this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Deleting LandCategory Details, areaTypesGenId " + landCategoryGenId
					+ "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting LandCategory Details , areaTypesGenId "
					+ landCategoryGenId + ",error : " + e.getLocalizedMessage());
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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			AreaTypes areaTypes = new AreaTypes();
			areaTypes.setAreaType(areaTypesModel.getAreaType());
			areaTypes.setCreatedBy(loginId);
			areaTypes.setActive(true);

			AreaTypes savedAreaType = areaTypesRepo.saveAndFlush(areaTypes);
			// Log action
			logAction(loginId, "AreaType", "ADD", "Area Type: Not defined",
					"AreaType added successfully with name: " + savedAreaType.getAreaType());

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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication != null ? authentication.getName() : "SYSTEM";
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

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

			AreaTypes updatedAreaType = areaTypesRepo.save(areaTypes);
			// Log action

			logAction(loginId, "Area Type", "DELETE", updatedAreaType.getAreaType(),
					"Area Type deleted (set active=false successfully with name: " + updatedAreaType.getAreaType());
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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication != null ? authentication.getName() : "SYSTEM";
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			LotDetails lotDetails = new LotDetails();
			lotDetails.setLotCode(lotCode.toString());
			lotDetails.setLotName(lotDetailsModel.getLotName());
			lotDetails.setDistrictCode(lotDetailsModel.getDistrictCode());
			lotDetails.setCircleCode(lotDetailsModel.getCircleCode());
			lotDetails.setAreaTypeId(lotDetailsModel.getAreaTypeId());
			lotDetails.setCreatedBy(loginId);
			lotDetails.setActive(true);

			LotDetails savedLotDetails = lotDetailsRepo.saveAndFlush(lotDetails);
			// Log action
			logAction(loginId, "Lot", "ADD",
					"District Code: " + savedLotDetails.getDistrictCode() + ", Circle Code: "
							+ savedLotDetails.getCircleCode() + ", AreaTypeId Code: " + savedLotDetails.getAreaTypeId()
							+ ", Lot Code: " + savedLotDetails.getLotCode(),
					"Lot added successfully with name: " + savedLotDetails.getLotName());
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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

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
			LotDetails updatedLot = new LotDetails();
			updatedLot.setLotCode(lotDetailsModel.getLotCode());
			updatedLot.setLotName(lotDetailsModel.getLotName());
			updatedLot.setDistrictCode(lotDetailsModel.getDistrictCode());
			updatedLot.setCircleCode(lotDetailsModel.getCircleCode());
			updatedLot.setAreaTypeId(lotDetailsModel.getAreaTypeId());
			updatedLot.setActive(true);
			updatedLot.setCreatedBy(existingLot.getCreatedBy()); // keep original
			updatedLot.setCreatedDtm(existingLot.getCreatedDtm()); // keep original
			updatedLot.setUpdatedBy(loginId);
			updatedLot.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			LotDetails savedLotDetails = lotDetailsRepo.save(updatedLot);
			// Log action
			logAction(loginId, "Lot", "UPDATE",
					"District Code: " + savedLotDetails.getDistrictCode() + ", Circle Code: "
							+ savedLotDetails.getCircleCode() + ", AreaTypeId Code: " + savedLotDetails.getAreaTypeId()
							+ ", Lot Code: " + savedLotDetails.getLotCode(),
					"Lot updated successfully with name: " + savedLotDetails.getLotName());

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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();

			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			LotDetails LotDetails = lotDetailsRepo.findByLotCodeAndActiveTrue(lotCode);

			if (LotDetails == null) {
				log.info("Respond: No Data Found - Lot Details by LotCode" + lotCode + "  Method Name" + methodName
						+ " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			LotDetails.setActive(false);
			LotDetails.setUpdatedBy(loginId);
			LotDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			LotDetails savedLotDetails = lotDetailsRepo.save(LotDetails);
			// Log action

			logAction(loginId, "Lot", "DELETE", savedLotDetails.getLotCode(),
					"Lot deleted (set active=false successfully with name: " + savedLotDetails.getLotName());
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
			List<LotDetails> lotList = lotDetailsRepo.findLotByDistrictCodeAndCircleCodeAndActiveTrue(districtCode,
					circleCode);

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
			List<LandSubClassDetails> landSubClassList = landSubClassDetailsRepo
					.findLandSubClassByLandClassNameAndActiveTrue(landClassName);

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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication != null ? authentication.getName() : "SYSTEM";
			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			LandSubClassDetails landSubClassDetails = new LandSubClassDetails();
			landSubClassDetails.setLandSubClassCode(landSubClassCode.toString());
			landSubClassDetails.setLandSubClassName(landSubClassDetailsModel.getLandSubClassName());
			landSubClassDetails.setLandClassName(landSubClassDetailsModel.getLandClassName());
			landSubClassDetails.setCreatedBy(loginId);
			landSubClassDetails.setActive(true);

			LandSubClassDetails savedLandSubClassDetails = landSubClassDetailsRepo.saveAndFlush(landSubClassDetails);
			// Log action
			logAction(loginId, "Land Sub Class", "ADD",
					"Land Class Name: " + savedLandSubClassDetails.getLandClassName() + ", Land Sub Class Code: "
							+ savedLandSubClassDetails.getLandSubClassCode(),
					"Land Sub Class added successfully with name: " + savedLandSubClassDetails.getLandSubClassName());

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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication != null ? authentication.getName() : "anonymousUser";

			// Check if user is authenticated
			if ("anonymousUser".equals(loginId)) {
				log.warn("Unauthorized request. Token expired or invalid. | loginId={} | Method={} | Class={}", loginId,
						methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired or invalid. Login Id: " + loginId);
				return response;
			}

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
			LandSubClassDetails updatedLandSubClassDetails = new LandSubClassDetails();
			updatedLandSubClassDetails.setLandSubClassCode(landSubClassDetailsModel.getLandSubClassCode());
			updatedLandSubClassDetails.setLandSubClassName(landSubClassDetailsModel.getLandSubClassName());
			updatedLandSubClassDetails.setLandClassName(landSubClassDetailsModel.getLandClassName());
			updatedLandSubClassDetails.setActive(true);
			updatedLandSubClassDetails.setCreatedBy(existingLandSubClassDetails.getCreatedBy());
			updatedLandSubClassDetails.setCreatedDtm(existingLandSubClassDetails.getCreatedDtm());
			updatedLandSubClassDetails.setUpdatedBy(loginId);
			updatedLandSubClassDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			LandSubClassDetails savedLandSubClassDetails = landSubClassDetailsRepo.save(updatedLandSubClassDetails);

			logAction(loginId, "Land Sub Class", "UPDATE",
					"Land Class Name: " + savedLandSubClassDetails.getLandClassName() + ", Land Sub Class Code: "
							+ savedLandSubClassDetails.getLandSubClassCode(),
					"Land Sub Class updated successfully with name: " + savedLandSubClassDetails.getLandSubClassName());

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

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String loginId = authentication.getName();

			// checked logged in correct user or not
			if (loginId == "anonymousUser") {
				log.info("Your Token is expired Please use the correct Token. Login Id : {} | Method: {} | Class: {}",
						loginId, methodName, this.getClass().getSimpleName());
				response.setHttpStatus(HttpStatus.UNAUTHORIZED);
				response.setMessage("Your Token is expired Please use the correct Token:" + loginId);
				return response;
			}

			LandSubClassDetails LandSubClassDetails = landSubClassDetailsRepo
					.findByLandSubClassNameAndActiveTrue(landSubClass);

			if (LandSubClassDetails == null) {
				log.info("Respond: No Data Found - LandSubClass Details by Land Sub Class" + landSubClass
						+ "  Method Name" + methodName + " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			LandSubClassDetails.setActive(false);
			LandSubClassDetails.setUpdatedBy(loginId);
			LandSubClassDetails.setUpdatedDtm(new Timestamp(System.currentTimeMillis()));

			LandSubClassDetails savedLandSubClassDetails = landSubClassDetailsRepo.save(LandSubClassDetails);

			// Log action

			logAction(loginId, "District", "DELETE", savedLandSubClassDetails.getLandSubClassCode(),
					"District deleted (set active=false successfully with name: "
							+ savedLandSubClassDetails.getLandSubClassName());

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

	public void logAction(String loginId, String featureName, String actionType, String referenceId, String message) {
		AuditLog log = new AuditLog();
		log.setLoginId(loginId);
		log.setFeatureName(featureName);
		log.setActionType(actionType);
		log.setActionDatetime(new Timestamp(System.currentTimeMillis()));
		log.setFeatureId(referenceId);
		log.setMessage(message);
		auditLogRepo.save(log);

	}

}
