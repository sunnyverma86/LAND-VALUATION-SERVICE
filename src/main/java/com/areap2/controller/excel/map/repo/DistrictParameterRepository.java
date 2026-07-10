package com.areap2.controller.excel.map.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.band.DistrictParameterMaster;
import com.areap2.controller.excel.map.enity.band.ParameterName;

@Repository
public interface DistrictParameterRepository extends JpaRepository<DistrictParameterMaster, Long> {

	Optional<DistrictParameterMaster> findByDistrictAndParameterNameAndRuralUrbanAndBand(String district,
			ParameterName parameterName, String ruralUrban, String band);

	List<DistrictParameterMaster> findByDistrictAndActiveTrue(String district);

}