package com.areap2.repository.excel.external;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.areap2.entity.excel.external.DistanceType;
import com.areap2.entity.excel.external.SlabGroup;

public interface SlabGroupRepository extends JpaRepository<SlabGroup, Long> {

	Optional<SlabGroup> findByDistrictAndDistanceTypeAndActiveTrue(String district, DistanceType distanceType);

	@Query("SELECT COALESCE(MAX(s.versionNo),0) FROM SlabGroup s " + "WHERE s.district = :district "
			+ "AND s.distanceType = :distanceType")
	Integer findMaxVersion(@Param("district") String district, @Param("distanceType") DistanceType distanceType);

	List<SlabGroup> findByDistanceTypeIdAndAreaTypeAndActiveTrue(Long distanceTypeId, String areaType);

	List<SlabGroup> findByDistrictAndDistanceType_CodeAndActiveTrue(String district, String distanceTypeCode);

	List<SlabGroup> findByDistrictAndDistanceTypeOrderByVersionNoDesc(String district, DistanceType type);

}