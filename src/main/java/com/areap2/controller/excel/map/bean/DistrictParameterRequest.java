package com.areap2.controller.excel.map.bean;

import java.math.BigDecimal;

import com.areap2.controller.excel.map.enity.band.ParameterName;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DistrictParameterRequest {

	@NotBlank
	private String district;

	@NotBlank
	private ParameterName parameterName;

	@NotBlank
	private String ruralUrban;

	@NotBlank
	private String band;

	@NotBlank
	private BigDecimal distanceFrom;

	@NotBlank
	private BigDecimal distanceTo;

	@NotBlank
	private BigDecimal weightage;

	@NotBlank
	private Boolean perpetual;

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public ParameterName getParameterName() {
		return parameterName;
	}

	public void setParameterName(ParameterName parameterName) {
		this.parameterName = parameterName;
	}

	public String getRuralUrban() {
		return ruralUrban;
	}

	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
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

	public BigDecimal getWeightage() {
		return weightage;
	}

	public void setWeightage(BigDecimal weightage) {
		this.weightage = weightage;
	}

	public Boolean getPerpetual() {
		return perpetual;
	}

	public void setPerpetual(Boolean perpetual) {
		this.perpetual = perpetual;
	}

}
