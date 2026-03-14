package com.areap2.entity.excel.external;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "land_data_original", schema = "areap2landvaluationexcel")
@Data
public class LandDataXlsPropertyOriginal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String niccode;
	private String textparcel;
	private String landArea;
	private String ruralUrban;

	private String districtCode;
	private String subDivisionCode;
	private String circleCode;
	private String mouzaCode;
	private String lotCode;
	private String villageCode;

	private String createdBy;
	private String updatedBy;
	private LocalDateTime createDtm;
	private LocalDateTime updateDtm;
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNiccode() {
		return niccode;
	}

	public void setNiccode(String niccode) {
		this.niccode = niccode;
	}

	public String getTextparcel() {
		return textparcel;
	}

	public void setTextparcel(String textparcel) {
		this.textparcel = textparcel;
	}

	public String getLandArea() {
		return landArea;
	}

	public void setLandArea(String landArea) {
		this.landArea = landArea;
	}

	public String getRuralUrban() {
		return ruralUrban;
	}

	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getSubDivisionCode() {
		return subDivisionCode;
	}

	public void setSubDivisionCode(String subDivisionCode) {
		this.subDivisionCode = subDivisionCode;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreateDtm() {
		return createDtm;
	}

	public void setCreateDtm(LocalDateTime createDtm) {
		this.createDtm = createDtm;
	}

	public LocalDateTime getUpdateDtm() {
		return updateDtm;
	}

	public void setUpdateDtm(LocalDateTime updateDtm) {
		this.updateDtm = updateDtm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
