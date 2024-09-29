package org.example.core.gateway.repository;

import org.example.common.LogicReply;
import org.example.core.domian.User;

import java.util.List;

public interface IUserRepository {
    LogicReply<Void> save(User user);
    LogicReply<List<User>> findAllUsers();
}
