package com.areap2.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ParameterDetailsModelUpdateRequest {
	
	private String parameterName;
	private String parameterCode;
	private Timestamp effectiveFrom;
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getParameterCode() {
		return parameterCode;
	}
	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}
	public Timestamp getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(Timestamp effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	
	
	

}
