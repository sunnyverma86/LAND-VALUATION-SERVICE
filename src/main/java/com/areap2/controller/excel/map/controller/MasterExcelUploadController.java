package com.areap2.controller.excel.map.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.controller.MasterDataController;
import com.areap2.controller.excel.map.service.MasterExcelUploadService;
import com.areap2.model.ResponseModel;

@RestController
@RequestMapping("/masterData")
public class MasterExcelUploadController {

	@Autowired
	private MasterExcelUploadService masterExcelUploadService;

	Logger log = LoggerFactory.getLogger(MasterDataController.class);

	@GetMapping("/getAllDistrictDetails")
	public ResponseModel getAllDistrictDetails() {
		String methodName = "getAllDistrictDetails";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}]", methodName, this.getClass().getSimpleName());

		try {
			log.info("Fetching all district details from MasterDataService...");

			response = masterExcelUploadService.getAllDistrictDetails();

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
	public ResponseModel getCircleByDistrict(@RequestParam String district) {
		String methodName = "getCircleByDistrict";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}] with district: {}", methodName, this.getClass().getSimpleName(), district);

		try {
			log.info("Fetching circle details for district: {}", district);

			response = masterExcelUploadService.getCircleByDistrict(district);

			log.info("Successfully retrieved circle details for district: {}. Response status: {}", district,
					response.getHttpStatus());

		} catch (Exception e) {
			log.error("Exception in [{}] of class [{}] while fetching circle details for district: {}. Error: {}",
					methodName, this.getClass().getSimpleName(), district, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch circle details for district: " + district + ". Reason: "
					+ e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}] with district: {}", methodName, this.getClass().getSimpleName(), district);

		return response;
	}

	@GetMapping("/getMouzaDetailsByDistrictAndCircle")
	public ResponseModel getMouzaDetailsByDistrictAndCircle(@RequestParam(required = true) String district,
			@RequestParam(required = false) String circle) {
		String methodName = "getMouzaDetails";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}] with district: {}, circle: {}", methodName,
				this.getClass().getSimpleName(), district, circle);

		try {
			log.info("Fetching Mouza details for district: {} and circle: {}", district, circle);

			response = masterExcelUploadService.getMouzaDetails(district, circle);

			log.info("Successfully retrieved Mouza details for district: {}, circle: {}. Response status: {}", district,
					circle, response.getHttpStatus());

		} catch (Exception e) {
			log.error(
					"Exception in [{}] of class [{}] while fetching Mouza details for district: {}, circle: {}. Error: {}",
					methodName, this.getClass().getSimpleName(), district, circle, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch Mouza details for district: " + district + ", circle: " + circle
					+ ". Reason: " + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}] with districtCode: {}, circleCode: {}", methodName,
				this.getClass().getSimpleName(), district, circle);

		return response;
	}

	@GetMapping("/getAllByDistrictAndCircle")
	public ResponseModel getAllByDistrictAndCircle(@RequestParam String district,
			@RequestParam(required = false) String circle) {

		return masterExcelUploadService.getAllByDistrictAndCircle(district, circle);
	}

	@GetMapping("/getLotByDistrictAndCircleAndMouza")
	public ResponseModel getLotByDistrictAndCircleAndMouza(@RequestParam String district, @RequestParam String circle,
			@RequestParam String mouza) {
		String methodName = "getLotByDistrictAndCircle";
		ResponseModel response = new ResponseModel();

		log.info("START - [{}] in class [{}] with district: {}, circle: {}", methodName,
				this.getClass().getSimpleName(), district, circle, mouza);

		try {
			log.info("Fetching lot details for district: {} and circle: {}", district, circle);

			response = masterExcelUploadService.getLotByDistrictAndCircleAndMouza(district, circle, mouza);

			log.info("Successfully retrieved lot details for district: {}, circle: {}. Response status: {}", district,
					circle, response.getHttpStatus());

		} catch (Exception e) {
			log.error(
					"Exception in [{}] of class [{}] while fetching lot details for district: {}, circle: {}. Error: {}",
					methodName, this.getClass().getSimpleName(), district, circle, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch lot details for district: " + district + ", circle: " + circle
					+ ". Reason: " + e.getLocalizedMessage());
		}

		log.info("END - [{}] in class [{}] with district: {}, circle: {}", methodName, this.getClass().getSimpleName(),
				district, circle);

		return response;
	}

	@GetMapping("/getVillageByDistrictAndCircleAndmouzaAndLot")
	public ResponseModel getVillageByDistrictAndCircleAndmouzaAndLot(@RequestParam String district,
			@RequestParam String circle, @RequestParam String mouza, @RequestParam String lot) {

		final String methodName = "getVillageByDistrictAndCircleAndmouzaAndLot";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}] | District: {} | Circle: {} | mouza: {} | Lot: {}", methodName,
				className, district, circle, mouza, lot);

		long startTime = System.currentTimeMillis();

		try {
			log.debug(
					"[PROCESS] [{}] - Fetching village details from service layer | Params: district={}, circle={}, mouza={}, lot={}",
					methodName, district, circle, mouza, lot);

			response = masterExcelUploadService.getVillageByDistrictAndCircleAndmouzaAndLot(district, circle, mouza,
					lot);

			log.info("[SUCCESS] [{}] - Village details fetched successfully | Status: {} | Message: {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {
			log.error(
					"[ERROR] [{}] - Exception occurred in [{}] | District: {} | Circle: {} | mouza: {} | Lot: {} | Error: {}",
					methodName, className, district, circle, mouza, lot, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(String.format(
					"Failed to fetch village details for District: %s, Circle: %s, mouza: %s, Lot: %s. Reason: %s",
					district, circle, mouza, lot, e.getLocalizedMessage()));
		}

		long endTime = System.currentTimeMillis();
		log.info("[END] [{}] - Completed in [{}] | Duration: {} ms | District: {} | Circle: {} | mouza: {} | Lot: {}",
				methodName, className, (endTime - startTime), district, circle, mouza, lot);

		return response;
	}

	@GetMapping("/getPlotByDistrictAndCircleAndMouzaAndLotAndVillage")
	public ResponseModel getPlotByDistrictAndCircleAndMouzaAndLotAndVillage(@RequestParam String district,
			@RequestParam String circle, @RequestParam String mouza, @RequestParam String lot,
			@RequestParam String village) {

		final String methodName = "getPlotByDistrictAndCircleAndMouzaAndLotAndVillage";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}] | District: {} | Circle: {} | Mouza: {} | Lot: {} | Village: {}",
				methodName, className, district, circle, mouza, lot, village);

		long startTime = System.currentTimeMillis();

		try {

			log.debug(
					"[PROCESS] [{}] - Fetching plot details from service layer | Params: district={}, circle={}, mouza={}, lot={}, village={}",
					methodName, district, circle, mouza, lot, village);

			response = masterExcelUploadService.getPlotByDistrictAndCircleAndMouzaAndLotAndVillage(district, circle,
					mouza, lot, village);

			log.info("[SUCCESS] [{}] - Plot details fetched successfully | Status: {} | Message: {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {

			log.error(
					"[ERROR] [{}] - Exception occurred in [{}] | District: {} | Circle: {} | Mouza: {} | Lot: {} | Village: {} | Error: {}",
					methodName, className, district, circle, mouza, lot, village, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(String.format(
					"Failed to fetch plot details for District: %s, Circle: %s, Mouza: %s, Lot: %s, Village: %s. Reason: %s",
					district, circle, mouza, lot, village, e.getLocalizedMessage()));
		}

		long endTime = System.currentTimeMillis();

		log.info(
				"[END] [{}] - Completed in [{}] | Duration: {} ms | District: {} | Circle: {} | Mouza: {} | Lot: {} | Village: {}",
				methodName, className, (endTime - startTime), district, circle, mouza, lot, village);

		return response;
	}

	@GetMapping("/getLandDetailsByDistrictAndCircleAndMouzaAndLotAndVillageAndPlot")
	public ResponseModel getLandDetailsByDistrictAndCircleAndMouzaAndLotAndVillageAndPlot(@RequestParam String district,
			@RequestParam String circle, @RequestParam String mouza, @RequestParam String lot,
			@RequestParam String village, @RequestParam String plot) {

		final String methodName = "getLandDetailsByDistrictAndCircleAndMouzaAndLotAndVillageAndPlot";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info(
				"[START] [{}] - Invoked in [{}] | District: {} | Circle: {} | Mouza: {} | Lot: {} | Village: {} | Plot: {}",
				methodName, className, district, circle, mouza, lot, village, plot);

		long startTime = System.currentTimeMillis();

		try {

			log.debug(
					"[PROCESS] [{}] - Fetching land details from service layer | Params: district={}, circle={}, mouza={}, lot={}, village={}, plot={}",
					methodName, district, circle, mouza, lot, village, plot);

			response = masterExcelUploadService.getLandDetailsByDistrictAndCircleAndMouzaAndLotAndVillageAndPlot(
					district, circle, mouza, lot, village, plot);

			log.info("[SUCCESS] [{}] - Land details fetched successfully | Status: {} | Message: {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {

			log.error(
					"[ERROR] [{}] - Exception occurred in [{}] | District: {} | Circle: {} | Mouza: {} | Lot: {} | Village: {} | Plot: {} | Error: {}",
					methodName, className, district, circle, mouza, lot, village, plot, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(String.format(
					"Failed to fetch land details for District: %s, Circle: %s, Mouza: %s, Lot: %s, Village: %s, Plot: %s. Reason: %s",
					district, circle, mouza, lot, village, plot, e.getLocalizedMessage()));
		}

		long endTime = System.currentTimeMillis();

		log.info("[END] [{}] - Completed in [{}] | Duration: {} ms", methodName, className, (endTime - startTime));

		return response;
	}

	@GetMapping("/getAllLandDetails")
	public ResponseModel getAllLandDetails() {

		final String methodName = "getAllLandDetails";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}]", methodName, className);

		long startTime = System.currentTimeMillis();

		try {

			log.debug("[PROCESS] [{}] - Fetching all land details", methodName);

			response = masterExcelUploadService.getAllLandDetails();

			log.info("[SUCCESS] [{}] - Records fetched successfully | Status: {} | Message: {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] - Exception occurred in [{}] | Error: {}", methodName, className, e.getMessage(),
					e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch land details. Reason : " + e.getLocalizedMessage());
		}

		long endTime = System.currentTimeMillis();

		log.info("[END] [{}] - Completed in [{}] | Duration: {} ms", methodName, className, (endTime - startTime));

		return response;
	}

	@GetMapping("/getAllLandDetailsByDistrict")
	public ResponseModel getAllLandDetailsByDistrict(@RequestParam String district, @RequestParam String circle) {

		final String methodName = "getAllLandDetailsByDistrict";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}] | District : {}", methodName, className, district);

		long startTime = System.currentTimeMillis();

		try {

			log.debug("[PROCESS] [{}] - Fetching land details for District : {}", methodName, district);

			response = masterExcelUploadService.getAllLandDetailsByDistrictAndCircle(district, circle);

			log.info("[SUCCESS] [{}] - Records fetched successfully | Status: {} | Message: {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] - Exception occurred in [{}] | District : {} | Error : {}", methodName, className,
					district, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch land details. Reason : " + e.getLocalizedMessage());
		}

		long endTime = System.currentTimeMillis();

		log.info("[END] [{}] - Completed in [{}] | Duration : {} ms", methodName, className, (endTime - startTime));

		return response;
	}

	@GetMapping("/getAllLandDetailsPagination")
	public ResponseModel getAllLandDetailsPagination(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {

		final String methodName = "getAllLandDetailsPagination";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}] | Page : {} | Size : {}", methodName, className, page, size);

		long startTime = System.currentTimeMillis();

		try {

			log.debug("[PROCESS] [{}] - Fetching paginated land details", methodName);

			response = masterExcelUploadService.getAllLandDetailsPagination(page, size);

			log.info("[SUCCESS] [{}] - Records fetched successfully | Status : {} | Message : {}", methodName,
					response.getHttpStatus(), response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] - Exception occurred in [{}] | Error : {}", methodName, className, e.getMessage(),
					e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch paginated land details. Reason : " + e.getLocalizedMessage());
		}

		long endTime = System.currentTimeMillis();

		log.info("[END] [{}] - Completed in [{}] | Duration : {} ms", methodName, className, (endTime - startTime));

		return response;
	}
	
	
}
