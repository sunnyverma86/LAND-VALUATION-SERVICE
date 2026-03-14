package com.areap2.model;

import lombok.Data;

@Data
public class SroDetailsModel {

	private Long sroGenId;

	private String sroName;

	private String sroCode;

	private String districtCode;

	private String districtName;

	private Boolean active;

	private String createdBy;

	private String updatedBy;

	public Long getSroGenId() {
		return sroGenId;
	}

	public void setSroGenId(Long sroGenId) {
		this.sroGenId = sroGenId;
	}

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

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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
