package com.areap2.landtransaction.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LandTransactionRequest(
        @NotBlank @Size(max = 150) String district,
        @NotBlank @Size(max = 150) String circle,
        @NotBlank @Size(max = 150) String mouza,
        @NotBlank @Size(max = 150) String lot,
        @NotBlank @Size(max = 150) String village,
        @NotBlank @Size(max = 100) String dagNo,
        @NotBlank @Size(max = 100) String nicCode,
        @NotNull @DecimalMin(value = "0.00") BigDecimal considerationValue,
        @NotNull LocalDate transactionDate
) {}
