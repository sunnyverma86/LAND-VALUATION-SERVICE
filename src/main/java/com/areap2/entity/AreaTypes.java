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
@Table(name = "areap2_area_types", schema = "areap2landvaluation")
@NamedQuery(name = "AreaTypes.findAll", query = "SELECT a FROM AreaTypes a")
public class AreaTypes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_area_types_area_types_gen_id_seq", sequenceName = "areap2_area_types_area_types_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_area_types_area_types_gen_id_seq")
	@Column(name = "area_types_gen_id")
	private Long areaTypesGenId;

	@Column(name = "area_type")
	private String areaType;

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

	@Column(name = "status")
	private String status;

	@Column(name = "status_code")
	private String statusCode;

	@Column(name = "base_price_increase_area_type")
	private Long basePriceIncreaseAreaType;

	@Column(name = "district_code")
	private String districtCode;

	@Column(name = "circle_code")
	private String circleCode;

	@Column(name = "mouza_code")
	private String mouzaCode;

	public Long getAreaTypesGenId() {
		return areaTypesGenId;
	}

	public void setAreaTypesGenId(Long areaTypesGenId) {
		this.areaTypesGenId = areaTypesGenId;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
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

	public Long getBasePriceIncreaseAreaType() {
		return basePriceIncreaseAreaType;
	}

	public void setBasePriceIncreaseAreaType(Long basePriceIncreaseAreaType) {
		this.basePriceIncreaseAreaType = basePriceIncreaseAreaType;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getCircleCode() {
		return circleCode;
	}

	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	public String getMouzaCode() {
		return mouzaCode;
	}

	public void setMouzaCode(String mouzaCode) {
		this.mouzaCode = mouzaCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
