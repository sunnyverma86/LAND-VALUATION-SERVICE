package com.areap2.model.external;

import lombok.Data;

@Data
public class MarketValuationRequest {
	private String mode;
	private PayloadExternal payloadExternal;
}
