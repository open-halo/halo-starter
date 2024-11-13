#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.starter;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import ${package}.core.gateway.IIdGenerator;
import io.helidon.config.Config;

import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class SnowflakeIdGenerator implements IIdGenerator {

    private Snowflake snowflake;

    public SnowflakeIdGenerator() {
        long centerId = Config.global().get("app.center-id").asInt().orElse(0);
        long workerId = Config.global().get("app.worker-id").asInt().orElse(0);
        log.info("SnowflakeIdGenerator init with {} {}", centerId, workerId);
        this.snowflake = new Snowflake(workerId, centerId);
    }

    @Override
    public long nextLongId() {
        return snowflake.nextId();
    }
}
