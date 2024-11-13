#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.bridge.grpc;

import io.grpc.stub.StreamObserver;
import org.example.${artifactId}.api.grpc.greet.GreetReply;
import org.example.${artifactId}.api.grpc.greet.GreetRequest;
import org.example.${artifactId}.api.grpc.greet.GreeterGrpcGrpc;

import java.text.MessageFormat;

public class GreeterGrpcService extends GreeterGrpcGrpc.GreeterGrpcImplBase {
    @Override
    public void sayHello(GreetRequest request, StreamObserver<GreetReply> responseObserver) {
        String name = request.getName();
        GreetReply reply = GreetReply.newBuilder().setMessage(MessageFormat.format("hello {0}!", name)).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
