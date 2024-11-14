package com.example.halo.infra.persistent.mapper;


import com.example.halo.infra.persistent.entity.AuthorEntity;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface AuthorDao {

    @SqlQuery("SELECT * FROM author WHERE id = ?")
    AuthorEntity fetchById(long id);

    @SqlUpdate("INSERT INTO author (id, name, email) VALUES (?, ?, ?)")
    void insert(long id, String name, String email);
}
