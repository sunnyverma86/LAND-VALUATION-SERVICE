package com.areap2.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "areap2_district_details", schema = "areap2landvaluation")
@NamedQuery(name = "DistrictDetails.findAll", query = "SELECT a FROM DistrictDetails a")
public class DistrictDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "district_gen_id")
	private Long districtGenId;

	@Column(name = "district_name")
	private String districtName;

	@Column(name = "district_code",nullable=false)
	private String districtCode;

	

	@Column(name = "created_by")
	private String createdBy;
 
	@Column(name = "created_dtm")
	private Timestamp createdDtm = new Timestamp(System.currentTimeMillis());

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_dtm")
	private Timestamp updatedDtm;

	
	@Column(name = "status")
	private String status;

	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "status_code")
	private String statusCode;
	
	@Column(name = "request_status")
	private String requestStatus;
	
	@Column(name = "is_corner_plot")
	private String isCornerPlot;
	
	@Column(name = "value_of_corner_plot")
	private String valueOfCornerPlot;
	
	

	public Long getDistrictGenId() {
		return districtGenId;
	}

	public void setDistrictGenId(Long districtGenId) {
		this.districtGenId = districtGenId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
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

	public Timestamp getCreatedDtm() {
		return createdDtm;
	}

	public void setCreatedDtm(Timestamp createdDtm) {
		this.createdDtm = createdDtm;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDtm() {
		return updatedDtm;
	}

	public void setUpdatedDtm(Timestamp updatedDtm) {
		this.updatedDtm = updatedDtm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIsCornerPlot() {
		return isCornerPlot;
	}

	public void setIsCornerPlot(String isCornerPlot) {
		this.isCornerPlot = isCornerPlot;
	}

	public String getValueOfCornerPlot() {
		return valueOfCornerPlot;
	}

	public void setValueOfCornerPlot(String valueOfCornerPlot) {
		this.valueOfCornerPlot = valueOfCornerPlot;
	}


	
	
	
	
	

}
