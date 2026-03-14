package com.areap2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "land_area_details", schema = "areap2landvaluation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LandAreaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "area")
	private String area;

	@Column(name = "district_name")
	private String distName;

	@Column(name = "revenue_circle")
	private String revenueCircle;

	@Column(name = "village_name")
	private String villageName;

	@Column(name = "mouza_name")
	private String mouzaName;

	@Column(name = "area_type")
	private String areaType;

	@Column(name = "lot_number")
	private String lotNumber;

	@Column(name = "dag_n_int")
	private String dagNInt;

	@Column(name = "dist_fm_cbd")
	private Double distFromCBD;

	@Column(name = "type_of_cbd")
	private String typeOfCBD;

	@Column(name = "road_fid")
	private String roadFid;

	@Column(name = "dist_fm_road")
	private Double distFromRoad;

	@Column(name = "type_of_road")
	private String typeOfRoad;

	@Column(name = "dist_fm_transport")
	private Double distFromTransport;

	@Column(name = "dist_fm_education")
	private Double distFromEducation;

	@Column(name = "dist_fm_restricted_area")
	private Double distFromRestrictedArea;

	@Column(name = "dist_fm_oil_pipeline")
	private Double distFromOilPipeline;

	@Column(name = "dist_fm_heritage")
	private Double distFromHeritage;

	@Column(name = "dist_fm_flood_prone")
	private Double distFromFloodProne;

	@Column(name = "elevation")
	private Double elevation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
