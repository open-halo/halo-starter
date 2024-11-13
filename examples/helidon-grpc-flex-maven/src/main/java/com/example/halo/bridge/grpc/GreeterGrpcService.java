package com.example.halo.bridge.grpc;

import io.grpc.stub.StreamObserver;
import org.example.halo.api.grpc.greet.GreetReply;
import org.example.halo.api.grpc.greet.GreetRequest;
import org.example.halo.api.grpc.greet.GreeterGrpcGrpc;

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
