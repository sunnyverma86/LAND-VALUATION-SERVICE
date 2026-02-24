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

}
