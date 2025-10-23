package com.areap2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "instrument_master", schema = "areap2landvaluation")
public class Instrument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(name = "male_duty")
	private Integer maleDuty;

	@Column(name = "female_duty")
	private Integer femaleDuty;

	@Column(name = "joint_duty")
	private Integer jointDuty;

}
