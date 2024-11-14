package com.example.halo.core.gateway;


import com.example.halo.core.model.Book;
import com.example.halo.core.model.Store;
import com.example.halo.core.model.base.ApiResult;
import com.example.halo.core.model.base.PagedRequest;
import com.example.halo.core.model.base.PagedResult;
import com.example.halo.core.model.dto.StoreProcureRequest;

public interface IStoreGateway {
    ApiResult<Void> register(Store store);
    ApiResult<Void> procure(StoreProcureRequest request);
    PagedResult<Book> fetchAllBooks(PagedRequest<Long> storeId);
}
