package com.areap2.controller.excel.map.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "land_details_input_entity", schema = "kau")
public class LandDetailsInputEntity {

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
	private String landuseEnglish;
	private String category;
	private Double zonalValue;
	private Double dagRevenue;
	private Double dagLocalTax;
	private Double totalRevenue;
	private String ruralUrban;
	private String niccode;
	private String landArea;

	public LandDetailsInputEntity() {
	}

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

	public String getLanduseEnglish() {
		return landuseEnglish;
	}

	public void setLanduseEnglish(String landuseEnglish) {
		this.landuseEnglish = landuseEnglish;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getZonalValue() {
		return zonalValue;
	}

	public void setZonalValue(Double zonalValue) {
		this.zonalValue = zonalValue;
	}

	public Double getDagRevenue() {
		return dagRevenue;
	}

	public void setDagRevenue(Double dagRevenue) {
		this.dagRevenue = dagRevenue;
	}

	public Double getDagLocalTax() {
		return dagLocalTax;
	}

	public void setDagLocalTax(Double dagLocalTax) {
		this.dagLocalTax = dagLocalTax;
	}

	public Double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
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

	// Generate Getters and Setters

}
