package com.chenjiang.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderInfoDto {
    //订单编号
    private String orderNumber;
    private String symptom;

    //病人信息
    private String patientName;
    private String age;
    private String sex;
    private String idCard;
    private String patientAddress;
    private String phoneNumber;
    private String is_insure;

    //医生信息
    private String doctorCode;
    private String doctor;
    private String location;
    private String skills;
}
