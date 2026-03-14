package com.areap2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.service.excel.LandDataXlsPropertyMeasurementService;

@RestController
@RequestMapping("/excel-data")
public class LandDataXlsController {

	@Autowired
	private LandDataXlsPropertyMeasurementService excelService;

	@GetMapping("/import-excel-data")
	public String importExcel() throws Exception {

		excelService.processExcel("F:/landdata.xlsx");

		return "Excel Data Imported Successfully";
	}
}
