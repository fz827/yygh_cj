package com.chenjiang.model.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tab_orderinfo")
public class OrderInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("orderNumber")
    private String orderNumber;

    @TableField("idCard")
    private String idCard;

    @TableField("doctorCode")
    private String doctorCode;


    @TableField("symptom")
    private String symptom;

    @TableField("receiveDate")
    private String receiveDate;

}
