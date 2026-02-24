package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillageDetailsModelUpdateRequest {

	private String districtCode;

	private String circleCode;

	private String mouzaCode;

	private String lotCode;

	private String villageCode;

	private String areaType;

	private String villageName;

}
