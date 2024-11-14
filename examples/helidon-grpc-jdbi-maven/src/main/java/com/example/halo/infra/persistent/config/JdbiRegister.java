package com.example.halo.infra.persistent.config;

import com.example.halo.infra.persistent.mapper.BookDao;
import com.example.halo.infra.persistent.mapper.BookDaoImpl;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.sql.DataSource;

@Factory
public class JdbiRegister {

    @Bean
    public Jdbi registerJdbi(DataSource dataSource) {
        Jdbi jdbi = Jdbi.create(dataSource);
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }

    @Bean
    BookDao getBookDao(Jdbi jdbi) {
//        return jdbi.onDemand(BookDaoImpl.class);
        return new BookDaoImpl.OnDemand(jdbi);
    }


}
