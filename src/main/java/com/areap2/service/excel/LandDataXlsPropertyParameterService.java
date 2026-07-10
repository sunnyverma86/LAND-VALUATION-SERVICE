package com.areap2.service.excel;

import org.springframework.data.domain.Page;

import com.areap2.entity.excel.external.LandDataXlsParameter;

public interface LandDataXlsPropertyParameterService {

	void processExcel(String string);

	Page<LandDataXlsParameter> getLandDataByDistrict(String district, int page, int size);

	void processExcelKaus(String path);

}
