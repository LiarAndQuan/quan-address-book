package online.aquan.controller;


import lombok.RequiredArgsConstructor;
import online.aquan.convention.Result;
import online.aquan.convention.Results;
import online.aquan.dao.entity.UserDO;
import online.aquan.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("user/register")
    public Result<Void> register(@RequestBody UserDO user) {
        userService.register(user);
        return Results.success();
    }

    @PostMapping("user/login")
    public Result<Void> login(@RequestBody UserDO user) {
        userService.login(user);
        return Results.success();
    }

    @PostMapping("user/logout")
    public Result<Void> logout() {
        return Results.success();
    }

    @PostMapping("user/update")
    public Result<Void> update(@RequestBody UserDO user) {
        userService.update(user);
        return Results.success();
    }

    @PostMapping("user/list")
    public Result<List<UserDO>> findAll(UserDO userDO) {
        return Results.success(userService.findAll(userDO));
    }

    @GetMapping("admin/list")
    public Result<List<UserDO>> findAllToPass() {
        return Results.success(userService.findAllToPass());
    }
    
    @PostMapping("admin/pass")
    public Result<Void> pass(@RequestBody List<String> names) {
        userService.pass(names);
        return Results.success();
    }
    
    @PostMapping("admin/delete")
    public Result<Void> delete(@RequestBody List<String> names) {
        userService.delete(names);
        return Results.success();
    }
    
    @PostMapping("admin/ban")
    public Result<Void> ban(@RequestBody List<String> names) {
        userService.ban(names);
        return Results.success();
    }
    
}
