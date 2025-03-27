package org.example.halo.api.adapter.grpc.base;

import io.grpc.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalGrpcInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        try {
            log.info("GlobalGrpcInterceptor called");
            Context ctx = Context.current();
            return Contexts.interceptCall(ctx, serverCall, metadata, serverCallHandler);
        } catch (Exception e) {
            log.error("grpc error: {}", e.getMessage());
            Status status = Status.UNAUTHENTICATED.withDescription(e.getMessage());
            serverCall.close(status, new Metadata());
            return new ServerCall.Listener<>() {};
        }
    }
}
