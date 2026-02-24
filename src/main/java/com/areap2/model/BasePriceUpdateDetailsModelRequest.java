package com.areap2.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePriceUpdateDetailsModelRequest {

	private Long basePriceMouza;

	private BigDecimal basePriceMouzaIncreaseLot;

	private Long basePriceMouzaIncreaseLandUse;

	private Long basePriceMouzaIncreaseAreaUrbanOrRural;

	private String districtCode;
	
	private String circleCode;
	
	private String mouzaCode;

}
