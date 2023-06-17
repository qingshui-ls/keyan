package com.vuetutorial.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vuetutorial.entity.Token;
import com.vuetutorial.entity.User;
import com.vuetutorial.entity.result.Result;
import com.vuetutorial.mapper.UserMapper;
import com.vuetutorial.utils.JwtUtils;
import com.vuetutorial.utils.PasswordEncoder;
import com.vuetutorial.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vuetutorial.entity.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Result<User> login(User user) {

        System.out.println(user);

        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || password == null) {
            return new Result<User>(ResultEnum.PARAMETER_ILLEGAL, null);
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("account", username).eq("password", PasswordEncoder.encodePassword(password))
                .last("limit 1");


        User selectedUser = null;
        try {
            selectedUser = userMapper.selectOne(wrapper);
            selectedUser.setPassword("");
        } catch (Exception e) {
            return new Result<User>(ResultEnum.PASSWORD_ERROR, null);
        }
        Token token = JwtUtils.createJwt(user, 1000);
        selectedUser.setToken(token);
        return new Result<User>(ResultEnum.SUCCESS, selectedUser);
    }
}
