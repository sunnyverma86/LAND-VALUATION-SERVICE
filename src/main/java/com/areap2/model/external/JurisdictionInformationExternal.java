package com.areap2.model.external;

import lombok.Data;

@Data
public class JurisdictionInformationExternal {
	private String districtCode;
	private String circleCode;
	private String mouzaCode;
	private String villageCode;
	private String lotCode;
	private String currentLandUse;
	private String plotNo;
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
	public String getVillageCode() {
		return villageCode;
	}
	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}
	public String getLotCode() {
		return lotCode;
	}
	public void setLotCode(String lotCode) {
		this.lotCode = lotCode;
	}
	public String getCurrentLandUse() {
		return currentLandUse;
	}
	public void setCurrentLandUse(String currentLandUse) {
		this.currentLandUse = currentLandUse;
	}
	public String getPlotNo() {
		return plotNo;
	}
	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}
	
	
	
	
}
