package org.example.biz.rest;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.api.rest.IUser;
import org.example.common.ApiResult;
import org.example.common.PagedResult;
import org.example.common.PagedRequest;
import org.example.core.model.User;
import org.example.core.service.IUserService;


import org.springframework.stereotype.Component;

@Slf4j
@Component
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
