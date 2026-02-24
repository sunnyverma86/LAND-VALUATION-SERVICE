package com.areap2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "market_valuation")
@Data
public class MarketValuationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Basic fields
	private String mode;
	private Long totalMarketValuation;

	// Jurisdiction
	private String districtCode;
	private String circleCode;
	private String mouzaCode;
	private String villageCode;
	private String lotCode;
	private String currentLandUse;
	private String plotNo;

	// Land Type
	private String currentLandType;
	private Boolean landUseChange;
	private String areaType;
	private Integer totalLessa;

	// Parameters (JSON string)
	@Column(columnDefinition = "TEXT")
	private String parametersJson;
}
