package org.example.core.service;

import org.example.core.model.base.ApiResult;
import org.example.core.model.base.PagedResult;
import org.example.core.model.base.PagedRequest;
import org.example.core.model.User;

public interface IUserService {
    ApiResult<Void> create(User user);

    ApiResult<Void> delete(long userId);

    ApiResult<Void> update(User user);

    ApiResult<User> select(long userId);

    ApiResult<User> selectByEmail(String email);

    ApiResult<PagedResult<User>> searchByName(PagedRequest<String> nameSearch);
}
