package com.areap2.excel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.excel.dto.SlabRequestDTO;
import com.areap2.excel.dto.SlabResponseDTO;
import com.areap2.excel.service.SlabService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/slabs")
public class SlabController {

	@Autowired
	private SlabService slabService;

	// =========================
	// CREATE SLAB
	// =========================
	@PostMapping("/create")
	public ResponseEntity<String> createSlab(@RequestBody SlabRequestDTO request) {

		log.info("START :: Create Slab API");
		log.info("Request Received :: District = {}, DistanceType = {}, CreatedBy = {}", request.getDistrict(),
				request.getDistanceTypeCode(), request.getCreatedBy());

		String response = slabService.applySlabFromJson(request);

		log.info("END :: Create Slab API :: Response = {}", response);

		return ResponseEntity.ok(response);
	}

	// =========================
	// GET ACTIVE SLABS
	// =========================
	@GetMapping("/getSlabs")
	public ResponseEntity<SlabResponseDTO> getSlabs(@RequestParam String district,
			@RequestParam String distanceTypeCode) {

		log.info("START :: Get Slabs API");
		log.info("Request Params :: District = {}, DistanceType = {}", district, distanceTypeCode);

		SlabResponseDTO response = slabService.getActiveSlabs(district, distanceTypeCode);

		log.info("END :: Get Slabs API :: Version = {}", response.getVersion());

		return ResponseEntity.ok(response);
	}
}