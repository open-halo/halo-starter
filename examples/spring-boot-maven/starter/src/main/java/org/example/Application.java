package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * For GraalVM, gclib proxies should be disabled, proxyBeanMethods = false
 */
@SpringBootApplication(proxyBeanMethods = false)
@EnableAspectJAutoProxy
public class Application {
    public static void main(String[] args) {SpringApplication.run(Application.class, args);
    }

//    private void unusedVariable() {
//        int unused = 42;
//    }
}