package com.areap2.dto.excel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SlabRangeDTO {

	private String band;
	private Double minValue;
	private Double maxValue;
	private Double weightage;//new changes
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
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
	public Double getWeightage() {
		return weightage;
	}
	public void setWeightage(Double weightage) {
		this.weightage = weightage;
	}
	
	public SlabRangeDTO() {}
	public SlabRangeDTO(String band, Double minValue, Double maxValue, Double weightage) {
	
		this.band = band;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.weightage = weightage;
	}
	
	
	
	
	
}