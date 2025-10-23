package com.areap2.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.entity.DistrictDetails;
import com.areap2.entity.LandCategories;

@Repository
public interface LandCategoriesRepo extends JpaRepository<LandCategories,Long>{

	@Query(value="SELECT l.landCategoryGenId as landCategoryId,l.landCategoryName as landCategoryName FROM LandCategories l WHERE l.active=true")
	List<Map<String,Object>> findAllLandCategories();
	
	LandCategories findByLandCategoryGenIdAndActiveTrue(Long landCategoryGenId);

	List<LandCategories> findAllByActiveTrue();

	List<LandCategories> findByStatusCode(String statusCode);

	LandCategories findByLandCategoryGenId(Long id);

	List<LandCategories> findAllByActiveTrueAndStatus(String status);
	
}
