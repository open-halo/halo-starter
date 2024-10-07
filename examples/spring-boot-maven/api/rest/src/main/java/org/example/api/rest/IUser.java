package org.example.api.rest;

import jakarta.websocket.server.PathParam;
import org.example.api.rest.model.User;
import org.example.common.LogicReply;
import org.example.common.PagedReply;
import org.example.common.PagedRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public interface IUser {

    @PostMapping
    LogicReply<Void> create(@RequestBody User user);

    @DeleteMapping("/{userId}")
    LogicReply<Void> delete(@PathVariable("userId") long userId);

    @PutMapping
    LogicReply<Void> update(@RequestBody User user);

    @GetMapping("/{userId}")
    LogicReply<User> select(@PathVariable("userId") long userId);

    @GetMapping
    LogicReply<User> selectOne(@PathParam("email") String email);

    @GetMapping
    LogicReply<PagedReply<User>> search(PagedRequest<String> nameSearch);

}
