#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.service;

import ${package}.core.model.Author;
import ${package}.core.model.Book;
import ${package}.core.model.Store;
import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedRequest;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.dto.BookPublishRequest;


public interface IAuthorService {

    ApiResult<Long> register(Author author);
    ApiResult<Long> publishBook(BookPublishRequest publishRequest);
    PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithAuthorId);

    PagedResult<Store> findAllStores(PagedRequest<Long> requestWithBookId);
}
