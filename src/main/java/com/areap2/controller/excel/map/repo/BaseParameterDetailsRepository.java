package com.areap2.controller.excel.map.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.BaseParameterDetails;

@Repository
public interface BaseParameterDetailsRepository extends JpaRepository<BaseParameterDetails, Long> {

	List<BaseParameterDetails> findByStatus(String status);

	Optional<BaseParameterDetails> findByIdAndStatus(Long id, String status);
}
