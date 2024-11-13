#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.model;


import ${package}.core.model.base.BaseModel;
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
public class BookStoreLink extends BaseModel {

        long bookId;

        long storeId;

        int remainCount;

        @NotNull
        @DecimalMin(value = "0.1")
        @DecimalMax(value = "99999.9")
        @Digits(integer = 8, fraction = 2)
        BigDecimal price;
}
