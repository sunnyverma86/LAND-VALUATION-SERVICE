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
@Table(name = "areap2_lands_category_details", schema = "areap2landvaluation")
@NamedQuery(name = "LandsCategoryDetails.findAll", query = "SELECT a FROM LandsCategoryDetails a")
public class LandsCategoryDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_lands_category_gen_id_seq", sequenceName = "areap2_lands_category_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_lands_category_gen_id_seq")
	@Column(name = "land_category_gen_id")
	private Long landCategoryGenId;

	@Column(name = "land_category_code")
	private String landCategoryCode;

	@Column(name = "land_category_name")
	private String landCategoryName;

	@Column(name = "land_class_name")
	private String landClassName;

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

	@Column(name = "request_status")
	private String requestStatus;

	@Column(name = "base_price_land_category")
	private BigDecimal basePriceLandCategory;

	public Long getLandCategoryGenId() {
		return landCategoryGenId;
	}

	public void setLandCategoryGenId(Long landCategoryGenId) {
		this.landCategoryGenId = landCategoryGenId;
	}

	public String getLandCategoryCode() {
		return landCategoryCode;
	}

	public void setLandCategoryCode(String landCategoryCode) {
		this.landCategoryCode = landCategoryCode;
	}

	public String getLandCategoryName() {
		return landCategoryName;
	}

	public void setLandCategoryName(String landCategoryName) {
		this.landCategoryName = landCategoryName;
	}

	public String getLandClassName() {
		return landClassName;
	}

	public void setLandClassName(String landClassName) {
		this.landClassName = landClassName;
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

	public BigDecimal getBasePriceLandCategory() {
		return basePriceLandCategory;
	}

	public void setBasePriceLandCategory(BigDecimal basePriceLandCategory) {
		this.basePriceLandCategory = basePriceLandCategory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
