package com.areap2.controller.excel.map.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.LandUseFactorExcelEntity;

@Repository
public interface LandUseFactorExcelEntityRepository extends JpaRepository<LandUseFactorExcelEntity, Long> {

	List<LandUseFactorExcelEntity> findByStatus(String string);

	Optional<LandUseFactorExcelEntity> findByLandUseFactorGenIdAndStatus(Long id, String string);

	@Query(value = "select MAX(land_use_factor_code) from kau.land_use_factor", nativeQuery = true)
	Integer findMaxLandUseFactorCode();

	LandUseFactorExcelEntity findByLandUseFactorGenId(Long id);

	List<LandUseFactorExcelEntity> findByStatusCode(String statusCode);

	List<LandUseFactorExcelEntity> findByLandUseFactorCode(String masterCode);

}
