package com.areap2.service;

import com.areap2.model.ParamsJurisdictionModel;
import com.areap2.model.ResponseModel;

public interface JurisdictionInfoService {

	ResponseModel getBasePrice(ParamsJurisdictionModel params);

	ResponseModel getStampDuty(Long stampDutyGenid);
	
	
}
