package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotNumberModelRequest {

	private String districtCode;

	private String circleCode;

	private String mouzaCode;

	private String villageCode;

	private String lotCode;
}


