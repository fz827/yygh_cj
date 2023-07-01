package com.chenjiang.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenjiang.model.dto.OrderInfoDto;
import com.chenjiang.model.order.OrderInfo;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderInfoMapper extends MPJBaseMapper<OrderInfo> {

}
