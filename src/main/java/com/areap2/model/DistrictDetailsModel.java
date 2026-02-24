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


}
