package com.chenjiang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenjiang.model.user.Patient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper extends BaseMapper<Patient> {
}
