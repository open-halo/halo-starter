package org.example.infra.persistent.repository;


import org.example.core.domian.User;
import org.example.core.gateway.repository.IUserRepository;
import org.example.infra.persistent.AppTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ContextConfiguration(classes = AppTestConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Sql(scripts = {"/db/sql/schema.sql", "/db/sql/data.sql"})
public class UserRepositoryTest {
//    @Autowired
//    private IUserRepository userRepository;
//
//    @Test
//    public void testUserRepository() {
//        User user = new User(10L, "Allen", "test@example.com");
//        userRepository.save(user);
//    }
}
