package com.areap2.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.areap2.serviceImpl.MasterDataServiceImpl;

@RestController
@RequestMapping("/masterData")
@CrossOrigin
public class MasterDataServiceController {

	private MasterDataService masterDataService;

	Logger log = LoggerFactory.getLogger(MasterDataServiceController.class);

	public MasterDataServiceController(MasterDataServiceImpl masterDataServiceImpl) {
		this.masterDataService = masterDataServiceImpl;
	}

	@GetMapping("/getAllDistrictDetails")
	public ResponseModel getAllDistrictDetails() {
		String methodName = "getAllDistrictDetails";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}]", methodName, this.getClass().getSimpleName());

		try {
			log.info("Fetching all district details from MasterDataService...");

			response = masterDataService.getAllDistrictDetails();

			log.info("Successfully retrieved district details  of Active is TRUE. Response status: {}",
					response.getHttpStatus());

		} catch (Exception e) {
			log.error("Exception in [{}] of class [{}]: {}", methodName, this.getClass().getSimpleName(),
					e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch district details. Reason: " + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}]", methodName, this.getClass().getSimpleName());

		return response;
	}

	@GetMapping("/getCircleByDistrict")
	public ResponseModel getCircleByDistrict(@RequestParam String districtCode) {
		String methodName = "getCircleByDistrict";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}] with districtCode: {}", methodName, this.getClass().getSimpleName(),
				districtCode);

		try {
			log.info("Fetching circle details for districtCode: {}", districtCode);

			response = masterDataService.getCircleByDistrict(districtCode);

			log.info("Successfully retrieved circle details for districtCode: {}. Response status: {}", districtCode,
					response.getHttpStatus());

		} catch (Exception e) {
			log.error("Exception in [{}] of class [{}] while fetching circle details for districtCode: {}. Error: {}",
					methodName, this.getClass().getSimpleName(), districtCode, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch circle details for districtCode: " + districtCode + ". Reason: "
					+ e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}] with districtCode: {}", methodName, this.getClass().getSimpleName(),
				districtCode);

		return response;
	}

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

	@GetMapping("/getVillageByDistrictAndCircle")
	public ResponseModel getVillageByDistrictAndCircle(@RequestParam String districtCode,
			@RequestParam String circleCode) {
		String methodName = "getVillageByDistrictAndCircle";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}] with districtCode: {}, circleCode: {}", methodName,
				this.getClass().getSimpleName(), districtCode, circleCode);

		try {
			log.info("Fetching village details for districtCode: {} and circleCode: {}", districtCode, circleCode);

			response = masterDataService.getVillageByDistrictAndCircle(districtCode, circleCode);

			log.info("Successfully retrieved village details for districtCode: {}, circleCode: {}. Response status: {}",
					districtCode, circleCode, response.getHttpStatus());

		} catch (Exception e) {
			log.error(
					"Exception in [{}] of class [{}] while fetching village details for districtCode: {}, circleCode: {}. Error: {}",
					methodName, this.getClass().getSimpleName(), districtCode, circleCode, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch village details for districtCode: " + districtCode + ", circleCode: "
					+ circleCode + ". Reason: " + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}] with districtCode: {}, circleCode: {}", methodName,
				this.getClass().getSimpleName(), districtCode, circleCode);

		return response;
	}

	@GetMapping("/getMouzaDetails")
	public ResponseModel getMouzaDetails(@RequestParam(required = true) String districtCode,
			@RequestParam(required = false) String circleCode) {
		String methodName = "getMouzaDetails";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}] with districtCode: {}, circleCode: {}", methodName,
				this.getClass().getSimpleName(), districtCode, circleCode);

		try {
			log.info("Fetching Mouza details for districtCode: {} and circleCode: {}", districtCode, circleCode);

			response = masterDataService.getMouzaDetails(districtCode, circleCode);

			log.info("Successfully retrieved Mouza details for districtCode: {}, circleCode: {}. Response status: {}",
					districtCode, circleCode, response.getHttpStatus());

		} catch (Exception e) {
			log.error(
					"Exception in [{}] of class [{}] while fetching Mouza details for districtCode: {}, circleCode: {}. Error: {}",
					methodName, this.getClass().getSimpleName(), districtCode, circleCode, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch Mouza details for districtCode: " + districtCode + ", circleCode: "
					+ circleCode + ". Reason: " + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}] with districtCode: {}, circleCode: {}", methodName,
				this.getClass().getSimpleName(), districtCode, circleCode);

		return response;
	}

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

	@GetMapping("/getLandSubClassByLandClass") // landSubClassByLandClass
	public ResponseModel getLandSubClassByLandClass(String landClassName) {
		String methodName = "getLandSubClassByLandClass";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}]", methodName, this.getClass().getSimpleName());

		try {
			log.info("Fetching all Land Sub Class By Land Class from MasterDataService...");

			response = masterDataService.getLandSubClassByLandClassName(landClassName);

			log.info("Successfully retrieved all Land Sub Class By Land Class. Response status: {}",
					response.getHttpStatus());

		} catch (Exception e) {
			log.error("Exception in [{}] of class [{}] while fetching all Land Sub Class By Land Class. Error: {}",
					methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch Land Sub Class By Land Class. Reason: " + e.getLocalizedMessage());
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

	@PostMapping("/add/district")
	public ResponseModel addDistrictDetails(@RequestBody DistrictDetailsModelRequest districtDetailsModel) {
		String methodName = "addDistrictDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Adding District Details, District Name: {}, District Code: {} | Method: {} | Class: {}",
					districtDetailsModel.getDistrictName(), districtDetailsModel.getDistrictCode(), methodName,
					this.getClass().getSimpleName());

			response = masterDataService.addDistrictDetails(districtDetailsModel);

		} catch (Exception e) {
			log.error(
					"Error while adding District Details, District Name: {}, District Code: {} | Method: {} | Class: {}",
					districtDetailsModel.getDistrictName(), districtDetailsModel.getDistrictCode(), methodName,
					this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add District Details for District Name: "
					+ districtDetailsModel.getDistrictName() + ", District Code: "
					+ districtDetailsModel.getDistrictCode() + ". Please try again later.");
		}
		return response;
	}

	@PostMapping("/update/district")
	public ResponseModel updateDistrictDetails(@RequestBody DistrictDetailsModelRequest districtDetailsModel) {
		String methodName = "updateDistrictDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update District Details | District Name: {} | District Code: {} | Method: {} | Class: {}",
					districtDetailsModel.getDistrictName(), districtDetailsModel.getDistrictCode(), methodName,
					this.getClass().getSimpleName());

			response = masterDataService.updateDistrictDetails(districtDetailsModel);

			log.info("District updated successfully | District Name: {} | District Code: {} | Method: {} | Class: {}",
					districtDetailsModel.getDistrictName(), districtDetailsModel.getDistrictCode(), methodName,
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

	@PostMapping("/delete/district")
	public ResponseModel deleteDistrictDetails(@RequestParam String districtCode) {
		String methodName = "deleteDistrictDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to delete District Details | District Code: {} | Method: {} | Class: {}",
					districtCode, methodName, this.getClass().getSimpleName());

			response = masterDataService.deleteDistrictDetails(districtCode);

			log.info("District deleted means Active is FALSE successfully | District Code: {} | Method: {} | Class: {}",
					districtCode, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error occurred while deleting District Details | District Code: {} | Method: {} | Class: {}",
					districtCode, methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to delete District Details | District Code: " + districtCode + ", Error: "
					+ e.getMessage());
		}

		return response;
	}

	@PostMapping("/add/circle")
	public ResponseModel addCircleDetails(@RequestBody CircleDetailsModelRequest circleDetailsModel) {
		String methodName = "addCircleDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to add Circle Details | Circle Name: {} | District Code: {} | Method: {} | Class: {}",
					circleDetailsModel.getCircleName(), circleDetailsModel.getDistrictCode(), methodName,
					this.getClass().getSimpleName());

			response = masterDataService.addCircleDetails(circleDetailsModel);

			log.info("Circle added successfully | Circle Name: {} | District Code: {} | Method: {} | Class: {}",
					circleDetailsModel.getCircleName(), circleDetailsModel.getDistrictCode(), methodName,
					this.getClass().getSimpleName());

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

	@PostMapping("/update/circle")
	public ResponseModel updateCircleDetails(@RequestBody CircleDetailsModelUpdateRequest circleDetailsModel) {
		String methodName = "updateCircleDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update Circle Details | Circle Name: {} | Circle Code: {} | District Code: {} | Method: {} | Class: {}",
					circleDetailsModel.getCircleName(), circleDetailsModel.getCircleCode(),
					circleDetailsModel.getDistrictCode(), methodName, this.getClass().getSimpleName());

			response = masterDataService.updateCircleDetails(circleDetailsModel);

			log.info(
					"Circle updated successfully | Circle Name: {} | Circle Code: {} | District Code: {} | Method: {} | Class: {}",
					circleDetailsModel.getCircleName(), circleDetailsModel.getCircleCode(),
					circleDetailsModel.getDistrictCode(), methodName, this.getClass().getSimpleName());

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

	@PostMapping("/delete/circle")
	public ResponseModel deleteCircleDetails(@RequestParam String circleCode) {
		String methodName = "deleteCircleDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to delete Circle Details | Circle Code: {} | Method: {} | Class: {}", circleCode,
					methodName, this.getClass().getSimpleName());

			response = masterDataService.deleteCircleDetails(circleCode);

			log.info("Circle deleted successfully | Circle Code: {} | Method: {} | Class: {}", circleCode, methodName,
					this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error occurred while deleting Circle Details | Circle Code: {} | Method: {} | Class: {}",
					circleCode, methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"Failed to delete Circle Details | Circle Code: " + circleCode + ", Error: " + e.getMessage());
		}

		return response;
	}

	@PostMapping("/add/village")
	public ResponseModel addVillageDetails(@RequestBody VillageDetailsModelRequest villageDetailsModel) {
		String methodName = "addVillageDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Add Village Details | DistrictCode: {} | CircleCode: {} | VillageName: {} | Method: {} | Class: {}",
					villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
					villageDetailsModel.getVillageName(), methodName, this.getClass().getSimpleName());

			response = masterDataService.addVillageDetails(villageDetailsModel);

		} catch (Exception e) {
			log.error(
					"Error while adding Village Details | DistrictCode: {} | CircleCode: {} | VillageName: {} | Method: {} | Class: {} | Error: {}",
					villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
					villageDetailsModel.getVillageName(), methodName, this.getClass().getSimpleName(), e.getMessage(),
					e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while adding Village Details, VillageName: "
					+ villageDetailsModel.getVillageName() + ", Error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/update/village")
	public ResponseModel updateVillageDetails(@RequestBody VillageDetailsModelUpdateRequest villageDetailsModel) {
		String methodName = "updateVillageDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Update Village Details | DistrictCode: {} | CircleCode: {} | VillageName: {} | Method: {} | Class: {}",
					villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
					villageDetailsModel.getVillageName(), methodName, this.getClass().getSimpleName());

			response = masterDataService.updateVillageDetails(villageDetailsModel);

		} catch (Exception e) {
			log.error(
					"Error while Updating Village Details | DistrictCode: {} | CircleCode: {} | VillageName: {} | Method: {} | Class: {} | Error: {}",
					villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
					villageDetailsModel.getVillageName(), methodName, this.getClass().getSimpleName(), e.getMessage(),
					e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while updating Village Details, VillageName: "
					+ villageDetailsModel.getVillageName() + ", Error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/delete/village")
	public ResponseModel deleteVillageDetails(@RequestParam String villageCode) {
		String methodName = "deleteVillageDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete Village Details | VillageCode: {} | Method: {} | Class: {}", villageCode,
					methodName, this.getClass().getSimpleName());

			response = masterDataService.deleteVillageDetails(villageCode);

			log.info("Respond: Village deletion process completed | VillageCode: {} | Method: {} | Class: {}",
					villageCode, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while deleting Village Details | VillageCode: {} | Method: {} | Class: {} | Error: {}",
					villageCode, methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while deleting Village Details | VillageCode: " + villageCode
					+ ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/add/mouza")
	public ResponseModel addMouzaDetails(@RequestBody MouzaDetailsModelRequest mouzaDetailsModel) {
		String methodName = "addMouzaDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Add Mouza Details | MouzaName: {} | AreaTypeId: {} | DistrictCode: {} | CircleCode: {} | Method: {} | Class: {}",
					mouzaDetailsModel.getMouzaName(), mouzaDetailsModel.getAreaTypeId(),
					mouzaDetailsModel.getDistrictCode(), mouzaDetailsModel.getCircleCode(), methodName,
					this.getClass().getSimpleName());

			response = masterDataService.addMouzaDetails(mouzaDetailsModel);

			log.info(
					"Respond: Mouza Details Added Successfully | MouzaName: {} | DistrictCode: {} | CircleCode: {} | Method: {} | Class: {}",
					mouzaDetailsModel.getMouzaName(), mouzaDetailsModel.getDistrictCode(),
					mouzaDetailsModel.getCircleCode(), methodName, this.getClass().getSimpleName());

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

	@PostMapping("/update/mouza")
	public ResponseModel updateMouzaDetails(@RequestBody MouzaDetailsModelUpdateRequest mouzaDetailsModel) {
		String methodName = "updateMouzaDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Update Mouza Details, MouzaCode: {}, MouzaName: {}, AreaTypeId: {}, DistrictCode: {}, CircleCode: {}, Method: {}, Class: {}",
					mouzaDetailsModel.getMouzaCode(), mouzaDetailsModel.getMouzaName(),
					mouzaDetailsModel.getAreaTypeId(), mouzaDetailsModel.getDistrictCode(),
					mouzaDetailsModel.getCircleCode(), methodName, this.getClass().getSimpleName());

			response = masterDataService.updateMouzaDetails(mouzaDetailsModel);

		} catch (Exception e) {
			log.error("Error while updating Mouza Details, MouzaName: {}, Method: {}, Class: {}",
					mouzaDetailsModel.getMouzaName(), methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while updating Mouza Details, Mouza Name: "
					+ mouzaDetailsModel.getMouzaName() + ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/delete/mouza")
	public ResponseModel deleteMouzaDetails(@RequestParam String mouzaCode) {
		String methodName = "deleteMouzaDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete Mouza Details | MouzaCode: {} | Method: {} | Class: {}", mouzaCode, methodName,
					this.getClass().getSimpleName());

			response = masterDataService.deleteMouzaDetails(mouzaCode);

			log.info("Respond: Mouza Delete request processed | MouzaCode: {} | Method: {} | Class: {}", mouzaCode,
					methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while Deleting Mouza Details | MouzaCode: {} | Method: {} | Class: {} | Error: {}",
					mouzaCode, methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting Mouza Details | MouzaCode: " + mouzaCode + ", error: "
					+ e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/add/landCategory")
	public ResponseModel addLandCategory(@RequestBody LandCategoriesModelRequest landCategoriesModel) {
		String methodName = "addLandCategory";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Add LandCategory, Name: {}, Method: {}, Class: {}",
					landCategoriesModel.getLandCategoryName(), methodName, this.getClass().getSimpleName());

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

	@PostMapping("/delete/landCategory")
	public ResponseModel deleteLandCategory(@RequestParam Long landCategoryGenId) {
		String methodName = "deleteLandCategory";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete LandCategory Details , landCategoryGenId " + landCategoryGenId + "  Method Name"
					+ methodName + " Class : " + this.getClass());

			response = masterDataService.deleteLandCategory(landCategoryGenId);

		} catch (Exception e) {
			log.error("An error occurred while Deleting LandCategory Details, LandCategory code " + landCategoryGenId
					+ "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting LandCategory Details , LandCategory code "
					+ landCategoryGenId + ",error : " + e.getLocalizedMessage());
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
		String methodName = "addAreaType";//urban or rural
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

	@PostMapping("/add/lot")
	public ResponseModel addLotDetails(@RequestBody LotDetailsModelRequest lotDetailsModel) {
		String methodName = "addLotDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request: Add Lot, Name: {}, AreaTypeId: {}, DistrictCode: {}, CircleCode: {}, Method: {}, Class: {}",
					lotDetailsModel.getLotName(), lotDetailsModel.getAreaTypeId(), lotDetailsModel.getDistrictCode(),
					lotDetailsModel.getCircleCode(), methodName, this.getClass().getSimpleName());

			response = masterDataService.addLotDetails(lotDetailsModel);

		} catch (Exception e) {
			log.error(
					"Error while adding Lot, Name: {}, AreaTypeId: {}, DistrictCode: {}, CircleCode: {}, Method: {}, Class: {}",
					lotDetailsModel.getLotName(), lotDetailsModel.getAreaTypeId(), lotDetailsModel.getDistrictCode(),
					lotDetailsModel.getCircleCode(), methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while adding Lot. Name: " + lotDetailsModel.getLotName()
					+ ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/update/lot")
	public ResponseModel updateLotDetails(@RequestBody LotDetailsModelUpdateRequest lotDetailsModel) {
		String methodName = "updateLotDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Update Lot Details [lotCode={}, lotName={}, districtCode={}, circleCode={}, areaTypeId={}] Method Name {} Class: {}",
					lotDetailsModel.getLotCode(), lotDetailsModel.getLotName(), lotDetailsModel.getDistrictCode(),
					lotDetailsModel.getCircleCode(), lotDetailsModel.getAreaTypeId(), methodName,
					this.getClass().getName());

			response = masterDataService.updateLotDetails(lotDetailsModel);

		} catch (Exception e) {
			log.error(
					"An error occurred while updating Lot Details [lotCode={}, lotName={}, districtCode={}, circleCode={}, areaTypeId={}] Method Name {} Class: {}",
					lotDetailsModel.getLotCode(), lotDetailsModel.getLotName(), lotDetailsModel.getDistrictCode(),
					lotDetailsModel.getCircleCode(), lotDetailsModel.getAreaTypeId(), methodName,
					this.getClass().getName(), e);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while updating Lot Details , Lot Name "
					+ lotDetailsModel.getLotName() + ", error : " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/delete/lot")
	public ResponseModel deleteLotDetails(@RequestParam String lotCode) {
		String methodName = "deleteLotDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete Lot Details | LotCode: {} | Method: {} | Class: {}", lotCode, methodName,
					this.getClass().getSimpleName());

			response = masterDataService.deleteLotDetails(lotCode);

			log.info("Respond: Lot Delete request processed | LotCode: {} | Method: {} | Class: {}", lotCode,
					methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while Deleting Lot Details | LotCode: {} | Method: {} | Class: {} | Error: {}", lotCode,
					methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting Lot Details | LotCode: " + lotCode + ", error: "
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

	@PostMapping("/add/landSubClass")
	public ResponseModel addLandSubClassDetails(@RequestBody LandSubClassDetailsModelRequest landSubClassDetailsModel) {
		String methodName = "addLandSubClassDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Add LandSubClass Details | LandClassName: {} |  | LandSubClassName: {} | Method: {} | Class: {}",
					landSubClassDetailsModel.getLandClassName(), landSubClassDetailsModel.getLandSubClassName(),
					methodName, this.getClass().getSimpleName());

			response = masterDataService.addLandSubClassDetails(landSubClassDetailsModel);

		} catch (Exception e) {
			log.error(
					"Error while adding LandSubClass Details | LandClassName: {}  | LandSubClassName: {} | Method: {} | Class: {} | Error: {}",
					landSubClassDetailsModel.getLandClassName(), landSubClassDetailsModel.getLandSubClassName(),
					methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while adding LandSubClass Details, LandSubClassName: "
					+ landSubClassDetailsModel.getLandSubClassName() + ", Error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/update/landSubClass")
	public ResponseModel updateLandSubClassDetails(
			@RequestBody LandSubClassDetailsModelUpdateRequest landSubClassDetailsModel) {
		String methodName = "updateLandSubClassDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update LandSubClass Details | LandSubClass Name: {} | LandClassName : {}  | LandSubClassCode : {}  | Method: {} | Class: {}",
					landSubClassDetailsModel.getLandSubClassName(), landSubClassDetailsModel.getLandClassName(),
					landSubClassDetailsModel.getLandSubClassCode(), methodName, this.getClass().getSimpleName());

			response = masterDataService.updateLandSubClassDetails(landSubClassDetailsModel);

			log.info(
					"LandSubClass updated successfully | LandSubClass Name: {} | LandClassName : {} | LandSubClassCode : {}   | Method: {} | Class: {}",
					landSubClassDetailsModel.getLandSubClassName(), landSubClassDetailsModel.getLandClassName(),
					landSubClassDetailsModel.getLandSubClassCode(), methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while updating LandSubClass Details | LandSubClass Name: {}| LandClassName : {}  | Method: {} | Class: {}",
					landSubClassDetailsModel.getLandSubClassName(), landSubClassDetailsModel.getLandClassName(),
					methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to update LandSubClass Details | LandSubClass Name: "
					+ landSubClassDetailsModel.getLandSubClassName() + ", LandClassName : "
					+ landSubClassDetailsModel.getLandClassName() + ", Error: " + e.getMessage());
		}

		return response;
	}

	@PostMapping("/delete/landSubClass")
	public ResponseModel deleteLandSubClassDetails(@RequestParam String landSubClass) {
		String methodName = "deleteLandSubClassDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete LandSubClass Details | LandSubClass: {} | Method: {} | Class: {}", landSubClass,
					methodName, this.getClass().getSimpleName());

			response = masterDataService.deleteLandSubClassDetails(landSubClass);

			log.info("Respond: LandSubClass Delete request processed | LandSubClass: {} | Method: {} | Class: {}",
					landSubClass, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error while Deleting LandSubClass Details | LandSubClass: {} | Method: {} | Class: {} | Error: {}",
					landSubClass, methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting LandSubClass Details | LandSubClass: " + landSubClass
					+ ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

}
