package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillageDetailsModelRequest {

	private String districtCode;

	private String circleCode;

	private String mouzaCode;

	private String lotCode;

	private String villageName;

	private String areaType;// Rural/Urban

}
