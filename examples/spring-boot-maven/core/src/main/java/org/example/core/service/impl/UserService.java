package org.example.core.service.impl;

import org.example.common.LogicReply;
import org.example.common.PagedReply;
import org.example.common.PagedRequest;
import org.example.core.domian.User;
import org.example.core.gateway.repository.IUserRepository;
import org.example.core.service.IUserService;
import jakarta.annotation.Resource;


@Resource
public class UserService implements IUserService {

    private IUserRepository userRepository;

    @Override
    public LogicReply<Void> create() {
        return null;
    }

    @Override
    public LogicReply<Void> delete() {
        return null;
    }

    @Override
    public LogicReply<Void> update() {
        return null;
    }

    @Override
    public LogicReply<User> select() {
        return null;
    }

    @Override
    public LogicReply<User> selectOne() {
        return null;
    }

    @Override
    public LogicReply<PagedReply<User>> searchByName(PagedRequest<String> nameSearch) {
        return null;
    }
}
