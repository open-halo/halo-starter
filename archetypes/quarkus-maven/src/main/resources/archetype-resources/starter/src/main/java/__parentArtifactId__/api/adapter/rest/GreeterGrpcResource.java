#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.api.adapter.rest;

import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import ${package}.${parentArtifactId}.api.grpc.Greeter;
import ${package}.${parentArtifactId}.api.grpc.HelloReply;
import ${package}.${parentArtifactId}.api.grpc.HelloRequest;

@Path("/hi")
public class GreeterGrpcResource {
    @GrpcClient("hello")
    Greeter greeterService;

    @GET
    @Path("/{name}")
    public Uni<String> sayHello(@PathParam("name") String name) {
        return greeterService.sayHello(HelloRequest.newBuilder().setName(name).build())
                .onItem().transform(HelloReply::getMessage);
    }
}
