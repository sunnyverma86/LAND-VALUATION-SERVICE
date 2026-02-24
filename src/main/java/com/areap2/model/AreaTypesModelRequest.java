package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaTypesModelRequest {

	private String areaType;

	private Long basePriceIncreaseAreaType;

	private String districtCode;

	private String circleCode;

	private String mouzaCode;

}
