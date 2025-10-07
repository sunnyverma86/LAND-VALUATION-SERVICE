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

}
