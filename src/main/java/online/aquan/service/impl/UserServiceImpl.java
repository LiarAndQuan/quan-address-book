package online.aquan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.xdevapi.Client;
import lombok.RequiredArgsConstructor;
import online.aquan.convention.Result;
import online.aquan.convention.Results;
import online.aquan.convention.exception.ClientException;
import online.aquan.dao.entity.UserDO;
import online.aquan.dao.mapper.UserMapper;
import online.aquan.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final UserMapper userMapper;

    @Override
    public void register(UserDO user) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getName, user.getName());
        UserDO userDO = userMapper.selectOne(wrapper);
        if (userDO != null) {
            throw new ClientException("用户名已存在");
        }
        userMapper.insert(user);
    }

    @Override
    public void login(UserDO user) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getName, user.getName())
                .eq(UserDO::getPassword, user.getPassword());
        UserDO userDO = userMapper.selectOne(wrapper);
        if (userDO == null) {
            throw new ClientException("用户名不存在或者密码错误");
        } else if (userDO.getApprovalStatus() == 0) {
            throw new ClientException("账号未审核通过,请联系管理员认证");
        }
        userDO.setLastLogin(new Date());
        userDO.setLoginTimes(userDO.getLoginTimes() + 1);
        userMapper.insert(userDO);
    }

    @Override
    public void update(UserDO user) {
        userMapper.updateById(user);
    }

    @Override
    public List<UserDO> findAll(UserDO userDO) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getPid, userDO.getPid())
                .eq(UserDO::getClassName, userDO.getClassName())
                .eq(UserDO::getApprovalStatus, 1);
        return userMapper.selectList(wrapper);
    }

    @Override
    public List<UserDO> findAllToPass() {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getApprovalStatus, 0);
        return userMapper.selectList(wrapper);
    }

    @Override
    public void pass(List<String> names) {
        LambdaUpdateWrapper<UserDO> wrapper = Wrappers.lambdaUpdate(UserDO.class)
                .set(UserDO::getApprovalStatus, 1)
                .in(UserDO::getName, names);
        update(wrapper);
    }

    @Override
    public void delete(List<String> names) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getApprovalStatus,0)
                .in(UserDO::getName, names);
        remove(wrapper);
    }

    @Override
    public void ban(List<String> names) {
        LambdaUpdateWrapper<UserDO> wrapper = Wrappers.lambdaUpdate(UserDO.class)
                .set(UserDO::getApprovalStatus,0)
                .eq(UserDO::getApprovalStatus,1)
                .in(UserDO::getName, names);
        update(wrapper);
    }
}
