package com.areap2.controller.excel.map.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.LandMasterOutputEntity;

@Repository
public interface LandMasterOutputRepository extends JpaRepository<LandMasterOutputEntity, Long> {

	
	@Query("""
			SELECT DISTINCT l.circle
			FROM LandMasterOutputEntity l
			WHERE l.district = :district
			ORDER BY l.circle
			""")
	List<String> findDistinctCircleByDistrict(@Param("district") String district);

	@Query("""
			SELECT DISTINCT l.mouzaCode
			FROM LandMasterOutputEntity l
			WHERE l.district = :district
			  AND l.circle = :circle
			ORDER BY l.mouzaCode
			""")
	List<String> findDistinctMouzaCodeByDistrictAndCircle(@Param("district") String district,
			@Param("circle") String circle);

	@Query("""
			SELECT DISTINCT l.lot
			FROM LandMasterOutputEntity l
			WHERE l.district = :district
			  AND l.circle = :circle
			  AND l.mouzaCode = :mouzaCode
			ORDER BY l.lot
			""")
	List<String> findDistinctLotByDistrictAndCircleAndMouza(@Param("district") String district,
			@Param("circle") String circle, @Param("mouzaCode") String mouza);

	@Query("""
			SELECT DISTINCT l.village
			FROM LandMasterOutputEntity l
			WHERE l.district = :district
			  AND l.circle = :circle
			  AND l.mouzaCode = :mouzaCode
			  AND l.lot = :lot
			ORDER BY l.village
			""")
	List<String> findDistinctVillageByDistrictAndCircleAndMouzaAndLot(@Param("district") String district,
			@Param("circle") String circle, @Param("mouzaCode") String mouza, @Param("lot") String lot);

	@Query("""
			SELECT DISTINCT l.plot
			FROM LandMasterOutputEntity l
			WHERE l.district = :district
			  AND l.circle = :circle
			  AND l.mouzaCode = :mouzaCode
			  AND l.lot = :lot
			  AND l.village = :village
			ORDER BY l.plot
			""")
	List<String> findPlotByDistrictAndCircleAndMouzaAndLotAndVillage(@Param("district") String district,
			@Param("circle") String circle, @Param("mouzaCode") String mouza, @Param("lot") String lot,
			@Param("village") String village);

	@Query("""
			SELECT l
			FROM LandMasterOutputEntity l
			WHERE l.district = :district
			  AND l.circle = :circle
			  AND l.mouzaCode = :mouzaCode
			  AND l.lot = :lot
			  AND l.village = :village
			  AND l.plot = :plot
			""")
	List<LandMasterOutputEntity> findLandDetailsByDistrictAndCircleAndMouzaAndLotAndVillageAndPlot(
			@Param("district") String district, @Param("circle") String circle, @Param("mouzaCode") String mouza,
			@Param("lot") String lot, @Param("village") String village, @Param("plot") String plot);

	List<LandMasterOutputEntity> findByDistrict(String district);

	List<LandMasterOutputEntity> findByDistrictAndCircle(String district, String circle);

	List<LandMasterOutputEntity> findAllByDistrictAndCircle(String district, String circle);

}
