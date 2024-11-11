#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.infra.persistent.gateway;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import ${package}.halo.core.gateway.IIdGenerator;
import ${package}.halo.core.gateway.IStoreGateway;
import ${package}.halo.core.model.Book;
import ${package}.halo.core.model.Store;
import ${package}.halo.core.model.base.ApiResult;
import ${package}.halo.core.model.base.PagedRequest;
import ${package}.halo.core.model.base.PagedResult;
import ${package}.halo.core.model.dto.StoreProcureRequest;
import ${package}.halo.infra.persistent.repository.StoreRepository;

@Named
@Singleton
public class StoreGateway implements IStoreGateway {

    @Inject
    StoreRepository storeRepository;

    @Override
    public ApiResult<Void> register(Store store) {
        storeRepository.persist(store);
        return ApiResult.ofSuccess();
    }

    @Override
    public ApiResult<Void> procure(StoreProcureRequest request) {
        return null;
    }

    @Override
    public PagedResult<Book> fetchAllBooks(PagedRequest<Long> storeId) {
        return null;
    }
}
