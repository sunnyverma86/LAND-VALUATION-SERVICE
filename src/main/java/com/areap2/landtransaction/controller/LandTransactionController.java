package com.areap2.landtransaction.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.areap2.landtransaction.dto.ApiResponse;
import com.areap2.landtransaction.dto.ExcelUploadResponse;
import com.areap2.landtransaction.dto.LandTransactionRequest;
import com.areap2.landtransaction.dto.LandTransactionResponse;
import com.areap2.landtransaction.dto.PageResponse;
import com.areap2.landtransaction.entity.LandTransaction;
import com.areap2.landtransaction.service.LandTransactionService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/land-transactions")
@Validated
public class LandTransactionController {

	private final LandTransactionService service;

	private static final class SetOfSortFields {
		private static final java.util.Set<String> ALLOWED = java.util.Set.of("id", "district", "circle", "mouza",
				"lot", "village", "dagNo", "nicCode", "considerationValue", "transactionDate", "createdAt");
	}

	public LandTransactionController(LandTransactionService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<LandTransactionResponse> create(@Valid @RequestBody LandTransactionRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
	}

	@GetMapping("/{id}")
	public ResponseEntity<LandTransactionResponse> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@GetMapping
	public ResponseEntity<PageResponse<LandTransactionResponse>> search(@RequestParam(required = false) String district,
			@RequestParam(required = false) String circle, @RequestParam(required = false) String mouza,
			@RequestParam(required = false) String village, @RequestParam(required = false) String dagNo,
			@RequestParam(required = false) String nicCode, @RequestParam(required = false) Boolean active,
			@RequestParam(defaultValue = "0") @Min(0) int page,
			@RequestParam(defaultValue = "20") @Min(1) @Max(200) int size,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "desc") String direction) {

		if (!SetOfSortFields.ALLOWED.contains(sortBy)) {
			throw new IllegalArgumentException("Unsupported sortBy. Allowed: " + SetOfSortFields.ALLOWED);
		}

		Sort.Direction sortDirection = "asc".equalsIgnoreCase(direction) ? Sort.Direction.ASC : Sort.Direction.DESC;

		Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
		return ResponseEntity.ok(service.search(district, circle, mouza, village, dagNo, nicCode, active, pageable));
	}

	@PutMapping("/{id}")
	public ResponseEntity<LandTransactionResponse> update(@PathVariable Long id,
			@Valid @RequestBody LandTransactionRequest request) {
		return ResponseEntity.ok(service.update(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok(Map.of("message", "Land transaction deactivated successfully"));
	}

	@PostMapping("/{id}/restore")
	public ResponseEntity<Map<String, String>> restore(@PathVariable Long id) {
		service.restore(id);
		return ResponseEntity.ok(Map.of("message", "Land transaction restored successfully"));
	}

	@PostMapping(value = "/excel/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ApiResponse<ExcelUploadResponse>> uploadExcel(@RequestPart("file") MultipartFile file)
			throws IOException {

		ExcelUploadResponse response = service.uploadExcel(file);

		return ResponseEntity.ok(new ApiResponse<>(true, HttpStatus.OK.value(), "SUCCESS", response));
	}

	@GetMapping("/registration/data")
	public ResponseEntity<List<LandTransaction>> getDataNew(@RequestParam(required = false) String district,
			@RequestParam(required = false) String circle) {

		return ResponseEntity.ok(service.findData(district, circle));
	}

	@GetMapping("/registration/data/mouza")
	public ResponseEntity<List<LandTransaction>> getDataNewByMouza(@RequestParam(required = false) String district,
			@RequestParam(required = false) String circle, @RequestParam(required = false) String mouza) {

		return ResponseEntity.ok(service.findData(district, circle, mouza));
	}

}
