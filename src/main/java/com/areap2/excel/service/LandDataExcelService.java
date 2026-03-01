package com.areap2.excel.service;

import org.springframework.data.domain.Page;

import com.areap2.excel.entity.LandDataExcel;

public interface LandDataExcelService {

	void readExcel(String string);

	Page<LandDataExcel> getLandDataByDistrict(String district, int page, int size);

}
