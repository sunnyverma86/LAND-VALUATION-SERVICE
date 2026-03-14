package com.areap2.entity.excel.external;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "land_data", schema = "areap2landvaluationexcel")
@Data
public class LandDataXlsPropertyMeasurement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String dist;
	private String circle;
	private String mouza;
	private String lot;
	private String village;
	private String textparcel;
	private String landuse;
	private Double zonalValue;
	private String landArea;
	private String dagRevenue;
	private String dagLocalTax;
	private String ruralUrban;
	private String niccode;
	
	
	
	//getter and setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
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
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getTextparcel() {
		return textparcel;
	}
	public void setTextparcel(String textparcel) {
		this.textparcel = textparcel;
	}
	public String getLanduse() {
		return landuse;
	}
	public void setLanduse(String landuse) {
		this.landuse = landuse;
	}
	public Double getZonalValue() {
		return zonalValue;
	}
	public void setZonalValue(Double zonalValue) {
		this.zonalValue = zonalValue;
	}
	
	public String getDagRevenue() {
		return dagRevenue;
	}
	public void setDagRevenue(String dagRevenue) {
		this.dagRevenue = dagRevenue;
	}
	public String getDagLocalTax() {
		return dagLocalTax;
	}
	public void setDagLocalTax(String dagLocalTax) {
		this.dagLocalTax = dagLocalTax;
	}
	public String getRuralUrban() {
		return ruralUrban;
	}
	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}
	public String getNiccode() {
		return niccode;
	}
	public void setNiccode(String niccode) {
		this.niccode = niccode;
	}
	public String getLandArea() {
		return landArea;
	}
	public void setLandArea(String landArea) {
		this.landArea = landArea;
	}
	
	
	//
	

}
