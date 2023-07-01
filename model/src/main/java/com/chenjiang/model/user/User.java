package com.chenjiang.model.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tab_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("account")
    private String account;

    @TableField("password")
    private String password;

    @TableField("phoneNumber")
    private String phoneNumber;

    @TableField("idCard")
    private String idCard;



}
