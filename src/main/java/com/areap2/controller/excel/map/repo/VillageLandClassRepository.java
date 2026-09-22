package com.areap2.controller.excel.map.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.VillageLandClassEntity;

@Repository
public interface VillageLandClassRepository extends JpaRepository<VillageLandClassEntity, Long> {

	List<VillageLandClassEntity> findByStatus(String status);

	Optional<VillageLandClassEntity> findByVillageFactorGenIdAndStatus(Long id, String status);


	VillageLandClassEntity findByVillageFactorGenId(Long id);

	List<VillageLandClassEntity> findByStatusCode(String statusCode);

	List<VillageLandClassEntity> findByVillageFactorCode(String masterCode);

	@Query(value = "select MAX(village_factor_code) from kau.village_land_class", nativeQuery = true)
	Integer findMaxVillageFactorCode();


	


}
