package com.areap2.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ParameterDetailsModelUpdateRequest {
	
	private String parameterName;
	private String parameterCode;
	private Timestamp effectiveFrom;

}
