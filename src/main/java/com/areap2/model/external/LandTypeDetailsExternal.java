package com.areap2.model.external;

import lombok.Data;

@Data
public class LandTypeDetailsExternal {
	private String currentLandType;
	private boolean landUseChange;
	private String areaType;
	private AreaDetailsExternal areaDetailsExternal;
	public String getCurrentLandType() {
		return currentLandType;
	}
	public void setCurrentLandType(String currentLandType) {
		this.currentLandType = currentLandType;
	}
	public boolean isLandUseChange() {
		return landUseChange;
	}
	public void setLandUseChange(boolean landUseChange) {
		this.landUseChange = landUseChange;
	}
	public String getAreaType() {
		return areaType;
	}
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	public AreaDetailsExternal getAreaDetailsExternal() {
		return areaDetailsExternal;
	}
	public void setAreaDetailsExternal(AreaDetailsExternal areaDetailsExternal) {
		this.areaDetailsExternal = areaDetailsExternal;
	}

	
}
