package com.chenjiang.controller;

import com.chenjiang.api.DepartmentFeign;
import com.chenjiang.model.department.Department;
import com.chenjiang.model.dto.DepartmentDto;
import com.chenjiang.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/department")
public class ConDepartmentController {

    @Autowired
    private DepartmentFeign departmentFeign;

    /**
     * 查询所有的科室信息（科室编号 ，科室名，科室所管理的疾病，疾病编号，医生编号）
     *
     * @return
     */
    @GetMapping("/selectDepartmentAll")
    public Result Select(){
        return departmentFeign.Select();
    }


    /**
     * 通过科室名来查询该科室的所属信息
     *
     * @param departmentDto
     * @return
     */
    @PostMapping("/selectDepartmentByName")
    public Result SelectByName(@RequestBody DepartmentDto departmentDto){
     return  departmentFeign.SelectByName(departmentDto);
    }


    /**
     * 添加科室
     * @param department
     * @return
     */
    @PostMapping("/saveDepartment")
    public Result saveDepartment(@RequestBody Department department){
        return departmentFeign.saveDepartment(department);
    }

}
