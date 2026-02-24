package com.areap2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.entity.ClusterDetails;

@Repository
public interface ClusterDetailsRepo extends JpaRepository<ClusterDetails, Long> {

	 

}
