package com.areap2.controller;

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

import com.areap2.model.BasePriceUpdateDetailsModelRequest;
import com.areap2.model.CircleDetailsModelRequest;
import com.areap2.model.CircleDetailsModelUpdateRequest;
import com.areap2.model.DistrictDetailsModelRequest;
import com.areap2.model.LandSubClassDetailsModelRequest;
import com.areap2.model.LandSubClassDetailsModelUpdateRequest;
import com.areap2.model.LotDetailsModelRequest;
import com.areap2.model.LotDetailsModelUpdateRequest;
import com.areap2.model.MouzaDetailsModelRequest;
import com.areap2.model.MouzaDetailsModelUpdateRequest;
import com.areap2.model.ParameterDetailsModelRequest;
import com.areap2.model.ParameterDetailsModelUpdateRequest;
import com.areap2.model.ResponseModel;
import com.areap2.model.SubParameterDetailsModelRequest;
import com.areap2.model.SubParameterDetailsModelUpdateRequest;
import com.areap2.model.VillageDetailsModelRequest;
import com.areap2.model.VillageDetailsModelUpdateRequest;
import com.areap2.service.MasterDataService;
import com.areap2.serviceImpl.MasterDataServiceImpl;

@RestController
@RequestMapping("/masterData")
@CrossOrigin
public class MasterDataController {

	private MasterDataService masterDataService;

	Logger log = LoggerFactory.getLogger(MasterDataController.class);

	public MasterDataController(MasterDataServiceImpl masterDataServiceImpl) {
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

	@GetMapping("/getMouzaDetailsByDistrictAndCircle")
	public ResponseModel getMouzaDetailsByDistrictAndCircle(@RequestParam(required = true) String districtCode,
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

	@GetMapping("/getLotByDistrictAndCircleAndMouza")
	public ResponseModel getLotByDistrictAndCircleAndMouza(@RequestParam String districtCode,
			@RequestParam String circleCode, @RequestParam String mouzaCode) {
		String methodName = "getLotByDistrictAndCircle";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}] with districtCode: {}, circleCode: {}", methodName,
				this.getClass().getSimpleName(), districtCode, circleCode, mouzaCode);

