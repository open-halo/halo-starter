#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.service.impl;

import ${package}.core.gateway.IAuthorGateway;
import ${package}.core.gateway.IIdGenerator;
import ${package}.core.model.Author;
import ${package}.core.model.Book;
import ${package}.core.model.Store;
import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedRequest;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.dto.BookPublishRequest;
import ${package}.core.service.IAuthorService;
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
