package com.areap2.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.areap2.entity.MouzaDetails;
import com.areap2.entity.VillageDetails;

@Repository
public interface MouzaDetailsRepo extends JpaRepository<MouzaDetails,Long>{
 
	@Query(value="SELECT m.mouzaCode as mouzaCode,m.mouzaName as mouzaName FROM MouzaDetails m where m.districtCode=:districtCode AND m.active=true")
	List<Map<String,Object>> findMouzaByDistrictCode(@Param("districtCode") String districtCode);
	
	@Query(value="SELECT m.mouzaCode as mouzaCode,m.mouzaName as mouzaName FROM MouzaDetails m where m.districtCode=:districtCode AND m.circleCode=:circleCode AND m.active=true")
	List<Map<String,Object>> findMouzaByDistrictCodeAndCircleCode(@Param("districtCode") String districtCode,@Param("circleCode") String circleCode);
	
	@Query(value = "select MAX(mouza_code) from areap2landvaluation.areap2_mouza_details", nativeQuery = true)
	Integer findMaxMouzaCode();
	
	MouzaDetails findByMouzaCodeAndActiveTrue(String mouzaCode);

	List<MouzaDetails> findMouzaByDistrictCodeAndCircleCodeAndActiveTrue(String districtCode, String circleCode);

	List<MouzaDetails> findByStatusCode(String statusCode);

	MouzaDetails findByMouzaGenId(Long id);

	List<MouzaDetails> findMouzaByDistrictCodeAndCircleCodeAndActiveTrueAndStatus(String districtCode,
			String circleCode, String status);

	MouzaDetails findMouzaByDistrictCodeAndCircleCodeAndMouzaCodeAndActiveTrueAndStatus(String districtCode,
			String circleCode, String mouzaCode, String status);
	
	
} 
