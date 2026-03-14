package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SroDetailsModelUpdateRequest {


	private String sroName;

	private String sroCode;

	private String districtCode;

	private String circleCode;

	public String getSroName() {
		return sroName;
	}

	public void setSroName(String sroName) {
		this.sroName = sroName;
	}

	public String getSroCode() {
		return sroCode;
	}

	public void setSroCode(String sroCode) {
		this.sroCode = sroCode;
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
	
	
	


}
