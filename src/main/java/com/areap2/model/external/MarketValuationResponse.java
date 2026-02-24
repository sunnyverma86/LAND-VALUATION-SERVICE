package com.areap2.model.external;

import lombok.Data;

@Data
public class MarketValuationResponse {

	private Long id;
	private String mode;
	private PayloadExternal payloadExternal;

}
