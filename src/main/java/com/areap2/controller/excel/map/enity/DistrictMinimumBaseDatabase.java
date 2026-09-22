package com.areap2.controller.excel.map.enity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "district_minimum_base_database", schema = "kau")
public class DistrictMinimumBaseDatabase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "district_minimum_gen_id")
	private Long districtMinimumGenId;

	@Column(name = "district_minimum_code")
	private String districtMinimumCode;
	
	

	@Column(name = "district")
	private String district;

	@Column(name = "rural_urban")
	private String ruralUrban;

	@Column(name = "land_use")
	private String landUse;

	@Column(name = "district_minimum_value")
	private Double districtMinimumValue;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_dtm")
	private LocalDateTime createdDtm;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_dtm")
	private LocalDateTime updatedDtm;

	@Column(name = "request_status")
	private String requestStatus;

	@Column(name = "status")
	private String status;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "status_code")
	private String statusCode;
	

	public DistrictMinimumBaseDatabase() {
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

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Long getDistrictMinimumGenId() {
		return districtMinimumGenId;
	}

	public void setDistrictMinimumGenId(Long districtMinimumGenId) {
		this.districtMinimumGenId = districtMinimumGenId;
	}

	public String getDistrictMinimumCode() {
		return districtMinimumCode;
	}

	public void setDistrictMinimumCode(String districtMinimumCode) {
		this.districtMinimumCode = districtMinimumCode;
	}

	

	
	
	

}
