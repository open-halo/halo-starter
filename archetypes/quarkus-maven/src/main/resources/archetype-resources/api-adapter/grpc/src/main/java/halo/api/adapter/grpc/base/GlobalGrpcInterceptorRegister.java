#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.api.adapter.grpc.base;


import io.quarkus.grpc.GlobalInterceptor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;


@ApplicationScoped
public class GlobalGrpcInterceptorRegister {

    @GlobalInterceptor
    @Singleton
    public GlobalGrpcInterceptor produceGlobalGrpcInterceptor() {
        return new GlobalGrpcInterceptor();
    }
}
