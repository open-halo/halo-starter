#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.api.rest;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public interface IHelloResource {

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    String sayHello(@PathParam("name") String name);

}
