#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.service.impl;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import ${package}.halo.core.gateway.IAuthorGateway;
import ${package}.halo.core.gateway.IIdGenerator;
import ${package}.halo.core.model.Author;
import ${package}.halo.core.model.Book;
import ${package}.halo.core.model.Store;
import ${package}.halo.core.model.base.ApiResult;
import ${package}.halo.core.model.base.PagedRequest;
import ${package}.halo.core.model.base.PagedResult;
import ${package}.halo.core.model.dto.BookPublishRequest;
import ${package}.halo.core.service.IAuthorService;


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
