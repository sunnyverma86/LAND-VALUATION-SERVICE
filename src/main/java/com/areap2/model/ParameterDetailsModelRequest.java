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

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAppreciationType() {
		return appreciationType;
	}

	public void setAppreciationType(String appreciationType) {
		this.appreciationType = appreciationType;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Timestamp getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(Timestamp effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	
	

}
