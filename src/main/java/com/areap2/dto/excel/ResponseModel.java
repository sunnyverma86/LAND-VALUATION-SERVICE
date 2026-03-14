package com.areap2.dto.excel;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class ResponseModel {

    private HttpStatus httpStatus;
    private String message;
    private Object data;

    public ResponseModel() {}

    public ResponseModel(HttpStatus httpStatus, String message, Object data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    // getters setters
}