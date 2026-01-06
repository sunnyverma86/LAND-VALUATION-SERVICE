package com.areap2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.entity.ParameterDetails;

@Repository
public interface ParameterDetailsRepo extends JpaRepository<ParameterDetails, Long> {

	@Query(value = "select MAX(parameter_code) from areap2landvaluation.areap2_parameter_details", nativeQuery = true)
	Integer findMaxParameterCode();

	ParameterDetails findByParameterCodeAndActiveTrue(String parameterCode);

	List<ParameterDetails> findAllByActiveTrueAndStatus(String status);

	ParameterDetails findByParameterGenId(Long id);

	List<ParameterDetails> findByParameterCode(String parameterCode);

	List<ParameterDetails> findAllByActiveTrue();

}
