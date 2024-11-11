#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.api.adapter.grpc;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import ${package}.halo.api.grpc.greet.GreetReply;
import ${package}.halo.api.grpc.greet.GreetRequest;
import ${package}.halo.api.grpc.greet.GreeterGrpc;


@GrpcService
public class GreeterGrpcService implements GreeterGrpc {

    @Override
    public Uni<GreetReply> sayHello(GreetRequest request) {
        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> GreetReply.newBuilder().setMessage(msg).build());
    }
}
