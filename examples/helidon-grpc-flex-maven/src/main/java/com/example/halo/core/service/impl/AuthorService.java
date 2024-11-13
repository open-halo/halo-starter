package com.example.halo.core.service.impl;

import com.example.halo.core.gateway.IAuthorGateway;
import com.example.halo.core.gateway.IIdGenerator;
import com.example.halo.core.model.Author;
import com.example.halo.core.model.Book;
import com.example.halo.core.model.Store;
import com.example.halo.core.model.base.ApiResult;
import com.example.halo.core.model.base.PagedRequest;
import com.example.halo.core.model.base.PagedResult;
import com.example.halo.core.model.dto.BookPublishRequest;
import com.example.halo.core.service.IAuthorService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;



@Named
@Singleton
public class AuthorService implements IAuthorService {

    @Inject
    IAuthorGateway authorGateway;

    @Inject
    IIdGenerator idGenerator;

    @Override
    public ApiResult<Long> register(Author author) {
        long authorId = idGenerator.nextLongId();
        author.setId(authorId);
        authorGateway.register(author);
        return ApiResult.ofSuccess(authorId);
    }

    @Override
    public ApiResult<Long> publishBook(BookPublishRequest publishRequest) {
        return null;
    }

    @Override
    public PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithAuthorId) {
        return null;
    }

    @Override
    public PagedResult<Store> findAllStores(PagedRequest<Long> requestWithBookId) {
        return null;
    }
}
