package org.example.infra.persistent.repository;


import org.example.infra.persistent.AppTestConfig;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

@ContextConfiguration(classes = AppTestConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Sql(scripts = {"/db/sql/schema.sql", "/db/sql/data.sql"})
public class UserRepositoryTest {

}
