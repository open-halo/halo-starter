package org.example.halo.api.adapter.grpc;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import org.example.halo.api.grpc.greet.GreetReply;
import org.example.halo.api.grpc.greet.GreetRequest;
import org.example.halo.api.grpc.greet.GreeterGrpc;


@GrpcService
public class GreeterGrpcService implements GreeterGrpc {

    @Override
    public Uni<GreetReply> sayHello(GreetRequest request) {
        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> GreetReply.newBuilder().setMessage(msg).build());
    }
}
