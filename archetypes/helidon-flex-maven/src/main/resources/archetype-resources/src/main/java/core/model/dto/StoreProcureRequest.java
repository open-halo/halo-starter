#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.model.dto;


import java.math.BigDecimal;

public record StoreProcureRequest(
        long storeId,
        long bookId,
        BigDecimal price,
        int count
) {
}
