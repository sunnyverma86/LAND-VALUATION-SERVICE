package com.areap2.controller.excel.map.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.areap2.controller.excel.map.bean.UploadResponse;
import com.areap2.controller.excel.map.service.ExcelUploadService;
import com.areap2.controller.excel.map.service.LandOutputService;

@RestController
@RequestMapping("/api/v1/excel")
@CrossOrigin(origins = "*")
public class ExcelUploadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUploadController.class);

	@Autowired
	private ExcelUploadService excelUploadService;

	@Autowired
	private LandOutputService landOutputService;

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UploadResponse> uploadExcel(@RequestParam("file") MultipartFile file) {

		long startTime = System.currentTimeMillis();

		LOGGER.info("==================================================");
		LOGGER.info("Excel Upload Request Received");
		LOGGER.info("File Name : {}", file.getOriginalFilename());
		LOGGER.info("File Size : {} MB", String.format("%.2f", file.getSize() / (1024.0 * 1024.0)));
		LOGGER.info("==================================================");

		try {

			if (file == null || file.isEmpty()) {

				UploadResponse response = new UploadResponse(false, "Uploaded file is empty", 0, 0);

				return ResponseEntity.badRequest().body(response);
			}

			long totalRecords = excelUploadService.upload(file);

			long executionTime = (System.currentTimeMillis() - startTime) / 1000;

			UploadResponse response = new UploadResponse(true, "File uploaded successfully", totalRecords,
					executionTime);

			LOGGER.info("Upload completed successfully. Records={}, Time={} sec", totalRecords, executionTime);

			return ResponseEntity.ok(response);

		} catch (Exception e) {

			LOGGER.error("Excel Upload Failed for file : {}", file.getOriginalFilename(), e);

			UploadResponse response = new UploadResponse(false, e.getMessage(), 0, 0);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@PostMapping("/generate")
	public ResponseEntity<String> generateOutput() {

		long startTime = System.currentTimeMillis();

		LOGGER.info("========================================");
		LOGGER.info("Land Output Generation Started");
		LOGGER.info("========================================");

		try {

			long totalRecords = landOutputService.generateOutputTable();

			long executionTime = (System.currentTimeMillis() - startTime) / 1000;

			LOGGER.info("========================================");
			LOGGER.info("Land Output Generation Completed");
			LOGGER.info("Total Records Processed : {}", totalRecords);
			LOGGER.info("Execution Time : {} sec", executionTime);
			LOGGER.info("========================================");

			return ResponseEntity.ok("SUCCESS : " + totalRecords + " records processed in " + executionTime + " sec");

		} catch (Exception e) {

			LOGGER.error("Land Output Generation Failed", e);

			return ResponseEntity.internalServerError().body("FAILED : " + e.getMessage());
		}
	}

}