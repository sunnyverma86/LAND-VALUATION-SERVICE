package com.areap2.model;

import lombok.Data;

@Data
public class LandCategoriesModelRequest {
	private String landCategoryName;

	private Long basePriceIncreaseLandUse;

	private String districtCode;

	private String circleCode;

	private String mouzaCode;

	public String getLandCategoryName() {
		return landCategoryName;
	}

	public void setLandCategoryName(String landCategoryName) {
		this.landCategoryName = landCategoryName;
	}

	public Long getBasePriceIncreaseLandUse() {
		return basePriceIncreaseLandUse;
	}

	public void setBasePriceIncreaseLandUse(Long basePriceIncreaseLandUse) {
		this.basePriceIncreaseLandUse = basePriceIncreaseLandUse;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getCircleCode() {
		return circleCode;
	}

	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	public String getMouzaCode() {
		return mouzaCode;
	}

	public void setMouzaCode(String mouzaCode) {
		this.mouzaCode = mouzaCode;
	}
	
	

}
