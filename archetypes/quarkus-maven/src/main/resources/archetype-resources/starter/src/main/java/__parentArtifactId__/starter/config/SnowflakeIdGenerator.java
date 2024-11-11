#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.starter.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import ${package}.${parentArtifactId}.core.gateway.IIdGenerator;

@ApplicationScoped
public class SnowflakeIdGenerator implements IIdGenerator {

    private Snowflake snowflake;

    public SnowflakeIdGenerator(
            @ConfigProperty(name="application.id-generator.center-id", defaultValue = "0")
            long dataCenterId,
            @ConfigProperty(name="application.id-generator.worker-id", defaultValue = "1")
            long workerId) {
        this.snowflake = IdUtil.getSnowflake(workerId, dataCenterId);
    }

    @Override
    public long nextLongId() {
        return snowflake.nextId();
    }
}
