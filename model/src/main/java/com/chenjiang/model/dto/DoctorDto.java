package com.chenjiang.model.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 通过疾病信息来查找到相对应的医生
 */
@Data
@ToString
public class DoctorDto {

    private String doctorCode;
    private String doctor;
    private String skills;
    private String location;
}
