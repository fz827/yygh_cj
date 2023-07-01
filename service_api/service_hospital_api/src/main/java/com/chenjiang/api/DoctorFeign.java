package com.chenjiang.api;

import com.chenjiang.model.doctor.Doctor;
import com.chenjiang.model.illness.Illness;
import com.chenjiang.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "service-hospital-cj")
@Repository
public interface DoctorFeign  {


    /**
     * 通过病情查找医生
     * @param illness
     * @return
     */
    @PostMapping("/selectDoctorByIllnessName")
    public Result selectDoctorByIllnessName(@RequestBody Illness illness);


    /**
     * 查找所有医生信息
     * @param
     * @return
     */
    @GetMapping("/getDoctorAll")
    public Result getAllDoctor();


    /**
     * 添加医生
     * @param doctor
     * @return
     */
    @PostMapping("/saveDoctor")
    public Result saveDoctor(@RequestBody Doctor doctor);
}
