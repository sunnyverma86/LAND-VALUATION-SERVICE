package com.areap2.controller.excel.map.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.LandUseMaster;

@Repository
public interface LandUseMasterRepository extends JpaRepository<LandUseMaster, Long> {

	Optional<LandUseMaster> findByLandUseName(String landUseName);

	List<LandUseMaster> findByStatus(String status);

}
