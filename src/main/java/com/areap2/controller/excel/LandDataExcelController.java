package com.areap2.controller.excel;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.dto.excel.SearchDtoRequest;
import com.areap2.entity.excel.external.LandDataXlsParameter;
import com.areap2.entity.excel.external.LandDataXlsPropertyOriginal;
import com.areap2.service.excel.LandDataService;
import com.areap2.service.excel.LandDataXlsPropertyMeasurementService;
import com.areap2.service.excel.LandDataXlsPropertyParameterService;
import com.areap2.serviceImpl.LandDataXlsPropertyOriginalPhaseOneService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/excel")
public class LandDataExcelController {

	private static final Logger log = LoggerFactory.getLogger(LandDataExcelController.class);

	@Autowired
	private LandDataXlsPropertyParameterService parameterExcelService;

	@Autowired
	private LandDataXlsPropertyMeasurementService measurementService;

	@Autowired
	private LandDataXlsPropertyOriginalPhaseOneService migrationService;

	@Autowired
	private LandDataService LandDataService;

	/**
	 * Step 1: Import Excel data into land_data_property_measurement table
	 */
	@GetMapping("/import-excel-data-phasei")
	public ResponseEntity<String> importExcelDataPhasei(@RequestParam String path) {

		log.info("START :: Excel Import API :: path={}", path);

		try {

			measurementService.processExcel(path);

			log.info("SUCCESS :: Excel Data Imported");

			return ResponseEntity.ok("Excel Data Imported Successfully");

		} catch (Exception e) {

			log.error("ERROR :: Excel Import Failed", e);

			return ResponseEntity.internalServerError().body("Excel Import Failed: " + e.getMessage());
		}
	}

	/**
	 * Step 2: Migrate land_data_property_measurement → land_data_original
	 */

	@GetMapping("/export-data-db-to-db-phasei")
	public ResponseEntity<String> migrateLandData() {

		log.info("START :: Land Data Migration Phase I");

		try {

			migrationService.migrateData();

			log.info("SUCCESS :: Migration Completed");

			return ResponseEntity.ok("Migration Completed Successfully");

		} catch (Exception e) {

			log.error("ERROR :: Migration Failed", e);

			return ResponseEntity.internalServerError().body("Migration Failed: " + e.getMessage());
		}
	}

	/**
	 * Step 1: Import Excel data into land_data_xls_parameter table
	 */
	@PostMapping("/import-excel-data-phaseii")
	public ResponseEntity<String> importExcelDataPhaseii(@RequestParam String path) {

		log.info("START :: Import Excel API :: path={}", path);

		try {

			parameterExcelService.processExcel(path);

			log.info("SUCCESS :: Excel Imported");

			return ResponseEntity.ok("Excel Imported Successfully");

		} catch (Exception e) {

			log.error("ERROR :: Excel Import Failed", e);

			return ResponseEntity.internalServerError().body("Excel Import Failed: " + e.getMessage());
		}
	}

	/**
	 * Step 2: Migrate land_data_property_measurement → land_data_original
	 */
	@GetMapping("/export-data-db-to-db-phaseii")
	public ResponseEntity<String> migrateLandDataPhaseii() {

		log.info("START :: Land Data Migration Phase II");

		try {

			migrationService.migrateLandDataPhaseii();

			log.info("SUCCESS :: Migration Completed");

			return ResponseEntity.ok("Migration Phase II Completed Successfully");

		} catch (Exception e) {

			log.error("ERROR :: Migration Failed", e);

			return ResponseEntity.internalServerError().body("Migration Failed: " + e.getMessage());
		}
	}

	/**
	 * Get land data by district
	 */
	@GetMapping("/by-district")
	public ResponseEntity<Page<LandDataXlsParameter>> getByDistrict(@RequestParam String district,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {

		log.info("START :: Get Land Data By District :: district={} page={} size={}", district, page, size);

		try {

			Page<LandDataXlsParameter> response = parameterExcelService.getLandDataByDistrict(district, page, size);

			log.info("SUCCESS :: Data fetched :: records={}", response.getTotalElements());

			return ResponseEntity.ok(response);

		} catch (Exception e) {

			log.error("ERROR :: Failed to fetch land data by district", e);

			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/search")
	public ResponseEntity<?> getLandData(@RequestBody SearchDtoRequest request) {

		LandDataXlsPropertyOriginal data = LandDataService.getLandData(request);

		return ResponseEntity.ok(data);
	}

	@PostMapping("/search-for-muliple")
	public ResponseEntity<?> getLandDataForMuliple(@RequestBody SearchDtoRequest request) {

		List<LandDataXlsPropertyOriginal> data = LandDataService.getLandDataMultiple(request);

		return ResponseEntity.ok(data);
	}
	
	@PostMapping("/import-excel-data-phaseii-kaus")
	public ResponseEntity<String> importExcelDataPhaseiiKaus(@RequestParam String path) {

		log.info("START :: Import Excel API :: path={}", path);

		try {

			parameterExcelService.processExcelKaus(path);

			log.info("SUCCESS :: Excel Imported");

			return ResponseEntity.ok("Excel Imported Successfully");

		} catch (Exception e) {

			log.error("ERROR :: Excel Import Failed", e);

			return ResponseEntity.internalServerError().body("Excel Import Failed: " + e.getMessage());
		}
	}

}