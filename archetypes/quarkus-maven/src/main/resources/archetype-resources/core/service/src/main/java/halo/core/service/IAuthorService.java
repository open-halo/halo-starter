#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.service;

import jakarta.transaction.Transactional;
import ${package}.halo.core.model.Author;
import ${package}.halo.core.model.Book;
import ${package}.halo.core.model.Store;
import ${package}.halo.core.model.base.ApiResult;
import ${package}.halo.core.model.base.PagedRequest;
import ${package}.halo.core.model.base.PagedResult;
import ${package}.halo.core.model.dto.BookPublishRequest;

public interface IAuthorService {

    ApiResult<Long> register(Author author);
    ApiResult<Long> publishBook(BookPublishRequest publishRequest);
    PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithAuthorId);

    PagedResult<Store> findAllStores(PagedRequest<Long> requestWithBookId);
}
