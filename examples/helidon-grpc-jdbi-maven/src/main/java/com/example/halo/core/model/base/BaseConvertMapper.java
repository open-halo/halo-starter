package com.example.halo.core.model.base;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseConvertMapper {
    BaseConvertMapper INSTANCE = Mappers.getMapper(BaseConvertMapper.class);

}
