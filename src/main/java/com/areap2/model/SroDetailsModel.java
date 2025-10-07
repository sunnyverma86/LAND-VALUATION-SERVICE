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

}
