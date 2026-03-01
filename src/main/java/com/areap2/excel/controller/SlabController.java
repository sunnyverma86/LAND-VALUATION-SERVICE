package com.areap2.excel.controller;

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

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/slabs")
@RequiredArgsConstructor
public class SlabController {

	private final SlabService slabService;

	// ==========================================================
	// CREATE SLAB
	// ==========================================================
	@PostMapping("/create")
	public ResponseEntity<String> createSlab(@RequestBody SlabRequestDTO request) {

		log.info("=======================================================================");
		log.info("START :: Create Slab API");

		if (request == null) {
			log.error("Request body is null");
			return ResponseEntity.badRequest().body("Request body cannot be null");
		}

		log.info(
				"Request Summary :: District = {}, DistanceType = {}, ParameterName = {}, CreatedBy = {}, AreaType = {}, Perpetual = {}, Band = {}",
				request.getDistrict(), request.getDistanceTypeCode(), request.getParameterName(),
				request.getCreatedBy(), request.getAreaType(), request.getPerpetual(), request.getBand());

		if (request.getSlabs() != null && !request.getSlabs().isEmpty()) {

			log.info("Total Slabs Received :: {}", request.getSlabs().size());

			request.getSlabs().forEach(slab -> log.info("Slab Detail :: Min = {}, Max = {}, Price = {}",
					slab.getMinValue(), slab.getMaxValue(), slab.getPriceValue()));

		} else {
			log.warn("No Slabs Received in Request");
		}

		String response = slabService.applySlabFromJson(request);

		log.info("END :: Create Slab API :: Response = {}", response);
		log.info("=======================================================================");

		return ResponseEntity.ok(response);
	}

	// ==========================================================
	// GET ACTIVE SLABS
	// ==========================================================
	@GetMapping("/active")
	public ResponseEntity<SlabResponseDTO> getActiveSlabs(@RequestParam String district,
			@RequestParam String distanceTypeCode) {

		log.info("=======================================================================");
		log.info("START :: Get Active Slabs API");
		log.info("Request Params :: District = {}, DistanceType = {}", district, distanceTypeCode);

		SlabResponseDTO response = slabService.getActiveSlabs(district, distanceTypeCode);

		if (response == null) {
			log.warn("No active slabs found for District = {} and DistanceType = {}", district, distanceTypeCode);
			return ResponseEntity.noContent().build();
		}

		log.info("END :: Get Active Slabs API :: Version = {}", response.getVersion());
		log.info("=======================================================================");

		return ResponseEntity.ok(response);
	}
}