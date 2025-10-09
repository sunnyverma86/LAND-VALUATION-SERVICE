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
@Table(name = "areap2_circle_details", schema = "areap2landvaluation")
@NamedQuery(name = "CircleDetails.findAll", query = "SELECT a FROM CircleDetails a")
public class CircleDetails implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_circle_details_circle_gen_id_seq", sequenceName = "areap2_circle_details_circle_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_circle_details_circle_gen_id_seq")
	@Column(name = "circle_gen_id")
	private Long circleGenId;

	@Column(name = "circle_name")
	private String circleName;
	
	@Column(name = "circle_code")
	private String circleCode;

//	@Column(name = "lot")
//	private String lot;
	
	@Column(name = "district_code")
	private String districtCode;

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

	
	@Column(name = "status")
	private String status;

	
	@Column(name = "status_code")
	private String statusCode;
}
