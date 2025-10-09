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
@Table(name = "land_details", schema = "areap2landvaluation")
@NamedQuery(name = "LandDetails.findAll", query = "SELECT a FROM LandDetails a")
public class LandDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "land_details_land_details_gen_id_seq", sequenceName = "land_details_land_details_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "land_details_land_details_gen_id_seq")
	@Column(name = "land_details_gen_id")
    private Long landDetailsGenId;

    @Column(name = "mouza_code", nullable = false, length = 20)
    private String mouzaCode;

    @Column(name = "range", nullable = false, length = 20) 
    private String range;

    @Column(name = "plot_from", nullable = false)
    private Integer plotFrom;

    @Column(name = "plot_to", nullable = false)
    private Integer plotTo;

    @Column(name = "market_value")
    private Long marketValue;

    @Column(name = "land_category_id", nullable = false)
    private Long landCategoryId;

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
}
