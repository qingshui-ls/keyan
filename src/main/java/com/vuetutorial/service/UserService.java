package com.vuetutorial.service;

import com.vuetutorial.entity.User;
import com.vuetutorial.entity.result.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
public interface UserService extends IService<User> {
    Result<User> login(User user);
}
