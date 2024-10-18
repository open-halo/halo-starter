package org.example.halo.api.adapter.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public interface IGreetingResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello();
}



