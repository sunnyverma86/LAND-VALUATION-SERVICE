package com.areap2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.model.ParamsJurisdictionModel;
import com.areap2.model.ResponseModel;
import com.areap2.service.JurisdictionInfoService;

@RestController
@RequestMapping("/jurisdictionInfo")
@CrossOrigin
public class JurisdictionInfoController {

	@Autowired
	private JurisdictionInfoService service;

	Logger log = LoggerFactory.getLogger(JurisdictionInfoController.class);

	@PostMapping("/getBasePrice")
	public ResponseModel getBasePrice(@RequestBody ParamsJurisdictionModel params) {
		String methodName = "getBasePrice";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding BasePrice by params : " + params + "  Method Name" + methodName + " Class : "
					+ this.getClass());

			response = service.getBasePrice(params);

		} catch (Exception e) {
			log.error("An error occurred while Finding  BasePrice by params :  " + params + "  Method Name" + methodName
					+ " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred while Finding BasePrice ,error : " + e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/getStampDuty")
	public ResponseModel getStampDutyAll(@RequestParam Long stampDutyGenid) {
		String methodName = "getStampDuty";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding Stamp Duty by stamp Duty Gen id : " + stampDutyGenid + "  Method Name"
					+ methodName + " Class : " + this.getClass());

			response = service.getStampDuty(stampDutyGenid);

		} catch (Exception e) {
			log.error("An error occurred while Finding Stamp Duty by stamp Duty Gen id :  " + stampDutyGenid
					+ "  Method Name" + methodName + " Class : " + this.getClass());
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("An error occurred whileFinding Stamp Duty by stamp Duty Gen Id ,error : "
					+ e.getLocalizedMessage());
		}

		return response;
	}
}
