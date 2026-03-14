package com.areap2.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SubParameterDetailsModelUpdateRequest {

	// private String parameterName;
	private String parameterCode;
	private String subParameterName;
	private String subParameterCode;
	private BigDecimal weightage;
	private Timestamp effectiveFrom;
	
	private String districtCode;
	private String areaTypeRandU;
	private String band;
	public String getParameterCode() {
		return parameterCode;
	}
	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}
	public String getSubParameterName() {
		return subParameterName;
	}
	public void setSubParameterName(String subParameterName) {
		this.subParameterName = subParameterName;
	}
	public String getSubParameterCode() {
		return subParameterCode;
	}
	public void setSubParameterCode(String subParameterCode) {
		this.subParameterCode = subParameterCode;
	}
	public BigDecimal getWeightage() {
		return weightage;
	}
	public void setWeightage(BigDecimal weightage) {
		this.weightage = weightage;
	}
	public Timestamp getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(Timestamp effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getAreaTypeRandU() {
		return areaTypeRandU;
	}
	public void setAreaTypeRandU(String areaTypeRandU) {
		this.areaTypeRandU = areaTypeRandU;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	
	
	
	
	


}
