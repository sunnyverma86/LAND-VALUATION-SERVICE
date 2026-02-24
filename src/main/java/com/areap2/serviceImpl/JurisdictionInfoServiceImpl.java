package com.areap2.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.areap2.entity.StampDutyCalculation;
import com.areap2.model.ParamsJurisdictionModel;
import com.areap2.model.ResponseModel;
import com.areap2.service.JurisdictionInfoService;

@Service
public class JurisdictionInfoServiceImpl extends AbstractMasterRepository implements JurisdictionInfoService {

	Logger log = LoggerFactory.getLogger(JurisdictionInfoServiceImpl.class);

	@Override
	public ResponseModel getBasePrice(ParamsJurisdictionModel params) {
		String methodName = "getBasePrice";
		ResponseModel response = new ResponseModel();
		Map<String, Object> map = new HashMap<>();
		Long result = 0L;

		try {
			log.info("Request: Finding BasePrice by params : " + params + " Method Name: " + methodName + " Class: "
					+ this.getClass());

			result = procedureRepo.fetchBasePrice(params.getMouzaCode(), params.getPlot(), null);

			if (result != null && result != 0L) {
				map.put("baseprice", result);
				response.setData(map);
				response.setHttpStatus(HttpStatus.OK);
				response.setMessage("Data Fetched Successfully");

				log.info("Respond: data fetched successfully BasePrice by params: " + params + " Method Name: "
						+ methodName + " Class: " + this.getClass());
			} else {
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");

				log.info("Respond: No Data Found - BasePrice by params: " + params + " Method Name: " + methodName
						+ " Class: " + this.getClass());
			}

		} catch (Exception e) {
			log.error("An error occurred while Finding BasePrice by params: " + params + " Method Name: " + methodName
					+ " Class: " + this.getClass(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding BasePrice, error: " + e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	public ResponseModel getStampDuty(Long stampDutyGenid) {
		String methodName = "getStampDuty";
		ResponseModel response = new ResponseModel();

		try {
			log.info("Request: Finding Stamp Duty by StampDutyGenid : {} | Method: {} | Class: {}", stampDutyGenid,
					methodName, this.getClass());

			Optional<StampDutyCalculation> optionalResult = stampDutyCalculationRepo.findById(stampDutyGenid);

			if (optionalResult.isPresent()) {
				StampDutyCalculation entity = optionalResult.get();

				// assuming entity has a field called basePrice

				response.setData(entity);
				response.setHttpStatus(HttpStatus.OK);
				response.setMessage("Data Fetched Successfully");

				log.info("Respond: data fetched successfully | StampDutyGenid: {} | Method: {} | Class: {}",
						stampDutyGenid, methodName, this.getClass());
			} else {
				response.setHttpStatus(HttpStatus.NO_CONTENT);
				response.setMessage("No Data Found");

				log.info("Respond: No Data Found | StampDutyGenid: {} | Method: {} | Class: {}", stampDutyGenid,
						methodName, this.getClass());
			}

		} catch (Exception e) {
			log.error("An error occurred while Finding BasePrice | StampDutyGenid: {} | Method: {} | Class: {}",
					stampDutyGenid, methodName, this.getClass(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding BasePrice, error: " + e.getLocalizedMessage());
		}

		return response;
	}
}
