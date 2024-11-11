package org.example.halo.infra.persistent.mapper;

import io.quarkus.panache.common.Page;
import org.example.halo.core.model.base.Pagination;
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
