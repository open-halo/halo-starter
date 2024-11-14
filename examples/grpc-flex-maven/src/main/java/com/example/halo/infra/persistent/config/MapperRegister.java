package com.example.halo.infra.persistent.config;

import com.example.halo.infra.persistent.mapper.AuthorMapper;
import com.example.halo.infra.persistent.mapper.BookMapper;
import com.example.halo.infra.persistent.mapper.BookStoreLinkMapper;
import com.example.halo.infra.persistent.mapper.StoreMapper;
import com.mybatisflex.core.MybatisFlexBootstrap;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import jakarta.inject.Inject;

import javax.sql.DataSource;

@Factory
public class MapperRegister {

    @Bean
    MybatisFlexBootstrap getMybatisFlexBootstrap(DataSource dataSource) {
        return MybatisFlexBootstrap.getInstance()
                .setDataSource(dataSource)
                .addMapper(BookMapper.class)
                .start();
    }

    @Bean
    AuthorMapper getAuthorMapper(MybatisFlexBootstrap bootstrap) {
        return bootstrap.getMapper(AuthorMapper.class);
    }

    @Bean
    BookMapper getBookMapper(MybatisFlexBootstrap bootstrap) {
        return bootstrap.getMapper(BookMapper.class);
    }

    @Bean
    StoreMapper getStoreMapper(MybatisFlexBootstrap bootstrap) {
        return bootstrap.getMapper(StoreMapper.class);
    }

    @Bean
    BookStoreLinkMapper getBookStoreLinkMapper(MybatisFlexBootstrap bootstrap) {
        return bootstrap.getMapper(BookStoreLinkMapper.class);
    }

}
