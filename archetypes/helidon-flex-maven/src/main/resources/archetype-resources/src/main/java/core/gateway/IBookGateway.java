#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.gateway;

import ${package}.core.model.Book;
import ${package}.core.model.base.ApiResult;

public interface IBookGateway {
    ApiResult<Book> fetch(long bookId);

}
