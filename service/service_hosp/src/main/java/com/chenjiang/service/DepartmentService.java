package com.chenjiang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenjiang.model.department.Department;
import com.chenjiang.model.dto.DepartmentDto;

import java.util.List;


public interface DepartmentService extends IService<Department> {
    /**
     * 查询所有的科室以及医生信息
     * @return
     */
     List<DepartmentDto> DepartmentSelectAll();

    /**
     * 通过科室名查找对应医生
     * @param selectDepartmentNameByName
     * @return
     */
    List<DepartmentDto> DepartmentSelectByName(String selectDepartmentNameByName);



    IPage<DepartmentDto> getDepartmentInfoList(int pageNo, int pageSize);
















    }

