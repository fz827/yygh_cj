package com.chenjiang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenjiang.mapper.IllnessMapper;
import com.chenjiang.model.illness.Illness;
import org.springframework.stereotype.Service;

@Service
public class IllnessService extends ServiceImpl<IllnessMapper, Illness> implements com.chenjiang.service.IllnessService {
}