		try {
			log.info("Fetching lot details for districtCode: {} and circleCode: {}", districtCode, circleCode);

			response = masterDataService.getLotByDistrictAndCircleAndMouza(districtCode, circleCode, mouzaCode);

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

	@GetMapping("/getVillageByDistrictAndCircleAndMauzaAndLot")
	public ResponseModel getVillageByDistrictAndCircleAndMauzaAndLot(@RequestParam String districtCode,
			@RequestParam String circleCode, @RequestParam String mauzaCode, @RequestParam String lotCode) {

		final String methodName = "getVillageByDistrictAndCircleAndMauzaAndLot";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}] | District: {} | Circle: {} | Mauza: {} | Lot: {}", methodName,
				className, districtCode, circleCode, mauzaCode, lotCode);

		long startTime = System.currentTimeMillis();

		try {
			log.debug(
					"[PROCESS] [{}] - Fetching village details from service layer | Params: districtCode={}, circleCode={}, mauza={}, lot={}",
					methodName, districtCode, circleCode, mauzaCode, lotCode);

			response = masterDataService.getVillageByDistrictAndCircleAndMauzaAndLot(districtCode, circleCode,
					mauzaCode, lotCode);

			log.info("[SUCCESS] [{}] - Village details fetched successfully | Status: {} | Message: {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {
			log.error(
					"[ERROR] [{}] - Exception occurred in [{}] | District: {} | Circle: {} | Mauza: {} | Lot: {} | Error: {}",
					methodName, className, districtCode, circleCode, mauzaCode, lotCode, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(String.format(
					"Failed to fetch village details for District: %s, Circle: %s, Mauza: %s, Lot: %s. Reason: %s",
					districtCode, circleCode, mauzaCode, lotCode, e.getLocalizedMessage()));
		}

		long endTime = System.currentTimeMillis();
		log.info("[END] [{}] - Completed in [{}] | Duration: {} ms | District: {} | Circle: {} | Mauza: {} | Lot: {}",
				methodName, className, (endTime - startTime), districtCode, circleCode, mauzaCode, lotCode);

		return response;
	}
	
	@GetMapping("/getAllLandsCategoryDetails")
	public ResponseModel getAllLandsCategoryDetails() {
		String methodName = "getAllLandsCategoryDetails";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}]", methodName, this.getClass().getSimpleName());

		try {
			log.info("Fetching all landsCategory details from MasterDataService...");

			response = masterDataService.getAllLandsCategoryDetails();

			log.info("Successfully retrieved landsCategory details  of Active is TRUE. Response status: {}",
					response.getHttpStatus());

		} catch (Exception e) {
			log.error("Exception in [{}] of class [{}]: {}", methodName, this.getClass().getSimpleName(),
					e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch landsCategory details. Reason: " + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}]", methodName, this.getClass().getSimpleName());

		return response;
	}


	@GetMapping("/getParameterDetailsAll")
	public ResponseModel getParameterDetailsAll() {
		final String methodName = "getParameterDetailsAll";
		ResponseModel response = new ResponseModel();

		log.info("START | [{}] | Request received to fetch Parameter Details : {}", methodName);

		try {
			ResponseModel serviceResponse = masterDataService.getParameterDetailsAll();

			// === Null and Status Handling ===
			if (serviceResponse == null) {
				log.error("NULL RESPONSE | [{}] | Service returned null for masterCode: {}", methodName);
				response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
				response.setMessage("Service returned null response");
			} else {
				// Safely cast the status and message
				Object statusObj = serviceResponse.getHttpStatus();
				HttpStatus status = (statusObj instanceof HttpStatus) ? (HttpStatus) statusObj
						: HttpStatus.INTERNAL_SERVER_ERROR;

				Object msgObj = serviceResponse.getMessage();
				String msg = (msgObj instanceof String) ? (String) msgObj : String.valueOf(msgObj);

				if (HttpStatus.OK.equals(status)) {
					log.info("SUCCESS | [{}] | Parameter details fetched successfully : {}", methodName);
				} else if (HttpStatus.NO_CONTENT.equals(status)) {
					log.warn("NO DATA | [{}] | No Parameter Details found for masterCode: {}", methodName);
				} else {
					log.warn("NON-SUCCESS RESPONSE | [{}] | Status: {} | Message: {}", methodName, status, msg);
				}

				response = serviceResponse;
			}

		} catch (Exception e) {
			log.error("EXCEPTION | [{}] | Error occurred while fetching Parameter Details | Exception: {}", methodName,
					e.getMessage(), e);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching Parameter Details: " + e.getLocalizedMessage());
		}

		// === Final Log (Always Safe) ===
		Object finalStatusObj = response.getHttpStatus();
		HttpStatus finalStatus = (finalStatusObj instanceof HttpStatus) ? (HttpStatus) finalStatusObj
				: HttpStatus.INTERNAL_SERVER_ERROR;

		Object finalMsgObj = response.getMessage();
		String finalMessage = (finalMsgObj instanceof String) ? (String) finalMsgObj : String.valueOf(finalMsgObj);

		log.info("END | [{}]  | Response Status: {} | Message: {}", methodName, finalStatus, finalMessage);

		return response;
	}

	@GetMapping("/getSubParameterDetailsAllByParameterCode")
	public ResponseModel getSubParameterDetailsAllByParameterCode(@RequestParam(required = true) String parameterCode) {
		String methodName = "getSubParameterDetailsAllByParameterCode";
		ResponseModel response = new ResponseModel();

		log.info("START | {} | Received request to fetch SubParameters by parameterCode: {}", methodName,
				parameterCode);

		try {
			log.debug("Invoking service: masterDataService.getSubParameterDetailsAllByParameterCode(parameterCode={})",
					parameterCode);
			response = masterDataService.getSubParameterDetailsAllByParameterCode(parameterCode);

			if (response.getHttpStatus() == HttpStatus.OK) {
				log.info("SUCCESS | {} | Area Types fetched successfully for parameterCode: {}", methodName,
						parameterCode);
			} else {
				log.warn("NO DATA | {} | Response message: {} | mouzaCode: {}", methodName, response.getMessage(),
						parameterCode);
			}

		} catch (Exception e) {
			log.error("ERROR | {} | Exception while fetching SubParameters for parameterCode: {} | Error: {}",
					methodName, parameterCode, e.getMessage(), e);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while fetching Parameters: " + e.getLocalizedMessage());
		}

		log.info("END | {} | Response Status: {} | Message: {}", methodName, response.getHttpStatus(),
				response.getMessage());

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

	@PostMapping("/add/district")
	public ResponseModel addDistrictDetails(@RequestBody DistrictDetailsModelRequest districtDetailsModel) {
		String methodName = "addDistrictDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Adding District Details, District Name: {} | Method: {} | Class: {}",
					districtDetailsModel.getDistrictName(), methodName, this.getClass().getSimpleName());

			response = masterDataService.addDistrictDetails(districtDetailsModel);

		} catch (Exception e) {
			log.error(
					"Error while adding District Details, District Name: {}, District Code: {} | Method: {} | Class: {}",
					districtDetailsModel.getDistrictName(), methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add District Details for District Name: "
					+ districtDetailsModel.getDistrictName() + ". Please try again later.");
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

	@PostMapping("/add/mouza")
	public ResponseModel addMouzaDetails(@RequestBody MouzaDetailsModelRequest mouzaDetailsModel) {
		String methodName = "addMouzaDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Add Mouza Details | MouzaName: {} | AreaTypeId: {} | DistrictCode: {} | CircleCode: {} | BasePriceMouza: {} | Method: {} | Class: {}",
					mouzaDetailsModel.getMouzaName(), mouzaDetailsModel.getAreaTypeId(),
					mouzaDetailsModel.getDistrictCode(), mouzaDetailsModel.getCircleCode(),
					mouzaDetailsModel.getBPMouza(), methodName, this.getClass().getSimpleName());

			response = masterDataService.addMouzaDetails(mouzaDetailsModel);

			log.info(
					"Respond: Mouza Details Added Successfully | MouzaName: {} | DistrictCode: {} | CircleCode: {} | BasePriceMouza: {} | Method: {} | Class: {}",
					mouzaDetailsModel.getMouzaName(), mouzaDetailsModel.getDistrictCode(),
					mouzaDetailsModel.getCircleCode(), mouzaDetailsModel.getBPMouza(), methodName,
					this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error while Adding Mouza Details | MouzaName: {} | DistrictCode: {} | CircleCode: {} | BasePriceMouza: {} | Method: {} | Class: {} | Error: {}",
					mouzaDetailsModel.getMouzaName(), mouzaDetailsModel.getDistrictCode(),
					mouzaDetailsModel.getCircleCode(), mouzaDetailsModel.getBPMouza(), methodName,
					this.getClass().getSimpleName(), e.getMessage(), e);

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
					"Request: Update Mouza Details, MouzaCode: {}, MouzaName: {}, AreaTypeId: {}, DistrictCode: {}, CircleCode: {}, BasePriceMouza: {}, Method: {}, Class: {}",
					mouzaDetailsModel.getMouzaCode(), mouzaDetailsModel.getMouzaName(),
					mouzaDetailsModel.getAreaTypeId(), mouzaDetailsModel.getDistrictCode(),
					mouzaDetailsModel.getCircleCode(), mouzaDetailsModel.getBPMouza(), methodName,
					this.getClass().getSimpleName());

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

	@PostMapping("/add/village")
	public ResponseModel addVillageDetails(@RequestBody VillageDetailsModelRequest villageDetailsModel) {
		final String methodName = "addVillageDetails";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info(
				"[START] [{}] - Invoked in [{}] | DistrictCode: {} | CircleCode: {} | MauzaCode: {} | LotCode: {} | VillageName: {} | AreaType: {}",
				methodName, className, villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
				villageDetailsModel.getMouzaCode(), villageDetailsModel.getLotCode(),
				villageDetailsModel.getVillageName(), villageDetailsModel.getAreaType());

		long startTime = System.currentTimeMillis();

		try {
			log.debug("[PROCESS] [{}] - Calling service: masterDataService.addVillageDetails(...) | Payload: {}",
					methodName, villageDetailsModel);

			response = masterDataService.addVillageDetails(villageDetailsModel);

			log.info("[SUCCESS] [{}] - Village added successfully | Status: {} | Message: {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {
			log.error(
					"[ERROR] [{}] - Exception occurred while adding village | DistrictCode: {} | CircleCode: {} | MauzaCode: {} | LotCode: {} | VillageName: {} | Error: {}",
					methodName, villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
					villageDetailsModel.getMouzaCode(), villageDetailsModel.getLotCode(),
					villageDetailsModel.getVillageName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(String.format("An error occurred while adding Village '%s'. Reason: %s",
					villageDetailsModel.getVillageName(), e.getLocalizedMessage()));
		}

		long endTime = System.currentTimeMillis();
		log.info("[END] [{}] - Completed in [{}] | Duration: {} ms | VillageName: {}", methodName, className,
				(endTime - startTime), villageDetailsModel.getVillageName());

		return response;
	}

	@PostMapping("/update/village")
	public ResponseModel updateVillageDetails(@RequestBody VillageDetailsModelUpdateRequest villageDetailsModel) {
		final String methodName = "updateVillageDetails";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info(
				"[START] [{}] - Invoked in [{}] | DistrictCode: {} | CircleCode: {} | MauzaCode: {} | LotCode: {} | VillageName: {} | AreaType: {}",
				methodName, className, villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
				villageDetailsModel.getMouzaCode(), villageDetailsModel.getLotCode(),
				villageDetailsModel.getVillageName(), villageDetailsModel.getAreaType());

		long startTime = System.currentTimeMillis();

		try {
			log.debug("[PROCESS] [{}] - Calling service: masterDataService.updateVillageDetails(...) | Payload: {}",
					methodName, villageDetailsModel);

			response = masterDataService.updateVillageDetails(villageDetailsModel);

			log.info("[SUCCESS] [{}] - Village updated successfully | Status: {} | Message: {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {
			log.error(
					"[ERROR] [{}] - Exception occurred while updating village | DistrictCode: {} | CircleCode: {} | MauzaCode: {} | LotCode: {} | VillageName: {} | Error: {}",
					methodName, villageDetailsModel.getDistrictCode(), villageDetailsModel.getCircleCode(),
					villageDetailsModel.getMouzaCode(), villageDetailsModel.getLotCode(),
					villageDetailsModel.getVillageName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(String.format("An error occurred while updating Village '%s'. Reason: %s",
					villageDetailsModel.getVillageName(), e.getLocalizedMessage()));
		}

		long endTime = System.currentTimeMillis();
		log.info("[END] [{}] - Completed in [{}] | Duration: {} ms | VillageName: {}", methodName, className,
				(endTime - startTime), villageDetailsModel.getVillageName());

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

	@PostMapping("/add/landsCategory")
	public ResponseModel landsCategory(@RequestParam String landCategoryName) {
		String methodName = "landsCategory";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete LandCategory Details , landCategoryName " + landCategoryName + "  Method Name"
					+ methodName + " Class : " + this.getClass());

			response = masterDataService.addLandsCategory(landCategoryName);

			log.info("Respond: LandCategory added successfully, Name: {}, Method: {}, Class: {}", landCategoryName,
					methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while adding LandCategory, Name: {}, Method: {}, Class: {}", landCategoryName, methodName,
					this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while adding LandCategory, Name: " + landCategoryName + ", error: "
					+ e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/delete/landsCategory")
	public ResponseModel deleteLandsCategory(@RequestParam String landCategoryCode) {
		String methodName = "deleteLandCategory";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete LandCategory Details , landCategoryCode " + landCategoryCode + "  Method Name"
					+ methodName + " Class : " + this.getClass());

			response = masterDataService.deleteLandsCategory(landCategoryCode);

		} catch (Exception e) {
			log.error("An error occurred while Deleting LandCategory Details, LandCategory code " + landCategoryCode
					+ "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Deleting LandCategory Details , LandCategory code "
					+ landCategoryCode + ",error : " + e.getLocalizedMessage());
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

	// mostImportantFor AdminOnly

	@PostMapping("/update/BasePriceDetails")
	public ResponseModel updateBasePriceDetails(@RequestBody BasePriceUpdateDetailsModelRequest bPRequest) {
		String methodName = "updateBasePriceDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update updateBasePriceDetails | District,Circle,Mouza Price: {} | Lot Price : {}  | LandUse Price : {}  | LandType Price : {}  | Method: {} | Class: {}",
					bPRequest.getBasePriceMouza(), bPRequest.getBasePriceMouzaIncreaseLot(),
					bPRequest.getBasePriceMouzaIncreaseLandUse(), bPRequest.getBasePriceMouzaIncreaseAreaUrbanOrRural(),
					methodName, this.getClass().getSimpleName());

			response = masterDataService.updateBasePriceDetails(bPRequest);

			log.info(
					"LandSubClass updated successfully | District,Circle,Mouza Price: {} | Lot Price : {}  | LandUse Price : {}  | LandType Price : {}  | Method: {} | Class: {}",
					bPRequest.getBasePriceMouza(), bPRequest.getBasePriceMouzaIncreaseLot(),
					bPRequest.getBasePriceMouzaIncreaseLandUse(), bPRequest.getBasePriceMouzaIncreaseAreaUrbanOrRural(),
					methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error(
					"Error occurred while updateBasePriceDetails | District,Circle,Mouza Price: {} | Lot Price : {}  | LandUse Price : {}  | LandType Price : {}  | Method: {} | Class: {}",
					bPRequest.getBasePriceMouza(), bPRequest.getBasePriceMouzaIncreaseLot(),
					bPRequest.getBasePriceMouzaIncreaseLandUse(), bPRequest.getBasePriceMouzaIncreaseAreaUrbanOrRural(),
					methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"An error occurred while updating Base Value Details:  error : " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/add/parameter")
	public ResponseModel addParameterDetails(@RequestBody ParameterDetailsModelRequest parameterDetailsModel) {
		final String methodName = "addParameterDetails";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info(
				"[START] [{}] - Invoked in [{}] | DistrictCode: {} | CircleCode: {} | MauzaCode: {} | LotCode: {} | ParameterName: {} | AreaType: {}",
				methodName, className, parameterDetailsModel.getParameterName());

		long startTime = System.currentTimeMillis();

		try {
			log.debug("[PROCESS] [{}] - Calling service: masterDataService.addParameterDetails(...) | Payload: {}",
					methodName, parameterDetailsModel);

			response = masterDataService.addParameterDetails(parameterDetailsModel);

			log.info("[SUCCESS] [{}] - Parameter added successfully | Status: {} | Message: {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {
			log.error(
					"[ERROR] [{}] - Exception occurred while adding parameter | DistrictCode: {} | CircleCode: {} | MauzaCode: {} | LotCode: {} | ParameterName: {} | Error: {}",
					methodName, parameterDetailsModel.getParameterName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(String.format("An error occurred while adding Parameter '%s'. Reason: %s",
					parameterDetailsModel.getParameterName(), e.getLocalizedMessage()));
		}

		long endTime = System.currentTimeMillis();
		log.info("[END] [{}] - Completed in [{}] | Duration: {} ms | ParameterName: {}", methodName, className,
				(endTime - startTime), parameterDetailsModel.getParameterName());

		return response;
	}

	@PostMapping("/update/parameter")
	public ResponseModel updateParameterDetails(@RequestBody ParameterDetailsModelUpdateRequest parameterDetailsModel) {
		final String methodName = "updateParameterDetails";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info(
				"[START] [{}] - Invoked in [{}] | DistrictCode: {} | CircleCode: {} | MauzaCode: {} | LotCode: {} | ParameterName: {} | AreaType: {}",
				methodName, className, parameterDetailsModel.getParameterName(),
				parameterDetailsModel.getParameterCode());

		long startTime = System.currentTimeMillis();

		try {
			log.debug("[PROCESS] [{}] - Calling service: masterDataService.updateParameterDetails(...) | Payload: {}",
					methodName, parameterDetailsModel);

			response = masterDataService.updateParameterDetails(parameterDetailsModel);

			log.info("[SUCCESS] [{}] - Parameter updated successfully | Status: {} | Message: {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {
			log.error(
					"[ERROR] [{}] - Exception occurred while updating parameter | DistrictCode: {} | CircleCode: {} | MauzaCode: {} | LotCode: {} | ParameterName: {} | Error: {}",
					methodName, parameterDetailsModel.getParameterName(), parameterDetailsModel.getParameterCode(),
					e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(String.format("An error occurred while updating Parameter '%s'. Reason: %s",
					parameterDetailsModel.getParameterName(), e.getLocalizedMessage()));
		}

		long endTime = System.currentTimeMillis();
		log.info("[END] [{}] - Completed in [{}] | Duration: {} ms | ParameterName: {}", methodName, className,
				(endTime - startTime), parameterDetailsModel.getParameterName());

		return response;
	}

	@PostMapping("/delete/parameter")
	public ResponseModel deleteParameterDetails(@RequestParam String parameterCode) {
		String methodName = "deleteParameterDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Delete Parameter Details | ParameterCode: {} | Method: {} | Class: {}", parameterCode,
					methodName, this.getClass().getSimpleName());

			response = masterDataService.deleteParameterDetails(parameterCode);

			log.info("Respond: Parameter deletion process completed | ParameterCode: {} | Method: {} | Class: {}",
					parameterCode, methodName, this.getClass().getSimpleName());

		} catch (Exception e) {
			log.error("Error while deleting Parameter Details | ParameterCode: {} | Method: {} | Class: {} | Error: {}",
					parameterCode, methodName, this.getClass().getSimpleName(), e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while deleting Parameter Details | ParameterCode: " + parameterCode
					+ ", error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/add/subParameter")
	public ResponseModel addSubParameterDetails(@RequestBody SubParameterDetailsModelRequest subParameterDetailsModel) {
		String methodName = "addSubParameterDetails";
		ResponseModel response = new ResponseModel();
		try {
			log.info(
					"Request: Adding SubParameter Details, SubParameter Name: {}, SubParameter Code: {} | Method: {} | Class: {}",
					subParameterDetailsModel.getSubParameterName(), subParameterDetailsModel.getParameterCode(),
					methodName, this.getClass().getSimpleName());

			response = masterDataService.addSubParameterDetails(subParameterDetailsModel);

		} catch (Exception e) {
			log.error(
					"Error while adding SubParameter Details, SubParameter Name: {}, SubParameter Code: {} | Method: {} | Class: {}",
					subParameterDetailsModel.getSubParameterName(), subParameterDetailsModel.getParameterCode(),
					methodName, this.getClass().getSimpleName(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to add SubParameter Details for SubParameter Name: "
					+ subParameterDetailsModel.getSubParameterName() + ", Parameter Code: "
					+ subParameterDetailsModel.getParameterCode() + ". Please try again later.");
		}
		return response;
	}

	@PostMapping("/update/subParameter")
	public ResponseModel updateSubParameterDetails(
			@RequestBody SubParameterDetailsModelUpdateRequest subParameterDetailsModel) {
		String methodName = "updateSubParameterDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info(
					"Request received to update SubParameter Details | SubParameter Name: {} | SubParameter Code: {} | Parameter Code: {} | Method: {} | Class: {}",
					subParameterDetailsModel.getSubParameterName(), subParameterDetailsModel.getSubParameterCode(),
					subParameterDetailsModel.getParameterCode(), subParameterDetailsModel.getWeightage(),
					subParameterDetailsModel.getEffectiveFrom(), methodName, this.getClass().getSimpleName());

			response = masterDataService.updateSubParameterDetails(subParameterDetailsModel);

			log.info(
					"SubParameter updated successfully | SubParameter Name: {} | SubParameter Code: {} | Parameter Code: {} | Method: {} | Class: {}",
					subParameterDetailsModel.getSubParameterName(), subParameterDetailsModel.getSubParameterCode(),
					subParameterDetailsModel.getParameterCode(), methodName, this.getClass().getSimpleName());

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

	@PostMapping("/delete/subParameter")
	public ResponseModel deleteSubParameterDetails(@RequestParam String subParameterCode) {
		String methodName = "deleteSubParameterDetails";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request received to delete SubParameter Details | SubParameter Code: {} | Method: {} | Class: {}",
					subParameterCode, methodName, this.getClass().getSimpleName());

			response = masterDataService.deleteSubParameterDetails(subParameterCode);

			log.info("SubParameter deleted successfully | SubParameter Code: {} | Method: {} | Class: {}",
					subParameterCode, methodName, this.getClass().getSimpleName());

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

	@PostMapping("/autoAddLots")
	public ResponseModel autoAddLots() {
		ResponseModel resp = new ResponseModel();

		try {
			masterDataService.autoCreateLotsForAllMouzas();
			resp.setHttpStatus(HttpStatus.OK);
			resp.setMessage("Lots created for all mouzas");

		} catch (Exception e) {
			resp.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			resp.setMessage("Error: " + e.getMessage());
		}
		return resp;
	}

	@PostMapping("/autoAddVillages")
	public ResponseModel autoAddVillages() {
		ResponseModel resp = new ResponseModel();

		try {
			masterDataService.autoCreateVillageForAllLots();
			resp.setHttpStatus(HttpStatus.OK);
			resp.setMessage("Village created for all Lots");

		} catch (Exception e) {
			resp.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			resp.setMessage("Error: " + e.getMessage());
		}
		return resp;
	}

}
