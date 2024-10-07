package org.example.core.gateway.repository;

import org.example.common.LogicReply;
import org.example.common.PagedReply;
import org.example.common.PagedRequest;
import org.example.core.domian.User;


public interface IUserRepository {
    LogicReply<Void> create(User user);

    LogicReply<Void> delete(long userId);

    LogicReply<Void> update(User user);

    LogicReply<User> select(long userId);

    LogicReply<User> selectOne(String email);

    LogicReply<PagedReply<User>> searchByName(PagedRequest<String> searchByNameRequest);

}
