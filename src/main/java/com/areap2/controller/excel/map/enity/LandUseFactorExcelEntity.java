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
@Table(name = "land_use_factor", schema = "kau")
public class LandUseFactorExcelEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "land_use_factor_gen_id")
	private Long landUseFactorGenId;

	@Column(name = "land_use_factor_code")
	private String landUseFactorCode;

	@Column(name = "land_use")
	private String landUse;

	@Column(name = "rural_urban")
	private String ruralUrban;

	@Column(name = "luf")
	private BigDecimal luf;

	@Column(name = "district")
	private String district;

	private String status;

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
	
	@Column(name = "active")
	private Boolean active;

	@Column(name = "status_code")
	private String statusCode;



	public String getLandUse() {
		return landUse;
	}

	public void setLandUse(String landUse) {
		this.landUse = landUse;
	}

	public String getRuralUrban() {
		return ruralUrban;
	}

	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}

	public BigDecimal getLuf() {
		return luf;
	}

	public void setLuf(BigDecimal luf) {
		this.luf = luf;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public LandUseFactorExcelEntity() {

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

	public Long getLandUseFactorGenId() {
		return landUseFactorGenId;
	}

	public void setLandUseFactorGenId(Long landUseFactorGenId) {
		this.landUseFactorGenId = landUseFactorGenId;
	}

	public String getLandUseFactorCode() {
		return landUseFactorCode;
	}

	public void setLandUseFactorCode(String landUseFactorCode) {
		this.landUseFactorCode = landUseFactorCode;
	}

	


	

	
	
	
	
	

}