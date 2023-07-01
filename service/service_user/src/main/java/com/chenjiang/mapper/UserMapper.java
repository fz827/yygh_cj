package com.chenjiang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenjiang.model.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
