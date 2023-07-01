package com.chenjiang.model.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tab_patient")
public class Patient {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("patientName")
    private String patientName;

    @TableField("age")
    private String age;

    @TableField("sex")
    private String sex;

    @TableField("idCard")
    private String idCard;

    @TableField("patientAddress")
    private String patientAddress;

    @TableField("phoneNumber")
    private String phoneNumber;

//    是否有医保卡
    @TableField("is_insure")
    private String is_insure;

}
