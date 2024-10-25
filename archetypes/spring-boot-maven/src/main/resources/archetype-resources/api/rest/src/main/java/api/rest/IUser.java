#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ${package}.core.model.User;
import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.base.PagedRequest;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public interface IUser {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    ApiResult<Void> create(User user);

    @Path("/{userId}")
    ApiResult<Void> delete(@PathParam("userId") long userId);

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    ApiResult<Void> update(User user);

    @Path("/{userId}")
    @GET
    ApiResult<User> select(@PathParam("userId") long userId);

    @GET
    ApiResult<User> selectByEmail(@QueryParam("email") String email);

    @Path("/search")
    @GET
    ApiResult<PagedResult<User>> search(PagedRequest<String> nameSearch);

}
