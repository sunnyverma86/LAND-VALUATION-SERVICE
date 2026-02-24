package com.areap2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.MarketValuationEntity;

@Repository
public interface MarketValuationRepository extends JpaRepository<MarketValuationEntity, Long> {

	List<MarketValuationEntity> findByPlotNo(String plotNo);

	List<MarketValuationEntity> findByDistrictCodeAndCircleCodeAndMouzaCodeAndVillageCodeAndLotCode(String districtCode,
			String circleCode, String mouzaCode, String lotCode, String villageCode);
}
