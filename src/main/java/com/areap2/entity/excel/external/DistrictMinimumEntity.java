package com.areap2.entity.excel.external;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "master_district_minimum", schema = "areap2landvaluationexcel")
public class DistrictMinimumEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String district;

	private String nicCodeForDistrict;

	private String ruralUrban; // R or U

	private BigDecimal districtMinimumValue;

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

	public String getNicCodeForDistrict() {
		return nicCodeForDistrict;
	}

	public void setNicCodeForDistrict(String nicCodeForDistrict) {
		this.nicCodeForDistrict = nicCodeForDistrict;
	}

	public String getRuralUrban() {
		return ruralUrban;
	}

	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}

	public BigDecimal getDistrictMinimumValue() {
		return districtMinimumValue;
	}

	public void setDistrictMinimumValue(BigDecimal districtMinimumValue) {
		this.districtMinimumValue = districtMinimumValue;
	}

}
