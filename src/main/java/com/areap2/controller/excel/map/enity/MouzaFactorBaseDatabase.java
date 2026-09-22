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
@Table(name = "mf_calculation", schema = "kau")
public class MouzaFactorBaseDatabase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mouza_factor_gen_id")
	private Long mouzaFactorGenId;

	@Column(name = "mouza_factor_code")
	private String mouzaFactorCode;

	private String district;

	private String mouza;

	@Column(name = "rural_urban")
	private String ruralUrban;

	@Column(name = "land_use")
	private String landUse;

	@Column(name = "min_excl")
	private BigDecimal minExcl;

	@Column(name = "higher_land_class_min")
	private BigDecimal higherLandClassMin;

	private BigDecimal lc;

	private BigDecimal luf;

	@Column(name = "district_minimum")
	private BigDecimal districtMinimum;

	private BigDecimal current;

	@Column(name = "final_mf_zonal_value")
	private BigDecimal finalMfZonalValue;

	private LocalDateTime createdDtm;

	//

	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private LocalDateTime updatedAt;

	@Column(name = "status")
	private String status;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "status_code")
	private String statusCode;

	@Column(name = "request_status")
	private String requestStatus;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_dtm")
	private LocalDateTime updatedDtm;

	//

	//

	public MouzaFactorBaseDatabase() {

	}

	public String getMouza() {
		return mouza;
	}

	public void setMouza(String mouza) {
		this.mouza = mouza;
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

	public BigDecimal getMinExcl() {
		return minExcl;
	}

	public void setMinExcl(BigDecimal minExcl) {
		this.minExcl = minExcl;
	}

	public BigDecimal getHigherLandClassMin() {
		return higherLandClassMin;
	}

	public void setHigherLandClassMin(BigDecimal higherLandClassMin) {
		this.higherLandClassMin = higherLandClassMin;
	}

	public BigDecimal getLc() {
		return lc;
	}

	public void setLc(BigDecimal lc) {
		this.lc = lc;
	}

	public BigDecimal getLuf() {
		return luf;
	}

	public void setLuf(BigDecimal luf) {
		this.luf = luf;
	}

	public BigDecimal getDistrictMinimum() {
		return districtMinimum;
	}

	public void setDistrictMinimum(BigDecimal districtMinimum) {
		this.districtMinimum = districtMinimum;
	}

	public BigDecimal getCurrent() {
		return current;
	}

	public void setCurrent(BigDecimal current) {
		this.current = current;
	}

	public BigDecimal getFinalMfZonalValue() {
		return finalMfZonalValue;
	}

	public void setFinalMfZonalValue(BigDecimal finalMfZonalValue) {
		this.finalMfZonalValue = finalMfZonalValue;
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

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
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

	public Long getMouzaFactorGenId() {
		return mouzaFactorGenId;
	}

	public void setMouzaFactorGenId(Long mouzaFactorGenId) {
		this.mouzaFactorGenId = mouzaFactorGenId;
	}

	public String getMouzaFactorCode() {
		return mouzaFactorCode;
	}

	public void setMouzaFactorCode(String mouzaFactorCode) {
		this.mouzaFactorCode = mouzaFactorCode;
	}

	

}