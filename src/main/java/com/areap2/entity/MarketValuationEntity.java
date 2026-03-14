package com.areap2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "market_valuation")
@Data
public class MarketValuationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Basic fields
	private String mode;
	private Long totalMarketValuation;

	// Jurisdiction
	private String districtCode;
	private String circleCode;
	private String mouzaCode;
	private String villageCode;
	private String lotCode;
	private String currentLandUse;
	private String plotNo;

	// Land Type
	private String currentLandType;
	private Boolean landUseChange;
	private String areaType;
	private Integer totalLessa;

	// Parameters (JSON string)
	@Column(columnDefinition = "TEXT")
	private String parametersJson;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Long getTotalMarketValuation() {
		return totalMarketValuation;
	}

	public void setTotalMarketValuation(Long totalMarketValuation) {
		this.totalMarketValuation = totalMarketValuation;
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

	public String getCurrentLandType() {
		return currentLandType;
	}

	public void setCurrentLandType(String currentLandType) {
		this.currentLandType = currentLandType;
	}

	public Boolean getLandUseChange() {
		return landUseChange;
	}

	public void setLandUseChange(Boolean landUseChange) {
		this.landUseChange = landUseChange;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public Integer getTotalLessa() {
		return totalLessa;
	}

	public void setTotalLessa(Integer totalLessa) {
		this.totalLessa = totalLessa;
	}

	public String getParametersJson() {
		return parametersJson;
	}

	public void setParametersJson(String parametersJson) {
		this.parametersJson = parametersJson;
	}
	
	
	
	
}
