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
@Table(name = "areap2_param_details", schema = "areap2landvaluation")
@NamedQuery(name = "ParamDetails.findAll", query = "SELECT a FROM ParamDetails a")
public class ParamDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "cluster_details_cluster_details_gen_id_seq", sequenceName = "cluster_details_cluster_details_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cluster_details_cluster_details_gen_id_seq")

	@Column(name = "parameter_id")
	private Long parameterId;

	@Column(name = "parameter", nullable = false, length = 200)
	private String parameter;

	@Column(name = "parameter_type", length = 200)
	private String parameterType;

	@Column(name = "area_type_id", nullable = false)
	private Long areaTypeId;

	@Column(name = "min_range_in_meters", precision = 10)
	private BigDecimal minRangeInMeters;

	@Column(name = "max_range_in_meters", precision = 10)
	private BigDecimal maxRangeInMeters;

	@Column(name = "min_max_range", length = 50)
	private String minMaxRange;

	@Column(name = "active")
	private Boolean active;

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

	@Column(name = "master_code")
	private String masterCode;
	
	@Column(name = "master_sub_code")
	private String masterSubCode;

	@Column(name = "base_price_increase_parameter")
	private Long basePriceIncreaseParameter;

	public Long getParameterId() {
		return parameterId;
	}

	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public Long getAreaTypeId() {
		return areaTypeId;
	}

	public void setAreaTypeId(Long areaTypeId) {
		this.areaTypeId = areaTypeId;
	}

	public BigDecimal getMinRangeInMeters() {
		return minRangeInMeters;
	}

	public void setMinRangeInMeters(BigDecimal minRangeInMeters) {
		this.minRangeInMeters = minRangeInMeters;
	}

	public BigDecimal getMaxRangeInMeters() {
		return maxRangeInMeters;
	}

	public void setMaxRangeInMeters(BigDecimal maxRangeInMeters) {
		this.maxRangeInMeters = maxRangeInMeters;
	}

	public String getMinMaxRange() {
		return minMaxRange;
	}

	public void setMinMaxRange(String minMaxRange) {
		this.minMaxRange = minMaxRange;
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

	public String getMasterCode() {
		return masterCode;
	}

	public void setMasterCode(String masterCode) {
		this.masterCode = masterCode;
	}

	public String getMasterSubCode() {
		return masterSubCode;
	}

	public void setMasterSubCode(String masterSubCode) {
		this.masterSubCode = masterSubCode;
	}

	public Long getBasePriceIncreaseParameter() {
		return basePriceIncreaseParameter;
	}

	public void setBasePriceIncreaseParameter(Long basePriceIncreaseParameter) {
		this.basePriceIncreaseParameter = basePriceIncreaseParameter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
