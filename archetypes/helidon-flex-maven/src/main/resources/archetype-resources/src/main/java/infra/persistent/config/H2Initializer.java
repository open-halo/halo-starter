#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.config;

import ${package}.infra.persistent.config.base.SqlInitExecutor;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


import javax.sql.DataSource;


@Slf4j
@Singleton
public class H2Initializer {
    @Inject
    DataSource dataSource;

    public void init() {
        log.info("H2Initializer init the database");
        try {
            SqlInitExecutor.execute(dataSource, "sql/h2");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }


}
