package com.chenjiang.model.dto;

import com.chenjiang.model.illness.Illness;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 通过科室来找到相对应的主治医师
 */
@Data
@ToString
public class DepartmentDto {

//    private Integer id;
//    private String departmentCode;
    private String department;

    //illness关联表中的字段
    private String doctorCode;
    private String doctor;
    private String skills;
    private String location;



//    //疾病列表 用于接下来的一对多映射查询
//    private List<Illness> illnessList;
//
//    // 用于接下来的一对一映射查询
//    private Illness illnesses;
}
