package org.example.halo.infra.persistent.gateway;

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
import org.example.halo.infra.persistent.mapper.StoreMapper;
import org.example.halo.infra.persistent.repository.StoreRepository;

@Named
@Singleton
public class StoreGateway implements IStoreGateway {

    @Inject
    StoreRepository storeRepository;

    @Inject
    StoreMapper storeMapper;

    @Override
    public ApiResult<Void> register(Store store) {
        storeMapper.insert(store);
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
