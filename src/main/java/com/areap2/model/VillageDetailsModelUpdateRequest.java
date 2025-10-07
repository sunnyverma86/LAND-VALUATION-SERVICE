package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillageDetailsModelUpdateRequest {

	private String villageName;
	
	private String villageCode;

	private String circleCode;

	private String districtCode;

}
