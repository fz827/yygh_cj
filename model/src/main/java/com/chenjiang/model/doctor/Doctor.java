package com.chenjiang.model.doctor;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tab_doctor")
public class Doctor {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("doctorCode")
    private String doctorCode;

    @TableField("doctor")
    private String doctor;

    @TableField("skills")
    private String skills;


    @TableField("location")
    private String location;


    @TableField("departmentCode")
    private String departmentCode;


}
