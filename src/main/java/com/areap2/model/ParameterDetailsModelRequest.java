package com.areap2.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ParameterDetailsModelRequest {

	private String parameterName;
	
	private String data;
	
	private String appreciationType;
	
	private String discription;
	
	//private String code;

	private Timestamp effectiveFrom;

}
