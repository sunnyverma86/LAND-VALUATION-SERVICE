package com.areap2.dto.historical;

import java.time.LocalDateTime;

public class HistoricalTableResponse {

	private String tableName;
	private String schema;
	private String qualifiedName;

	private LocalDateTime actionDatetime;
	private String actionType;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}

	public LocalDateTime getActionDatetime() {
		return actionDatetime;
	}

	public void setActionDatetime(LocalDateTime actionDatetime) {
		this.actionDatetime = actionDatetime;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public HistoricalTableResponse() {
	}

	public HistoricalTableResponse(String tableName, String schema, String qualifiedName, LocalDateTime actionDatetime,
			String actionType) {

		this.tableName = tableName;
		this.schema = schema;
		this.qualifiedName = qualifiedName;
		this.actionDatetime = actionDatetime;
		this.actionType = actionType;
	}

}