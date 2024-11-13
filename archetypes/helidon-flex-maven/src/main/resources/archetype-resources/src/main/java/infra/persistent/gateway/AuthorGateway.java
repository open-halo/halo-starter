#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.gateway;

import ${package}.core.gateway.IAuthorGateway;
import ${package}.core.model.Author;
import ${package}.core.model.Book;
import ${package}.core.model.Store;
import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedRequest;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.dto.BookPublishRequest;
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
