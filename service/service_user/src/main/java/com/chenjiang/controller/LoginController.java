package com.chenjiang.controller;

import com.chenjiang.model.user.User;
import com.chenjiang.result.Result;
import com.chenjiang.service.UserService;
import com.chenjiang.utils.JwtUtils;
import com.chenjiang.utils.SaltMD5Util;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 登录功能
     * @param user
     * @return
     */

    @PostMapping  ("/login")
    public Result<String> loginUser(@RequestBody User user) {

        long expirationTimeMillis = 30 * 60 * 1000; // 设置过期时间为30分钟

        // 账号
        String account = user.getAccount();
        // 密码
        String password = user.getPassword();
        // 如果账号或者密码为空,返回错误信息
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return Result.fail("账号和密码都不能为空！");
        }
        // 根据账号和密码查询对应的用户信息
        User loginUser = userService.isUserExists(account);

        if (!StringUtils.isEmpty(loginUser)){
            // 获取该用户在数据库里面的加密过的密码
            String saltPassword = loginUser.getPassword();
            // 输入的密码和加密后的密码进行比较
            boolean passwordFlag = SaltMD5Util.verifySaltPassword(password, saltPassword);
            // 如果根据账号查询和校验加密密码失败,则返回错误信息
            if (StringUtils.isEmpty(loginUser) || !passwordFlag) {
                return Result.fail("登录失败,账号或者密码错误！");
            }
            //登录成功生成token
            Date date=new Date();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
            String dateStr=format.format(date);

            Map<String, Object> payload = new HashMap<>();
            payload.put("account", account);
            payload.put("password", password);
            payload.put("time",dateStr);
            // 生成JWT令牌
            String token = JwtUtils.generateToken(payload, expirationTimeMillis);
            System.out.println("JWT Token: " + token);


            stringRedisTemplate.opsForValue().set(token,user.toString(),30, TimeUnit.MINUTES);
            Boolean aBoolean = stringRedisTemplate.hasKey(token);
            System.out.println(aBoolean);
            String s = stringRedisTemplate.opsForValue().get(token);
            System.out.println("logintoken"+s);


            return Result.ok("登录成功"+loginUser+"token"+token);
        }

        return Result.fail("登录失败,账号或者密码错误！");
    }
}
