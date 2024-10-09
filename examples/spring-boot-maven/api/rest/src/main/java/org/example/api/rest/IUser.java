package org.example.api.rest;

import jakarta.websocket.server.PathParam;
import org.example.core.model.User;
import org.example.common.ApiResult;
import org.example.common.PagedResult;
import org.example.common.PagedRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public interface IUser {

    @PostMapping
    ApiResult<Void> create(@RequestBody User user);

    @DeleteMapping("/{userId}")
    ApiResult<Void> delete(@PathVariable("userId") long userId);

    @PutMapping
    ApiResult<Void> update(@RequestBody User user);

    @GetMapping("/{userId}")
    ApiResult<User> select(@PathVariable("userId") long userId);

    @GetMapping
    ApiResult<User> selectByEmail(@PathParam("email") String email);

    @GetMapping
    ApiResult<PagedResult<User>> search(PagedRequest<String> nameSearch);

}
