package com.chenjiang.api;
import com.chenjiang.model.user.User;
import com.chenjiang.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-user-cj")
@Repository
public interface RegisterFeign {
    @PostMapping("/register")
    public Result Register(@RequestBody User user);
}
