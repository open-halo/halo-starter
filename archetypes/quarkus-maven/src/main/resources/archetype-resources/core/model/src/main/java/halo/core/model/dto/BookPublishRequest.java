#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.model.dto;


import java.math.BigDecimal;

public record BookPublishRequest(
        String name,

        Integer edition,

        BigDecimal price,

        Long authorId
) {
}
