package com.areap2.controller.excel.map.enity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "land_master_output", schema = "kau")
public class LandMasterOutputEntity {

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

	private String helperCode;
	private String helper;

	private String nic;
	private String plot;

	private String mouzaCode;

	private String district;
	
	private String circle;
	
	private String lot;

	private BigDecimal districtMinimum;

	@Column(name = "mf_calculated", precision = 20, scale = 6)
	private BigDecimal mfCalculated;

	@Column(name = "luf", precision = 20, scale = 6)
	private BigDecimal luf;

	@Column(name = "vf_calculated", precision = 20, scale = 6)
	private BigDecimal vfCalculated;

	@Column(name = "base_value", precision = 20, scale = 6)
	private BigDecimal baseValue;

	@Column(name = "nh_weightage", precision = 20, scale = 6)
	private BigDecimal nhWeightage;

	@Column(name = "dist_pwd_weightage", precision = 20, scale = 6)
	private BigDecimal distPwdWeightage;

	@Column(name = "d_mjcbd_weightage", precision = 20, scale = 6)
	private BigDecimal dMjcbdWeightage;

	@Column(name = "d_ur_mncbd_weightage", precision = 20, scale = 6)
	private BigDecimal dUrMncbdWeightage;

	@Column(name = "dis_wtr_lg_weightage", precision = 20, scale = 6)
	private BigDecimal disWtrLgWeightage;

	@Column(name = "oil_pipeline_weightage", precision = 20, scale = 6)
	private BigDecimal oilPipelineWeightage;

	@Column(name = "ecosensitive_weightage", precision = 20, scale = 6)
	private BigDecimal ecosensitiveWeightage;

	@Column(name = "option_sum_weightage", precision = 20, scale = 6)
	private BigDecimal optionSumWeightage;

	@Column(name = "option_value_one_add_weightage", precision = 20, scale = 6)
	private BigDecimal optionValueOneAddWeightage;

	@Column(name = "option_final", precision = 20, scale = 6)
	private BigDecimal optionFinal;
	
	@Column(name = "option_final_sub_zonal", precision = 20, scale = 6)
	private BigDecimal optionFinalSubZonal;
	
	@Column(name = "option_final_sub_zonal_percen", precision = 20, scale = 6)
	private BigDecimal optionFinalSubZonalPercen;
	
	@Column(name = "option_final_sub_zonal_percen_bracket")
	private String optionFinalSubZonalPercenBracket;
	
	
	private String landArea;
	

	

	public LandMasterOutputEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getDistrictMinimum() {
		return districtMinimum;
	}

	public void setDistrictMinimum(BigDecimal districtMinimum) {
		this.districtMinimum = districtMinimum;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public BigDecimal getMfCalculated() {
		return mfCalculated;
	}

	public void setMfCalculated(BigDecimal mfCalculated) {
		this.mfCalculated = mfCalculated;
	}

	public BigDecimal getLuf() {
		return luf;
	}

	public void setLuf(BigDecimal luf) {
		this.luf = luf;
	}

	public BigDecimal getVfCalculated() {
		return vfCalculated;
	}

	public void setVfCalculated(BigDecimal vfCalculated) {
		this.vfCalculated = vfCalculated;
	}

	public BigDecimal getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(BigDecimal baseValue) {
		this.baseValue = baseValue;
	}

	public BigDecimal getNhWeightage() {
		return nhWeightage;
	}

	public void setNhWeightage(BigDecimal nhWeightage) {
		this.nhWeightage = nhWeightage;
	}

	public BigDecimal getDistPwdWeightage() {
		return distPwdWeightage;
	}

	public void setDistPwdWeightage(BigDecimal distPwdWeightage) {
		this.distPwdWeightage = distPwdWeightage;
	}

	public BigDecimal getdMjcbdWeightage() {
		return dMjcbdWeightage;
	}

	public void setdMjcbdWeightage(BigDecimal dMjcbdWeightage) {
		this.dMjcbdWeightage = dMjcbdWeightage;
	}

	public BigDecimal getdUrMncbdWeightage() {
		return dUrMncbdWeightage;
	}

	public void setdUrMncbdWeightage(BigDecimal dUrMncbdWeightage) {
		this.dUrMncbdWeightage = dUrMncbdWeightage;
	}

	public BigDecimal getDisWtrLgWeightage() {
		return disWtrLgWeightage;
	}

	public void setDisWtrLgWeightage(BigDecimal disWtrLgWeightage) {
		this.disWtrLgWeightage = disWtrLgWeightage;
	}

	public BigDecimal getOilPipelineWeightage() {
		return oilPipelineWeightage;
	}

	public void setOilPipelineWeightage(BigDecimal oilPipelineWeightage) {
		this.oilPipelineWeightage = oilPipelineWeightage;
	}

	public BigDecimal getEcosensitiveWeightage() {
		return ecosensitiveWeightage;
	}

	public void setEcosensitiveWeightage(BigDecimal ecosensitiveWeightage) {
		this.ecosensitiveWeightage = ecosensitiveWeightage;
	}

	public BigDecimal getOptionSumWeightage() {
		return optionSumWeightage;
	}

	public void setOptionSumWeightage(BigDecimal optionSumWeightage) {
		this.optionSumWeightage = optionSumWeightage;
	}

	public BigDecimal getOptionValueOneAddWeightage() {
		return optionValueOneAddWeightage;
	}

	public void setOptionValueOneAddWeightage(BigDecimal optionValueOneAddWeightage) {
		this.optionValueOneAddWeightage = optionValueOneAddWeightage;
	}

	public BigDecimal getOptionFinal() {
		return optionFinal;
	}

	public void setOptionFinal(BigDecimal optionFinal) {
		this.optionFinal = optionFinal;
	}

	public BigDecimal getOptionFinalSubZonal() {
		return optionFinalSubZonal;
	}

	public void setOptionFinalSubZonal(BigDecimal optionFinalSubZonal) {
		this.optionFinalSubZonal = optionFinalSubZonal;
	}

	public BigDecimal getOptionFinalSubZonalPercen() {
		return optionFinalSubZonalPercen;
	}

	public void setOptionFinalSubZonalPercen(BigDecimal optionFinalSubZonalPercen) {
		this.optionFinalSubZonalPercen = optionFinalSubZonalPercen;
	}

	public String getOptionFinalSubZonalPercenBracket() {
		return optionFinalSubZonalPercenBracket;
	}

	public void setOptionFinalSubZonalPercenBracket(String optionFinalSubZonalPercenBracket) {
		this.optionFinalSubZonalPercenBracket = optionFinalSubZonalPercenBracket;
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

	public String getLandArea() {
		return landArea;
	}

	public void setLandArea(String landArea) {
		this.landArea = landArea;
	}

	

	
	
	
	

}
