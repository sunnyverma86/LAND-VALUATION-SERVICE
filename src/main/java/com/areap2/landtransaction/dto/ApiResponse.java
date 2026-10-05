package com.areap2.landtransaction.dto;

public record ApiResponse<T>(
        boolean success,
        int statusCode,
        String status,
        T value
) {
}
