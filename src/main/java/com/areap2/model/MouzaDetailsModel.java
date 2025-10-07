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
}
