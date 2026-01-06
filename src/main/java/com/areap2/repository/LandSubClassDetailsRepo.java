package com.areap2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.entity.DistrictDetails;
import com.areap2.entity.LandSubClassDetails;

@Repository
public interface LandSubClassDetailsRepo extends JpaRepository<LandSubClassDetails, Long> {

	List<LandSubClassDetails> findLandSubClassByLandClassNameAndActiveTrue(String landClassName);

	@Query(value = "select MAX(land_sub_class_code) from areap2landvaluation.areap2_land_sub_class", nativeQuery = true)
	Integer findMaxLandSubClassCode();

	LandSubClassDetails findByLandSubClassNameAndActiveTrue(String landSubClassName);

	List<DistrictDetails> findByStatusCode(String statusCode);

	LandSubClassDetails findByLandSubClassGenId(Long id);

	List<LandSubClassDetails> findLandSubClassByLandClassNameAndActiveTrueAndStatus(String landClassName,
			String status);

	LandSubClassDetails findByLandSubClassNameAndActiveTrueAndStatus(String landSubClass, String status);

	List<?> findByLandSubClassCode(String landSubClassCode);

}
