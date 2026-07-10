package com.areap2.controller.excel.map.repo;

import java.util.List;

import com.areap2.controller.excel.map.enity.LandUseFactorExcelEntity;

public interface LufBatchRepository {

	void saveBatch(List<LandUseFactorExcelEntity> records);

}