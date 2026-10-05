package com.areap2.landtransaction.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record LandTransactionResponse(
        Long id,
        String district,
        String circle,
        String mouza,
        String lot,
        String village,
        String dagNo,
        String nicCode,
        BigDecimal considerationValue,
        LocalDate transactionDate,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String createdBy,
        String updatedBy
) {}
