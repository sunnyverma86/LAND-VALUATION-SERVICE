package com.areap2.landtransaction.dto;

import java.math.BigDecimal;

public record DistrictCircleValueResponse(String district, String circle, BigDecimal totalValue) {
}