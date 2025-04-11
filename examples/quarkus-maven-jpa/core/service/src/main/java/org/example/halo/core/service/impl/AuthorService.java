package org.example.halo.core.service.impl;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import org.example.halo.core.gateway.IAuthorGateway;
import org.example.halo.core.gateway.IIdGenerator;
import org.example.halo.core.model.Author;
import org.example.halo.core.model.Book;
import org.example.halo.core.model.Store;
import org.example.halo.core.model.base.ApiResult;
import org.example.halo.core.model.base.PagedRequest;
import org.example.halo.core.model.base.PagedResult;
import org.example.halo.core.model.dto.BookPublishRequest;
import org.example.halo.core.service.IAuthorService;


@Named
@Singleton
public class AuthorService implements IAuthorService {

    @Inject
    IAuthorGateway authorGateway;

    @Inject
    IIdGenerator idGenerator;

    @Override
    @Transactional
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
