package com.areap2.excel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.areap2.excel.entity.DistanceType;
import com.areap2.excel.entity.SlabGroup;

public interface SlabGroupRepository extends JpaRepository<SlabGroup, Long> {

	Optional<SlabGroup> findByDistrictAndDistanceTypeAndActiveTrue(String district, DistanceType distanceType);

	@Query("SELECT COALESCE(MAX(s.versionNo),0) FROM SlabGroup s " + "WHERE s.district = :district "
			+ "AND s.distanceType = :distanceType")
	Integer findMaxVersion(@Param("district") String district, @Param("distanceType") DistanceType distanceType);
}