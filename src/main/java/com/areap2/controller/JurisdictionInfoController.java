package com.areap2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.dto.excel.SelectionRequest;
import com.areap2.dto.excel.SelectionResponse;
import com.areap2.entity.Instrument;
import com.areap2.model.ParamsJurisdictionModel;
import com.areap2.model.ResponseModel;
import com.areap2.service.JurisdictionInfoService;
import com.areap2.serviceImpl.StampDutyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jurisdictionInfo")
@CrossOrigin
public class JurisdictionInfoController {

	@Autowired
	private JurisdictionInfoService jurisdictionInfoService;

	@Autowired
	private StampDutyService stampDutyService;;

	Logger log = LoggerFactory.getLogger(JurisdictionInfoController.class);

	@PostMapping("/getBasePrice")
	public ResponseModel getBasePrice(@RequestBody ParamsJurisdictionModel params) {
		String methodName = "getBasePrice";
		ResponseModel response = new ResponseModel();
		try {
			log.info("Request: Finding BasePrice by params : " + params + "  Method Name" + methodName + " Class : "
					+ this.getClass());

			response = jurisdictionInfoService.getBasePrice(params);

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

			response = jurisdictionInfoService.getStampDuty(stampDutyGenid);

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

	@GetMapping("/instruments")
	public ResponseEntity<List<Instrument>> getInstruments() {
		return ResponseEntity.ok(stampDutyService.listInstruments());
	}

	@PostMapping("/selections")
	public ResponseEntity<List<SelectionResponse>> saveSelections(@RequestBody @Valid List<SelectionRequest> requests) {
		List<SelectionResponse> saved = stampDutyService.saveSelections(requests);
		return ResponseEntity.ok(saved);
	}

}
