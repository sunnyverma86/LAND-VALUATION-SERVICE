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

import com.areap2.entity.excel.external.GeographicalFactorEntity;
import com.areap2.service.excel.GeographicalFactorService;

@RestController
@RequestMapping("/api/geographical-factor")
public class MasterGeographicalFactorController {

	@Autowired
	private GeographicalFactorService service;

	// CRUD APIs

	@PostMapping
	public ResponseEntity<GeographicalFactorEntity> create(@RequestBody GeographicalFactorEntity entity) {
		return ResponseEntity.ok(service.save(entity));
	}

	@GetMapping
	public ResponseEntity<List<GeographicalFactorEntity>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<GeographicalFactorEntity> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<GeographicalFactorEntity> update(@PathVariable Long id,
			@RequestBody GeographicalFactorEntity entity) {
		return ResponseEntity.ok(service.update(id, entity));
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
		return ResponseEntity.ok("Excel uploaded successfully");
	}
}
