#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.mapper;

import ${package}.infra.persistent.entity.AuthorEntity;
import com.mybatisflex.core.BaseMapper;

public interface AuthorMapper extends BaseMapper<AuthorEntity> {
}
