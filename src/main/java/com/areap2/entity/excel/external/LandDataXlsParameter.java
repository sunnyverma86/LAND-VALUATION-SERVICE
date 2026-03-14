package com.areap2.entity.excel.external;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "land_data_xls_parameter", schema = "areap2landvaluationexcel")
public class LandDataXlsParameter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	private Double drlCbdPriceValue;// new changes


	

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

	public BigDecimal getTextparcel() {
		return textparcel;
	}

	public void setTextparcel(BigDecimal textparcel) {
		this.textparcel = textparcel;
	}

	public String getGmLayer() {
		return gmLayer;
	}

	public void setGmLayer(String gmLayer) {
		this.gmLayer = gmLayer;
	}

	public String getGmType() {
		return gmType;
	}

	public void setGmType(String gmType) {
		this.gmType = gmType;
	}

	public BigDecimal getObjectid() {
		return objectid;
	}

	public void setObjectid(BigDecimal objectid) {
		this.objectid = objectid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getNicCode() {
		return nicCode;
	}

	public void setNicCode(BigDecimal nicCode) {
		this.nicCode = nicCode;
	}

	public BigDecimal getNicVill() {
		return nicVill;
	}

	public void setNicVill(BigDecimal nicVill) {
		this.nicVill = nicVill;
	}

	public BigDecimal getShapeLeng() {
		return shapeLeng;
	}

	public void setShapeLeng(BigDecimal shapeLeng) {
		this.shapeLeng = shapeLeng;
	}

	public BigDecimal getShapeArea() {
		return shapeArea;
	}

	public void setShapeArea(BigDecimal shapeArea) {
		this.shapeArea = shapeArea;
	}

	public BigDecimal getFid2() {
		return fid2;
	}

	public void setFid2(BigDecimal fid2) {
		this.fid2 = fid2;
	}

	public BigDecimal getFid1() {
		return fid1;
	}

	public void setFid1(BigDecimal fid1) {
		this.fid1 = fid1;
	}

	public BigDecimal getOrigFid() {
		return origFid;
	}

	public void setOrigFid(BigDecimal origFid) {
		this.origFid = origFid;
	}

	public BigDecimal getFidPwd() {
		return fidPwd;
	}

	public void setFidPwd(BigDecimal fidPwd) {
		this.fidPwd = fidPwd;
	}

	public BigDecimal getDistPwd() {
		return distPwd;
	}

	public void setDistPwd(BigDecimal distPwd) {
		this.distPwd = distPwd;
	}

	public BigDecimal getFidTr() {
		return fidTr;
	}

	public void setFidTr(BigDecimal fidTr) {
		this.fidTr = fidTr;
	}

	public BigDecimal getDistTr() {
		return distTr;
	}

	public void setDistTr(BigDecimal distTr) {
		this.distTr = distTr;
	}

	public BigDecimal getFidEdu() {
		return fidEdu;
	}

	public void setFidEdu(BigDecimal fidEdu) {
		this.fidEdu = fidEdu;
	}

	public BigDecimal getDistEdu() {
		return distEdu;
	}

	public void setDistEdu(BigDecimal distEdu) {
		this.distEdu = distEdu;
	}

	public BigDecimal getFidBrkl() {
		return fidBrkl;
	}

	public void setFidBrkl(BigDecimal fidBrkl) {
		this.fidBrkl = fidBrkl;
	}

	public BigDecimal getDistBrkl() {
		return distBrkl;
	}

	public void setDistBrkl(BigDecimal distBrkl) {
		this.distBrkl = distBrkl;
	}

	public BigDecimal getFidCnal() {
		return fidCnal;
	}

	public void setFidCnal(BigDecimal fidCnal) {
		this.fidCnal = fidCnal;
	}

	public BigDecimal getDistCnal() {
		return distCnal;
	}

	public void setDistCnal(BigDecimal distCnal) {
		this.distCnal = distCnal;
	}

	public BigDecimal getFidCntBt() {
		return fidCntBt;
	}

	public void setFidCntBt(BigDecimal fidCntBt) {
		this.fidCntBt = fidCntBt;
	}

	public BigDecimal getDistCntBt() {
		return distCntBt;
	}

	public void setDistCntBt(BigDecimal distCntBt) {
		this.distCntBt = distCntBt;
	}

	public BigDecimal getFidDstPa() {
		return fidDstPa;
	}

	public void setFidDstPa(BigDecimal fidDstPa) {
		this.fidDstPa = fidDstPa;
	}

	public BigDecimal getDistDstPa() {
		return distDstPa;
	}

	public void setDistDstPa(BigDecimal distDstPa) {
		this.distDstPa = distDstPa;
	}

	public BigDecimal getFidHliPa() {
		return fidHliPa;
	}

	public void setFidHliPa(BigDecimal fidHliPa) {
		this.fidHliPa = fidHliPa;
	}

	public BigDecimal getDistHliPa() {
		return distHliPa;
	}

	public void setDistHliPa(BigDecimal distHliPa) {
		this.distHliPa = distHliPa;
	}

	public BigDecimal getFidPrk() {
		return fidPrk;
	}

	public void setFidPrk(BigDecimal fidPrk) {
		this.fidPrk = fidPrk;
	}

	public BigDecimal getDistPrk() {
		return distPrk;
	}

	public void setDistPrk(BigDecimal distPrk) {
		this.distPrk = distPrk;
	}

	public BigDecimal getFidSwgPl() {
		return fidSwgPl;
	}

	public void setFidSwgPl(BigDecimal fidSwgPl) {
		this.fidSwgPl = fidSwgPl;
	}

	public BigDecimal getDisSwgPl() {
		return disSwgPl;
	}

	public void setDisSwgPl(BigDecimal disSwgPl) {
		this.disSwgPl = disSwgPl;
	}

	public BigDecimal getFidWlPrk() {
		return fidWlPrk;
	}

	public void setFidWlPrk(BigDecimal fidWlPrk) {
		this.fidWlPrk = fidWlPrk;
	}

	public BigDecimal getDisWlPrk() {
		return disWlPrk;
	}

	public void setDisWlPrk(BigDecimal disWlPrk) {
		this.disWlPrk = disWlPrk;
	}

	public String getTypeOfCbd() {
		return typeOfCbd;
	}

	public void setTypeOfCbd(String typeOfCbd) {
		this.typeOfCbd = typeOfCbd;
	}

	public BigDecimal getdRlCbd() {
		return dRlCbd;
	}

	public void setdRlCbd(BigDecimal dRlCbd) {
		this.dRlCbd = dRlCbd;
	}

	public String getdRlCbdSlab() {
		return dRlCbdSlab;
	}

	public void setdRlCbdSlab(String dRlCbdSlab) {
		this.dRlCbdSlab = dRlCbdSlab;
	}

	public Double getDrlCbdPriceValue() {
		return drlCbdPriceValue;
	}

	public void setDrlCbdPriceValue(Double drlCbdPriceValue) {
		this.drlCbdPriceValue = drlCbdPriceValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	@Column(name = "d_rl_cbd_slab")
//	private BigDecimal dRlCbdPriceValue;

}
