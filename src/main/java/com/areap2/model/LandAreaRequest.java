package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LandAreaRequest {

	private String area;
	private String distName;
	private String revenueCircle;
	private String villageName;
	private String mouzaName;
	private String areaType;
	private String lotNumber;
	private String dagNInt;
	private Double distFromCBD;
	private String typeOfCBD;
	private String roadFid;
	private Double distFromRoad;
	private String typeOfRoad;
	private Double distFromTransport;
	private Double distFromEducation;
	private Double distFromRestrictedArea;
	private Double distFromOilPipeline;
	private Double distFromHeritage;
	private Double distFromFloodProne;
	private Double elevation;
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDistName() {
		return distName;
	}
	public void setDistName(String distName) {
		this.distName = distName;
	}
	public String getRevenueCircle() {
		return revenueCircle;
	}
	public void setRevenueCircle(String revenueCircle) {
		this.revenueCircle = revenueCircle;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getMouzaName() {
		return mouzaName;
	}
	public void setMouzaName(String mouzaName) {
		this.mouzaName = mouzaName;
	}
	public String getAreaType() {
		return areaType;
	}
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	public String getLotNumber() {
		return lotNumber;
	}
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}
	public String getDagNInt() {
		return dagNInt;
	}
	public void setDagNInt(String dagNInt) {
		this.dagNInt = dagNInt;
	}
	public Double getDistFromCBD() {
		return distFromCBD;
	}
	public void setDistFromCBD(Double distFromCBD) {
		this.distFromCBD = distFromCBD;
	}
	public String getTypeOfCBD() {
		return typeOfCBD;
	}
	public void setTypeOfCBD(String typeOfCBD) {
		this.typeOfCBD = typeOfCBD;
	}
	public String getRoadFid() {
		return roadFid;
	}
	public void setRoadFid(String roadFid) {
		this.roadFid = roadFid;
	}
	public Double getDistFromRoad() {
		return distFromRoad;
	}
	public void setDistFromRoad(Double distFromRoad) {
		this.distFromRoad = distFromRoad;
	}
	public String getTypeOfRoad() {
		return typeOfRoad;
	}
	public void setTypeOfRoad(String typeOfRoad) {
		this.typeOfRoad = typeOfRoad;
	}
	public Double getDistFromTransport() {
		return distFromTransport;
	}
	public void setDistFromTransport(Double distFromTransport) {
		this.distFromTransport = distFromTransport;
	}
	public Double getDistFromEducation() {
		return distFromEducation;
	}
	public void setDistFromEducation(Double distFromEducation) {
		this.distFromEducation = distFromEducation;
	}
	public Double getDistFromRestrictedArea() {
		return distFromRestrictedArea;
	}
	public void setDistFromRestrictedArea(Double distFromRestrictedArea) {
		this.distFromRestrictedArea = distFromRestrictedArea;
	}
	public Double getDistFromOilPipeline() {
		return distFromOilPipeline;
	}
	public void setDistFromOilPipeline(Double distFromOilPipeline) {
		this.distFromOilPipeline = distFromOilPipeline;
	}
	public Double getDistFromHeritage() {
		return distFromHeritage;
	}
	public void setDistFromHeritage(Double distFromHeritage) {
		this.distFromHeritage = distFromHeritage;
	}
	public Double getDistFromFloodProne() {
		return distFromFloodProne;
	}
	public void setDistFromFloodProne(Double distFromFloodProne) {
		this.distFromFloodProne = distFromFloodProne;
	}
	public Double getElevation() {
		return elevation;
	}
	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}
	
	
	
}
