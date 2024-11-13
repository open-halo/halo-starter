#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.service.impl;

import ${package}.core.gateway.IBookGateway;
import ${package}.core.model.Book;
import ${package}.core.model.base.ApiResult;
import ${package}.core.service.IBookService;
import ${package}.infra.persistent.gateway.BookGateway;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class BookService implements IBookService {

    private IBookGateway bookGateway;

    @Inject
    public BookService(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public ApiResult<Book> fetch(long bookId) {
        return bookGateway.fetch(bookId);
    }
}
