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
@Table(name = "areap2_lot_details", schema = "areap2landvaluation")
@NamedQuery(name = "LotDetails.findAll", query = "SELECT a FROM LotDetails a")
public class LotDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_lot_details_lot_gen_id_seq", sequenceName = "areap2_lot_details_lot_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_lot_details_lot_gen_id_seq")
	@Column(name = "lot_gen_id")
	private Long lotGenId;

	@Column(name = "lot_name")
	private String lotName;

	@Column(name = "lot_code")
	private String lotCode;

	@Column(name = "area_type_id")
	private Long areaTypeId;

	@Column(name = "district_code")
	private String districtCode;

	@Column(name = "circle_code")
	private String circleCode;

	@Column(name = "mouza_code")
	private String mouzaCode;

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

	@Column(name = "circle_name")
	private String circleName;

	@Column(name = "base_price_increase_lot")
	private BigDecimal basePriceIncreaseLot;
	
	@Column(name = "request_status")
	private String requestStatus;

	public Long getLotGenId() {
		return lotGenId;
	}

	public void setLotGenId(Long lotGenId) {
		this.lotGenId = lotGenId;
	}

	public String getLotName() {
		return lotName;
	}

	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

	public String getLotCode() {
		return lotCode;
	}

	public void setLotCode(String lotCode) {
		this.lotCode = lotCode;
	}

	public Long getAreaTypeId() {
		return areaTypeId;
	}

	public void setAreaTypeId(Long areaTypeId) {
		this.areaTypeId = areaTypeId;
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

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public BigDecimal getBasePriceIncreaseLot() {
		return basePriceIncreaseLot;
	}

	public void setBasePriceIncreaseLot(BigDecimal basePriceIncreaseLot) {
		this.basePriceIncreaseLot = basePriceIncreaseLot;
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
