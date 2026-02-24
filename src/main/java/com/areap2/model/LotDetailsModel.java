package com.areap2.model;

import lombok.Data;

@Data
public class LotDetailsModel {
	
	private Long lotGenId;

	private String lotName;

	private String lotCode;

	private Long areaTypeId;

	private String districtCode;

	private String circleCode;
	
	private Boolean active;

	private String createdBy;

	private String updatedBy;
}
