package com.areap2.controller.excel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.entity.excel.external.LandDataXlsParameter;
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

	/**
	 * Step 1: Import Excel data into land_data table
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
	 * Step 2: Migrate land_data → land_data_original
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
	 * Alternative Excel Import
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
	
	
	
	@GetMapping("/export-data-db-to-db-phaseii")
	public ResponseEntity<String> migrateLandDataPhaseii() {

		log.info("START :: Land Data Migration Phase II");

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
}