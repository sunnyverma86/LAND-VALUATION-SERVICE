package com.areap2.entity.excel.external;

import java.math.BigDecimal;
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

	private String nicCode;
	private String textParcel;
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

	//parameter
	private BigDecimal distPwd;
	private BigDecimal distTr;
	private BigDecimal distPrk;
	private BigDecimal disWtrLg;
	private BigDecimal dUrMjcbd;
	private BigDecimal dUrMncbd;
	private BigDecimal dRlMjcbd;
	
	private String distPwdSlab;
	private String distTrSlab;
	private String distPrkSlab;
	private String disWtrLgSlab;
	private String dUrMjcbdSlab;
	private String dUrMncbdSlab;
	private String dRlMjcbdSlab;
	
	private BigDecimal distPwdWeightage;
	private BigDecimal distTrWeightage;
	private BigDecimal distPrkWeightage;
	private BigDecimal disWtrLgWeightage;
	private BigDecimal dUrMjcbdWeightage;
	private BigDecimal dUrMncbdWeightage;
	private BigDecimal dRlMjcbdWeightage;
	
	private String distPwdBand;
	private String distTrBand;
	private String distPrkBand;
	private String disWtrLgBand;
	private String dUrMjcbdBand;
	private String dUrMncbdBand;
	private String dRlMjcbdBand;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNicCode() {
		return nicCode;
	}

	public void setNicCode(String nicCode) {
		this.nicCode = nicCode;
	}

	

	public String getTextParcel() {
		return textParcel;
	}

	public void setTextParcel(String textParcel) {
		this.textParcel = textParcel;
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

	
	public BigDecimal getDistPwdWeightage() {
		return distPwdWeightage;
	}

	public void setDistPwdWeightage(BigDecimal distPwdWeightage) {
		this.distPwdWeightage = distPwdWeightage;
	}

	public BigDecimal getDistTrWeightage() {
		return distTrWeightage;
	}

	public void setDistTrWeightage(BigDecimal distTrWeightage) {
		this.distTrWeightage = distTrWeightage;
	}

	public BigDecimal getDistPrkWeightage() {
		return distPrkWeightage;
	}

	public void setDistPrkWeightage(BigDecimal distPrkWeightage) {
		this.distPrkWeightage = distPrkWeightage;
	}

	public BigDecimal getDisWtrLgWeightage() {
		return disWtrLgWeightage;
	}

	public void setDisWtrLgWeightage(BigDecimal disWtrLgWeightage) {
		this.disWtrLgWeightage = disWtrLgWeightage;
	}

	public BigDecimal getdUrMjcbdWeightage() {
		return dUrMjcbdWeightage;
	}

	public void setdUrMjcbdWeightage(BigDecimal dUrMjcbdWeightage) {
		this.dUrMjcbdWeightage = dUrMjcbdWeightage;
	}

	public BigDecimal getdUrMncbdWeightage() {
		return dUrMncbdWeightage;
	}

	public void setdUrMncbdWeightage(BigDecimal dUrMncbdWeightage) {
		this.dUrMncbdWeightage = dUrMncbdWeightage;
	}

	public BigDecimal getdRlMjcbdWeightage() {
		return dRlMjcbdWeightage;
	}

	public void setdRlMjcbdWeightage(BigDecimal dRlMjcbdWeightage) {
		this.dRlMjcbdWeightage = dRlMjcbdWeightage;
	}

	public String getDistPwdBand() {
		return distPwdBand;
	}

	public void setDistPwdBand(String distPwdBand) {
		this.distPwdBand = distPwdBand;
	}

	public String getDistTrBand() {
		return distTrBand;
	}

	public void setDistTrBand(String distTrBand) {
		this.distTrBand = distTrBand;
	}

	public String getDistPrkBand() {
		return distPrkBand;
	}

	public void setDistPrkBand(String distPrkBand) {
		this.distPrkBand = distPrkBand;
	}

	public String getDisWtrLgBand() {
		return disWtrLgBand;
	}

	public void setDisWtrLgBand(String disWtrLgBand) {
		this.disWtrLgBand = disWtrLgBand;
	}

	public String getdUrMjcbdBand() {
		return dUrMjcbdBand;
	}

	public void setdUrMjcbdBand(String dUrMjcbdBand) {
		this.dUrMjcbdBand = dUrMjcbdBand;
	}

	public String getdUrMncbdBand() {
		return dUrMncbdBand;
	}

	public void setdUrMncbdBand(String dUrMncbdBand) {
		this.dUrMncbdBand = dUrMncbdBand;
	}

	public String getdRlMjcbdBand() {
		return dRlMjcbdBand;
	}

	public void setdRlMjcbdBand(String dRlMjcbdBand) {
		this.dRlMjcbdBand = dRlMjcbdBand;
	}

	
	public String getDistPwdSlab() {
		return distPwdSlab;
	}

	public void setDistPwdSlab(String distPwdSlab) {
		this.distPwdSlab = distPwdSlab;
	}

	public String getDistTrSlab() {
		return distTrSlab;
	}

	public void setDistTrSlab(String distTrSlab) {
		this.distTrSlab = distTrSlab;
	}

	public String getDistPrkSlab() {
		return distPrkSlab;
	}

	public void setDistPrkSlab(String distPrkSlab) {
		this.distPrkSlab = distPrkSlab;
	}

	public String getDisWtrLgSlab() {
		return disWtrLgSlab;
	}

	public void setDisWtrLgSlab(String disWtrLgSlab) {
		this.disWtrLgSlab = disWtrLgSlab;
	}

	public String getdUrMjcbdSlab() {
		return dUrMjcbdSlab;
	}

	public void setdUrMjcbdSlab(String dUrMjcbdSlab) {
		this.dUrMjcbdSlab = dUrMjcbdSlab;
	}

	public String getdUrMncbdSlab() {
		return dUrMncbdSlab;
	}

	public void setdUrMncbdSlab(String dUrMncbdSlab) {
		this.dUrMncbdSlab = dUrMncbdSlab;
	}

	public String getdRlMjcbdSlab() {
		return dRlMjcbdSlab;
	}

	public void setdRlMjcbdSlab(String dRlMjcbdSlab) {
		this.dRlMjcbdSlab = dRlMjcbdSlab;
	}

	public BigDecimal getDistPwd() {
		return distPwd;
	}

	public void setDistPwd(BigDecimal distPwd) {
		this.distPwd = distPwd;
	}

	public BigDecimal getDistTr() {
		return distTr;
	}

	public void setDistTr(BigDecimal distTr) {
		this.distTr = distTr;
	}

	public BigDecimal getDistPrk() {
		return distPrk;
	}

	public void setDistPrk(BigDecimal distPrk) {
		this.distPrk = distPrk;
	}

	public BigDecimal getDisWtrLg() {
		return disWtrLg;
	}

	public void setDisWtrLg(BigDecimal disWtrLg) {
		this.disWtrLg = disWtrLg;
	}

	public BigDecimal getdUrMjcbd() {
		return dUrMjcbd;
	}

	public void setdUrMjcbd(BigDecimal dUrMjcbd) {
		this.dUrMjcbd = dUrMjcbd;
	}

	public BigDecimal getdUrMncbd() {
		return dUrMncbd;
	}

	public void setdUrMncbd(BigDecimal dUrMncbd) {
		this.dUrMncbd = dUrMncbd;
	}

	public BigDecimal getdRlMjcbd() {
		return dRlMjcbd;
	}

	public void setdRlMjcbd(BigDecimal dRlMjcbd) {
		this.dRlMjcbd = dRlMjcbd;
	}
	
	
	

		

}
