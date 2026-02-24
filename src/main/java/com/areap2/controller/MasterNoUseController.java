package com.areap2.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.model.AreaTypesModelRequest;
import com.areap2.model.LandCategoriesModelRequest;
import com.areap2.model.ResponseModel;
import com.areap2.model.SroDetailsModelRequest;
import com.areap2.model.SroDetailsModelUpdateRequest;
import com.areap2.service.MasterDataService;

@RestController
@RequestMapping("/masterNoUse")
@CrossOrigin
public class MasterNoUseController {

	Logger log = LoggerFactory.getLogger(MasterNoUseController.class);

	@Autowired
	private MasterDataService masterDataService;

	@GetMapping("/getLotByDistrictAndCircle")
	public ResponseModel getLotByDistrictAndCircle(@RequestParam String districtCode, @RequestParam String circleCode) {
		String methodName = "getLotByDistrictAndCircle";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}] with districtCode: {}, circleCode: {}", methodName,
				this.getClass().getSimpleName(), districtCode, circleCode);

		try {
			log.info("Fetching lot details for districtCode: {} and circleCode: {}", districtCode, circleCode);

			response = masterDataService.getLotByDistrictAndCircle(districtCode, circleCode);

			log.info("Successfully retrieved lot details for districtCode: {}, circleCode: {}. Response status: {}",
					districtCode, circleCode, response.getHttpStatus());

		} catch (Exception e) {
			log.error(
					"Exception in [{}] of class [{}] while fetching lot details for districtCode: {}, circleCode: {}. Error: {}",
					methodName, this.getClass().getSimpleName(), districtCode, circleCode, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch lot details for districtCode: " + districtCode + ", circleCode: "
					+ circleCode + ". Reason: " + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}] with districtCode: {}, circleCode: {}", methodName,
				this.getClass().getSimpleName(), districtCode, circleCode);

		return response;
	}

	@GetMapping("/getAllLandCategoriesByMouza") // Land Category endpoint
	public ResponseModel getAllLandCategoriesByMouza(@RequestParam(required = true) String mouzaCode) {
		String methodName = "getAllLandCategoriesByMouza";
		ResponseModel response = new ResponseModel();

		log.info("START | {} | Received request to fetch Land Categories for mouzaCode: {}", methodName, mouzaCode);

		try {
			log.debug("Invoking service: masterDataService.getAllLandCategoriesByMouza(mouzaCode={})", mouzaCode);
			response = masterDataService.getAllLandCategoriesByMouza(mouzaCode);

			if (response.getHttpStatus() == HttpStatus.OK) {
				log.info("SUCCESS | {} | Land Categories fetched successfully for mouzaCode: {}", methodName,
						mouzaCode);
			} else {
				log.warn("NO DATA | {} | Response message: {} | mouzaCode: {}", methodName, response.getMessage(),
						mouzaCode);
			}

		} catch (Exception e) {
			log.error("ERROR | {} | Exception while fetching Land Categories for mouzaCode: {} | Error: {}", methodName,
					mouzaCode, e.getMessage(), e);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching Land Categories: " + e.getLocalizedMessage());
		}

		log.info("END | {} | Response Status: {} | Message: {}", methodName, response.getHttpStatus(),
				response.getMessage());

		return response;
	}

//not in use any more start
	@GetMapping("/getAllLandCategories") // land class
	public ResponseModel getAllLandCategories() {
		String methodName = "getAllLandCategories";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}]", methodName, this.getClass().getSimpleName());

		try {
			log.info("Fetching all land categories from MasterDataService...");

			response = masterDataService.getAllLandCategories();

			log.info("Successfully retrieved all land categories. Response status: {}", response.getHttpStatus());

		} catch (Exception e) {
			log.error("Exception in [{}] of class [{}] while fetching all land categories. Error: {}", methodName,
					this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch land categories. Reason: " + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}]", methodName, this.getClass().getSimpleName());

		return response;
	}

