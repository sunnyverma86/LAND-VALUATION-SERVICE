package com.areap2.excel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.excel.entity.SlabDetail;
import com.areap2.excel.entity.SlabGroup;

@Repository
public interface SlabDetailRepository extends JpaRepository<SlabDetail, Long> {

	List<SlabDetail> findBySlabGroup(SlabGroup slabGroup);

	List<SlabDetail> findBySlabGroupOrderByMinValueAsc(SlabGroup slabGroup);
}