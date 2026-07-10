package com.areap2.controller.excel.map.enity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "land_master", schema = "kau")
public class LandRecordEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String mouza;
	private String village;
	private BigDecimal zonalValue;

	private String ruralUrban;
	private String landUse;

	private BigDecimal nh;
	private BigDecimal distPwd;
	private BigDecimal dMjcbd;
	private BigDecimal dUrMncbd;

	private String disWtrLg;

	private BigDecimal oilPipeline;
	private BigDecimal ecosensitive;

	private String nic;
	private String helper;
	private String plot;

	private String mouzaCode;
	private String helperCode;

	private String district;

	private String circle;

	private String lot;

	public LandRecordEntity() {
	}

	public String getMouza() {
		return mouza;
	}

	public void setMouza(String mouza) {
		this.mouza = mouza;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public BigDecimal getZonalValue() {
		return zonalValue;
	}

	public void setZonalValue(BigDecimal zonalValue) {
		this.zonalValue = zonalValue;
	}

	public String getRuralUrban() {
		return ruralUrban;
	}

	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}

	public String getLandUse() {
		return landUse;
	}

	public void setLandUse(String landUse) {
		this.landUse = landUse;
	}

	public BigDecimal getNh() {
		return nh;
	}

	public void setNh(BigDecimal nh) {
		this.nh = nh;
	}

	public BigDecimal getDistPwd() {
		return distPwd;
	}

	public void setDistPwd(BigDecimal distPwd) {
		this.distPwd = distPwd;
	}

	public BigDecimal getdMjcbd() {
		return dMjcbd;
	}

	public void setdMjcbd(BigDecimal dMjcbd) {
		this.dMjcbd = dMjcbd;
	}

	public BigDecimal getdUrMncbd() {
		return dUrMncbd;
	}

	public void setdUrMncbd(BigDecimal dUrMncbd) {
		this.dUrMncbd = dUrMncbd;
	}

	public String getDisWtrLg() {
		return disWtrLg;
	}

	public void setDisWtrLg(String disWtrLg) {
		this.disWtrLg = disWtrLg;
	}

	public BigDecimal getOilPipeline() {
		return oilPipeline;
	}

	public void setOilPipeline(BigDecimal oilPipeline) {
		this.oilPipeline = oilPipeline;
	}

	public BigDecimal getEcosensitive() {
		return ecosensitive;
	}

	public void setEcosensitive(BigDecimal ecosensitive) {
		this.ecosensitive = ecosensitive;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getHelper() {
		return helper;
	}

	public void setHelper(String helper) {
		this.helper = helper;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getMouzaCode() {
		return mouzaCode;
	}

	public void setMouzaCode(String mouzaCode) {
		this.mouzaCode = mouzaCode;
	}

	public String getHelperCode() {
		return helperCode;
	}

	public void setHelperCode(String helperCode) {
		this.helperCode = helperCode;
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

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public LandRecordEntity(Long id, String mouza, String village, BigDecimal zonalValue, String ruralUrban,
			String landUse, BigDecimal nh, BigDecimal distPwd, BigDecimal dMjcbd, BigDecimal dUrMncbd, String disWtrLg,
			BigDecimal oilPipeline, BigDecimal ecosensitive, String nic, String helper, String plot, String mouzaCode,
			String helperCode, String district, String circle, String lot) {
		this.id = id;
		this.mouza = mouza;
		this.village = village;
		this.zonalValue = zonalValue;
		this.ruralUrban = ruralUrban;
		this.landUse = landUse;
		this.nh = nh;
		this.distPwd = distPwd;
		this.dMjcbd = dMjcbd;
		this.dUrMncbd = dUrMncbd;
		this.disWtrLg = disWtrLg;
		this.oilPipeline = oilPipeline;
		this.ecosensitive = ecosensitive;
		this.nic = nic;
		this.helper = helper;
		this.plot = plot;
		this.mouzaCode = mouzaCode;
		this.helperCode = helperCode;
		this.district = district;
		this.circle = circle;
		this.lot = lot;
	}

}