//	@GetMapping("/getZonalValues")
//	public ResponseModel getZonalValues(@RequestParam String districtCode,@RequestParam String circleCode,@RequestParam String villageCode) {
//		String methodName = "getZonalValues";
//		ResponseModel response = new ResponseModel(); 
//		try {
//			log.info("Request: Finding ZonalValues by districtCode : " + districtCode + " ,circleCode :  " + circleCode
//					+ " and villageCode : " + villageCode + "  Method Name" + methodName + " Class : "
//					+ this.getClass());
//
//			response= masterDataService.getZonalValues(districtCode,circleCode,villageCode);
//
//		} catch (Exception e) {
//			log.error("An error occurred while Finding ZonalValue by districtCode :  "+ districtCode + " ,circleCode :  " + circleCode + " and villageCode : " + villageCode + "  Method Name" + methodName + " Class : "
//					+ this.getClass());
//			e.printStackTrace();
//			e.printStackTrace();
//			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
//			response.setMessage("An error occurred while Finding  ZonalValue  ,error : " + e.getLocalizedMessage());
//		}
//		
//		return response;
//	}

	@GetMapping("/getZonalValues") // zone name
	public ResponseModel getZonalValues(@RequestParam String districtCode, @RequestParam String circleCode,
			@RequestParam String mouzaCode) {
		String methodName = "getZonalValues";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}] with districtCode: {}, circleCode: {}, mouzaCode: {}", methodName,
				this.getClass().getSimpleName(), districtCode, circleCode, mouzaCode);

		try {
			log.info("Fetching zonal values for districtCode: {}, circleCode: {}, mouzaCode: {}", districtCode,
					circleCode, mouzaCode);

			response = masterDataService.getZonalValues(districtCode, circleCode, mouzaCode);

			log.info(
					"Successfully retrieved zonal values for districtCode: {}, circleCode: {}, mouzaCode: {}. Response status: {}",
					districtCode, circleCode, mouzaCode, response.getHttpStatus());

		} catch (Exception e) {
			log.error(
					"Exception in [{}] of class [{}] while fetching zonal values for districtCode: {}, circleCode: {}, mouzaCode: {}. Error: {}",
					methodName, this.getClass().getSimpleName(), districtCode, circleCode, mouzaCode, e.getMessage(),
					e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch zonal values for districtCode: " + districtCode + ", circleCode: "
					+ circleCode + ", mouzaCode: " + mouzaCode + ". Reason: " + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}] with districtCode: {}, circleCode: {}, mouzaCode: {}", methodName,
				this.getClass().getSimpleName(), districtCode, circleCode, mouzaCode);

		return response;
	}

	@GetMapping("/getParameterDetails")
	public ResponseModel getParameterDetails(@RequestParam BigDecimal minRange, @RequestParam BigDecimal maxRange) {
		String methodName = "getParameterDetails";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}] with minRange: {}, maxRange: {}", methodName,
				this.getClass().getSimpleName(), minRange, maxRange);

		try {
			log.info("Fetching parameter details for minRange: {}, maxRange: {}", minRange, maxRange);

			response = masterDataService.getParameterDetails(minRange, maxRange);

			log.info("Successfully retrieved parameter details for minRange: {}, maxRange: {}. Response status: {}",
					minRange, maxRange, response.getHttpStatus());

		} catch (Exception e) {
			log.error(
					"Exception in [{}] of class [{}] while fetching parameter details for minRange: {}, maxRange: {}. Error: {}",
					methodName, this.getClass().getSimpleName(), minRange, maxRange, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch parameter details for minRange: " + minRange + ", maxRange: "
					+ maxRange + ". Reason: " + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}] with minRange: {}, maxRange: {}", methodName,
				this.getClass().getSimpleName(), minRange, maxRange);

		return response;
	}

	@GetMapping("/getParameterDetailsDynamic") // new
	public ResponseModel getParameterDetailsDynamic() {
		String methodName = "getParameterDetailsDynamic";
		ResponseModel response = new ResponseModel();

		log.info("START | {} | Received request to fetch all parameter details", methodName);

		try {
			log.debug("Invoking service: masterDataService.getParameterDetailsDynamic()");
			response = masterDataService.getParameterDetailsDynamic();

			if (response.getHttpStatus() == HttpStatus.OK) {
				log.info("SUCCESS | {} | Parameter details fetched successfully", methodName);
			} else {
				log.warn("NO DATA | {} | Response message: {}", methodName, response.getMessage());
			}

		} catch (Exception e) {
			log.error("ERROR | {} | Exception while fetching parameter details | Error: {}", methodName, e.getMessage(),
					e);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching parameter details: " + e.getLocalizedMessage());
		}

		log.info("END | {} | Response Status: {} | Message: {}", methodName, response.getHttpStatus(),
				response.getMessage());

		return response;
	}

	@GetMapping("/getAreaType")
	public ResponseModel getAreaType() {
		String methodName = "getAreaType";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding All Area Types | Method: {} | Class: {}", methodName,
					this.getClass().getSimpleName());

			response = masterDataService.getAreaType();

		} catch (Exception e) {
			log.error("Error while Finding Area Types | Method: {} | Class: {} | Error: {}", methodName,
					this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while finding Area Types. Error: " + e.getLocalizedMessage());
		}
		return response;
	}

	@GetMapping("/getAreaTypeByMouza")
	public ResponseModel getAreaTypeByMouza(@RequestParam(required = true) String mouzaCode) {
		String methodName = "getAreaTypeByMouza";
		ResponseModel response = new ResponseModel();

		log.info("START | {} | Received request to fetch Area Types for mouzaCode: {}", methodName, mouzaCode);

		try {
			log.debug("Invoking service: masterDataService.getAreaTypeByMouza(mouzaCode={})", mouzaCode);
			response = masterDataService.getAreaTypeByMouza(mouzaCode);

			if (response.getHttpStatus() == HttpStatus.OK) {
				log.info("SUCCESS | {} | Area Types fetched successfully for mouzaCode: {}", methodName, mouzaCode);
			} else {
				log.warn("NO DATA | {} | Response message: {} | mouzaCode: {}", methodName, response.getMessage(),
						mouzaCode);
			}

		} catch (Exception e) {
			log.error("ERROR | {} | Exception while fetching Area Types for mouzaCode: {} | Error: {}", methodName,
					mouzaCode, e.getMessage(), e);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching Area Types: " + e.getLocalizedMessage());
		}

		log.info("END | {} | Response Status: {} | Message: {}", methodName, response.getHttpStatus(),
				response.getMessage());

		return response;
	}
	
	@PostMapping("/add/landCategory")
	public ResponseModel addLandCategory(@RequestBody LandCategoriesModelRequest landCategoriesModel) {
		String methodName = "addLandCategory";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Add LandCategory, Name: {}, BasePriceIncrease: {}, CircleCode: {}, Method: {}, Class: {}",
					landCategoriesModel.getLandCategoryName(), landCategoriesModel.getBasePriceIncreaseLandUse(),
					landCategoriesModel.getCircleCode(), methodName, this.getClass().getSimpleName());

			response = masterDataService.addLandCategory(landCategoriesModel);

			log.info("Respond: LandCategory added successfully, Name: {}, Method: {}, Class: {}",
					landCategoriesModel.getLandCategoryName(), methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while adding LandCategory, Name: {}, Method: {}, Class: {}",
					landCategoriesModel.getLandCategoryName(), methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while adding LandCategory, Name: "
					+ landCategoriesModel.getLandCategoryName() + ", error: " + e.getLocalizedMessage());
		}

		return response;
	}
	

