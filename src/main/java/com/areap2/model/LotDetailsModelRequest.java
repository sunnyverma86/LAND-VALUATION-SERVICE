package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotDetailsModelRequest {

	private String lotName;

	private Long areaTypeId;

	private String districtCode;

	private String circleCode;
	
	private String mouzaCode;

}
