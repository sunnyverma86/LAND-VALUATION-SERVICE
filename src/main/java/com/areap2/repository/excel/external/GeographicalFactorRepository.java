package com.areap2.repository.excel.external;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.excel.external.GeographicalFactorEntity;

@Repository
public interface GeographicalFactorRepository extends JpaRepository<GeographicalFactorEntity, Long> {

	Optional<GeographicalFactorEntity> findByMouzaAndRuralUrban(String mouza, String ruralUrban);
}
