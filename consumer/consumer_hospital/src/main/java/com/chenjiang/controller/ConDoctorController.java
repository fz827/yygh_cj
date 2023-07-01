package com.chenjiang.controller;

import com.chenjiang.api.DepartmentFeign;
import com.chenjiang.api.DoctorFeign;
import com.chenjiang.model.doctor.Doctor;
import com.chenjiang.model.illness.Illness;
import com.chenjiang.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class ConDoctorController {

    @Autowired
    private DoctorFeign doctorFeign;

    /**
     * 通过病情查找医生
     * @param illness
     * @return
     */
    @PostMapping("/selectDoctorByIllnessName")
    public Result selectDoctorByIllnessName(@RequestBody Illness illness){
        return doctorFeign.selectDoctorByIllnessName(illness);
    }


    /**
     * 查找所有医生信息
     * @param
     * @return
     */
    @GetMapping("/getDoctorAll")
    public Result getAllDoctor(){
        return doctorFeign.getAllDoctor();
    }




    /**
     * 添加医生
     * @param doctor
     * @return
     */
    @PostMapping("/saveDoctor")
    public Result saveDoctor(@RequestBody Doctor doctor){
        return doctorFeign.saveDoctor(doctor);
    }




}
