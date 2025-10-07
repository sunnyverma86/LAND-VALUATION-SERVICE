package com.areap2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.areap2.entity.ClusterDetails;

//@Repository
//public interface ProcedureRepo extends JpaRepository<ClusterDetails, Long> {
//
//	@Query(value = "CALL areap2landvaluation.fetchbaseprice(:mouzaCode, :plot, :v_price)", nativeQuery = true)
//	Long fetchBasePrice(String mouzaCode, Integer plot, Long v_price);
//}
@Repository
public interface ProcedureRepo extends JpaRepository<ClusterDetails, Long> {

	@Procedure(procedureName = "areap2landvaluation.fetchbaseprice")
	Long fetchBasePrice(String mouzaCode, Integer plot, Long v_price);
}
