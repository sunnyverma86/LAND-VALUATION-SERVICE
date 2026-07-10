package com.areap2.dto.excel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class SlabRequestDTO {
	
	public SlabRequestDTO() {}

	private String district;
	private String distanceTypeCode;
	private String parameterName; //distanceTypeCode;
	private String createdBy;
	
	private String areaType;
	private Boolean perpetual;
	private String effectiveTill;
	
	private List<SlabRangeDTO> slabs;

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDistanceTypeCode() {
		return distanceTypeCode;
	}

	public void setDistanceTypeCode(String distanceTypeCode) {
		this.distanceTypeCode = distanceTypeCode;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public Boolean getPerpetual() {
		return perpetual;
	}

	public void setPerpetual(Boolean perpetual) {
		this.perpetual = perpetual;
	}

	public String getEffectiveTill() {
		return effectiveTill;
	}

	public void setEffectiveTill(String effectiveTill) {
		this.effectiveTill = effectiveTill;
	}

	public List<SlabRangeDTO> getSlabs() {
		return slabs;
	}

	public void setSlabs(List<SlabRangeDTO> slabs) {
		this.slabs = slabs;
	}
	
	
	

	// getters setters
}