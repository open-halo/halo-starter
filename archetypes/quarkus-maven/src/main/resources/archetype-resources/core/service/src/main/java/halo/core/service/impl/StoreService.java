#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.service.impl;

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
import ${package}.halo.core.service.IStoreService;


@Named
@Singleton
public class StoreService implements IStoreService {

    @Inject
    IStoreGateway storeGateway;

    @Inject
    IIdGenerator idGenerator;

    @Override
    public ApiResult<Void> register(Store store) {
        store.setId(idGenerator.nextLongId());
        return storeGateway.register(store);
    }

    @Override
    public ApiResult<Void> procure(StoreProcureRequest request) {
        return storeGateway.procure(request);
    }

    @Override
    public PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithStoreId) {
        return null;
    }
}
