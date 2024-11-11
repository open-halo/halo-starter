#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.api.adapter.grpc;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import ${package}.halo.api.grpc.author.*;
import ${package}.halo.core.model.Author;
import ${package}.halo.core.model.base.ApiResult;
import ${package}.halo.core.service.IAuthorService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Slf4j
@GrpcService
public class AuthorGrpcService extends AuthorGrpcGrpc.AuthorGrpcImplBase {

    @Inject
    IAuthorService authorService;

    @Mapper
    interface AuthorGrpcServiceMapper {
        AuthorGrpcServiceMapper INSTANCE = Mappers.getMapper(AuthorGrpcServiceMapper.class);
        Author toEntity(RegisterRequest request);

        default RegisterReply toRegisterReply(ApiResult<Long> reply) {
            return RegisterReply.newBuilder()
                    .setAuthorId(reply.getData())
                    .build();
        }
    }



    @Override
    @Blocking
    public void register(RegisterRequest request, StreamObserver<RegisterReply> responseObserver) {
        log.info("register request: {}", request);
        Author author = AuthorGrpcServiceMapper.INSTANCE.toEntity(request);
        ApiResult<Long> result = authorService.register(author);
        RegisterReply reply = AuthorGrpcServiceMapper.INSTANCE.toRegisterReply(result);
        log.info("register reply: {}", reply);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void publish(PublishRequest request, StreamObserver<PublishReply> responseObserver) {
        super.publish(request, responseObserver);
    }

    @Override
    public void fetchAllBooks(FetchAllBooksRequest request, StreamObserver<FetchAllBooksReply> responseObserver) {
        super.fetchAllBooks(request, responseObserver);
    }

    @Override
    public void fetchAllStores(FetchAllStoresRequest request, StreamObserver<FetchAllStoresReply> responseObserver) {
        super.fetchAllStores(request, responseObserver);
    }
}
