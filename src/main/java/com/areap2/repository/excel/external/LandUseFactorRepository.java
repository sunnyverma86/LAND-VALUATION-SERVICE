package com.areap2.repository.excel.external;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.excel.external.LandUseFactorEntity;

@Repository
public interface LandUseFactorRepository extends JpaRepository<LandUseFactorEntity, Long> {

	Optional<LandUseFactorEntity> findByLandUseAndRuralUrban(String landUse, String ruralUrban);
}
