package com.chenjiang.model.department;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 科室的信息类
 */
@Data
@TableName("tab_department")
public class Department {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("departmentCode")
    private String departmentCode;

    @TableField("department")
    private String department;

}
