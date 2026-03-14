package com.areap2.model.external;


import lombok.Data;

@Data
public class PayloadExternal {
    private JurisdictionInformationExternal jurisdictionInformationExternal;
    private LandTypeDetailsExternal landTypeDetailsExternal;
    private PlotLandDetailsExternal plotLandDetailsExternal;
    private Long totalMarketValuation;
	public JurisdictionInformationExternal getJurisdictionInformationExternal() {
		return jurisdictionInformationExternal;
	}
	public void setJurisdictionInformationExternal(JurisdictionInformationExternal jurisdictionInformationExternal) {
		this.jurisdictionInformationExternal = jurisdictionInformationExternal;
	}
	public LandTypeDetailsExternal getLandTypeDetailsExternal() {
		return landTypeDetailsExternal;
	}
	public void setLandTypeDetailsExternal(LandTypeDetailsExternal landTypeDetailsExternal) {
		this.landTypeDetailsExternal = landTypeDetailsExternal;
	}
	public PlotLandDetailsExternal getPlotLandDetailsExternal() {
		return plotLandDetailsExternal;
	}
	public void setPlotLandDetailsExternal(PlotLandDetailsExternal plotLandDetailsExternal) {
		this.plotLandDetailsExternal = plotLandDetailsExternal;
	}
	public Long getTotalMarketValuation() {
		return totalMarketValuation;
	}
	public void setTotalMarketValuation(Long totalMarketValuation) {
		this.totalMarketValuation = totalMarketValuation;
	}
    
    
    
}

