package com.chenjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenjiang.model.doctor.Doctor;
import com.chenjiang.model.dto.DoctorDto;

import java.util.List;

public interface DoctorService extends IService<Doctor> {

    List<DoctorDto> SelectDoctorByIllnessName(String selectDoctorByIllnessName);
}
