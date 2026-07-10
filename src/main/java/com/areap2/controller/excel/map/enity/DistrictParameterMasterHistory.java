package com.areap2.controller.excel.map.enity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.areap2.controller.excel.map.enity.band.ParameterName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "district_parameter_master_history", schema = "kau")
public class DistrictParameterMasterHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long historyId;

	private Long masterId;

	private String district;

	@Enumerated(EnumType.STRING)
	private ParameterName parameterName;

	private String ruralUrban;

	private String band;

	private BigDecimal distanceFrom;

	private BigDecimal distanceTo;

	private BigDecimal weightage;

	private Boolean perpetual;

	private Boolean active;

	private String createdBy;

	private LocalDateTime createdOn;

	private String updatedBy;

	private LocalDateTime updatedOn;

	private String action; // UPDATE / DELETE

	private String actionBy;

	private LocalDateTime actionOn;
	
	public DistrictParameterMasterHistory() {
		
	}

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public Long getMasterId() {
		return masterId;
	}

	public void setMasterId(Long masterId) {
		this.masterId = masterId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public ParameterName getParameterName() {
		return parameterName;
	}

	public void setParameterName(ParameterName parameterName) {
		this.parameterName = parameterName;
	}

	public String getRuralUrban() {
		return ruralUrban;
	}

	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public BigDecimal getDistanceFrom() {
		return distanceFrom;
	}

	public void setDistanceFrom(BigDecimal distanceFrom) {
		this.distanceFrom = distanceFrom;
	}

	public BigDecimal getDistanceTo() {
		return distanceTo;
	}

	public void setDistanceTo(BigDecimal distanceTo) {
		this.distanceTo = distanceTo;
	}

	public BigDecimal getWeightage() {
		return weightage;
	}

	public void setWeightage(BigDecimal weightage) {
		this.weightage = weightage;
	}

	public Boolean getPerpetual() {
		return perpetual;
	}

	public void setPerpetual(Boolean perpetual) {
		this.perpetual = perpetual;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public LocalDateTime getActionOn() {
		return actionOn;
	}

	public void setActionOn(LocalDateTime actionOn) {
		this.actionOn = actionOn;
	}
	
	
	
}
