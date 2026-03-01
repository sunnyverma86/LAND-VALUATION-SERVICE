package com.areap2.service;

import org.springframework.data.domain.Page;

import com.areap2.entity.LandDataExcel;

public interface LandDataExcelService {

	void readExcel(String string);

	Page<LandDataExcel> getLandDataByDistrict(String district, int page, int size);

}
