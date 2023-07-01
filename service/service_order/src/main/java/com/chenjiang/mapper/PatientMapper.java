package com.chenjiang.mapper;

import com.chenjiang.model.user.Patient;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper extends MPJBaseMapper<Patient> {
}
