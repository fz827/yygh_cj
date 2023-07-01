package com.chenjiang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenjiang.mapper.PatientMapper;
import com.chenjiang.model.user.Patient;
import com.chenjiang.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

}
