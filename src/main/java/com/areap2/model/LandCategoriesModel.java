package com.areap2.model;

import lombok.Data;

@Data
public class LandCategoriesModel {
	
	private Long landCategoryGenId;
	
	private String landCategoryName;
	
	private Boolean active;

	private String createdBy;

	private String updatedBy;
}
