package com.example.halo.infra.persistent.mapper;

import com.example.halo.infra.persistent.entity.BookEntity;
import org.jdbi.v3.sqlobject.GenerateSqlObject;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;


@GenerateSqlObject
public interface BookDao  {

    @SqlQuery("SELECT * FROM book WHERE id = ?")
    @RegisterBeanMapper(BookEntity.class)
    BookEntity fetchOneById(long id);
}
