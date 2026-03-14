package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LandSubClassDetailsModelRequest {

	private String landClassName;

	private String landSubClassName;

	public String getLandClassName() {
		return landClassName;
	}

	public void setLandClassName(String landClassName) {
		this.landClassName = landClassName;
	}

	public String getLandSubClassName() {
		return landSubClassName;
	}

	public void setLandSubClassName(String landSubClassName) {
		this.landSubClassName = landSubClassName;
	}

	
	
}
