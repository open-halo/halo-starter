package com.example.halo.starter;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.example.halo.core.gateway.IIdGenerator;

import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class SnowflakeIdGenerator implements IIdGenerator {

    private Snowflake snowflake;

    public SnowflakeIdGenerator() {
//        long centerId = Config.global().get("app.center-id").asInt().orElse(0);
//        long workerId = Config.global().get("app.worker-id").asInt().orElse(0);
        long centerId = 0;
        long workerId = 1;
        log.info("SnowflakeIdGenerator init with {} {}", centerId, workerId);
        this.snowflake = new Snowflake(workerId, centerId);
    }

    @Override
    public long nextLongId() {
        return snowflake.nextId();
    }
}
