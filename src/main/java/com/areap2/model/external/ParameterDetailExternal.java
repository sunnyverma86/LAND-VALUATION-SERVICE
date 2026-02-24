package com.areap2.model.external;

import java.util.List;

import lombok.Data;

@Data
public class ParameterDetailExternal {

	private String parameterCode;
	private String parameterName;

	// Optional (only present when sub-parameter exists)
	private List<SubParameterDetailExternal> subParameters;
}
