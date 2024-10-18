package org.example.halo.api.adapter.rest;

import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.example.halo.api.grpc.Greeter;
import org.example.halo.api.grpc.HelloReply;
import org.example.halo.api.grpc.HelloRequest;

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
