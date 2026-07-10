package com.areap2.controller.excel.map.bean;


public class UploadResponse {

	private boolean success;
	private String message;
	private long totalRecords;
	private long executionTime;

	public UploadResponse() {
	}

	public UploadResponse(boolean success, String message, long totalRecords, long executionTime) {

		this.success = success;
		this.message = message;
		this.totalRecords = totalRecords;
		this.executionTime = executionTime;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	
}