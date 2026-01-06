package com.areap2.model.external;


import lombok.Data;

@Data
public class PayloadExternal {
    private JurisdictionInformationExternal jurisdictionInformationExternal;
    private LandTypeDetailsExternal landTypeDetailsExternal;
    private PlotLandDetailsExternal plotLandDetailsExternal;
    private Long totalMarketValuation;
}

