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
@Table(name = "areap2_parameter_details", schema = "areap2landvaluation")
@NamedQuery(name = "ParameterDetails.findAll", query = "SELECT a FROM ParameterDetails a")
public class ParameterDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_parameter_details_parameter_gen_id_seq", sequenceName = "areap2_parameter_details_parameter_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_parameter_details_parameter_gen_id_seq")
	@Column(name = "parameter_gen_id")
	private Long parameterGenId;

	

	@Column(name = "parameter_code")
	private String parameterCode;
	
	@Column(name = "parameter_id")
	private String parameterId;

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

	@Column(name = "base_price_increase_parameter")
	private Long basePriceIncreaseParameter;
	
	@Column(name = "request_status")
	private String requestStatus;
	
	@Column(name = "parameter_name")
	private String parameterName;
	
	@Column(name = "parameter_data")
	private String parameterData;
	
	@Column(name = "appreciation_type")
	private String appreciationType;

	@Column(name = "parameter_description")
	private String parameterDescription;
	
	@Column(name = "visible_to_citizen")
	private Boolean visibleToCitizen;

	public Long getParameterGenId() {
		return parameterGenId;
	}

	public void setParameterGenId(Long parameterGenId) {
		this.parameterGenId = parameterGenId;
	}

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}

	public String getParameterId() {
		return parameterId;
	}

	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
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

	public Long getBasePriceIncreaseParameter() {
		return basePriceIncreaseParameter;
	}

	public void setBasePriceIncreaseParameter(Long basePriceIncreaseParameter) {
		this.basePriceIncreaseParameter = basePriceIncreaseParameter;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterData() {
		return parameterData;
	}

	public void setParameterData(String parameterData) {
		this.parameterData = parameterData;
	}

	public String getAppreciationType() {
		return appreciationType;
	}

	public void setAppreciationType(String appreciationType) {
		this.appreciationType = appreciationType;
	}

	public String getParameterDescription() {
		return parameterDescription;
	}

	public void setParameterDescription(String parameterDescription) {
		this.parameterDescription = parameterDescription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getVisibleToCitizen() {
		return visibleToCitizen;
	}

	public void setVisibleToCitizen(Boolean visibleToCitizen) {
		this.visibleToCitizen = visibleToCitizen;
	}
	
	
	
	
	
//
//	@Column(name = "parameter", nullable = false, length = 200)
//	private String parameter;
//
//	@Column(name = "parameter_type", length = 200)
//	private String parameterType;
//
//	@Column(name = "area_type_id", nullable = false)
//	private Long areaTypeId;
//
//	@Column(name = "min_range_in_meters", precision = 10)
//	private BigDecimal minRangeInMeters;
//
//	@Column(name = "max_range_in_meters", precision = 10)
//	private BigDecimal maxRangeInMeters;
//
//	@Column(name = "min_max_range", length = 50)
//	private String minMaxRange;

	
	
}
