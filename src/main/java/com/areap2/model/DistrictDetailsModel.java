package com.areap2.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DistrictDetailsModel {
	
	private Long districtGenId; 

	private String districtName;

	private String districtCode;

	private Boolean active;

	private String createdBy;

	private String updatedBy;

	public Long getDistrictGenId() {
		return districtGenId;
	}

	public void setDistrictGenId(Long districtGenId) {
		this.districtGenId = districtGenId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
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
