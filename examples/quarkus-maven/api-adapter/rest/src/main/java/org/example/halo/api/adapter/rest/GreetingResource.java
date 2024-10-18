package org.example.halo.api.adapter.rest;


import jakarta.inject.Named;

@Named
public class GreetingResource implements IGreetingResource {
    @Override
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
