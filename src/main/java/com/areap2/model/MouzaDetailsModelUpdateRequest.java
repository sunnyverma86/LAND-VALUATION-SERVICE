package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MouzaDetailsModelUpdateRequest {

	private String mouzaCode;

	private String mouzaName;

	private Long areaTypeId;

	private String districtCode;

	private String circleCode;
	
	private Long bPMouza;

	public String getMouzaCode() {
		return mouzaCode;
	}

	public void setMouzaCode(String mouzaCode) {
		this.mouzaCode = mouzaCode;
	}

	public String getMouzaName() {
		return mouzaName;
	}

	public void setMouzaName(String mouzaName) {
		this.mouzaName = mouzaName;
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

	public Long getbPMouza() {
		return bPMouza;
	}

	public void setbPMouza(Long bPMouza) {
		this.bPMouza = bPMouza;
	}
	
	

}
