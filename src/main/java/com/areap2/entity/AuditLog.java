package com.areap2.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "audit_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String loginId;
	private String featureName;
	private String actionType;
	private Timestamp actionDatetime;
	private String featureDescription;
	private String message;
	private String status;

	private String statusCode;

	private Long referenceId;

	private Long newReferenceId;

	private Timestamp updateDatetime;

	private String featureId;
	private String updatedBy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public Timestamp getActionDatetime() {
		return actionDatetime;
	}
	public void setActionDatetime(Timestamp actionDatetime) {
		this.actionDatetime = actionDatetime;
	}
	public String getFeatureDescription() {
		return featureDescription;
	}
	public void setFeatureDescription(String featureDescription) {
		this.featureDescription = featureDescription;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public Long getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}
	public Long getNewReferenceId() {
		return newReferenceId;
	}
	public void setNewReferenceId(Long newReferenceId) {
		this.newReferenceId = newReferenceId;
	}
	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}
	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	public String getFeatureId() {
		return featureId;
	}
	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public AuditLog() {}
	public AuditLog(Long id, String loginId, String featureName, String actionType, Timestamp actionDatetime,
			String featureDescription, String message, String status, String statusCode, Long referenceId,
			Long newReferenceId, Timestamp updateDatetime, String featureId, String updatedBy) {
		
		this.id = id;
		this.loginId = loginId;
		this.featureName = featureName;
		this.actionType = actionType;
		this.actionDatetime = actionDatetime;
		this.featureDescription = featureDescription;
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.referenceId = referenceId;
		this.newReferenceId = newReferenceId;
		this.updateDatetime = updateDatetime;
		this.featureId = featureId;
		this.updatedBy = updatedBy;
	}
	
	
	

	// getters and setters
}
