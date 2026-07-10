package com.areap2.repository.excel.external;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.excel.external.DistrictMinimumEntity;

@Repository
public interface DistrictMinimumRepository extends JpaRepository<DistrictMinimumEntity, Long> {

}
