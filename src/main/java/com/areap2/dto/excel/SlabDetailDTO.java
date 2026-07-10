package com.areap2.dto.excel;

import lombok.Data;

@Data
public class SlabDetailDTO {

	private Long id;
	private Double minValue;
	private Double maxValue;
	private String bandNameStr;
	private Double weightage;

	public SlabDetailDTO() {
	}

	public SlabDetailDTO(Long id, Double minValue, Double maxValue, String bandNameStr, Double weightage) {
		this.id = id;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.bandNameStr = bandNameStr;
		this.weightage = weightage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public String getBandNameStr() {
		return bandNameStr;
	}

	public void setBandNameStr(String bandNameStr) {
		this.bandNameStr = bandNameStr;
	}

	public Double getWeightage() {
		return weightage;
	}

	public void setWeightage(Double weightage) {
		this.weightage = weightage;
	}

}