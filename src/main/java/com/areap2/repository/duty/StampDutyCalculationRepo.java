package com.areap2.repository.duty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.StampDutyCalculation;

@Repository
public interface StampDutyCalculationRepo extends JpaRepository<StampDutyCalculation, Long> {

}