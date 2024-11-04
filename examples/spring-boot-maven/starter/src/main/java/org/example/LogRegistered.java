package org.example;

//import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Slf4j
@Component
public class LogRegistered implements CommandLineRunner {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Override
    public void run(String... args) throws Exception {
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();

        log.info("Registered REST Endpoints:");
        handlerMethods.forEach((info, method) -> {
            StringBuilder sb = new StringBuilder();
//            info.getPatternsCondition().getPatterns().forEach(pattern -> sb.append(pattern).append(" "));
            info.getMethodsCondition().getMethods().forEach(httpMethod -> sb.append(httpMethod.name()).append(" "));
            sb.append(method.getMethod().getDeclaringClass().getName()).append("#").append(method.getMethod().getName());
            log.info("{}", sb);
        });
    }
}
