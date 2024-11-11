#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.model.base;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseConvertMapper {
    BaseConvertMapper INSTANCE = Mappers.getMapper(BaseConvertMapper.class);

}
