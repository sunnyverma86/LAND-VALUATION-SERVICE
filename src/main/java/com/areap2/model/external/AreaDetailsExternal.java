package com.areap2.model.external;

import lombok.Data;

@Data
public class AreaDetailsExternal {

	private int totalLessa; // or BigDecimal

	public int getTotalLessa() {
		return totalLessa;
	}

	public void setTotalLessa(int totalLessa) {
		this.totalLessa = totalLessa;
	}
	
	

}
