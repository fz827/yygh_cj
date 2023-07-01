package com.chenjiang.controller;

import com.chenjiang.model.doctor.Doctor;
import com.chenjiang.model.illness.Illness;
import com.chenjiang.result.Result;
import com.chenjiang.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.chenjiang.model.constants.Constants.MESSAGE_FAILURE;
import static com.chenjiang.model.constants.Constants.MESSAGE_SUCCESS;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /**
     * 通过病情查找医生
     * @param illness
     * @return
     */
    @PostMapping("/selectDoctorByIllnessName")
    public Result selectDoctorByIllnessName(@RequestBody Illness illness){
        return Result.ok(doctorService.SelectDoctorByIllnessName(illness.getIllness()));
    }

    /**
     * 查找所有医生信息
     * @param
     * @return
     */
    @GetMapping("/getDoctorAll")
    public Result getAllDoctor(){
        List<Doctor> list = doctorService.list();
        if (list == null){
            return Result.fail(MESSAGE_FAILURE);
        }
        return Result.ok(list);

    }

    /**
     * 修改医生信息
     * @param doctor
     * @return
     */

    @PostMapping("/updateDoctor")
    public Result updateDoctor(@RequestBody Doctor doctor){
        Boolean flag = doctorService.updateById(doctor);
        if (flag){
            return Result.ok(MESSAGE_SUCCESS);
        }
        return Result.fail(MESSAGE_FAILURE);

    }

    /**
     * 通过id来删除医生
     * @param id
     * @return
     */
    @DeleteMapping("/deleteDoctor/{id}")
    public Result deleteDoctor(@PathVariable Integer id){
        Boolean flag = doctorService.removeById(id);
        if (flag){
            return Result.ok(MESSAGE_SUCCESS);
        }
            return Result.fail(MESSAGE_FAILURE);

    }

    /**
     * 添加医生
     * @param doctor
     * @return
     */
    @PostMapping("/saveDoctor")
    public Result saveDoctor(@RequestBody Doctor doctor){
        boolean flag = doctorService.save(doctor);
        if (flag){
            return Result.ok(MESSAGE_SUCCESS);
        }
        return Result.fail(MESSAGE_FAILURE);
    }



}
