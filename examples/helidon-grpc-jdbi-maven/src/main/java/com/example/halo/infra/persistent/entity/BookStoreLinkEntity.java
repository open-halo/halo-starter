package com.example.halo.infra.persistent.entity;

import com.example.halo.infra.persistent.entity.base.BaseEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Valid
@Data
@EqualsAndHashCode(callSuper=true)
public class BookStoreLinkEntity extends BaseEntity {
    @NotNull
    private Long bookId;

    @NotNull
    private Long storeId;

    @Min(0)
    @Max(1_000_000)
    private Integer remainCount;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "99999.9")
    @Digits(integer = 8, fraction = 2)
    private BigDecimal price;
}
