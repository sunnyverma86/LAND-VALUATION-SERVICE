package com.areap2.controller.excel.map.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.DistrictMinimumBaseDatabase;

@Repository
public interface DistrictMinimumBaseDatabaseRepository extends JpaRepository<DistrictMinimumBaseDatabase, Long> {

	List<DistrictMinimumBaseDatabase> findByStatus(String string);

	Optional<DistrictMinimumBaseDatabase> findByIdAndStatus(Long id, String string);

	Optional<DistrictMinimumBaseDatabase> findByDistrictAndRuralUrbanAndStatus(String district, String ruralUrban,
			String status);

}
