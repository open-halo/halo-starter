#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ${package}.halo.core.model.base.BaseModel;

import java.math.BigDecimal;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
public class BookStoreLink extends BaseModel {

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
