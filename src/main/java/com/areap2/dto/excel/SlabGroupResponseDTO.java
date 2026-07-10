package com.areap2.dto.excel;

import java.util.List;

import com.areap2.entity.excel.external.SlabGroup;

public class SlabGroupResponseDTO {

	private SlabGroup slabGroup;
	private List<SlabDetailDTO> slabDetails; // ✅ changed

	public SlabGroupResponseDTO() {
	}

	public SlabGroup getSlabGroup() {
		return slabGroup;
	}

	public void setSlabGroup(SlabGroup slabGroup) {
		this.slabGroup = slabGroup;
	}

	public List<SlabDetailDTO> getSlabDetails() {
		return slabDetails;
	}

	public void setSlabDetails(List<SlabDetailDTO> slabDetails) {
		this.slabDetails = slabDetails;
	}

}
