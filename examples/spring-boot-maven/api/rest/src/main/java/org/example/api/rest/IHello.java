package org.example.api.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public interface IHello {

    @GET
    String sayHello();
}
