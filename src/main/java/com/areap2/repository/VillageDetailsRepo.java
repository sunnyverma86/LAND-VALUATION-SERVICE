package com.areap2.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.areap2.entity.CircleDetails;
import com.areap2.entity.VillageDetails;

@Repository
public interface VillageDetailsRepo extends JpaRepository<VillageDetails, Long> {

	@Query(value = "SELECT v.villageCode as villageCode,v.villageName as villageName  FROM VillageDetails v where v.districtCode=:districtCode AND v.circleCode=:circleCode And v.active=true")
	List<Map<String, String>> findVillageByDistrictCodeAndCircleCode(@Param("districtCode") String districtCode,
			                                                         @Param("circleCode") String circleCode);
	
	@Query(value = "select MAX(village_code) from areap2landvaluation.areap2_village_details", nativeQuery = true)
	Integer findMaxVillageCode();
	
	VillageDetails findByVillageCodeAndActiveTrue(String villageCode);

	List<VillageDetails> findVillageByDistrictCodeAndCircleCodeAndActiveTrue(String districtCode, String circleCode);
}
