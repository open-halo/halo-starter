#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config.ratelimit;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.zhxu.xjson.YamlKit;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class SentinelInit implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String rateLimitDefinitions = ResourceUtil.readUtf8Str("ratelimit.yaml");
        if (rateLimitDefinitions.isBlank()) {
            throw new Exception("no rate limit definitions found");
        }
        log.info("rate limit definitions: {}", rateLimitDefinitions);

        RateLimits rateLimits = YamlKit.toBean(RateLimits.class, rateLimitDefinitions);
        List<FlowRule> flowRules = rateLimits.rateLimits.stream().map(e->{
            FlowRule flowRule = new FlowRule(e.name);
            flowRule.setGrade(RuleConstant.FLOW_GRADE_THREAD);
            flowRule.setCount(e.limit);
            return flowRule;
        }).toList();

        FlowRuleManager.loadRules(flowRules);

        List<DegradeRule> degradeRules = rateLimits.rateLimits.stream().map(e->{
            DegradeRule degradeRule = new DegradeRule(e.name);
            degradeRule.setMinRequestAmount(e.degrade.minRequest);
            degradeRule.setTimeWindow(e.degrade.timeWindowSeconds);
            if (e.degrade.grade.equalsIgnoreCase("RT")) {
                degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
                degradeRule.setSlowRatioThreshold(e.degrade.count);
                return degradeRule;
            } else if (e.degrade.grade.equalsIgnoreCase("EXCEPTION")) {
                degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_RATIO);
                degradeRule.setCount(e.degrade.count);
                return degradeRule;
            }
            return null;
        }).filter(Objects::nonNull).toList();
        DegradeRuleManager.loadRules(degradeRules);
    }
}
