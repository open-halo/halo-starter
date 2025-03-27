package org.example.halo.api.adapter.rest;

import jakarta.inject.Named;
import org.example.halo.api.rest.IHelloResource;

@Named
public class HelloResource implements IHelloResource {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
