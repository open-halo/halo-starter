#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public interface IHello {

    @GET
    String sayHello();
}
