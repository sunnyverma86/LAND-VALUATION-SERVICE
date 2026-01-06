package com.areap2.model.external;

import java.util.List;

import lombok.Data;

@Data
public class PlotLandDetailsExternal {
	private String locationMethod;
	private List<ParameterDetailExternal> parameters;
}
