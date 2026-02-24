package com.areap2.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SubParameterDetailsModelRequest {

	// private String parameterName;
	private String districtCode;
	private String areaTypeRandU;
	private String band;
	private String parameterCode;
	private String subParameterName;
	private BigDecimal weightage;
	private Timestamp effectiveFrom;
}

