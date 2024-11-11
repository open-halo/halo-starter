#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.service;

import ${package}.halo.core.model.Book;
import ${package}.halo.core.model.Store;
import ${package}.halo.core.model.base.ApiResult;
import ${package}.halo.core.model.base.PagedRequest;
import ${package}.halo.core.model.base.PagedResult;
import ${package}.halo.core.model.dto.StoreProcureRequest;

public interface IStoreService {

    ApiResult<Void> register(Store store);
    ApiResult<Void> procure(StoreProcureRequest request);

    PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithStoreId);
}
