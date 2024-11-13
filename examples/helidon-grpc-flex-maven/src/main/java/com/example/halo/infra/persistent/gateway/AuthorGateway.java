package com.example.halo.infra.persistent.gateway;

import com.example.halo.core.gateway.IAuthorGateway;
import com.example.halo.core.model.Author;
import com.example.halo.core.model.Book;
import com.example.halo.core.model.Store;
import com.example.halo.core.model.base.ApiResult;
import com.example.halo.core.model.base.PagedRequest;
import com.example.halo.core.model.base.PagedResult;
import com.example.halo.core.model.dto.BookPublishRequest;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class AuthorGateway implements IAuthorGateway {

    @Override
    public ApiResult<Void> register(Author author) {
        return null;
    }

    @Override
    public ApiResult<Void> publishBook(BookPublishRequest publishRequest) {
        return null;
    }

    @Override
    public PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithAuthorId) {
        return null;
    }

    @Override
    public PagedResult<Store> fetchAllStores(PagedRequest<Long> requestWithBookId) {
        return null;
    }
}
