package com.areap2.excel.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "areap2_land_data_excel", schema = "areap2landvaluation")
public class LandDataExcel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_land_data_excel_gen_id_seq", sequenceName = "areap2_land_data_excel_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_land_data_excel_gen_id_seq")
	@Column(name = "land_data_excel_id")
	private Long landDataExcelId;

	// First required fields
	private String district;
	private String circle;
	private String mouza;
	private String village;
	private BigDecimal textparcel;

	// Remaining fields
	private String gmLayer;
	private String gmType;
	private BigDecimal objectid;
	private String type;
	private BigDecimal area;
	private BigDecimal nicCode;
	private BigDecimal nicVill;
	private BigDecimal shapeLeng;
	private BigDecimal shapeArea;

	private BigDecimal fid2;
	private BigDecimal fid1;
	private BigDecimal origFid;
	private BigDecimal fidPwd;
	private BigDecimal distPwd;
	private BigDecimal fidTr;
	private BigDecimal distTr;
	private BigDecimal fidEdu;
	private BigDecimal distEdu;
	private BigDecimal fidBrkl;
	private BigDecimal distBrkl;
	private BigDecimal fidCnal;
	private BigDecimal distCnal;
	private BigDecimal fidCntBt;
	private BigDecimal distCntBt;
	private BigDecimal fidDstPa;
	private BigDecimal distDstPa;
	private BigDecimal fidHliPa;
	private BigDecimal distHliPa;
	private BigDecimal fidPrk;
	private BigDecimal distPrk;
	private BigDecimal fidSwgPl;
	private BigDecimal disSwgPl;
	private BigDecimal fidWlPrk;
	private BigDecimal disWlPrk;

	private String typeOfCbd;
	private BigDecimal dRlCbd;

	@Column(name = "d_rl_cbd_slab")
	private String dRlCbdSlab;
	
	@Column(name = "d_rl_cbd_price_value")
	private Double drlCbdPriceValue;//new changes
	
//	@Column(name = "d_rl_cbd_slab")
//	private BigDecimal dRlCbdPriceValue;

}
