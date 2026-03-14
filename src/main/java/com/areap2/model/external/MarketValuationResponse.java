package com.areap2.model.external;

import lombok.Data;

@Data
public class MarketValuationResponse {

	private Long id;
	private String mode;
	private PayloadExternal payloadExternal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
