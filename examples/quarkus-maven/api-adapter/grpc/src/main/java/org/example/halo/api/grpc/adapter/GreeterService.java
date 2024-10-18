package org.example.halo.api.grpc.adapter;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import org.example.halo.api.grpc.Greeter;
import org.example.halo.api.grpc.HelloReply;
import org.example.halo.api.grpc.HelloRequest;

@GrpcService
public class GreeterService implements Greeter {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item(() ->
                HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
    }
}
