package com.areap2.controller.excel.map.enity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "village_land_class", schema = "kau")
public class VillageLandClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "excel_id")
	private String excelId;

	@Column(name = "village")
	private String village;
	
	@Column(name = "mouza")
	private String mouza;

	@Column(name = "rural_urban")
	private String ruralUrban;

	@Column(name = "land_class")
	private String landClass;
	
	@Column(name = "village_code")
	private Long villageCode;

	@Column(name = "min_without_outliers")
	private BigDecimal minWithoutOutliers;

	@Column(name = "equivalent_minimum")
	private BigDecimal equivalentMinimum;

	@Column(name = "name_of_equivalent")
	private String nameOfEquivalent;

	@Column(name = "luf")
	private BigDecimal luf;

	@Column(name = "min_equivalent_value")
	private BigDecimal minEquivalentValue;

	@Column(name = "final_min_eq")
	private BigDecimal finalMinEq;

	@Column(name = "mouza_code")
	private String mouzaCode;

	@Column(name = "unique_id")
	private String uniqueId;

	@Column(name = "mouza_name")
	private String mouzaName;

	@Column(name = "mouza_min")
	private BigDecimal mouzaMin;

	@Column(name = "band_ratio")
	private BigDecimal bandRatio;

	private String status;
	
	private String district;

	private String createdBy;

	private LocalDateTime createdDtm;

	private String updatedBy;

	private LocalDateTime updatedDtm;

	public VillageLandClassEntity() {

	}

	// ===== Getters and Setters =====

	public Long getId() {
		return id;
	}

	public String getExcelId() {
		return excelId;
	}

	public void setExcelId(String excelId) {
		this.excelId = excelId;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getRuralUrban() {
		return ruralUrban;
	}

	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}

	public String getLandClass() {
		return landClass;
	}

	public void setLandClass(String landClass) {
		this.landClass = landClass;
	}

	public BigDecimal getMinWithoutOutliers() {
		return minWithoutOutliers;
	}

	public void setMinWithoutOutliers(BigDecimal minWithoutOutliers) {
		this.minWithoutOutliers = minWithoutOutliers;
	}

	public BigDecimal getEquivalentMinimum() {
		return equivalentMinimum;
	}

	public void setEquivalentMinimum(BigDecimal equivalentMinimum) {
		this.equivalentMinimum = equivalentMinimum;
	}

	public String getNameOfEquivalent() {
		return nameOfEquivalent;
	}

	public void setNameOfEquivalent(String nameOfEquivalent) {
		this.nameOfEquivalent = nameOfEquivalent;
	}

	public BigDecimal getLuf() {
		return luf;
	}

	public void setLuf(BigDecimal luf) {
		this.luf = luf;
	}

	public BigDecimal getMinEquivalentValue() {
		return minEquivalentValue;
	}

	public void setMinEquivalentValue(BigDecimal minEquivalentValue) {
		this.minEquivalentValue = minEquivalentValue;
	}

	public BigDecimal getFinalMinEq() {
		return finalMinEq;
	}

	public void setFinalMinEq(BigDecimal finalMinEq) {
		this.finalMinEq = finalMinEq;
	}

	public String getMouzaCode() {
		return mouzaCode;
	}

	public void setMouzaCode(String mouzaCode) {
		this.mouzaCode = mouzaCode;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getMouzaName() {
		return mouzaName;
	}

	public void setMouzaName(String mouzaName) {
		this.mouzaName = mouzaName;
	}

	public BigDecimal getMouzaMin() {
		return mouzaMin;
	}

	public void setMouzaMin(BigDecimal mouzaMin) {
		this.mouzaMin = mouzaMin;
	}

	public BigDecimal getBandRatio() {
		return bandRatio;
	}

	public void setBandRatio(BigDecimal bandRatio) {
		this.bandRatio = bandRatio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDtm() {
		return createdDtm;
	}

	public void setCreatedDtm(LocalDateTime createdDtm) {
		this.createdDtm = createdDtm;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDtm() {
		return updatedDtm;
	}

	public void setUpdatedDtm(LocalDateTime updatedDtm) {
		this.updatedDtm = updatedDtm;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	
	
}
