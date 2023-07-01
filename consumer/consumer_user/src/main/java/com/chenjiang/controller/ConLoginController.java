package com.chenjiang.controller;

import com.chenjiang.api.LoginFeign;
import com.chenjiang.model.user.User;
import com.chenjiang.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doLogin")
@CrossOrigin
public class ConLoginController {

    @Autowired
    private LoginFeign loginFeign;

    @PostMapping("/login")
    public Result Login(@RequestBody User user){
        return  loginFeign.loginUser(user);
    }
}
