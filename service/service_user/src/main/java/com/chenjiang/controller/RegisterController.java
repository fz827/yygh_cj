package com.chenjiang.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.chenjiang.model.user.User;
import com.chenjiang.result.Result;
import com.chenjiang.service.UserService;
import com.chenjiang.utils.SaltMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    /**
     * 注册功能
     *
     * @return
     */
    @PostMapping("/register")
    public Result Register(@RequestBody User user) {
        user.setPassword(SaltMD5Util.generateSaltPassword(user.getPassword()));
        boolean flag = userService.save(user);
        if (flag) {
            return Result.ok("注册成功");
        }
        return Result.fail("注册失败");
    }
}
