package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CircleDetailsModel {

	private Long circleGenId;

	private String circleName;

	private String circleCode;

	private String districtCode;

	private Boolean active;

	private String createdBy;

	private String updatedBy;

}
