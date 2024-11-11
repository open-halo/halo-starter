package org.example.infra.persistent.config.source;

//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Profile;
//import org.testcontainers.containers.MySQLContainer;

//@Profile("dev-mysql")
//@Configuration
public class MySqlContainerSource {
    //    public static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.26")
    //                                                       .withDatabaseName("testdb")
    //                                                       .withUsername("testuser")
    //                                                       .withPassword("testpassword");
    //
    //    @Bean
    //    @Primary
    //    public HikariDataSource dataSource() {
    //        HikariConfig config = new HikariConfig();
    //        config.setJdbcUrl(mysqlContainer.getJdbcUrl());
    //        config.setUsername(mysqlContainer.getUsername());
    //        config.setPassword(mysqlContainer.getPassword());
    //        return new HikariDataSource(config);
    //    }
}
