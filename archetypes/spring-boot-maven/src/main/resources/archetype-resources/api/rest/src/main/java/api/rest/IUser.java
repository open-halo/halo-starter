#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.rest;

import jakarta.validation.Valid;

import ${package}.core.model.User;
import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.base.PagedRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public interface IUser {

    @PostMapping
    ApiResult<Void> create(@Valid User user);

    @DeleteMapping("/{userId}")
    ApiResult<Void> delete(@PathVariable("userId") long userId);

    @PatchMapping
    ApiResult<Void> update(User user);

    @GetMapping("/{userId}")
    ApiResult<User> select(@PathVariable("userId") long userId);

    @GetMapping
    ApiResult<User> selectByEmail(@RequestParam("email") String email);

    @GetMapping("/index")
    ApiResult<PagedResult<User>> search(PagedRequest<String> nameSearch);

}
