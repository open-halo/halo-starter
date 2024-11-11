package org.example.halo.infra.persistent.config;

import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.example.halo.infra.persistent.config.base.SqlInitExecutor;

import javax.sql.DataSource;


@Slf4j
@ApplicationScoped
public class H2Initializer {
    @Inject
    DataSource dataSource;

    @Startup
    public void init() {
        log.info("H2Initializer init the database");
        try {
            SqlInitExecutor.execute(dataSource, "sql/h2");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }


}
