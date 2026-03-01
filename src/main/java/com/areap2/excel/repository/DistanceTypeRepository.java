package com.areap2.excel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.excel.entity.DistanceType;
import com.areap2.excel.entity.SlabGroup;

@Repository
public interface DistanceTypeRepository extends JpaRepository<DistanceType, Long> {

	Optional<DistanceType> findByCodeAndActiveTrue(String code);
	
	 Optional<DistanceType> findByCodeIgnoreCaseAndActiveTrue(String code);
}
