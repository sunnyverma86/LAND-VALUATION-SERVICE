package com.areap2.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.entity.LandSubClassDetails;
import com.areap2.entity.LotDetails;

@Repository
public interface LotDetailsRepo extends JpaRepository<LotDetails, Long> {

	// 1. Find LotDetails by districtCode where active = true
	List<LotDetails> findByDistrictCodeAndActiveTrue(String districtCode);

	// 2. Find LotDetails by districtCode and circleCode where active = true
	List<LotDetails> findByDistrictCodeAndCircleCodeAndActiveTrue(String districtCode, String circleCode);

	// 3. Find max LotCode (JPA way)
	@Query("SELECT MAX(l.lotCode) FROM LotDetails l")
	Integer findMaxLotCode();

	LotDetails findByLotCodeAndActiveTrue(String lotCode);

	List<LotDetails> findLotByDistrictCodeAndCircleCodeAndActiveTrue(String districtCode, String circleCode);

	List<LandSubClassDetails> findByStatusCode(String statusCode);

	LotDetails findByLotGenId(Long id);

	//List<LotDetails> findLotByDistrictCodeAndCircleCodeAndStatusAndActiveTrue(String districtCode, String circleCode,
		//	String status);
	
	LotDetails findLotByDistrictCodeAndCircleCodeAndStatusAndActiveTrue(String districtCode, String circleCode,
			String status);

	List<LotDetails> findLotByDistrictCodeAndCircleCodeAndActiveTrueAndStatus(String districtCode, String circleCode,
			String status);

	List<LotDetails> findLotByDistrictCodeAndCircleCodeAndMouzaCodeAndActiveTrueAndStatus(String districtCode,
			String circleCode,String mouzaCode, String status);

	 @Query("SELECT MAX(l.basePriceIncreaseLot) FROM LotDetails l")
	    BigDecimal findMaxIncreaseLot();

	//LotDetails findByStatus(String status);

	//List<LotDetails> findByDistrictCode(String districtCode);

}
