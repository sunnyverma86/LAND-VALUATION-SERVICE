package com.areap2.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SubParameterDetailsModelRequest {
	
	private String parameterCode;
	private String bandCode;
	private BigDecimal weightage;
	private String effectiveTill;
	private String areaType;
	private String district;
	private String band;
	private BigDecimal distanceFrom;
	private BigDecimal distanceTo;
	private Boolean perpetual;
	// private String parameterName;
	private String districtCode;
	private String areaTypeRandU;
	
	private String subParameterName;
	
	private Timestamp effectiveFrom;

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}

	public String getBandCode() {
		return bandCode;
	}

	public void setBandCode(String bandCode) {
		this.bandCode = bandCode;
	}

	public BigDecimal getWeightage() {
		return weightage;
	}

	public void setWeightage(BigDecimal weightage) {
		this.weightage = weightage;
	}

	public String getEffectiveTill() {
		return effectiveTill;
	}

	public void setEffectiveTill(String effectiveTill) {
		this.effectiveTill = effectiveTill;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public BigDecimal getDistanceFrom() {
		return distanceFrom;
	}

	public void setDistanceFrom(BigDecimal distanceFrom) {
		this.distanceFrom = distanceFrom;
	}

	public BigDecimal getDistanceTo() {
		return distanceTo;
	}

	public void setDistanceTo(BigDecimal distanceTo) {
		this.distanceTo = distanceTo;
	}

	public Boolean getPerpetual() {
		return perpetual;
	}

	public void setPerpetual(Boolean perpetual) {
		this.perpetual = perpetual;
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

	public String getSubParameterName() {
		return subParameterName;
	}

	public void setSubParameterName(String subParameterName) {
		this.subParameterName = subParameterName;
	}

	public Timestamp getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(Timestamp effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	
	
	
	
}

