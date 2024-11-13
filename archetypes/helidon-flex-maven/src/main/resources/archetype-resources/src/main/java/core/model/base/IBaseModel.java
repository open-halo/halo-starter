#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.model.base;

import java.time.LocalDateTime;

public interface IBaseModel {
    long getId();

    LocalDateTime getCreateTime();

    LocalDateTime getUpdateTime();
}
