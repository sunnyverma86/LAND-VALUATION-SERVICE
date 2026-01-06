package com.areap2.service;

import java.util.List;

import com.areap2.entity.MarketValuationEntity;
import com.areap2.model.external.MarketValuationRequest;
import com.areap2.model.external.MarketValuationResponse;

public interface MarketValuationService {

	MarketValuationEntity saveValuation(MarketValuationRequest request);

	List<MarketValuationEntity> getAll();

	List<MarketValuationEntity> getByPlotNo(String plotNo);

	MarketValuationResponse convertToResponse(MarketValuationEntity entity);

	List<String> getAllPlotNosByAttributes(String districtCode, String circleCode, String mouzaCode, String lotCode,
			String villageCode);
}
