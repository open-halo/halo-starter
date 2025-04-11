package org.example.halo.infra.persistent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.halo.core.model.Book;
import org.example.halo.core.model.Store;

@Mapper
public interface StoreMapper extends BaseMapper<Store> {
}
