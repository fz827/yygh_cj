package com.chenjiang.api;

import com.chenjiang.model.user.User;
import com.chenjiang.result.Result;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "service-user-cj")
@Repository
public interface LoginFeign {
    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result loginUser(@RequestBody User user);
}
