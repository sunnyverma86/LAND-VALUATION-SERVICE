package com.areap2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.LandDataExcel;

@Repository
public interface LandDataExcelRepository extends JpaRepository<LandDataExcel, Long> {

}
