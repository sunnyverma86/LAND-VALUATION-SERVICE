package com.areap2.controller.historical;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.dto.historical.HistoricalTableResponse;
import com.areap2.service.historical.HistoricalLandOutputServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HistoricalLandOutputController {

	@Autowired
	private HistoricalLandOutputServiceImpl service;

	@GetMapping("/historical-land-output/tables")
	public ResponseEntity<List<HistoricalTableResponse>> tables() {
		String loginId = "ashwini";
		return ResponseEntity.ok(service.tablesForLogin(loginId));
	}

	@GetMapping("/historical-land-output/data")
	public ResponseEntity<List<Map<String, Object>>> getData(

			@RequestParam String qualifiedName,

			@RequestParam(required = false) String district,

			@RequestParam(required = false) String circle) {

		return ResponseEntity.ok(service.findData(qualifiedName, district, circle));
	}

	@GetMapping("/historical-land-output/data/mouza")
	public ResponseEntity<List<Map<String, Object>>> getDataByMouza(@RequestParam String qualifiedName,
			@RequestParam(required = false) String district, @RequestParam(required = false) String circle,
			@RequestParam(required = false) String mouzaCode) {
		return ResponseEntity.ok(service.findData(qualifiedName, district, circle, mouzaCode));
	}

	@GetMapping("/new-land-output/data")
	public ResponseEntity<List<Map<String, Object>>> getDataNew(@RequestParam(required = false) String district,
			@RequestParam(required = false) String circle) {
		String qualifiedName = "kau.land_master_output";
		return ResponseEntity.ok(service.findData(qualifiedName, district, circle));
	}
	
	@GetMapping("/new-land-output/data/mouza")
	public ResponseEntity<List<Map<String, Object>>> getDataNewByMouza(
			@RequestParam(required = false) String district, @RequestParam(required = false) String circle,
			@RequestParam(required = false) String mouzaCode) {
		String qualifiedName = "kau.land_master_output";
		return ResponseEntity.ok(service.findData(qualifiedName, district, circle, mouzaCode));
	}
	

}
