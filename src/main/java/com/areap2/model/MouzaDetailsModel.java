package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MouzaDetailsModel {

	private Long mouzaGenId;

	private String mouzaName;

	private String mouzaCode;

	private Long areaTypeId;

	private String districtCode;

	private String circleCode;

	private Boolean active;

	private String createdBy;

	private String updatedBy;

	public Long getMouzaGenId() {
		return mouzaGenId;
	}

	public void setMouzaGenId(Long mouzaGenId) {
		this.mouzaGenId = mouzaGenId;
	}

	public String getMouzaName() {
		return mouzaName;
	}

	public void setMouzaName(String mouzaName) {
		this.mouzaName = mouzaName;
	}

	public String getMouzaCode() {
		return mouzaCode;
	}

	public void setMouzaCode(String mouzaCode) {
		this.mouzaCode = mouzaCode;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}
