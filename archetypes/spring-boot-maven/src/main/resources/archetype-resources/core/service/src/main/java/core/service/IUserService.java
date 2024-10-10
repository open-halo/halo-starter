#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.service;

import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.base.PagedRequest;
import ${package}.core.model.User;

public interface IUserService {
    ApiResult<Void> create(User user);
    ApiResult<Void> delete(long userId);

    ApiResult<Void> update(User user);

    ApiResult<User> select(long userId);

    ApiResult<User> selectByEmail(String email);

    ApiResult<PagedResult<User>> searchByName(PagedRequest<String> nameSearch);
}
