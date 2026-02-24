package com.areap2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.entity.SubParameterDetails;

@Repository
public interface SubParameterDetailsRepo extends JpaRepository<SubParameterDetails, Long> {

	@Query(value = "select MAX(sub_parameter_code) from areap2landvaluation.areap2_sub_parameter_details", nativeQuery = true)
	Integer findMaxSubParameterCode();

	SubParameterDetails findBySubParameterCodeAndActiveTrue(String subParameterCode);


	List<SubParameterDetails> findAllByActiveTrueAndStatusAndParameterCode(String status, String parameterCode);

	SubParameterDetails findBySubParameterGenId(Long id);

	List<SubParameterDetails> findBySubParameterCode(String subParameterCode);

	List<SubParameterDetails> findAllByActiveTrueAndStatusAndParameterCodeAndDistrictCode(String status,
			String parameterCode, String districtCode);

}
