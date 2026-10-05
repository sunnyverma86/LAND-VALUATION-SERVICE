package com.areap2.landtransaction.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "land_transaction", schema = "areap2landvaluationexcel", indexes = {
		@Index(name = "idx_land_tx_district", columnList = "district"),
		@Index(name = "idx_land_tx_circle", columnList = "circle"),
		@Index(name = "idx_land_tx_mouza", columnList = "mouza"),
		@Index(name = "idx_land_tx_village", columnList = "village"),
		@Index(name = "idx_land_tx_dag_no", columnList = "dag_no"),
		@Index(name = "idx_land_tx_nic_code", columnList = "nic_code"),
		@Index(name = "idx_land_tx_date", columnList = "transaction_date"),
		@Index(name = "uk_land_tx_fingerprint", columnList = "fingerprint", unique = true) })

public class LandTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150)
	private String district;

	@Column(nullable = false, length = 150)
	private String circle;

	@Column(nullable = false, length = 150)
	private String mouza;

	@Column(nullable = false, length = 150)
	private String lot;

	@Column(nullable = false, length = 150)
	private String village;

	@Column(name = "dag_no", nullable = false, length = 100)
	private String dagNo;

	@Column(name = "nic_code", nullable = false, length = 100)
	private String nicCode;

	@Column(name = "consideration_value", nullable = false, precision = 19, scale = 2)
	private BigDecimal considerationValue;

	@Column(name = "transaction_date", nullable = false)
	private LocalDate transactionDate;

	@Column(nullable = false, length = 64, updatable = false)
	private String fingerprint;

	@Column(nullable = false)
	@Builder.Default
	private Boolean active = true;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private LocalDateTime updatedAt;

	@Column(length = 100, updatable = false)
	private String createdBy;

	@Column(length = 100)
	private String updatedBy;

	@PrePersist
	protected void onCreate() {
		LocalDateTime now = LocalDateTime.now();
		createdAt = now;
		updatedAt = now;
		if (active == null)
			active = true;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getMouza() {
		return mouza;
	}

	public void setMouza(String mouza) {
		this.mouza = mouza;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getDagNo() {
		return dagNo;
	}

	public void setDagNo(String dagNo) {
		this.dagNo = dagNo;
	}

	public String getNicCode() {
		return nicCode;
	}

	public void setNicCode(String nicCode) {
		this.nicCode = nicCode;
	}

	public BigDecimal getConsiderationValue() {
		return considerationValue;
	}

	public void setConsiderationValue(BigDecimal considerationValue) {
		this.considerationValue = considerationValue;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LandTransaction() {
	}

	public LandTransaction(Long id, String district, String circle, String mouza, String lot, String village,
			String dagNo, String nicCode, BigDecimal considerationValue, LocalDate transactionDate, String fingerprint,
			Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
		this.id = id;
		this.district = district;
		this.circle = circle;
		this.mouza = mouza;
		this.lot = lot;
		this.village = village;
		this.dagNo = dagNo;
		this.nicCode = nicCode;
		this.considerationValue = considerationValue;
		this.transactionDate = transactionDate;
		this.fingerprint = fingerprint;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

}
