package com.chenjiang.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenjiang.model.user.User;

public interface UserService extends IService<User> {
   User isUserExists(String account);
}
