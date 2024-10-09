package org.example.core.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.ApiResult;
import org.example.common.PagedResult;
import org.example.common.PagedRequest;
import org.example.core.model.User;
import org.example.core.gateway.repository.IUserRepository;
import org.example.core.service.IUserService;



@Slf4j
@AllArgsConstructor
public class UserService implements IUserService {

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
