package com.chenjiang.controller;

import com.chenjiang.api.RegisterFeign;
import com.chenjiang.model.user.User;
import com.chenjiang.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doRegister")
@CrossOrigin
public class ConRegisterController {

    @Autowired
    private RegisterFeign registerFeign;


    @PostMapping("/register")
    public Result Register(@RequestBody User user){
       return registerFeign.Register(user);
    }
}
