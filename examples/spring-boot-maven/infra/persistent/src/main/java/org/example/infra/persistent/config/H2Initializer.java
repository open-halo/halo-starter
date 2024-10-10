package org.example.infra.persistent.config;

import cn.hutool.core.io.resource.ResourceUtil;
import lombok.extern.slf4j.Slf4j;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.runtime.Initializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@Component
@Profile("dev")
public class H2Initializer implements Initializer {

    private final DataSource dataSource;

    private final String url;

    public H2Initializer(
            DataSource dataSource,
            @Value("${spring.datasource.url}") String url) {
        this.dataSource = dataSource;
        this.url = url;
    }

    @Override
    public void initialize(JSqlClient sqlClient) throws Exception {
        if (url.startsWith("jdbc:h2:")) {
            initH2();
        }
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
