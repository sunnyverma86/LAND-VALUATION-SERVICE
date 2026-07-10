package com.areap2.controller.excel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.areap2.entity.excel.external.DistrictMinimumEntity;
import com.areap2.service.excel.MasterDistrictMinimumService;

@RestController
@RequestMapping("/api/district-minimum")
public class MasterDistrictMinimumController {

	@Autowired
	private MasterDistrictMinimumService service;

	@PostMapping
	public ResponseEntity<DistrictMinimumEntity> create(@RequestBody DistrictMinimumEntity data) {
		return ResponseEntity.ok(service.save(data));
	}

	@GetMapping
	public ResponseEntity<List<DistrictMinimumEntity>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DistrictMinimumEntity> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<DistrictMinimumEntity> update(@PathVariable Long id,
			@RequestBody DistrictMinimumEntity data) {
		return ResponseEntity.ok(service.update(id, data));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok("Deleted successfully");
	}

	// Excel Upload API

	@PostMapping("/upload")
	public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
		service.uploadExcel(file);
		return ResponseEntity.ok("File uploaded successfully");
	}
}
