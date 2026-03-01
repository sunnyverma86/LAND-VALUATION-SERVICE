package com.areap2.excel.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlabRequestDTO {

	private String district;
	private String distanceTypeCode;
	private String parameterName; //distanceTypeCode;
	private String createdBy;
	
	private String areaType;
	private Boolean perpetual;
	private String band;
	
	private List<SlabRangeDTO> slabs;

	// getters setters
}