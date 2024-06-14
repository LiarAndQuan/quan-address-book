package online.aquan.controller;


import lombok.RequiredArgsConstructor;
import online.aquan.convention.Result;
import online.aquan.convention.Results;
import online.aquan.dao.entity.ProfessionDO;
import online.aquan.dao.entity.UserDO;
import online.aquan.service.ProfessionService;
import online.aquan.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final ProfessionService professionService;

    @PostMapping("user/register")
    public Result<Void> register(@RequestBody UserDO user) {
        userService.register(user);
        return Results.success();
    }

    @PostMapping("user/login")
    public Result<UserDO> login(@RequestBody UserDO user) {
        return Results.success(userService.login(user));
    }

    @GetMapping("user")
    public Result<UserDO> getUserById(@RequestParam long id) {
        return Results.success(userService.getUserById(id));
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
    public Result<List<UserDO>> findAll(@RequestBody UserDO userDO) {
        return Results.success(userService.findAll(userDO));
    }

    @GetMapping("admin/findAllPassed")
    public Result<List<UserDO>> findAllPassed() {
        return Results.success(userService.findAllPassed());
    }

    @GetMapping("admin/list")
    public Result<List<UserDO>> findAllToPass() {
        return Results.success(userService.findAllToPass());
    }

    @PostMapping("admin/pass")
    public Result<Void> pass(@RequestParam List<String> usernames) {
        userService.pass(usernames);
        return Results.success();
    }

    @PostMapping("admin/delete")
    public Result<Void> delete(@RequestParam List<String> usernames) {
        userService.delete(usernames);
        return Results.success();
    }

    @PostMapping("admin/ban")
    public Result<Void> ban(@RequestParam List<String> usernames) {
        userService.ban(usernames);
        return Results.success();
    }

    @PostMapping("admin/addProfession")
    public Result<Void> saveProfession(@RequestParam String profession) {
        professionService.save(profession);
        return Results.success();
    }

    @PostMapping("admin/deleteProfession")
    public Result<Void> deleteProfession(@RequestParam List<String> pids) {
        professionService.delete(pids);
        return Results.success();
    }

    @GetMapping("user/getAllProfession")
    public Result<List<ProfessionDO>> getAllProfession() {
        return Results.success(professionService.getAll());
    }

}
