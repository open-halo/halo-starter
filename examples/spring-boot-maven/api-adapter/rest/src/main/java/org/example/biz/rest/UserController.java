package org.example.biz.rest;


import lombok.AllArgsConstructor;
import org.example.api.rest.IUser;
import org.example.common.LogicReply;
import org.example.common.PagedReply;
import org.example.common.PagedRequest;
import org.example.core.service.IUserService;
import org.example.api.rest.model.User;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserController implements IUser {

    private IUserService userService;

    @Override
    public LogicReply<Void> create(User user) {

        return null;
    }

    @Override
    public LogicReply<Void> delete(long userId) {
        return null;
    }

    @Override
    public LogicReply<Void> update(User user) {
        return null;
    }

    @Override
    public LogicReply<User> select(long userId) {
        return null;
    }

    @Override
    public LogicReply<User> selectOne(String email) {
        return null;
    }

    @Override
    public LogicReply<PagedReply<User>> search(PagedRequest<String> nameSearch) {
        return null;
    }
}
