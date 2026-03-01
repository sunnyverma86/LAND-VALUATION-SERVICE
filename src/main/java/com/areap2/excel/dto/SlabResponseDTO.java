package com.areap2.excel.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlabResponseDTO {

	private String district;
	private String distanceTypeCode;
	private Integer version;
	private List<SlabRangeDTO> slabs;

	// getters setters
}
