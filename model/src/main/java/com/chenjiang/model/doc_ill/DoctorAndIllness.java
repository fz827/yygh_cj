package com.chenjiang.model.doc_ill;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 结合病情和医生的多对多
 */
@Data
@TableName("tab_middle")
public class DoctorAndIllness {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("doctorCode")
    private String doctorCode;
    @TableField("illnessCode")
    private String illnessCode;

}
