package com.areap2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "land_area_details", schema = "areap2landvaluation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LandAreaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "area")
	private String area;

	@Column(name = "district_name")
	private String distName;

	@Column(name = "revenue_circle")
	private String revenueCircle;

	@Column(name = "village_name")
	private String villageName;

	@Column(name = "mouza_name")
	private String mouzaName;

	@Column(name = "area_type")
	private String areaType;

	@Column(name = "lot_number")
	private String lotNumber;

	@Column(name = "dag_n_int")
	private String dagNInt;

	@Column(name = "dist_fm_cbd")
	private Double distFromCBD;

	@Column(name = "type_of_cbd")
	private String typeOfCBD;

	@Column(name = "road_fid")
	private String roadFid;

	@Column(name = "dist_fm_road")
	private Double distFromRoad;

	@Column(name = "type_of_road")
	private String typeOfRoad;

	@Column(name = "dist_fm_transport")
	private Double distFromTransport;

	@Column(name = "dist_fm_education")
	private Double distFromEducation;

	@Column(name = "dist_fm_restricted_area")
	private Double distFromRestrictedArea;

	@Column(name = "dist_fm_oil_pipeline")
	private Double distFromOilPipeline;

	@Column(name = "dist_fm_heritage")
	private Double distFromHeritage;

	@Column(name = "dist_fm_flood_prone")
	private Double distFromFloodProne;

	@Column(name = "elevation")
	private Double elevation;
}
