package com.areap2.entity.excel.external;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "geographical_factor", schema = "areap2landvaluationexcel")
public class GeographicalFactorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String mouza;

	private String nicCodeForMouza;

	private String ruralUrban; // R / U

	private Double factor;

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public String getMouza() {
		return mouza;
	}

	public void setMouza(String mouza) {
		this.mouza = mouza;
	}

	public String getNicCodeForMouza() {
		return nicCodeForMouza;
	}

	public void setNicCodeForMouza(String nicCodeForMouza) {
		this.nicCodeForMouza = nicCodeForMouza;
	}

	public String getRuralUrban() {
		return ruralUrban;
	}

	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}

	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}
}
