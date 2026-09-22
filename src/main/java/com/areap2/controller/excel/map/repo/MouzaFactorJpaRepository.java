package com.areap2.controller.excel.map.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.MouzaFactorBaseDatabase;

@Repository
public interface MouzaFactorJpaRepository extends JpaRepository<MouzaFactorBaseDatabase, Long> {

	List<MouzaFactorBaseDatabase> findByStatus(String status);

	Optional<MouzaFactorBaseDatabase> findByMouzaFactorGenIdAndStatus(Long id, String status);

	List<MouzaFactorBaseDatabase> findByStatusCode(String statusCode);

	MouzaFactorBaseDatabase findByMouzaFactorGenId(Long id);

	List<MouzaFactorBaseDatabase> findByMouzaFactorCode(String masterCode);

	@Query(value = "select MAX(mouza_factor_code) from kau.mf_calculation", nativeQuery = true)
	Integer findMaxMouzaFactorCode();

}
