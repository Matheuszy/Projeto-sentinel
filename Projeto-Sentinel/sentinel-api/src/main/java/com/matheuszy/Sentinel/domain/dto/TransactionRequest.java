package com.matheuszy.Sentinel.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record TransactionRequest(
        @NotNull
        Integer transaction_id,
        @NotNull
        Timestamp timestamp,
        @NotNull
        @Positive
        BigDecimal amount,
        @NotNull
        Long merchantCategory
) {
}
