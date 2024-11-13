#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.service.impl;

import ${package}.core.gateway.IIdGenerator;
import ${package}.core.gateway.IStoreGateway;
import ${package}.core.model.Book;
import ${package}.core.model.Store;
import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedRequest;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.dto.StoreProcureRequest;
import ${package}.core.service.IStoreService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

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
