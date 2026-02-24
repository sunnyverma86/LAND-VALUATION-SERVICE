package com.areap2.stamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.LandAreaEntity;

@Repository
public interface LandAreaRepository extends JpaRepository<LandAreaEntity, Long> {
}
