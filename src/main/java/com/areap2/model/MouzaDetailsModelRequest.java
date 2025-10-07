package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MouzaDetailsModelRequest {

	private String mouzaName;

	private Long areaTypeId;

	private String districtCode;

	private String circleCode;
}
