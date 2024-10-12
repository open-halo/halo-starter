package org.example.config.ratelimit;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;


@Data
public class RateLimits {

    @Data
    public static class Degrade {
        @JsonAlias("time-window-seconds")
        int timeWindowSeconds;

        @JsonAlias("min-request")
        int minRequest;
        String grade;
        double count;
    }


    @Data
    public static class LimitRule {
        String name;
        int limit;
        Degrade degrade;
    }

    @JsonAlias("rate-limits")
    List<LimitRule> rateLimits;
}
