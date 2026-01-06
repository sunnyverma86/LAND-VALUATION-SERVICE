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
@Table(name = "areap2_sub_parameter_details", schema = "areap2landvaluation")
@NamedQuery(name = "SubParameterDetails.findAll", query = "SELECT a FROM SubParameterDetails a")
public class SubParameterDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_sub_parameter_details_sub_parameter_gen_id_seq", sequenceName = "areap2_sub_parameter_details_sub_parameter_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_sub_parameter_details_sub_parameter_gen_id_seq")
	@Column(name = "sub_parameter_gen_id")
	private Long subParameterGenId;

	@Column(name = "parameter_code")
	private String parameterCode;

	@Column(name = "sub_parameter_name")
	private String subParameterName;

	@Column(name = "sub_parameter_code")
	private String subParameterCode;

	@Column(name = "effective_from")
	private Timestamp effectiveFrom;

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

	@Column(name = "base_price_increase_sub_parameter")
	private BigDecimal basePriceIncreaseSubParameter;
	
	@Column(name = "request_status")
	private String requestStatus;
}
