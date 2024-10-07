package org.example.biz.rest;

import org.example.api.rest.IHello;
import org.springframework.stereotype.Component;

@Component
public class HelloController implements IHello {
    @Override
    public String sayHello() {
        return "Hello world!";
    }
}
