package com.areap2.model;

import lombok.Data;

@Data
public class LandCategoriesModelRequest {
	private String landCategoryName;

	private Long basePriceIncreaseLandUse;

	private String districtCode;

	private String circleCode;

	private String mouzaCode;

}
