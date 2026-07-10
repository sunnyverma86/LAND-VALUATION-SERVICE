package com.areap2.repository.excel.external;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.excel.external.SlabDetail;
import com.areap2.entity.excel.external.SlabGroup;

@Repository
public interface SlabDetailRepository extends JpaRepository<SlabDetail, Long> {

	List<SlabDetail> findBySlabGroup(SlabGroup slabGroup);

	List<SlabDetail> findBySlabGroupOrderByMinValueAsc(SlabGroup slabGroup);
	
	List<SlabDetail> findBySlabGroup_IdOrderByIdDesc(Long slabGroupId);
}