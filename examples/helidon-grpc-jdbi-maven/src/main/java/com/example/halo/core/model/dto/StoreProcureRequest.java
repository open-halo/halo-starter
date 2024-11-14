package com.example.halo.core.model.dto;


import java.math.BigDecimal;

public record StoreProcureRequest(
        long storeId,
        long bookId,
        BigDecimal price,
        int count
) {
}
