package org.example.infra.persistent.config;

import lombok.extern.slf4j.Slf4j;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.runtime.Initializer;
import org.example.infra.persistent.config.base.SqlInitExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Slf4j
@Component
@Profile("h2")
public class H2Initializer implements Initializer {
    private final SqlInitExecutor initExecutor;
    private final DataSource      dataSource;
    private final String          url;

    public H2Initializer(DataSource dataSource, @Value("${spring.datasource.url}") String url,
                         SqlInitExecutor initExecutor) {
        this.dataSource = dataSource;
        this.url = url;
        this.initExecutor = initExecutor;
    }

    @Override
    public void initialize(JSqlClient sqlClient) throws Exception {
        if (url.startsWith("jdbc:h2:")) {
            initExecutor.execute(dataSource, "sql/h2");
        }
    }
}
