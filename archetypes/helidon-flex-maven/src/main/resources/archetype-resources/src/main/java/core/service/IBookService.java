#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.service;

import ${package}.core.model.Book;
import ${package}.core.model.base.ApiResult;

public interface IBookService {
    ApiResult<Book> fetch(long bookId);
}
