package com.example.halo.core.service.impl;

import com.example.halo.core.gateway.IIdGenerator;
import com.example.halo.core.gateway.IStoreGateway;
import com.example.halo.core.model.Book;
import com.example.halo.core.model.Store;
import com.example.halo.core.model.base.ApiResult;
import com.example.halo.core.model.base.PagedRequest;
import com.example.halo.core.model.base.PagedResult;
import com.example.halo.core.model.dto.StoreProcureRequest;
import com.example.halo.core.service.IStoreService;
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
