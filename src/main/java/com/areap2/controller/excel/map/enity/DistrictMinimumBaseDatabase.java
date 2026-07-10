package com.areap2.controller.excel.map.enity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "district_minimum_base_database",schema = "kau")
public class DistrictMinimumBaseDatabase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "district")
	private String district;

	@Column(name = "rural_urban")
	private String ruralUrban;

	@Column(name = "land_use")
	private String landUse;

	@Column(name = "district_minimum_value")
	private Double districtMinimumValue;

	private String status;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_dtm")
	private LocalDateTime createdDtm;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_dtm")
	private LocalDateTime updatedDtm;

	public DistrictMinimumBaseDatabase() {
	}

	public Long getId() {
		return id;
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

	public String getRuralUrban() {
		return ruralUrban;
	}

	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}

	public String getLandUse() {
		return landUse;
	}

	public void setLandUse(String landUse) {
		this.landUse = landUse;
	}

	public Double getDistrictMinimumValue() {
		return districtMinimumValue;
	}

	public void setDistrictMinimumValue(Double districtMinimumValue) {
		this.districtMinimumValue = districtMinimumValue;
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

}
