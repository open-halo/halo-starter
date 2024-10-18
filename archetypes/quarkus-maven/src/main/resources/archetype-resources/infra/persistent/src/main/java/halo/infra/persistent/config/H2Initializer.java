#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.infra.persistent.config;

import cn.hutool.core.io.resource.ResourceUtil;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;


import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@ApplicationScoped
public class H2Initializer {

    @Inject
    private DataSource dataSource;


    @ConfigProperty(name = "quarkus.datasource.jdbc.url")
    private String url;

    void onStart(@Observes StartupEvent ev) {
        log.info("The application is starting...");
    }

    void onStop(@Observes ShutdownEvent ev) {
        log.info("The application is stopping...");
    }

    private void initH2() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            String teardownSql = ResourceUtil.readUtf8Str("sql/teardown/drop.sql");
            log.info("h2 teardown: {}", teardownSql);
            conn.createStatement().execute(teardownSql);
            log.info("h2 teardown success");

            String schemaSql = ResourceUtil.readUtf8Str("sql/schemas/schema.sql");
            log.info("h2 init sql: {}", schemaSql);
            conn.createStatement().execute(schemaSql);
            log.info("h2 create schema success");

            String dataSql = ResourceUtil.readUtf8Str("sql/data/data.sql");
            log.info("h2 load data: {}", dataSql);
            conn.createStatement().execute(dataSql);
            log.info("h2 load data success");
        }
    }
}
