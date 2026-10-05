package com.areap2.landtransaction.dto;

import java.util.List;

public record ExcelUploadResponse(
        String fileName,
        int totalRows,
        int insertedRows,
        int duplicateRows,
        int failedRows,
        List<RowError> errors
) {
    public record RowError(int rowNumber, String message) {}
}
