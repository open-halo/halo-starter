package org.example.core.service.impl;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.example.common.annotations.HaloSentinelResource;
import org.example.core.model.base.ApiResult;
import org.example.core.model.base.PagedResult;
import org.example.core.model.base.PagedRequest;
import org.example.core.model.User;
import org.example.core.gateway.repository.IUserRepository;
import org.example.core.service.IUserService;

@Slf4j
@Named
public class UserService implements IUserService {

    @Inject
    private IUserRepository userRepository;

    @Override
    public ApiResult<Void> create(User user) {
        return userRepository.create(user);
    }

    @Override
    public ApiResult<Void> delete(long userId) {
        return userRepository.delete(userId);
    }

    @Override
    public ApiResult<Void> update(User user) {
        return userRepository.update(user);
    }

    @HaloSentinelResource("query-user-by-id")
    @Override
    public ApiResult<User> select(long userId) {
        log.info("select({})", userId);
        return userRepository.select(userId);
    }

    @Override
    public ApiResult<User> selectByEmail(String email) {
        return userRepository.selectByEmail(email);
    }

    @Override
    public ApiResult<PagedResult<User>> searchByName(PagedRequest<String> nameSearch) {
        return userRepository.searchByName(nameSearch);
    }
}
