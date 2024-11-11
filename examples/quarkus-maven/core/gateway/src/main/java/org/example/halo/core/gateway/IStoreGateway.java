package org.example.halo.core.gateway;

import org.example.halo.core.model.Book;
import org.example.halo.core.model.Store;
import org.example.halo.core.model.base.ApiResult;
import org.example.halo.core.model.base.PagedRequest;
import org.example.halo.core.model.base.PagedResult;
import org.example.halo.core.model.dto.StoreProcureRequest;

public interface IStoreGateway {
    ApiResult<Void> register(Store store);
    ApiResult<Void> procure(StoreProcureRequest request);
    PagedResult<Book> fetchAllBooks(PagedRequest<Long> storeId);
}
