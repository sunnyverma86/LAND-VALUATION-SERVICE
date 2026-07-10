package com.areap2.controller.excel.map.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.LandUseFactorExcelEntity;

@Repository
public interface LandUseFactorExcelEntityRepository extends JpaRepository<LandUseFactorExcelEntity, Long> {

	List<LandUseFactorExcelEntity> findByStatus(String string);

	Optional<LandUseFactorExcelEntity> findByIdAndStatus(Long id, String string);

}
