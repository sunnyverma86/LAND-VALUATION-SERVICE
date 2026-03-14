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

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public Long getBasePriceIncreaseAreaType() {
		return basePriceIncreaseAreaType;
	}

	public void setBasePriceIncreaseAreaType(Long basePriceIncreaseAreaType) {
		this.basePriceIncreaseAreaType = basePriceIncreaseAreaType;
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
