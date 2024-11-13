package com.example.halo.core.model;

import com.example.halo.core.model.base.BaseModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Valid
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Book extends BaseModel {

        @NotBlank
        String name;

        @Min(value = 1)
        int edition;

        @NotNull
        @DecimalMin(value = "0.1")
        @DecimalMax(value = "99999.9")
        @Digits(integer = 8, fraction = 2)
        BigDecimal price;

        long authorId;
}
