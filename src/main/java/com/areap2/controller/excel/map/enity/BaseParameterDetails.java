package com.areap2.controller.excel.map.enity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "base_parameter_details_database", schema = "kau")
public class BaseParameterDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "parameter_name", nullable = false)
	private String parameterName;

	private String district;

	private String appreciationType;

	private String discription;

	private boolean visibleToCitizen;

	private String typeOfParameter;

	@Column(name = "status")
	private String status;

	@Column(name = "created_by", updatable = false)
	private String createdBy;

	@Column(name = "created_dtm", updatable = false)
	private LocalDateTime createdDtm;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_dtm")
	private LocalDateTime updatedDtm;

	public BaseParameterDetails() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
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

	public String getAppreciationType() {
		return appreciationType;
	}

	public void setAppreciationType(String appreciationType) {
		this.appreciationType = appreciationType;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public boolean isVisibleToCitizen() {
		return visibleToCitizen;
	}

	public void setVisibleToCitizen(boolean visibleToCitizen) {
		this.visibleToCitizen = visibleToCitizen;
	}

	public String getTypeOfParameter() {
		return typeOfParameter;
	}

	public void setTypeOfParameter(String typeOfParameter) {
		this.typeOfParameter = typeOfParameter;
	}

}
