package com.areap2.controller.excel.map.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.MouzaFactorBaseDatabase;

@Repository
public interface MouzaFactorJpaRepository extends JpaRepository<MouzaFactorBaseDatabase, Long> {

	List<MouzaFactorBaseDatabase> findByStatus(String status);

	Optional<MouzaFactorBaseDatabase> findByIdAndStatus(Long id, String status);

}
