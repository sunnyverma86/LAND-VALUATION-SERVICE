package com.areap2.entity.excel.external;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "slab_group", schema = "areap2landvaluationexcel")
public class SlabGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String district;

	private Integer versionNo;

	private Boolean active;

	private String createdBy;

	private String requestStatus;

	private LocalDateTime createdDtm;

	@ManyToOne
	@JoinColumn(name = "distance_type_id")
	private DistanceType distanceType;

	@Column(name = "parameter_name")
	private String parameterName;

	@Column(name = "area_type")
	private String areaType;

	@Column(name = "perpetual")
	private boolean perpetual;

	@Column(name = "effective_till")
	private String effectiveTill;

	private String status;

	private String statusCode;

	private Boolean isActive;

	public SlabGroup() {
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

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
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

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public LocalDateTime getCreatedDtm() {
		return createdDtm;
	}

	public void setCreatedDtm(LocalDateTime createdDtm) {
		this.createdDtm = createdDtm;
	}

	public DistanceType getDistanceType() {
		return distanceType;
	}

	public void setDistanceType(DistanceType distanceType) {
		this.distanceType = distanceType;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public boolean isPerpetual() {
		return perpetual;
	}

	public void setPerpetual(boolean perpetual) {
		this.perpetual = perpetual;
	}

	public String getEffectiveTill() {
		return effectiveTill;
	}

	public void setEffectiveTill(String effectiveTill) {
		this.effectiveTill = effectiveTill;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



}