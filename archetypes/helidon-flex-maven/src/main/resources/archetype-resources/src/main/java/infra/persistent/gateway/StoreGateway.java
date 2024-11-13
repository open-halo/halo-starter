#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.gateway;

import ${package}.core.gateway.IStoreGateway;
import ${package}.core.model.Book;
import ${package}.core.model.Store;
import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedRequest;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.dto.StoreProcureRequest;
import jakarta.inject.Singleton;

@Singleton
public class StoreGateway implements IStoreGateway {
    @Override
    public ApiResult<Void> register(Store store) {
        return null;
    }

    @Override
    public ApiResult<Void> procure(StoreProcureRequest request) {
        return null;
    }

    @Override
    public PagedResult<Book> fetchAllBooks(PagedRequest<Long> storeId) {
        return null;
    }
}
