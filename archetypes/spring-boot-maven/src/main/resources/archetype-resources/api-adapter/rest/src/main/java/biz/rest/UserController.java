#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.biz.rest;

import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ${package}.api.rest.IUser;
import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.base.PagedRequest;
import ${package}.core.model.User;
import ${package}.core.service.IUserService;

@Slf4j
@Named
@AllArgsConstructor
public class UserController implements IUser {

    private IUserService userService;

    @Override
    public ApiResult<Void> create(User user) {
        return userService.create(user);
    }

    @Override
    public ApiResult<Void> delete(long userId) {
        return userService.delete(userId);
    }

    @Override
    public ApiResult<Void> update(User user) {
        return userService.update(user);
    }

    @Override
    public ApiResult<User> select(long userId) {
        log.info("select({})", userId);
        return userService.select(userId);
    }

    @Override
    public ApiResult<User> selectByEmail(String email) {
        return userService.selectByEmail(email);
    }

    @Override
    public ApiResult<PagedResult<User>> search(PagedRequest<String> nameSearch) {
        return userService.searchByName(nameSearch);
    }
}
