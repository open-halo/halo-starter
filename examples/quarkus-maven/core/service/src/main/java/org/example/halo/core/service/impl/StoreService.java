package org.example.halo.core.service.impl;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.example.halo.core.gateway.IIdGenerator;
import org.example.halo.core.gateway.IStoreGateway;
import org.example.halo.core.model.Book;
import org.example.halo.core.model.Store;
import org.example.halo.core.model.base.ApiResult;
import org.example.halo.core.model.base.PagedRequest;
import org.example.halo.core.model.base.PagedResult;
import org.example.halo.core.model.dto.StoreProcureRequest;
import org.example.halo.core.service.IStoreService;


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
