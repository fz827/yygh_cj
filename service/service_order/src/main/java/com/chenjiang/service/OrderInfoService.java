package com.chenjiang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenjiang.model.dto.OrderInfoDto;
import com.chenjiang.model.order.OrderInfo;
import com.chenjiang.result.Result;

import java.util.List;


public interface OrderInfoService extends IService<OrderInfo> {
    /**
     * 查询通过订单号来查找订单信息
     * @return
     */
    OrderInfoDto selectOrderByOrderNumber(String orderNumber);

    /**
     * 查询所有订单信息
     * @return
     */
    List<OrderInfoDto> selectOrderInfo();


    /**
     * 取消订单(通过订单编号）
     */
    Boolean deleteOrder(String orderNumber);


    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
     IPage<OrderInfoDto> getOrderInfoList(int pageNo, int pageSize);

}

