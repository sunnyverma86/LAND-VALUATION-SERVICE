package com.areap2.entity.excel.external;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "land_data_xls_parameter", schema = "areap2landvaluationexcel")
public class LandDataXlsParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "GM_LAYER")
    private String gmLayer;

    @Column(name = "GM_TYPE")
    private String gmType;

    @Column(name = "OBJECTID")
    private BigDecimal objectid;

    @Column(name = "TEXTPARCEL")
    private String textParcel;

    @Column(name = "VILLAGE")
    private String village;

    @Column(name = "MOUZA")
    private String mouza;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "CIRCLE")
    private String circle;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "AREA")
    private BigDecimal area;

    @Column(name = "NIC_Code")
    private String nicCode;

    @Column(name = "Plot_Code")
    private BigDecimal plotCode;

    @Column(name = "Shape_Leng")
    private BigDecimal shapeLeng;

    @Column(name = "Shape_Area")
    private BigDecimal shapeArea;

    @Column(name = "FID_2")
    private BigDecimal fid2;

    @Column(name = "FID_1")
    private BigDecimal fid1;

    @Column(name = "ORIG_FID")
    private BigDecimal origFid;

    @Column(name = "FID_PWD")
    private BigDecimal fidPwd;

    @Column(name = "DIST_PWD")
    private BigDecimal distPwd;

    @Column(name = "FID_TR")
    private BigDecimal fidTr;

    @Column(name = "DIST_TR")
    private BigDecimal distTr;

    @Column(name = "FID_PRK")
    private BigDecimal fidPrk;

    @Column(name = "DIST_PRK")
    private BigDecimal distPrk;

    @Column(name = "FID_WTR_LG")
    private BigDecimal fidWtrLg;

    @Column(name = "DIS_WTR_LG")
    private BigDecimal disWtrLg;

    @Column(name = "F_UR_MJCBD")
    private BigDecimal fUrMjcbd;

    @Column(name = "D_UR_MJCBD")
    private BigDecimal dUrMjcbd;

    @Column(name = "F_UR_MNCBD")
    private BigDecimal fUrMncbd;

    @Column(name = "D_UR_MNCBD")
    private BigDecimal dUrMncbd;

    @Column(name = "F_RL_MJCBD")
    private BigDecimal fRlMjcbd;

    @Column(name = "D_RL_MJCBD")
    private BigDecimal dRlMjcbd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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



	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getMouza() {
		return mouza;
	}

	public void setMouza(String mouza) {
		this.mouza = mouza;
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

	


	public String getTextParcel() {
		return textParcel;
	}

	public void setTextParcel(String textParcel) {
		this.textParcel = textParcel;
	}

	public String getNicCode() {
		return nicCode;
	}

	public void setNicCode(String nicCode) {
		this.nicCode = nicCode;
	}

	public BigDecimal getPlotCode() {
		return plotCode;
	}

	public void setPlotCode(BigDecimal plotCode) {
		this.plotCode = plotCode;
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

	public BigDecimal getFidWtrLg() {
		return fidWtrLg;
	}

	public void setFidWtrLg(BigDecimal fidWtrLg) {
		this.fidWtrLg = fidWtrLg;
	}

	public BigDecimal getDisWtrLg() {
		return disWtrLg;
	}

	public void setDisWtrLg(BigDecimal disWtrLg) {
		this.disWtrLg = disWtrLg;
	}

	public BigDecimal getfUrMjcbd() {
		return fUrMjcbd;
	}

	public void setfUrMjcbd(BigDecimal fUrMjcbd) {
		this.fUrMjcbd = fUrMjcbd;
	}

	public BigDecimal getdUrMjcbd() {
		return dUrMjcbd;
	}

	public void setdUrMjcbd(BigDecimal dUrMjcbd) {
		this.dUrMjcbd = dUrMjcbd;
	}

	public BigDecimal getfUrMncbd() {
		return fUrMncbd;
	}

	public void setfUrMncbd(BigDecimal fUrMncbd) {
		this.fUrMncbd = fUrMncbd;
	}

	public BigDecimal getdUrMncbd() {
		return dUrMncbd;
	}

	public void setdUrMncbd(BigDecimal dUrMncbd) {
		this.dUrMncbd = dUrMncbd;
	}

	public BigDecimal getfRlMjcbd() {
		return fRlMjcbd;
	}

	public void setfRlMjcbd(BigDecimal fRlMjcbd) {
		this.fRlMjcbd = fRlMjcbd;
	}

	public BigDecimal getdRlMjcbd() {
		return dRlMjcbd;
	}

	public void setdRlMjcbd(BigDecimal dRlMjcbd) {
		this.dRlMjcbd = dRlMjcbd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
    
    
    
}