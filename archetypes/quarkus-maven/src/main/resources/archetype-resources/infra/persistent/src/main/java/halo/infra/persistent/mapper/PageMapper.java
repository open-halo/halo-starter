#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.infra.persistent.mapper;

import io.quarkus.panache.common.Page;
import ${package}.halo.core.model.base.Pagination;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PageMapper {
    PageMapper INSTANCE = Mappers.getMapper(PageMapper.class);

    default Page toPage(Pagination pagination) {
        return new Page( pagination.getPageIndex(), pagination.getPageSize());
    }
}
