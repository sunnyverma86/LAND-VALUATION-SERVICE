package com.areap2.entity.excel.external;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "slab_detail", schema = "areap2landvaluationexcel")
public class SlabDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double minValue;
	private Double maxValue;
	
	@Column(name = "band")
	private String bandNameStr;

	@Column(name = "weightage")
	private Double weightage;//new changes
	

	@ManyToOne
	@JoinColumn(name = "slab_group_id")
	private SlabGroup slabGroup;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getMinValue() {
		return minValue;
	}


	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}


	public Double getMaxValue() {
		return maxValue;
	}


	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}


	public String getBandNameStr() {
		return bandNameStr;
	}


	public void setBandNameStr(String bandNameStr) {
		this.bandNameStr = bandNameStr;
	}


	public Double getWeightage() {
		return weightage;
	}


	public void setWeightage(Double weightage) {
		this.weightage = weightage;
	}


	public SlabGroup getSlabGroup() {
		return slabGroup;
	}


	public void setSlabGroup(SlabGroup slabGroup) {
		this.slabGroup = slabGroup;
	}
	
	
	
}
