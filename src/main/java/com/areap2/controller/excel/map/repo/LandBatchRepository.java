package com.areap2.controller.excel.map.repo;

import java.util.List;

import com.areap2.controller.excel.map.enity.LandRecordEntity;

public interface LandBatchRepository {

	void saveBatch(List<LandRecordEntity> records);

}