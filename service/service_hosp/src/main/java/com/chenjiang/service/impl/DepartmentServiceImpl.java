package com.chenjiang.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenjiang.mapper.DepartmentMapper;
import com.chenjiang.model.department.Department;
import com.chenjiang.model.doctor.Doctor;
import com.chenjiang.model.dto.DepartmentDto;
import com.chenjiang.service.DepartmentService;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>implements DepartmentService {
@Autowired
private DepartmentMapper departmentMapper;

    /**
     * 展示科室全部信息
     * @return
     */
    @Override
    public List<DepartmentDto> DepartmentSelectAll() {
        MPJLambdaWrapper<Department> wrapper = new MPJLambdaWrapper<Department>()
                .selectAll(Department.class)//查询user表全部字段
                .select(Doctor::getDoctorCode,Doctor::getDoctor,Doctor::getSkills,Doctor::getLocation)
                .leftJoin(Doctor.class, Doctor::getDepartmentCode,Department::getDepartmentCode);
        List<DepartmentDto> userList = departmentMapper.selectJoinList(DepartmentDto.class, wrapper);
//        userList.forEach(System.out::println);
        return userList;
    }

    /**
     * 通过科室名来查询到所管属的各种疾病
     * @return
     */
    @Override
    public List<DepartmentDto> DepartmentSelectByName(String selectDepartmentByName) {
        MPJLambdaWrapper<Department> wrapper = new MPJLambdaWrapper<Department>()
                .selectAll(Department.class)//查询user表全部字段
                .select(Doctor::getDoctorCode,Doctor::getDoctor,Doctor::getSkills,Doctor::getLocation)
                .leftJoin(Doctor.class, Doctor::getDepartmentCode,Department::getDepartmentCode)
                .like(Department::getDepartment,selectDepartmentByName);
        List<DepartmentDto> userList = departmentMapper.selectJoinList(DepartmentDto.class, wrapper);
        return userList;
    }

    /**
     * 科室信息分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public IPage<DepartmentDto> getDepartmentInfoList(int pageNo, int pageSize) {
        MPJLambdaWrapper mpjLambdaWrapper = new MPJLambdaWrapper<DepartmentDto>()
                .selectAll(Department.class)//查询user表全部字段
                .select(Doctor::getDoctorCode,Doctor::getDoctor,Doctor::getSkills,Doctor::getLocation)
                .leftJoin(Doctor.class, Doctor::getDepartmentCode,Department::getDepartmentCode);
        Page<DepartmentDto> pages = new Page<>(pageNo,pageSize);
        IPage<DepartmentDto> page = departmentMapper.selectJoinPage(pages, DepartmentDto.class,mpjLambdaWrapper);
        return page;
    }


}
