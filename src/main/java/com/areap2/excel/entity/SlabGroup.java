package com.areap2.excel.entity;

import java.time.LocalDateTime;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "slab_group")
public class SlabGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String district;

	private Integer versionNo;

	private Boolean active;

	private String createdBy;

	private LocalDateTime createdDtm;

	@ManyToOne
	@JoinColumn(name = "distance_type_id")
	private DistanceType distanceType;

	@Column(name = "parameter_name")
	private String parameterName;

	@Column(name = "area_type")
	private String areaType;

	@Column(name = "perpetual")
	private boolean perpetual;

	@Column(name = "band")
	private String band;
}