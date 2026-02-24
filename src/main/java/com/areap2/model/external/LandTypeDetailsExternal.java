package com.areap2.model.external;

import lombok.Data;

@Data
public class LandTypeDetailsExternal {
	private String currentLandType;
	private boolean landUseChange;
	private String areaType;
	private AreaDetailsExternal areaDetailsExternal;
}
