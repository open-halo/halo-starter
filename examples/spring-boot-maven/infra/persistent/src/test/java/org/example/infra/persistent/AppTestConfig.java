package org.example.infra.persistent;

import org.example.core.gateway.repository.IUserRepository;
import org.example.infra.persistent.gateway.UserRepository;
import org.example.infra.persistent.repository.AuthorJRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
@ComponentScan("org.example.infra.persistent")
public class AppTestConfig {

    @Bean
    IUserRepository getIUserRepository(AuthorJRepository jRepository) {
        return new UserRepository(jRepository);
    }

    @Bean
    JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
