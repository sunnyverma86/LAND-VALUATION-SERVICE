package com.areap2.controller.excel;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.dto.excel.SlabRequestDTO;
import com.areap2.entity.excel.external.SlabGroup;
import com.areap2.model.ResponseModel;
import com.areap2.service.excel.SlabService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/slab")
@RequiredArgsConstructor

public class SlabController {

	private static final Logger log = LoggerFactory.getLogger(SlabController.class);

	@Autowired
	private SlabService slabService;

	// ============================================================
	// 1️⃣ CREATE SLAB
	// ============================================================
	@PostMapping("/create")
	public ResponseEntity<ResponseModel> createSlab(@RequestBody SlabRequestDTO request) {

		log.info("API Call: Create Slab | District: {}", request.getDistrict());

		ResponseModel response = slabService.createSlab(request);

		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}

	// ============================================================
	// 2️⃣ APPROVE / REJECT SLAB
	// ============================================================
	@PutMapping("/approve/{slabGroupId}")
	public ResponseEntity<ResponseModel> approveSlab(@PathVariable Long slabGroupId, @RequestParam boolean approve) {

		log.info("API Call: Approve Slab | Slab ID: {} | Approve: {}", slabGroupId, approve);

		ResponseModel response = slabService.approveSlab(slabGroupId, approve);

		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}

	// ============================================================
	// 3️⃣ REVERT VERSION
	// ============================================================
	@PutMapping("/revert/{slabGroupId}")
	public ResponseEntity<ResponseModel> revertVersion(@PathVariable Long slabGroupId) {

		log.info("API Call: Revert Slab Version | Slab ID: {}", slabGroupId);

		ResponseModel response = slabService.revertVersion(slabGroupId);

		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}

	// ============================================================
	// 4️⃣ GET ACTIVE SLAB
	// ============================================================
	@GetMapping("/active")
	public ResponseEntity<ResponseModel> getActiveSlab(@RequestParam String district,
			@RequestParam String distanceTypeCode) {

		log.info("API Call: Get Active Slab | District: {} | Type: {}", district, distanceTypeCode);

		ResponseModel response = slabService.getActiveSlabs(district, distanceTypeCode);

		return ResponseEntity.ok(response);
	}

	// ============================================================
	// 5️⃣ GET SLAB HISTORY
	// ============================================================
	@GetMapping("/history")
	public ResponseEntity<List<SlabGroup>> getHistory(@RequestParam String district,
			@RequestParam String distanceTypeCode) {

		log.info("API Call: Get Slab History | District: {} | Type: {}", district, distanceTypeCode);

		List<SlabGroup> history = slabService.getHistory(district, distanceTypeCode);

		return ResponseEntity.ok(history);
	}
}