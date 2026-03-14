package com.areap2.model;

import lombok.Data;

@Data
public class Params {

	private String districtCode;
	private String circleCode;
	private String mouzaCode;
	private Integer plot;
	private String landName;
	private String orgLandName;
	private String parameter;
	private String areaType;
	private String areaInDecimal;
	private String price;
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
	public Integer getPlot() {
		return plot;
	}
	public void setPlot(Integer plot) {
		this.plot = plot;
	}
	public String getLandName() {
		return landName;
	}
	public void setLandName(String landName) {
		this.landName = landName;
	}
	public String getOrgLandName() {
		return orgLandName;
	}
	public void setOrgLandName(String orgLandName) {
		this.orgLandName = orgLandName;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getAreaType() {
		return areaType;
	}
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	public String getAreaInDecimal() {
		return areaInDecimal;
	}
	public void setAreaInDecimal(String areaInDecimal) {
		this.areaInDecimal = areaInDecimal;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
