package com.chenjiang.api;

import com.chenjiang.model.department.Department;
import com.chenjiang.model.dto.DepartmentDto;
import com.chenjiang.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "service-hospital-cj")
@Repository
public interface DepartmentFeign {

    /**
     * 查询所有的科室信息（科室编号 ，科室名，科室所管理的疾病，疾病编号，医生编号）
     *
     * @return
     */
    @GetMapping("/selectDepartmentAll")
    public Result Select();

    /**
     * 通过科室名来查询该科室的所属信息
     *
     * @param departmentDto
     * @return
     */
    @PostMapping("/selectDepartmentByName")
    public Result SelectByName(@RequestBody DepartmentDto departmentDto);


    /**
     * 添加科室
     * @param department
     * @return
     */
    @PostMapping("/saveDepartment")
    public Result saveDepartment(@RequestBody Department department);

}
