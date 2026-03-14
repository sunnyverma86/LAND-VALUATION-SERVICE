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
@Table(name = "areap2_village_details", schema = "areap2landvaluation")
@NamedQuery(name = "VillageDetails.findAll", query = "SELECT a FROM VillageDetails a")
public class VillageDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_village_details_village_gen_id_seq", sequenceName = "areap2_village_details_village_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_village_details_village_gen_id_seq")
	@Column(name = "village_gen_id")
	private Long villageGenId;

	@Column(name = "district_code")
	private String districtCode;

	@Column(name = "circle_code")
	private String circleCode;

	@Column(name = "mouza_code")
	private String mouzaCode;

	@Column(name = "lot_code")
	private String lotCode;

	@Column(name = "village_code")
	private String villageCode;

	@Column(name = "village_name")
	private String villageName;

	@Column(name = "area_type") // urban/rural
	private String areaType;
	
	@Column(name = "landCategory") // Agricultural/
	private String landCategory;

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

	@Column(name = "base_price_village")
	private BigDecimal basePriceVillage;
	
	@Column(name = "request_status")
	private String requestStatus;

	public Long getVillageGenId() {
		return villageGenId;
	}

	public void setVillageGenId(Long villageGenId) {
		this.villageGenId = villageGenId;
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

	public String getLotCode() {
		return lotCode;
	}

	public void setLotCode(String lotCode) {
		this.lotCode = lotCode;
	}

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public String getLandCategory() {
		return landCategory;
	}

	public void setLandCategory(String landCategory) {
		this.landCategory = landCategory;
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

	public BigDecimal getBasePriceVillage() {
		return basePriceVillage;
	}

	public void setBasePriceVillage(BigDecimal basePriceVillage) {
		this.basePriceVillage = basePriceVillage;
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

	
	
}
