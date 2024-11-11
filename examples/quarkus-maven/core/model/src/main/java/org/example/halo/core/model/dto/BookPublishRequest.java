package org.example.halo.core.model.dto;


import java.math.BigDecimal;

public record BookPublishRequest(
        String name,

        Integer edition,

        BigDecimal price,

        Long authorId
) {
}
