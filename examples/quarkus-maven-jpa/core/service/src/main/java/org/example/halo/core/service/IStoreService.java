package org.example.halo.core.service;

import org.example.halo.core.model.Book;
import org.example.halo.core.model.Store;
import org.example.halo.core.model.base.ApiResult;
import org.example.halo.core.model.base.PagedRequest;
import org.example.halo.core.model.base.PagedResult;
import org.example.halo.core.model.dto.StoreProcureRequest;

public interface IStoreService {

    ApiResult<Void> register(Store store);
    ApiResult<Void> procure(StoreProcureRequest request);

    PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithStoreId);
}
