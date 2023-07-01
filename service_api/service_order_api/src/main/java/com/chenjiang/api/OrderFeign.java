package com.chenjiang.api;

import com.chenjiang.model.order.OrderInfo;
import com.chenjiang.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "service-order-cj")
@Repository
public interface OrderFeign {
    /**
     * 查询订单所有信息
     * @return
     */
    @GetMapping("/findAll")
    public Result findAllOrderInfo();

    /**
     * 通过订单号查询订单信息
     * @param orderInfo
     * @return
     */
    @PostMapping("/getOrderInfo")
    public Result get(@RequestBody OrderInfo orderInfo);


    /**
     * 取消订单通过订单号
     * @param orderInfo、
     * @return
     */
    @PostMapping("/deleteOrderByOrderNumber")
    public Result deleteOrder(@RequestBody OrderInfo orderInfo);


}
