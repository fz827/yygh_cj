package com.chenjiang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenjiang.mapper.DoctorMapper;
import com.chenjiang.model.doc_ill.DoctorAndIllness;
import com.chenjiang.model.doctor.Doctor;
import com.chenjiang.model.dto.DoctorDto;
import com.chenjiang.model.illness.Illness;
import com.chenjiang.service.DoctorService;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;


    /**
     * 通过病名查找医生
     *
     * @param selectDoctorByIllnessName
     * @return
     */
    @Override
    public List<DoctorDto> SelectDoctorByIllnessName(String selectDoctorByIllnessName) {
        MPJLambdaWrapper<Doctor> wrapper = new MPJLambdaWrapper<Doctor>()
                .selectAll(Doctor.class)
                .select(Doctor::getDoctorCode, Doctor::getDoctor, Doctor::getSkills, Doctor::getLocation)
                .leftJoin(DoctorAndIllness.class, DoctorAndIllness::getDoctorCode, Doctor::getDoctorCode)
                .leftJoin(Illness.class, Illness::getIllnessCode, DoctorAndIllness::getIllnessCode)
                .eq(Illness::getIllness, selectDoctorByIllnessName);
        List<DoctorDto> doctorList = doctorMapper.selectJoinList(DoctorDto.class, wrapper);
        return doctorList;
    }


}
