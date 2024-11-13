#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.mapper;

import ${package}.infra.persistent.entity.BookEntity;
import com.mybatisflex.core.BaseMapper;

public interface BookMapper extends BaseMapper<BookEntity> {

}
