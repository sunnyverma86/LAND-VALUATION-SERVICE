package com.areap2.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.areap2.entity.ZonalValues;

@Repository
public interface ZonalValuesRepo extends JpaRepository<ZonalValues, Long> {
	@Query(value = "SELECT z.plotResidentialPerSqmRate,z.plotCommercialPerSqmRate,z.industrialPerSqmRate,z.rccPerSqmRate,z.rbcPerSqmRate,z.tin_shadePerSqmRate,z.kaccha_kabeluPerSqmRate,z.shopPerSqmRate,z.officePerSqmRate,z.godownPerSqmRate,z.buildingrResidentialPerSqmRate,z.buildingCommercialPerSqmRate,z.irrigatedPerSqmRate,z.unIrrigatedPerSqmRate,z.subClauseWiseResidentialPerSqmRate,z.subClauseWiseCommercialPerSqmRate "
			+ " FROM ZonalValues z where z.districtCode=:districtCode AND z.circleCode=:circleCode AND z.villageCode=:villageCode AND z.active=true")
	List<Map<String, Object>> findMouzaByDistrictCodeAndCircleCodeAndVillageCode(
			@Param("districtCode") String districtCode, @Param("circleCode") String circleCode,
			@Param("villageCode") String villageCode);

	@Query(value = "SELECT " + "z.plotResidentialPerSqmRate AS plotResidentialPerSqmRate, "
			+ "z.plotCommercialPerSqmRate AS plotCommercialPerSqmRate, "
			+ "z.industrialPerSqmRate AS industrialPerSqmRate, " + "z.rccPerSqmRate AS rccPerSqmRate, "
			+ "z.rbcPerSqmRate AS rbcPerSqmRate, " + "z.tin_shadePerSqmRate AS tin_shadePerSqmRate, "
			+ "z.kaccha_kabeluPerSqmRate AS kaccha_kabeluPerSqmRate, " + "z.shopPerSqmRate AS shopPerSqmRate, "
			+ "z.officePerSqmRate AS officePerSqmRate, " + "z.godownPerSqmRate AS godownPerSqmRate, "
			+ "z.buildingrResidentialPerSqmRate AS buildingrResidentialPerSqmRate, "
			+ "z.buildingCommercialPerSqmRate AS buildingCommercialPerSqmRate, "
			+ "z.irrigatedPerSqmRate AS irrigatedPerSqmRate, " + "z.unIrrigatedPerSqmRate AS unIrrigatedPerSqmRate, "
			+ "z.subClauseWiseResidentialPerSqmRate AS subClauseWiseResidentialPerSqmRate, "
			+ "z.subClauseWiseCommercialPerSqmRate AS subClauseWiseCommercialPerSqmRate " + "FROM ZonalValues z "
			+ "WHERE z.districtCode=:districtCode " + "AND z.circleCode=:circleCode " + "AND z.mouzaCode=:mouzaCode "
			+ "AND z.active=true")
	List<Map<String, Object>> findMouzaByDistrictCodeAndCircleCodeAndMouzaCode(
			@Param("districtCode") String districtCode, @Param("circleCode") String circleCode,
			@Param("mouzaCode") String mouzaCode);

	List<ZonalValues> findMouzaByDistrictCodeAndCircleCodeAndMouzaCodeAndActiveTrue(String districtCode,
			String circleCode, String mouzaCode);

	List<ZonalValues> findMouzaByDistrictCodeAndCircleCodeAndMouzaCodeAndStatusAndActiveTrue(String districtCode,
			String circleCode, String mouzaCode, String status);

}
