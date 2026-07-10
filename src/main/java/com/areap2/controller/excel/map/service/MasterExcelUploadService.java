package com.areap2.controller.excel.map.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.areap2.constant.ModelConstant;
import com.areap2.controller.excel.map.enity.LandDetailsInputEntity;
import com.areap2.controller.excel.map.enity.LandMasterOutputEntity;
import com.areap2.controller.excel.map.repo.LandDetailsInputRepository;
import com.areap2.controller.excel.map.repo.LandMasterOutputRepository;
import com.areap2.entity.DistrictDetails;
import com.areap2.model.ResponseModel;
import com.areap2.repository.DistrictDetailsRepo;

@Service
public class MasterExcelUploadService {

	@Autowired
	private DistrictDetailsRepo districtDetailsRepo;

	@Autowired
	private LandMasterOutputRepository landMasterOutputRepository;

	@Autowired
	private LandDetailsInputRepository landDetailsInputRepository;

	Logger log = LoggerFactory.getLogger(MasterExcelUploadService.class);

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

	public ResponseModel getCircleByDistrict(String district) {
		String methodName = "getCircleByDistrict";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding Circle By District  :  " + district + "  Method Name" + methodName + " Class : "
					+ this.getClass());

			String status = ModelConstant.COMPLETE;
			// Log repository invocation
			log.debug("PROCESSING | [{}] | Invoking repository: circleDetailsRepo.findCircleByDistrictAndActiveTrue",
					methodName);
			List<String> circleList = landMasterOutputRepository.findDistinctCircleByDistrict(district);
			if (circleList == null || circleList.isEmpty()) {
				log.info("Respond: No Data Found for Circle By District :  " + district + "  Method Name" + methodName
						+ " Class : " + this.getClass());
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(circleList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info("Respond : data Fetched successfully - Circle By District  : " + district + "  Method Name"
					+ methodName + " Class : " + this.getClass());
		} catch (Exception e) {
			log.error("An error occurred while Finding  Circle By District  : " + district + "  Method Name"
					+ methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(
					"An error occurred while Finding  Circle By District  ,error : " + e.getLocalizedMessage());
		}
		return response;

	}

	public ResponseModel getMouzaDetails(String district, String circle) {

		String methodName = "getMouzaDetails";
		ResponseModel response = new ResponseModel();

		try {

			if (district == null || district.trim().isBlank()) {

				log.info("Respond : Invalid Parameters | Method Name {} | Class : {}", methodName, this.getClass());

				response.setHttpStatus(HttpStatus.BAD_REQUEST);
				response.setMessage("Invalid Parameter");
				return response;
			}

			log.info("Request: Finding Mouza By District : {} and Circle : {} | Method Name {} | Class : {}", district,
					circle, methodName, this.getClass());

			log.debug(
					"PROCESSING | [{}] | Invoking repository: landMasterOutputRepository.findDistinctMouzaByDistrictAndCircle",
					methodName);

			List<String> mouzaList = landMasterOutputRepository.findDistinctMouzaCodeByDistrictAndCircle(district,
					circle);

			if (mouzaList == null || mouzaList.isEmpty()) {

				log.info(
						"Respond: No Data Found for Mouza By District : {} and Circle : {} | Method Name {} | Class : {}",
						district, circle, methodName, this.getClass());

				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(mouzaList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info(
					"Respond : Data Fetched Successfully - Mouza By District : {} and Circle : {} | Method Name {} | Class : {}",
					district, circle, methodName, this.getClass());

		} catch (Exception e) {

			log.error("An error occurred while Finding Mouza Details | Method Name {} | Class : {}", methodName,
					this.getClass(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding Mouza Details, error : " + e.getLocalizedMessage());
		}

		return response;
	}
	
	public ResponseModel getAllByDistrictAndCircle(String district, String circle) {

	    ResponseModel response = new ResponseModel();

	    try {

	        if (district == null || district.trim().isBlank()) {
	            response.setHttpStatus(HttpStatus.BAD_REQUEST);
	            response.setMessage("District is required");
	            return response;
	        }

	        List<LandMasterOutputEntity> list =
	                landMasterOutputRepository.findAllByDistrictAndCircle(district, circle);

	        if (list.isEmpty()) {
	            response.setHttpStatus(HttpStatus.NO_CONTENT);
	            response.setMessage("No Data Found");
	            return response;
	        }

	        response.setData(list);
	        response.setHttpStatus(HttpStatus.OK);
	        response.setMessage("Data Fetched Successfully");

	    } catch (Exception e) {

	        response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
	        response.setMessage(e.getLocalizedMessage());
	    }

	    return response;
	}

	public ResponseModel getLotByDistrictAndCircleAndMouza(String district, String circle, String mouza) {

		String methodName = "getLotByDistrictAndCircleAndMouza";
		ResponseModel response = new ResponseModel();

		try {

			if (district == null || district.trim().isBlank() || circle == null || circle.trim().isBlank()
					|| mouza == null || mouza.trim().isBlank()) {

				log.info("Respond : Invalid Parameters | Method Name {} | Class : {}", methodName, this.getClass());

				response.setHttpStatus(HttpStatus.BAD_REQUEST);
				response.setMessage("Invalid Parameter");
				return response;
			}

			log.info("Request: Finding Lot By District : {} | Circle : {} | Mouza : {} | Method Name {} | Class : {}",
					district, circle, mouza, methodName, this.getClass());

			log.debug(
					"PROCESSING | [{}] | Invoking repository: landMasterOutputRepository.findDistinctLotByDistrictAndCircleAndMouza",
					methodName);

			List<String> lotList = landMasterOutputRepository.findDistinctLotByDistrictAndCircleAndMouza(district,
					circle, mouza);

			if (lotList == null || lotList.isEmpty()) {

				log.info(
						"Respond: No Data Found for District : {} | Circle : {} | Mouza : {} | Method Name {} | Class : {}",
						district, circle, mouza, methodName, this.getClass());

				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(lotList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info(
					"Respond : Data Fetched Successfully - District : {} | Circle : {} | Mouza : {} | Method Name {} | Class : {}",
					district, circle, mouza, methodName, this.getClass());

		} catch (Exception e) {

			log.error("An error occurred while Finding Lot Details | Method Name {} | Class : {}", methodName,
					this.getClass(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding Lot Details, error : " + e.getLocalizedMessage());
		}

		return response;
	}

	public ResponseModel getVillageByDistrictAndCircleAndmouzaAndLot(String district, String circle, String mouza,
			String lot) {

		String methodName = "getVillageByDistrictAndCircleAndmouzaAndLot";
		ResponseModel response = new ResponseModel();

		try {

			if (district == null || district.trim().isBlank() || circle == null || circle.trim().isBlank()
					|| mouza == null || mouza.trim().isBlank() || lot == null || lot.trim().isBlank()) {

				log.info("Respond : Invalid Parameters | Method Name {} | Class : {}", methodName, this.getClass());

				response.setHttpStatus(HttpStatus.BAD_REQUEST);
				response.setMessage("Invalid Parameter");
				return response;
			}

			log.info(
					"Request: Finding Village By District : {} | Circle : {} | Mouza : {} | Lot : {} | Method Name {} | Class : {}",
					district, circle, mouza, lot, methodName, this.getClass());

			log.debug(
					"PROCESSING | [{}] | Invoking repository: landMasterOutputRepository.findDistinctVillageByDistrictAndCircleAndMouzaAndLot",
					methodName);

			List<String> villageList = landMasterOutputRepository
					.findDistinctVillageByDistrictAndCircleAndMouzaAndLot(district, circle, mouza, lot);

			if (villageList == null || villageList.isEmpty()) {

				log.info(
						"Respond: No Data Found for District : {} | Circle : {} | Mouza : {} | Lot : {} | Method Name {} | Class : {}",
						district, circle, mouza, lot, methodName, this.getClass());

				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");
				return response;
			}

			response.setData(villageList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");

			log.info(
					"Respond : Data Fetched Successfully - District : {} | Circle : {} | Mouza : {} | Lot : {} | Method Name {} | Class : {}",
					district, circle, mouza, lot, methodName, this.getClass());

		} catch (Exception e) {

			log.error("An error occurred while Finding Village Details | Method Name {} | Class : {}", methodName,
					this.getClass(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding Village Details, error : " + e.getLocalizedMessage());
		}

		return response;
	}

	public ResponseModel getPlotByDistrictAndCircleAndMouzaAndLotAndVillage(String district, String circle,
			String mouza, String lot, String village) {

		final String methodName = "getPlotByDistrictAndCircleAndMouzaAndLotAndVillage";
		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Fetching plot details | District: {} | Circle: {} | Mouza: {} | Lot: {} | Village: {}",
				methodName, district, circle, mouza, lot, village);

		try {

			List<String> plotList = landMasterOutputRepository
					.findPlotByDistrictAndCircleAndMouzaAndLotAndVillage(district, circle, mouza, lot, village);

			response.setData(plotList);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Plot details fetched successfully.");

			log.info("[SUCCESS] [{}] - Total Plots Found: {}", methodName, plotList.size());

		} catch (Exception e) {

			log.error(
					"[ERROR] [{}] - Error while fetching plot details | District: {} | Circle: {} | Mouza: {} | Lot: {} | Village: {} | Error: {}",
					methodName, district, circle, mouza, lot, village, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to fetch plot details. " + e.getLocalizedMessage());
		}

		log.info("[END] [{}] - Completed", methodName);

		return response;
	}

	public ResponseModel getLandDetailsByDistrictAndCircleAndMouzaAndLotAndVillageAndPlot(String district,
			String circle, String mouza, String lot, String village, String plot) {

		final String methodName = "getLandDetailsByDistrictAndCircleAndMouzaAndLotAndVillageAndPlot";

		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Fetching land details", methodName);

		try {

			// Existing query
			List<LandMasterOutputEntity> landDetails = landMasterOutputRepository
					.findLandDetailsByDistrictAndCircleAndMouzaAndLotAndVillageAndPlot(district, circle, mouza, lot,
							village, plot);

			log.info("[{}] LandMasterOutput Records Found : {}", methodName, landDetails.size());

			// Fetch landArea from input table
			List<LandDetailsInputEntity> inputEntities = landDetailsInputRepository
					.findByDistAndCircleAndMouzaAndLotAndVillageAndTextparcel(district, circle, mouza, lot, village,
							plot);

			if (inputEntities != null && !inputEntities.isEmpty()) {

				if (inputEntities.size() > 1) {

					log.warn(
							"[{}] Duplicate LandDetailsInputEntity found for District={}, Circle={}, Mouza={}, Lot={}, Village={}, Plot={}. Total Records={}. Using the first record.",
							methodName, district, circle, mouza, lot, village, plot, inputEntities.size());
				}

				String landArea = inputEntities.get(0).getLandArea();

				if (landArea != null) {

					landDetails.forEach(entity -> entity.setLandArea(landArea));

					log.info("[{}] landArea [{}] mapped successfully.", methodName, landArea);
				}

			} else {

				log.warn(
						"[{}] No matching LandDetailsInputEntity found for District={}, Circle={}, Mouza={}, Lot={}, Village={}, Plot={}",
						methodName, district, circle, mouza, lot, village, plot);
			}

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Data Fetched Successfully");
			response.setData(landDetails);

			log.info("[SUCCESS] [{}] - Total Records Returned : {}", methodName, landDetails.size());

		} catch (Exception ex) {

			log.error("[ERROR] [{}] - {}", methodName, ex.getMessage(), ex);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(ex.getLocalizedMessage());
		}

		log.info("[END] [{}] - Completed", methodName);

		return response;
	} // ----------------------------//---------------------//

	public ResponseModel getAllLandDetails() {

		ResponseModel response = new ResponseModel();

		try {

			List<LandMasterOutputEntity> list = landMasterOutputRepository.findAll();

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Land details fetched successfully.");
			response.setData(list);

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	public ResponseModel getAllLandDetailsByDistrictAndCircle(String district,String circle) {

		ResponseModel response = new ResponseModel();

		try {

			List<LandMasterOutputEntity> list = landMasterOutputRepository.findByDistrictAndCircle(district,circle);

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Land details fetched successfully.");
			response.setData(list);

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	public ResponseModel getAllLandDetailsPagination(Integer page, Integer size) {

		ResponseModel response = new ResponseModel();

		try {

			Pageable pageable = PageRequest.of(page, size);

			Page<LandMasterOutputEntity> pageData = landMasterOutputRepository.findAll(pageable);

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Land details fetched successfully.");
			response.setData(pageData);

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getMessage());
		}

		return response;
	}
}
