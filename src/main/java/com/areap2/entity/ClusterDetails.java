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
@Table(name = "cluster_details", schema = "areap2landvaluation")
@NamedQuery(name = "ClusterDetails.findAll", query = "SELECT a FROM ClusterDetails a")
public class ClusterDetails implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "cluster_details_cluster_details_gen_id_seq", sequenceName = "cluster_details_cluster_details_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cluster_details_cluster_details_gen_id_seq")
	@Column(name = "cluster_details_gen_id")
	 private Long clusterDetailsGenId;

    @Column(name = "cluster_code", nullable = false, length = 20, unique = true)
    private String clusterCode;

    @Column(name = "base_value", nullable = false)
    private Long baseValue;

    @Column(name = "cluster_range", nullable = false, precision = 10)
    private BigDecimal clusterRange;

    @Column(name = "cluster_minimum", nullable = false, precision = 10)
    private BigDecimal clusterMinimum;
    
    @Column(name = "mouza_code", nullable = false, length = 20)
    private String mouzaCode;
    
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
