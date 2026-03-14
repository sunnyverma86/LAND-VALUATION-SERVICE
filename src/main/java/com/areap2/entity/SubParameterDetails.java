package com.areap2.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "areap2_sub_parameter_details", schema = "areap2landvaluation")
@NamedQuery(name = "SubParameterDetails.findAll", query = "SELECT a FROM SubParameterDetails a")
public class SubParameterDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_sub_parameter_details_sub_parameter_gen_id_seq", sequenceName = "areap2_sub_parameter_details_sub_parameter_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_sub_parameter_details_sub_parameter_gen_id_seq")
	@Column(name = "sub_parameter_gen_id")
	private Long subParameterGenId;

	@Column(name = "parameter_code")
	private String parameterCode;
	
	@Column(name = "band_code")
	private String bandCode;
	
	@Column(name = "weightage")
	private BigDecimal weightage;
	
	@Column(name = "effective_till")
	private String effectiveTill;
	
	@Column(name = "area_type")
	private String areaType;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "band")
	private String band;
	
	@Column(name = "distance_from")
	private BigDecimal distanceFrom;
	
	@Column(name = "distance_to")
	private BigDecimal distanceTo;
	
	@Column(name = "perpetual")
	private Boolean perpetual;
	
	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_dtm")
	private Timestamp createdDtm = new Timestamp(System.currentTimeMillis());

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_dtm")
	private Timestamp updatedDtm;

	@Column(name = "approved_by")
	private String approvedBy;

	@Column(name = "approved_dtm")
	private Timestamp approvedDtm;

	@Column(name = "status")
	private String status;

	@Column(name = "status_code")
	private String statusCode;
	
	@Column(name = "request_status")
	private String requestStatus;
	
	@Column(name = "district_code")
	private String districtCode;
	
	@Column(name = "sub_parameter_code")
	private String subParameterCode;
	
	@Column(name = "sub_parameter_name")
	private String subParameterName;
	
	@Column(name = "active")
	private boolean active;

	public Long getSubParameterGenId() {
		return subParameterGenId;
	}

	public void setSubParameterGenId(Long subParameterGenId) {
		this.subParameterGenId = subParameterGenId;
	}

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}

	public String getBandCode() {
		return bandCode;
	}

	public void setBandCode(String bandCode) {
		this.bandCode = bandCode;
	}

	public BigDecimal getWeightage() {
		return weightage;
	}

	public void setWeightage(BigDecimal weightage) {
		this.weightage = weightage;
	}

	public String getEffectiveTill() {
		return effectiveTill;
	}

	public void setEffectiveTill(String effectiveTill) {
		this.effectiveTill = effectiveTill;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public Boolean getPerpetual() {
		return perpetual;
	}

	public void setPerpetual(Boolean perpetual) {
		this.perpetual = perpetual;
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

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Timestamp getApprovedDtm() {
		return approvedDtm;
	}

	public void setApprovedDtm(Timestamp approvedDtm) {
		this.approvedDtm = approvedDtm;
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

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getSubParameterCode() {
		return subParameterCode;
	}

	public void setSubParameterCode(String subParameterCode) {
		this.subParameterCode = subParameterCode;
	}

	public String getSubParameterName() {
		return subParameterName;
	}

	public void setSubParameterName(String subParameterName) {
		this.subParameterName = subParameterName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

	

}
