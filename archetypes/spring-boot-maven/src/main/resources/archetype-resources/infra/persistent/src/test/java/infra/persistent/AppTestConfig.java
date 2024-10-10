#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent;


import ${package}.core.gateway.repository.IUserRepository;
import ${package}.infra.persistent.gateway.UserRepository;
import ${package}.infra.persistent.repository.UserJRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
@ComponentScan("${package}.infra.persistent")
public class AppTestConfig {


    @Bean
    IUserRepository getIUserRepository(UserJRepository jRepository) {
        return new UserRepository(jRepository);
    }
    @Bean
    JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
