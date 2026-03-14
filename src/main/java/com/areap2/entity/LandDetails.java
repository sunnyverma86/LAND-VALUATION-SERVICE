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


	public Long getLandDetailsGenId() {
		return landDetailsGenId;
	}


	public void setLandDetailsGenId(Long landDetailsGenId) {
		this.landDetailsGenId = landDetailsGenId;
	}


	public String getMouzaCode() {
		return mouzaCode;
	}


	public void setMouzaCode(String mouzaCode) {
		this.mouzaCode = mouzaCode;
	}


	public String getRange() {
		return range;
	}


	public void setRange(String range) {
		this.range = range;
	}


	public Integer getPlotFrom() {
		return plotFrom;
	}


	public void setPlotFrom(Integer plotFrom) {
		this.plotFrom = plotFrom;
	}


	public Integer getPlotTo() {
		return plotTo;
	}


	public void setPlotTo(Integer plotTo) {
		this.plotTo = plotTo;
	}


	public Long getMarketValue() {
		return marketValue;
	}


	public void setMarketValue(Long marketValue) {
		this.marketValue = marketValue;
	}


	public Long getLandCategoryId() {
		return landCategoryId;
	}


	public void setLandCategoryId(Long landCategoryId) {
		this.landCategoryId = landCategoryId;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getCreatedDtm() {
		return createdDtm;
	}


	public void setCreatedDtm(Timestamp createdDtm) {
		this.createdDtm = createdDtm;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Timestamp getUpdatedDtm() {
		return updatedDtm;
	}


	public void setUpdatedDtm(Timestamp updatedDtm) {
		this.updatedDtm = updatedDtm;
	}


	public String getApprovedBy() {
		return approvedBy;
	}


	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}


	public Timestamp getApprovedDtm() {
		return approvedDtm;
	}


	public void setApprovedDtm(Timestamp approvedDtm) {
		this.approvedDtm = approvedDtm;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
