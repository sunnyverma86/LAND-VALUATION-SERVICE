package com.areap2.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.entity.ParameterDetails;

@Repository
public interface ParameterDetailsRepo extends JpaRepository<ParameterDetails, Long> {

	@Query(value = "SELECT p.parameterId as parameterId,p.parameter as parameter FROM ParameterDetails p WHERE p.minRangeInMeters >=:minRange AND p.maxRangeInMeters <=:maxRange AND p.active=true")
	List<Map<String, Object>> findParameterDetailsByRange(BigDecimal minRange, BigDecimal maxRange);

	// List<ParameterDetails> findParameterDetailsByRangeAndActiveTrue(BigDecimal
	// minRange, BigDecimal maxRange);

	List<ParameterDetails> findByMinRangeInMetersGreaterThanEqualAndMaxRangeInMetersLessThanEqualAndActiveTrueAndStatus(
			BigDecimal minRange, BigDecimal maxRange,String status);

}
