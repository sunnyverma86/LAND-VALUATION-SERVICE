package com.areap2.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SubParameterDetailsModelRequest {
	
	private String parameterCode;
	private String bandCode;
	private BigDecimal weightage;
	private String effectiveTill;
	private String areaType;
	private String district;
	private String band;
	private BigDecimal distanceFrom;
	private BigDecimal distanceTo;
	private Boolean perpetual;
	// private String parameterName;
	private String districtCode;
	private String areaTypeRandU;
	
	private String subParameterName;
	
	private Timestamp effectiveFrom;
}

