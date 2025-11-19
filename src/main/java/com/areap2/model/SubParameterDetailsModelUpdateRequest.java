package com.areap2.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SubParameterDetailsModelUpdateRequest {

	// private String parameterName;
	private String parameterCode;
	private String subParameterName;
	private String subParameterCode;
	private BigDecimal weightage;
	private Timestamp effectiveFrom;

}
