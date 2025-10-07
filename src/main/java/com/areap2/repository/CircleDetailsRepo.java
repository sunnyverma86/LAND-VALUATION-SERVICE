package com.areap2.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.areap2.entity.CircleDetails;
import com.areap2.entity.DistrictDetails;

@Repository
public interface CircleDetailsRepo extends JpaRepository<CircleDetails,Long>{
	
	@Query(value="SELECT c.circleCode as circleCode,c.circleName as circleName FROM CircleDetails c where c.districtCode=:districtCode AND c.active=true")
	List<Map<String,String>> findCircleByDistrictCode(@Param("districtCode") String districtCode);
	
	@Query(value = "select MAX(circle_code) from areap2landvaluation.areap2_circle_details", nativeQuery = true)
	Integer findMaxCircleCode();
	
	CircleDetails findByCircleCodeAndActiveTrue(String circleCode);

	List<CircleDetails> findCircleByDistrictCodeAndActiveTrue(String districtCode);
	
}
