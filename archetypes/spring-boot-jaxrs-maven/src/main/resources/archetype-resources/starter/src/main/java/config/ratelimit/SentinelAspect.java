#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config.ratelimit;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.aspectj.AbstractSentinelAspectSupport;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import ${package}.common.annotations.HaloSentinelResource;

@Slf4j
@Aspect
public class SentinelAspect extends AbstractSentinelAspectSupport {

    @Pointcut("@annotation(${package}.common.annotations.HaloSentinelResource)")
    public void sentinelResourceAnnotationPointcut() {
    }

    @Around("@annotation(com.example.common.annotations.HaloSentinelResource)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = getMethodName(joinPoint);
        log.info("aop: {} ", methodName);
        HaloSentinelResource customSentinelResource = getHaloSentinelResource(joinPoint);
        if (customSentinelResource == null) {
            return joinPoint.proceed();
        }

        // 获取资源名称
        String resourceName = customSentinelResource.value();
        if (resourceName.isEmpty()) {
            resourceName = joinPoint.getSignature().getName();
        }

        Entry entry = null;
        try {
            entry = SphU.entry(resourceName);
            return joinPoint.proceed();
        } catch (BlockException e) {
            return "Blocked by Sentinel: " + resourceName + "->" + e.getClass().getSimpleName()
                   + "->" + methodName;
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    private String getMethodName(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature methodSignature) {
            return methodSignature.getName();
        }
        return "";
    }

    private HaloSentinelResource getHaloSentinelResource(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature methodSignature) {
            HaloSentinelResource resource = methodSignature.getMethod().getAnnotation(HaloSentinelResource.class);
            if (resource != null) {
                return resource;
            } else {
                return joinPoint.getTarget().getClass().getAnnotation(HaloSentinelResource.class);
            }
        }
        return null;
    }
}
