package com.areap2.model.external;

import lombok.Data;

@Data
public class MarketValuationRequest {
	private String mode;
	private PayloadExternal payloadExternal;
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public PayloadExternal getPayloadExternal() {
		return payloadExternal;
	}
	public void setPayloadExternal(PayloadExternal payloadExternal) {
		this.payloadExternal = payloadExternal;
	}
	
	
}
