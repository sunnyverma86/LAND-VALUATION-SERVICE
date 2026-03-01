package com.areap2.excel.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.areap2.excel.dto.SlabRangeDTO;
import com.areap2.excel.dto.SlabRequestDTO;
import com.areap2.excel.dto.SlabResponseDTO;
import com.areap2.excel.entity.DistanceType;
import com.areap2.excel.entity.SlabDetail;
import com.areap2.excel.entity.SlabGroup;
import com.areap2.excel.repository.DistanceTypeRepository;
import com.areap2.excel.repository.LandDataExcelRepository;
import com.areap2.excel.repository.SlabDetailRepository;
import com.areap2.excel.repository.SlabGroupRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SlabService {

	@Autowired
	private SlabGroupRepository slabGroupRepository;

	@Autowired
	private SlabDetailRepository slabDetailRepository;

	@Autowired
	private DistanceTypeRepository distanceTypeRepository;

	@Autowired
	private LandDataExcelRepository landDataExcelRepository;

	public String createNewSlabSet(SlabRequestDTO request) {

		DistanceType type = distanceTypeRepository.findByCodeAndActiveTrue(request.getDistanceTypeCode())
				.orElseThrow(() -> new RuntimeException("Distance type not found"));

		validateSlabs(request.getSlabs());

		slabGroupRepository.findByDistrictAndDistanceTypeAndActiveTrue(request.getDistrict(), type).ifPresent(old -> {
			old.setActive(false);
			slabGroupRepository.save(old);
		});

		Integer maxVersion = slabGroupRepository.findMaxVersion(request.getDistrict(), type);

		SlabGroup newGroup = new SlabGroup();
		newGroup.setDistrict(request.getDistrict());
		newGroup.setDistanceType(type);
		newGroup.setVersionNo(maxVersion + 1);
		newGroup.setActive(true);
		newGroup.setCreatedBy(request.getCreatedBy());
		newGroup.setCreatedDtm(LocalDateTime.now());

		slabGroupRepository.save(newGroup);

		for (SlabRangeDTO dto : request.getSlabs()) {

			SlabDetail detail = new SlabDetail();
			detail.setMinValue(dto.getMinValue());
			detail.setMaxValue(dto.getMaxValue());
			detail.setSlabLabel(dto.getMinValue() + "-" + dto.getMaxValue());
			detail.setSlabGroup(newGroup);

			slabDetailRepository.save(detail);
		}

		return "Slab version " + newGroup.getVersionNo() + " created successfully";
	}

	private void validateSlabs(List<SlabRangeDTO> slabs) {
		slabs.sort(Comparator.comparing(SlabRangeDTO::getMinValue));

		for (int i = 0; i < slabs.size() - 1; i++) {

			SlabRangeDTO current = slabs.get(i);
			SlabRangeDTO next = slabs.get(i + 1);

			if (current.getMaxValue() >= next.getMinValue()) {
				throw new RuntimeException("Slabs overlapping detected");
			}
		}
	}

	public SlabResponseDTO getActiveSlabs(String district, String distanceTypeCode) {

		DistanceType type = distanceTypeRepository.findByCodeAndActiveTrue(distanceTypeCode)
				.orElseThrow(() -> new RuntimeException("Distance type not found"));

		SlabGroup slabGroup = slabGroupRepository.findByDistrictAndDistanceTypeAndActiveTrue(district, type)
				.orElseThrow(() -> new RuntimeException("No active slab found"));

		List<SlabDetail> details = slabDetailRepository.findBySlabGroupOrderByMinValueAsc(slabGroup);

		List<SlabRangeDTO> slabList = details.stream().map(d -> {
			SlabRangeDTO dto = new SlabRangeDTO();
			dto.setMinValue(d.getMinValue());
			dto.setMaxValue(d.getMaxValue());
			return dto;
		}).toList();

		SlabResponseDTO response = new SlabResponseDTO();
		response.setDistrict(district);
		response.setDistanceTypeCode(distanceTypeCode);
		response.setVersion(slabGroup.getVersionNo());
		response.setSlabs(slabList);

		return response;
	}

	@Transactional
	public String applySlabFromJson(SlabRequestDTO request) {

		DistanceType type = distanceTypeRepository.findByCodeAndActiveTrue(request.getDistanceTypeCode())
				.orElseThrow(() -> new RuntimeException("Distance type not found"));

		slabGroupRepository.findByDistrictAndDistanceTypeAndActiveTrue(request.getDistrict(), type).ifPresent(old -> {
			old.setActive(false);
			slabGroupRepository.save(old);
		});

		Integer maxVersion = slabGroupRepository.findMaxVersion(request.getDistrict(), type);
		if (maxVersion == null)
			maxVersion = 0;

		SlabGroup group = new SlabGroup();
		group.setDistrict(request.getDistrict());
		group.setDistanceType(type);
		group.setVersionNo(maxVersion + 1);
		group.setActive(true);
		group.setCreatedBy(request.getCreatedBy());
		group.setCreatedDtm(LocalDateTime.now());

		slabGroupRepository.save(group);

		for (SlabRangeDTO range : request.getSlabs()) {

			SlabDetail detail = new SlabDetail();
			detail.setSlabGroup(group);
			detail.setMinValue(range.getMinValue());
			detail.setMaxValue(range.getMaxValue());
			detail.setSlabLabel(range.getMinValue() + "-" + range.getMaxValue());

			slabDetailRepository.save(detail);
		}

		int updatedRows = landDataExcelRepository.updateDRlCbdSlab();
		System.out.println("Updated rows: " + updatedRows);
		String valueReturn = " values:" + updatedRows;
		return valueReturn;
	}
}