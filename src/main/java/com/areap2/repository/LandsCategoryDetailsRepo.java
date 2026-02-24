package com.areap2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.areap2.entity.LandsCategoryDetails;

public interface LandsCategoryDetailsRepo extends JpaRepository<LandsCategoryDetails, Long> {

	@Query(value = "select MAX(land_category_code) from areap2landvaluation.areap2_lands_category_details", nativeQuery = true)
	Integer findMaxLandCategoryCode();

	List<LandsCategoryDetails> findAllByActiveTrueAndStatus(String status);

	LandsCategoryDetails findByLandCategoryCodeAndActiveTrue(String landCategoryCode);

	LandsCategoryDetails findByLandCategoryGenId(Long id);

	List<LandsCategoryDetails> findByLandCategoryCode(String landCategoryCode);

	List<LandsCategoryDetails> findAllByActiveTrue();

}
