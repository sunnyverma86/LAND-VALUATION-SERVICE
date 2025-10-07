package com.areap2.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "areap2_land_sub_class", schema = "areap2landvaluation")
@NamedQuery(name = "LandSubClassDetails.findAll", query = "SELECT a FROM LandSubClassDetails a")
public class LandSubClassDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_land_sub_class_gen_id_seq", sequenceName = "areap2_land_sub_class_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_land_sub_class_gen_id_seq")
	@Column(name = "land_sub_class_gen_id")
	private Long landSubClassGenId;
	
	@Column(name = "land_sub_class_code")
	private String landSubClassCode;

	@Column(name = "land_sub_class_name")
	private String landSubClassName;

	@Column(name = "land_class_name")
	private String landClassName;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_dtm")
	private Timestamp createdDtm = new Timestamp(System.currentTimeMillis());

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_dtm")
	private Timestamp updatedDtm;

}
