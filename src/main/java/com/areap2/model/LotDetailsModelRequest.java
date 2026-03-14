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

	public String getLotName() {
		return lotName;
	}

	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

	public Long getAreaTypeId() {
		return areaTypeId;
	}

	public void setAreaTypeId(Long areaTypeId) {
		this.areaTypeId = areaTypeId;
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
