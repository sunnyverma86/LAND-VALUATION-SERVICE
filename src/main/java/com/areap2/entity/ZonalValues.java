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
@Table(name = "areap2_zonal_values", schema = "areap2landvaluation")
@NamedQuery(name = "ZonalValues.findAll", query = "SELECT a FROM ZonalValues a")
public class ZonalValues implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_zone_zone_gen_id_seq", sequenceName = "areap2_zone_zone_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_zone_zone_gen_id_seq")
	@Column(name = "zonal_values_gen_id")
	private Long zonalValuesGenId;

	@Column(name = "district_code")
	private String districtCode;

	@Column(name = "circle_code")
	private String circleCode;

	@Column(name = "mouza_code")
	private String mouzaCode;

	@Column(name = "village_code")
	private String villageCode;

	@Column(name = "plot_residential_per_sqm_rate")
	private Long plotResidentialPerSqmRate;

	@Column(name = "plot_commercial_per_sqm_rate")
	private Long plotCommercialPerSqmRate;

	@Column(name = "industrial_per_sqm_rate")
	private Long industrialPerSqmRate;

	@Column(name = "rcc_per_sqm_rate")
	private Long rccPerSqmRate;

	@Column(name = "rbc_per_sqm_rate")
	private Long rbcPerSqmRate;

	@Column(name = "tin_shade_per_sqm_rate")
	private Long tin_shadePerSqmRate;

	@Column(name = "kaccha_kabelu_per_sqm_rate")
	private Long kaccha_kabeluPerSqmRate;

	@Column(name = "shop_per_sqm_rate")
	private Long shopPerSqmRate;

	@Column(name = "office_per_sqm_rate")
	private Long officePerSqmRate;

	@Column(name = "godown_per_sqm_rate")
	private Long godownPerSqmRate;

	@Column(name = "building_residential_per_sqm_rate")
	private Long buildingrResidentialPerSqmRate;

	@Column(name = "building_commercial_per_sqm_rate")
	private Long buildingCommercialPerSqmRate;

	@Column(name = "irrigated_per_hectare_rate")
	private Long irrigatedPerSqmRate;

	@Column(name = "un_irrigated_per_hectare_rate")
	private Long unIrrigatedPerSqmRate;

	@Column(name = "sub_clause_wise_residential_per_sqm_rate")
	private Long subClauseWiseResidentialPerSqmRate;

	@Column(name = "sub_clause_wise_commercial_per_sqm_rate")
	private Long subClauseWiseCommercialPerSqmRate;

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

	public Long getZonalValuesGenId() {
		return zonalValuesGenId;
	}

	public void setZonalValuesGenId(Long zonalValuesGenId) {
		this.zonalValuesGenId = zonalValuesGenId;
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

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public Long getPlotResidentialPerSqmRate() {
		return plotResidentialPerSqmRate;
	}

	public void setPlotResidentialPerSqmRate(Long plotResidentialPerSqmRate) {
		this.plotResidentialPerSqmRate = plotResidentialPerSqmRate;
	}

	public Long getPlotCommercialPerSqmRate() {
		return plotCommercialPerSqmRate;
	}

	public void setPlotCommercialPerSqmRate(Long plotCommercialPerSqmRate) {
		this.plotCommercialPerSqmRate = plotCommercialPerSqmRate;
	}

	public Long getIndustrialPerSqmRate() {
		return industrialPerSqmRate;
	}

	public void setIndustrialPerSqmRate(Long industrialPerSqmRate) {
		this.industrialPerSqmRate = industrialPerSqmRate;
	}

	public Long getRccPerSqmRate() {
		return rccPerSqmRate;
	}

	public void setRccPerSqmRate(Long rccPerSqmRate) {
		this.rccPerSqmRate = rccPerSqmRate;
	}

	public Long getRbcPerSqmRate() {
		return rbcPerSqmRate;
	}

	public void setRbcPerSqmRate(Long rbcPerSqmRate) {
		this.rbcPerSqmRate = rbcPerSqmRate;
	}

	public Long getTin_shadePerSqmRate() {
		return tin_shadePerSqmRate;
	}

	public void setTin_shadePerSqmRate(Long tin_shadePerSqmRate) {
		this.tin_shadePerSqmRate = tin_shadePerSqmRate;
	}

	public Long getKaccha_kabeluPerSqmRate() {
		return kaccha_kabeluPerSqmRate;
	}

	public void setKaccha_kabeluPerSqmRate(Long kaccha_kabeluPerSqmRate) {
		this.kaccha_kabeluPerSqmRate = kaccha_kabeluPerSqmRate;
	}

	public Long getShopPerSqmRate() {
		return shopPerSqmRate;
	}

	public void setShopPerSqmRate(Long shopPerSqmRate) {
		this.shopPerSqmRate = shopPerSqmRate;
	}

	public Long getOfficePerSqmRate() {
		return officePerSqmRate;
	}

	public void setOfficePerSqmRate(Long officePerSqmRate) {
		this.officePerSqmRate = officePerSqmRate;
	}

	public Long getGodownPerSqmRate() {
		return godownPerSqmRate;
	}

	public void setGodownPerSqmRate(Long godownPerSqmRate) {
		this.godownPerSqmRate = godownPerSqmRate;
	}

	public Long getBuildingrResidentialPerSqmRate() {
		return buildingrResidentialPerSqmRate;
	}

	public void setBuildingrResidentialPerSqmRate(Long buildingrResidentialPerSqmRate) {
		this.buildingrResidentialPerSqmRate = buildingrResidentialPerSqmRate;
	}

	public Long getBuildingCommercialPerSqmRate() {
		return buildingCommercialPerSqmRate;
	}

	public void setBuildingCommercialPerSqmRate(Long buildingCommercialPerSqmRate) {
		this.buildingCommercialPerSqmRate = buildingCommercialPerSqmRate;
	}

	public Long getIrrigatedPerSqmRate() {
		return irrigatedPerSqmRate;
	}

	public void setIrrigatedPerSqmRate(Long irrigatedPerSqmRate) {
		this.irrigatedPerSqmRate = irrigatedPerSqmRate;
	}

	public Long getUnIrrigatedPerSqmRate() {
		return unIrrigatedPerSqmRate;
	}

	public void setUnIrrigatedPerSqmRate(Long unIrrigatedPerSqmRate) {
		this.unIrrigatedPerSqmRate = unIrrigatedPerSqmRate;
	}

	public Long getSubClauseWiseResidentialPerSqmRate() {
		return subClauseWiseResidentialPerSqmRate;
	}

	public void setSubClauseWiseResidentialPerSqmRate(Long subClauseWiseResidentialPerSqmRate) {
		this.subClauseWiseResidentialPerSqmRate = subClauseWiseResidentialPerSqmRate;
	}

	public Long getSubClauseWiseCommercialPerSqmRate() {
		return subClauseWiseCommercialPerSqmRate;
	}

	public void setSubClauseWiseCommercialPerSqmRate(Long subClauseWiseCommercialPerSqmRate) {
		this.subClauseWiseCommercialPerSqmRate = subClauseWiseCommercialPerSqmRate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
