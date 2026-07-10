package com.areap2.controller.excel.map.enity.band;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "district_parameter_master", schema = "kau")
public class DistrictParameterMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String district;

	@Enumerated(EnumType.STRING)
	@Column(name = "parameter_name")
	private ParameterName parameterName;

	@Column(name = "rural_urban")
	private String ruralUrban;

	private String band;

	@Column(name = "distance_from")
	private BigDecimal distanceFrom;

	@Column(name = "distance_to")
	private BigDecimal distanceTo;

	@Column(name = "weightage", precision = 20, scale = 6)
	private BigDecimal weightage;

	private Boolean perpetual;

	@Column(name = "is_active")
	private Boolean active;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	@PrePersist
	public void prePersist() {
		this.createdOn = LocalDateTime.now();
		this.updatedOn = LocalDateTime.now();

		if (this.active == null) {
			this.active = true;
		}

		if (this.perpetual == null) {
			this.perpetual = true;
		}
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedOn = LocalDateTime.now();
	}

	public DistrictParameterMaster() {
	}

	public DistrictParameterMaster(Long id, String district, ParameterName parameterName, String ruralUrban,
			String band, BigDecimal distanceFrom, BigDecimal distanceTo, BigDecimal weightage, Boolean perpetual,
			Boolean active, String createdBy, LocalDateTime createdOn, String updatedBy, LocalDateTime updatedOn) {
		super();
		this.id = id;
		this.district = district;
		this.parameterName = parameterName;
		this.ruralUrban = ruralUrban;
		this.band = band;
		this.distanceFrom = distanceFrom;
		this.distanceTo = distanceTo;
		this.weightage = weightage;
		this.perpetual = perpetual;
		this.active = active;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
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

}
