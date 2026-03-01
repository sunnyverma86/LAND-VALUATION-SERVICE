package com.areap2.excel.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.areap2.excel.entity.DistanceType;

import jakarta.transaction.Transactional;

@Service
public class SlabBatchService {

	@Async
	@Transactional
	public void updateDistrictSlabs(String district, DistanceType type, Long slabGroupId) {

		// Native update query yaha likhenge
		// based on type.getColumnName()

	}
}
