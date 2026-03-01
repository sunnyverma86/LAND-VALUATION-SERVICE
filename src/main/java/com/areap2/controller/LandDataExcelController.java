package com.areap2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.entity.LandDataExcel;
import com.areap2.service.LandDataExcelService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@RequestMapping("/excel")
@Log4j2
public class LandDataExcelController {

	@Autowired
	private LandDataExcelService landDataExcelService;

	@PostMapping("/import")
	public String importExcel(@RequestParam String path) {
		landDataExcelService.readExcel(path);
		return "Excel Imported Successfully!";
	}

	@GetMapping("/by-district")
	public ResponseEntity<Page<LandDataExcel>> getByDistrict(@RequestParam String district,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {

		log.info("START :: Get Land Data By District API");

		Page<LandDataExcel> response = landDataExcelService.getLandDataByDistrict(district, page, size);

		return ResponseEntity.ok(response);
	}
}
