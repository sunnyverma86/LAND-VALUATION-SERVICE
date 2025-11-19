package com.areap2.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "areap2_parameter_details", schema = "areap2landvaluation")
@NamedQuery(name = "ParameterDetails.findAll", query = "SELECT a FROM ParameterDetails a")
public class ParameterDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_parameter_details_parameter_gen_id_seq", sequenceName = "areap2_parameter_details_parameter_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_parameter_details_parameter_gen_id_seq")
	@Column(name = "parameter_gen_id")
	private Long parameterGenId;

	@Column(name = "parameter_name")
	private String parameterName;

	@Column(name = "parameter_code")
	private String parameterCode;
	
	@Column(name = "parameter_id")
	private String parameterId;

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

	@Column(name = "approved_by")
	private String approvedBy;

	@Column(name = "approved_dtm")
	private Timestamp approvedDtm;

	@Column(name = "status")
	private String status;

	@Column(name = "status_code")
	private String statusCode;

	@Column(name = "base_price_increase_parameter")
	private Long basePriceIncreaseParameter;
	
//
//	@Column(name = "parameter", nullable = false, length = 200)
//	private String parameter;
//
//	@Column(name = "parameter_type", length = 200)
//	private String parameterType;
//
//	@Column(name = "area_type_id", nullable = false)
//	private Long areaTypeId;
//
//	@Column(name = "min_range_in_meters", precision = 10)
//	private BigDecimal minRangeInMeters;
//
//	@Column(name = "max_range_in_meters", precision = 10)
//	private BigDecimal maxRangeInMeters;
//
//	@Column(name = "min_max_range", length = 50)
//	private String minMaxRange;

}
