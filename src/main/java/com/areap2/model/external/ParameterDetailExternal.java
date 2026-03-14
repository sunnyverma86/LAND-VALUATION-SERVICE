package com.areap2.model.external;

import java.util.List;

import lombok.Data;

@Data
public class ParameterDetailExternal {

	private String parameterCode;
	private String parameterName;

	// Optional (only present when sub-parameter exists)
	private List<SubParameterDetailExternal> subParameters;

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public List<SubParameterDetailExternal> getSubParameters() {
		return subParameters;
	}

	public void setSubParameters(List<SubParameterDetailExternal> subParameters) {
		this.subParameters = subParameters;
	}
	
	
	
}
