package com.chenjiang.controller;

import com.chenjiang.model.department.Department;
import com.chenjiang.model.dto.DepartmentDto;
import com.chenjiang.result.Result;
import com.chenjiang.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.chenjiang.model.constants.Constants.MESSAGE_FAILURE;
import static com.chenjiang.model.constants.Constants.MESSAGE_SUCCESS;


@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询所有的科室信息（科室编号 ，科室名，科室所管理的疾病，疾病编号，医生编号）
     *
     * @return
     */
    @GetMapping("/selectDepartmentAll")
    public Result Select() {
        return Result.ok(departmentService.DepartmentSelectAll());
    }

    /**
     * 通过科室名来查询该科室的所属信息
     *
     * @param departmentDto
     * @return
     */
    @PostMapping("/selectDepartmentByName")
    public Result SelectByName(@RequestBody DepartmentDto departmentDto) {
        return Result.ok(departmentService.DepartmentSelectByName(departmentDto.getDepartment()));
    }


    /**
     * 修改科室
     *
     * @param
     * @return
     */
    @PostMapping("updateDepartment")
    public Result updateDepartment(@RequestBody Department department) {
        Boolean flag = departmentService.updateById(department);
        if (flag){
            return Result.ok(MESSAGE_SUCCESS);
        }
        return Result.fail(MESSAGE_FAILURE);
    }

    /**
     * 删除科室
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteDepartment/{id}")
    public Result deleteDepartment(@PathVariable Integer id) {
        Boolean flag = departmentService.removeById(id);
        if (flag){
            return Result.ok(MESSAGE_SUCCESS);
        }
        return Result.fail(MESSAGE_FAILURE);
    }

    /**
     * 添加科室
     * @param department
     * @return
     */
    @PostMapping("/saveDepartment")
    public Result saveDepartment(@RequestBody Department department){
        boolean flag = departmentService.save(department);
        if (flag){
            return Result.ok(MESSAGE_SUCCESS);
        }
        return Result.fail(MESSAGE_FAILURE);
    }

    /**
     * 订单分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/getOrderInfoList/{pageNo}/{pageSize}")
    public Result getOrderInfoList(@PathVariable int pageNo ,@PathVariable int pageSize){
        return Result.ok(departmentService.getDepartmentInfoList(pageNo, pageSize));
    }
    }






