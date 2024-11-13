#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.config;

import com.zaxxer.hikari.HikariDataSource;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import javax.sql.DataSource;

@Factory
public class DataSourceRegister {
    @Bean
    DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:h2:mem:testdb;MODE=MYSQL;DATABASE_TO_UPPER=true;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

}
