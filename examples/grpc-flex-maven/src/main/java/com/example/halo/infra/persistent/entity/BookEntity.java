package com.example.halo.infra.persistent.entity;


import java.math.BigDecimal;

import com.example.halo.infra.persistent.entity.base.BaseEntity;
import com.mybatisflex.annotation.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Valid
@Data
@Table("book")
@EqualsAndHashCode(callSuper=true)
public class BookEntity extends BaseEntity {

    @NotBlank
    private String name;

    @NotNull
    @Min(value = 1)
    private Integer edition;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "99999.9")
    @Digits(integer = 8, fraction = 2)
    private BigDecimal price;

    @NotNull
    private Long authorId;

}
