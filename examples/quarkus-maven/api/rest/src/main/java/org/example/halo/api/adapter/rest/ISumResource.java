package org.example.halo.api.adapter.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/sum")
public interface ISumResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    int sum(@QueryParam("el")String elements);
}
