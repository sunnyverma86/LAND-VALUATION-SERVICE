package com.areap2.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.entity.DistrictDetails;

@Repository
public interface DistrictDetailsRepo extends JpaRepository<DistrictDetails,Long> {
	
	@Query(value="SELECT d.districtCode as districtCode,d.districtName as districtName  FROM DistrictDetails d WHERE d.active=true")
	List<Map<String,String>> findAllDistrict();
	
	@Query(value = "select MAX(district_code) from areap2landvaluation.areap2_district_details", nativeQuery = true)
	Integer findMaxDistrictCode();
	
	DistrictDetails findByDistrictCodeAndActiveTrue(String districtCode);
	
    List<DistrictDetails> findAllByActiveTrue();




}
