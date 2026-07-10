package com.areap2.controller.excel.map.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.DistrictParameterMasterHistory;

@Repository
public interface DistrictParameterHistoryRepository extends JpaRepository<DistrictParameterMasterHistory, Long> {

}
