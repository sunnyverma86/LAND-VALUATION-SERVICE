package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LandSubClassDetailsModelUpdateRequest {

	private String landSubClassCode;

	private String landSubClassName;

	private String landClassName;

	public String getLandSubClassCode() {
		return landSubClassCode;
	}

	public void setLandSubClassCode(String landSubClassCode) {
		this.landSubClassCode = landSubClassCode;
	}

	public String getLandSubClassName() {
		return landSubClassName;
	}

	public void setLandSubClassName(String landSubClassName) {
		this.landSubClassName = landSubClassName;
	}

	public String getLandClassName() {
		return landClassName;
	}

	public void setLandClassName(String landClassName) {
		this.landClassName = landClassName;
	}
	
	
}
