package com.areap2.controller.excel.map.controller;

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

import com.areap2.controller.excel.map.service.LandDetailsInputService;

@RestController
@RequestMapping("/api/land-details")
@CrossOrigin(origins = "*")
public class LandDetailsInputController {

	@Autowired
	private LandDetailsInputService landDetailsInputService;

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) {

		try {

			long totalRecords = landDetailsInputService.upload(file);

			return ResponseEntity.ok("Excel uploaded successfully. Total records imported : " + totalRecords);

		} catch (IllegalArgumentException e) {

			return ResponseEntity.badRequest().body(e.getMessage());

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Excel upload failed : " + e.getMessage());
		}
	}

}
