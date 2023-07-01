package com.chenjiang.controller;

import com.chenjiang.api.OrderFeign;
import com.chenjiang.model.order.OrderInfo;
import com.chenjiang.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/orderInfo")
public class ConsumerOrder {
    @Autowired
    private OrderFeign orderFeign;

    /**
     * 所有订单信息
     * @return
     */
    @GetMapping("/getAllOrderInfo")
    public Result getAllOrderInfo(){
       return orderFeign.findAllOrderInfo();
    }


    /**
     * 订单查询
     * @param orderInfo
     * @return
     */
    @PostMapping("/getOrderInfoByOrderNumber")
    public Result getOrderInfoByOrderNumber(@RequestBody OrderInfo orderInfo){
        return orderFeign.get(orderInfo);
    }


    /**
     * 取消订单
     * @param orderInfo
     * @return
     */
    @PostMapping("/deleteOrder")
    private Result deleteOrder(@RequestBody OrderInfo orderInfo){
        return orderFeign.deleteOrder(orderInfo);
    }
}