//	@PostMapping("/add/areaType")
//	public ResponseModel addAreaType(@RequestBody AreaTypeModelRequest areaTypeModel) {
//		String methodName = "addAreaType";
//		ResponseModel response = new ResponseModel();
//		try {
//			log.info("Request: Add AreaType, Name: {}, Method: {}, Class: {}",
//					areaTypeModel.getAreaTypeName(), methodName, this.getClass().getSimpleName());
//
//			response = masterDataService.addAreaType(areaTypeModel);
//
//			log.info("Respond: AreaType added successfully, Name: {}, Method: {}, Class: {}",
//					areaTypeModel.getAreaTypeName(), methodName, this.getClass().getSimpleName());
//
//		} catch (Exception e) {
//			log.error("Error while adding AreaType, Name: {}, Method: {}, Class: {}",
//					areaTypeModel.getAreaTypeName(), methodName, this.getClass().getSimpleName(), e);
//
//			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//			response.setMessage("An error occurred while adding AreaType, Name: "
//					+ areaTypeModel.getAreaTypeName() + ", error: " + e.getLocalizedMessage());
//		}
//
//		return response;
//	}

	@PostMapping("/add/areaType")
	public ResponseModel addAreaType(@RequestBody AreaTypesModelRequest areaTypesModel) {
		String methodName = "addAreaType";// urban or rural
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: add AreaType Details , AreaType Name " + areaTypesModel.getAreaType() + "  Method Name"
					+ methodName + " Class : " + this.getClass());

			response = masterDataService.addAreaType(areaTypesModel);

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

	@PostMapping("/delete/areaType")
	public ResponseModel deleteAreaType(@RequestParam Long areaTypesGenId) {
		String methodName = "deleteAreaType";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request: Delete AreaType, ID: {}, Method: {}, Class: {}", areaTypesGenId, methodName,
					this.getClass().getSimpleName());

			response = masterDataService.deleteAreaType(areaTypesGenId);

			log.info("Respond: AreaType deleted successfully, ID: {}, Method: {}, Class: {}", areaTypesGenId,
					methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while deleting AreaType, ID: {}, Method: {}, Class: {}", areaTypesGenId, methodName,
					this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while deleting AreaType, ID: " + areaTypesGenId + ", error: "
					+ e.getLocalizedMessage());
		}

		return response;
	}
	

	@PostMapping("/add/sro")
	public ResponseModel addSroDetails(@RequestBody SroDetailsModelRequest sroDetailsModel) {
		String methodName = "addSroDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Add Sro Details | DistrictCode: {} | CircleCode: {} | SroName: {} | Method: {} | Class: {}",
					sroDetailsModel.getDistrictCode(), sroDetailsModel.getCircleCode(), sroDetailsModel.getSroName(),
					methodName, this.getClass().getSimpleName());

			response = masterDataService.addSroDetails(sroDetailsModel);

		} catch (Exception e) {
			log.error(
					"Error while adding Sro Details | DistrictCode: {} | CircleCode: {} | SroName: {} | Method: {} | Class: {} | Error: {}",
					sroDetailsModel.getDistrictCode(), sroDetailsModel.getCircleCode(), sroDetailsModel.getSroName(),
					methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while adding Sro Details, SroName: " + sroDetailsModel.getSroName()
					+ ", Error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/update/sro")
	public ResponseModel updateSroDetails(@RequestBody SroDetailsModelUpdateRequest sroDetailsModel) {
		String methodName = "updateSroDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update Sro Details | Sro Name: {} | Sro Code: {} | District Code: {} | Circle Code: {} | Method: {} | Class: {}",
					sroDetailsModel.getSroName(), sroDetailsModel.getSroCode(), sroDetailsModel.getDistrictCode(),
					sroDetailsModel.getCircleCode(), methodName, this.getClass().getSimpleName());

			response = masterDataService.updateSroDetails(sroDetailsModel);

			log.info(
					"Sro updated successfully | Sro Name: {} | Sro Code: {} | District Code: {} | Circle Code: {} | Method: {} | Class: {}",
					sroDetailsModel.getSroName(), sroDetailsModel.getSroCode(), sroDetailsModel.getDistrictCode(),
					sroDetailsModel.getCircleCode(), methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while updating Sro Details | Sro Name: {} | Sro Code: {} | District Code: {} | Circle Code: {} | Method: {} | Class: {}",
					sroDetailsModel.getSroName(), sroDetailsModel.getSroCode(), sroDetailsModel.getDistrictCode(),
					sroDetailsModel.getCircleCode(), methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"Failed to update Sro Details | Sro Name: " + sroDetailsModel.getSroName() + ", Sro Code: "
							+ sroDetailsModel.getSroCode() + ", District Code: " + sroDetailsModel.getDistrictCode()
							+ ", Circle Code: " + sroDetailsModel.getCircleCode() + ", Error: " + e.getMessage());
		}

		return response;
	}

	@PostMapping("/delete/sro")
	public ResponseModel deleteSroDetails(@RequestParam String sroCode) {
		String methodName = "deleteSroDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete Sro Details | SroCode: {} | Method: {} | Class: {}", sroCode, methodName,
					this.getClass().getSimpleName());

			response = masterDataService.deleteSroDetails(sroCode);

			log.info("Respond: Sro Delete request processed | SroCode: {} | Method: {} | Class: {}", sroCode,
					methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while Deleting Sro Details | SroCode: {} | Method: {} | Class: {} | Error: {}", sroCode,
					methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting Sro Details | SroCode: " + sroCode + ", error: "
					+ e.getLocalizedMessage());
		}

		return response;
	}
	
	@GetMapping("/getParameterDetailsDynamicBy")
	public ResponseModel getParameterDetailsDynamicBy() {
		String methodName = "getParameterDetailsDynamic";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}]", methodName, this.getClass().getSimpleName());

		try {
			log.info("Fetching parameter details for All");

			response = masterDataService.getParameterDetailsDynamic();

			log.info("Successfully retrieved parameter details for All. Response status: {}", response.getHttpStatus());

		} catch (Exception e) {
			log.error(
					"Exception in [{}] of class [{}] while fetching parameter details for minRange: {}, maxRange: {}. Error: {}",
					methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch parameter details of All. Reason" + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}] with", methodName, this.getClass().getSimpleName());

		return response;
	}




}
