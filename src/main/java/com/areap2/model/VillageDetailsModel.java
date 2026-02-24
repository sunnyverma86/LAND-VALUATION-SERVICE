package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillageDetailsModel {

	private Long villageGenId;

	private String villageCode;

	private String villageName;

	private String circleCode;

	private String districtCode;
	
	private Boolean active;

	private String createdBy;

	private String updatedBy;

}
