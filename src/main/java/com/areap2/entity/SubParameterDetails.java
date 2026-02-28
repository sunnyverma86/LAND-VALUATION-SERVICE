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
	
	@Column(name = "band_code")
	private String bandCode;
	
	@Column(name = "weightage")
	private BigDecimal weightage;
	
	@Column(name = "effective_till")
	private String effectiveTill;
	
	@Column(name = "area_type")
	private String areaType;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "band")
	private String band;
	
	@Column(name = "distance_from")
	private BigDecimal distanceFrom;
	
	@Column(name = "distance_to")
	private BigDecimal distanceTo;
	
	@Column(name = "perpetual")
	private Boolean perpetual;
	
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
	
	@Column(name = "request_status")
	private String requestStatus;
	
	@Column(name = "district_code")
	private String districtCode;
	
	@Column(name = "sub_parameter_code")
	private String subParameterCode;
	
	@Column(name = "sub_parameter_name")
	private String subParameterName;
	
	@Column(name = "active")
	private boolean active;
	

	

}
