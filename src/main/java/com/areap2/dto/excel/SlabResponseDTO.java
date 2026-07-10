package com.areap2.dto.excel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class SlabResponseDTO {
	
	public SlabResponseDTO() {}

	private String district;
	private String distanceTypeCode;
	private Integer version;
	private List<SlabRangeDTO> slabs;
	
	private String parameterName;
	private String areaType;
	private Boolean perpetual;
	private String band;
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public List<SlabRangeDTO> getSlabs() {
		return slabs;
	}
	public void setSlabs(List<SlabRangeDTO> slabs) {
		this.slabs = slabs;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
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
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	
	
	

	// getters setters
}
