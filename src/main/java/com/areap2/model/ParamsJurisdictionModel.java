package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamsJurisdictionModel {

	private String mouzaCode;
	private Integer plot;
	public String getMouzaCode() {
		return mouzaCode;
	}
	public void setMouzaCode(String mouzaCode) {
		this.mouzaCode = mouzaCode;
	}
	public Integer getPlot() {
		return plot;
	}
	public void setPlot(Integer plot) {
		this.plot = plot;
	}
	
	

}
