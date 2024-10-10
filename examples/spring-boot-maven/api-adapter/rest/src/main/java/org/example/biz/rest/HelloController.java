package org.example.biz.rest;

import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.example.api.rest.IHello;


@Named
@Slf4j
public class HelloController implements IHello {
    @Override
    public String sayHello() {
        log.info("sayHello()");
        return "Hello world!";
    }
}
