package com.areap2.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.entity.AreaTypes;
import com.areap2.entity.LandCategories;

@Repository
public interface AreaTypesRepo extends JpaRepository<AreaTypes,Long>{

	@Query(value="SELECT a.areaTypesGenId as areaTypesId,a.areaType as areaType FROM AreaTypes a WHERE a.active=true")
	List<Map<String,Object>> findAllAreaType();
	
	AreaTypes findByAreaTypesGenIdAndActiveTrue(Long areaTypesGenId);

	List<AreaTypes> findAllByActiveTrue();

	List<AreaTypes> findByStatusCode(String statusCode);

	AreaTypes findByAreaTypesGenId(Long id);

	List<AreaTypes> findAllByActiveTrueAndStatus(String status);
	
}
