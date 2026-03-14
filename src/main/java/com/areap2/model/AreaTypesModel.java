package com.areap2.model;

import lombok.Data;

@Data
public class AreaTypesModel {
	
	private Long areaTypesGenId;

	private String areaType;
	
	private Boolean active;

	private String createdBy;

	private String updatedBy;

	public Long getAreaTypesGenId() {
		return areaTypesGenId;
	}

	public void setAreaTypesGenId(Long areaTypesGenId) {
		this.areaTypesGenId = areaTypesGenId;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
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
