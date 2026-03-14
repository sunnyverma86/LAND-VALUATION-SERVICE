package com.areap2.model;

import lombok.Data;

@Data
public class LandCategoriesModel {
	
	private Long landCategoryGenId;
	
	private String landCategoryName;
	
	private Boolean active;

	private String createdBy;

	private String updatedBy;

	public Long getLandCategoryGenId() {
		return landCategoryGenId;
	}

	public void setLandCategoryGenId(Long landCategoryGenId) {
		this.landCategoryGenId = landCategoryGenId;
	}

	public String getLandCategoryName() {
		return landCategoryName;
	}

	public void setLandCategoryName(String landCategoryName) {
		this.landCategoryName = landCategoryName;
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
