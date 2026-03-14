package com.areap2.model.external;

import java.util.List;

import lombok.Data;

@Data
public class PlotLandDetailsExternal {
	private String locationMethod;
	private List<ParameterDetailExternal> parameters;
	public String getLocationMethod() {
		return locationMethod;
	}
	public void setLocationMethod(String locationMethod) {
		this.locationMethod = locationMethod;
	}
	public List<ParameterDetailExternal> getParameters() {
		return parameters;
	}
	public void setParameters(List<ParameterDetailExternal> parameters) {
		this.parameters = parameters;
	}
	
	
}
