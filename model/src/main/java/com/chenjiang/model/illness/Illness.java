package com.chenjiang.model.illness;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tab_illness")
public class Illness {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("illnessCode")
    private String illnessCode;

    @TableField("illness")
    private String illness;


}
