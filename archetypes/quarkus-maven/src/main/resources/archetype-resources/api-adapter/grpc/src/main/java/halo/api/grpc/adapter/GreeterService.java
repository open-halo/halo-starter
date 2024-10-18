#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.api.grpc.adapter;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import ${package}.halo.api.grpc.Greeter;
import ${package}.halo.api.grpc.HelloReply;
import ${package}.halo.api.grpc.HelloRequest;

@GrpcService
public class GreeterService implements Greeter {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item(() ->
                HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
    }
}
