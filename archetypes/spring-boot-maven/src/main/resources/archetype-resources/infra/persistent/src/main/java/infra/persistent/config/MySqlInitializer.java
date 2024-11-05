#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.runtime.Initializer;
import ${package}.infra.persistent.config.base.SqlInitExecutor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Slf4j
@Component
@Profile("dev-mysql")
@AllArgsConstructor
public class MySqlInitializer implements Initializer {

    private final SqlInitExecutor initExecutor;

    private final DataSource      dataSource;

    @Override
    public void initialize(JSqlClient sqlClient) throws Exception {
        initExecutor.execute(dataSource, "sql/mysql");
    }
}
