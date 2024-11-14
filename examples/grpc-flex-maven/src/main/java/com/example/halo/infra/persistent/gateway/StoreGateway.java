package com.example.halo.infra.persistent.gateway;

import com.example.halo.core.gateway.IStoreGateway;
import com.example.halo.core.model.Book;
import com.example.halo.core.model.Store;
import com.example.halo.core.model.base.ApiResult;
import com.example.halo.core.model.base.PagedRequest;
import com.example.halo.core.model.base.PagedResult;
import com.example.halo.core.model.dto.StoreProcureRequest;
import jakarta.inject.Singleton;

@Singleton
public class StoreGateway implements IStoreGateway {
    @Override
    public ApiResult<Void> register(Store store) {
        return null;
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
