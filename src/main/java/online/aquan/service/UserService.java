package online.aquan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.aquan.convention.Result;
import online.aquan.dao.entity.UserDO;

import java.util.List;

public interface UserService extends IService<UserDO> {
    void register(UserDO user);

    UserDO login(UserDO user);

    void update(UserDO user);

    List<UserDO> findAll(UserDO userDO);

    List<UserDO> findAllToPass();

    void pass(List<String> names);

    void delete(List<String> names);

    void ban(List<String> names);
}
