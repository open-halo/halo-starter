package org.example.biz.rest;

import org.example.api.rest.IHello;
import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements IHello {
    @Override
    public String sayHello() {
        return "Hello world!";
    }
}
