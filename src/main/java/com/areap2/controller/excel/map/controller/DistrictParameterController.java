package com.areap2.controller.excel.map.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.controller.excel.map.bean.DistrictParameterRequest;
import com.areap2.controller.excel.map.enity.band.DistrictParameterMaster;
import com.areap2.controller.excel.map.service.DistrictParameterServiceImpl;
import com.areap2.controller.excel.map.service.LandOutputService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/district-parameter")

public class DistrictParameterController {

	Logger log = LoggerFactory.getLogger(DistrictParameterController.class);

	@Autowired
	private DistrictParameterServiceImpl service;

	@Autowired
	private LandOutputService landOutputService;

	@PostMapping("/band-parameter-save")
	public ResponseEntity<String> saveBandParameter(@RequestBody DistrictParameterRequest request) {

		log.info("Received save request for district={}", request.getDistrict());

		service.save(request);

		return ResponseEntity.ok("Saved Successfully");
	}

	@PostMapping("/band-parameter-save-bulk")
	public ResponseEntity<String> saveAllBandParameter(@RequestBody List<DistrictParameterRequest> requests) {

		service.saveAll(requests);
		return ResponseEntity.ok("Saved Successfully");
	}

	@PutMapping("band-parameter-update/{id}")
	public ResponseEntity<String> updateBandParameter(@PathVariable Long id, @RequestBody DistrictParameterRequest request) {

		service.update(id, request);
		landOutputService.generateOutputTable();

		return ResponseEntity.ok("Updated Successfully");
	}

	@GetMapping("band-parameter-get-all/{district}")
	public ResponseEntity<List<DistrictParameterMaster>> getBandParameter(@PathVariable String district) {

		return ResponseEntity.ok(service.getDistrict(district));
	}
	
	@GetMapping("dq/{district}")
	public ResponseEntity<List<DistrictParameterMaster>> getBandParameterN(@PathVariable String district) {

		return ResponseEntity.ok(service.getDistrict(district));
	}
	
	
	
}
