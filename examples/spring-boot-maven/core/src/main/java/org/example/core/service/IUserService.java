package org.example.core.service;

import org.example.common.LogicReply;
import org.example.common.PagedReply;
import org.example.common.PagedRequest;
import org.example.core.domian.User;

public interface IUserService {
    LogicReply<Void> create();
    LogicReply<Void> delete();

    LogicReply<Void> update();

    LogicReply<User> select();

    LogicReply<User> selectOne();

    LogicReply<PagedReply<User>> searchByName(PagedRequest<String> nameSearch);
}
