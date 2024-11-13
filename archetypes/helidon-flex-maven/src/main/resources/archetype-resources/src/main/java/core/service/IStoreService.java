#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.service;


import ${package}.core.model.Book;
import ${package}.core.model.Store;
import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedRequest;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.dto.StoreProcureRequest;

public interface IStoreService {

    ApiResult<Void> register(Store store);
    ApiResult<Void> procure(StoreProcureRequest request);

    PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithStoreId);
}
