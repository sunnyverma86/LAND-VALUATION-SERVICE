package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LandAreaRequest {

	private String area;
	private String distName;
	private String revenueCircle;
	private String villageName;
	private String mouzaName;
	private String areaType;
	private String lotNumber;
	private String dagNInt;
	private Double distFromCBD;
	private String typeOfCBD;
	private String roadFid;
	private Double distFromRoad;
	private String typeOfRoad;
	private Double distFromTransport;
	private Double distFromEducation;
	private Double distFromRestrictedArea;
	private Double distFromOilPipeline;
	private Double distFromHeritage;
	private Double distFromFloodProne;
	private Double elevation;
}
