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

	public Long getBasePriceMouza() {
		return basePriceMouza;
	}

	public void setBasePriceMouza(Long basePriceMouza) {
		this.basePriceMouza = basePriceMouza;
	}

	public BigDecimal getBasePriceMouzaIncreaseLot() {
		return basePriceMouzaIncreaseLot;
	}

	public void setBasePriceMouzaIncreaseLot(BigDecimal basePriceMouzaIncreaseLot) {
		this.basePriceMouzaIncreaseLot = basePriceMouzaIncreaseLot;
	}

	public Long getBasePriceMouzaIncreaseLandUse() {
		return basePriceMouzaIncreaseLandUse;
	}

	public void setBasePriceMouzaIncreaseLandUse(Long basePriceMouzaIncreaseLandUse) {
		this.basePriceMouzaIncreaseLandUse = basePriceMouzaIncreaseLandUse;
	}

	public Long getBasePriceMouzaIncreaseAreaUrbanOrRural() {
		return basePriceMouzaIncreaseAreaUrbanOrRural;
	}

	public void setBasePriceMouzaIncreaseAreaUrbanOrRural(Long basePriceMouzaIncreaseAreaUrbanOrRural) {
		this.basePriceMouzaIncreaseAreaUrbanOrRural = basePriceMouzaIncreaseAreaUrbanOrRural;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getCircleCode() {
		return circleCode;
	}

	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	public String getMouzaCode() {
		return mouzaCode;
	}

	public void setMouzaCode(String mouzaCode) {
		this.mouzaCode = mouzaCode;
	}
	
	

}
