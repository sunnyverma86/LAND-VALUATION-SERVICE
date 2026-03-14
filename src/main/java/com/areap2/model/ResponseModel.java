package com.areap2.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

	private HttpStatus httpStatus;
	private String message;
	private Object data;

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseModel() {
	}

	public ResponseModel(HttpStatus httpStatus, String message, Object data) {

		this.httpStatus = httpStatus;
		this.message = message;
		this.data = data;
	}

}
