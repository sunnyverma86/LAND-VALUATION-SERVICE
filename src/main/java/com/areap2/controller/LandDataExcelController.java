package com.areap2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.service.LandDataExcelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/excel")
public class LandDataExcelController {

	@Autowired
	private LandDataExcelService landDataExcelService;

	@PostMapping("/import")
	public String importExcel(@RequestParam String path) {
		landDataExcelService.readExcel(path);
		return "Excel Imported Successfully!";
	}
}
