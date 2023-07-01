package com.chenjiang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenjiang.model.dto.OrderInfoDto;
import com.chenjiang.model.order.OrderInfo;
import com.chenjiang.result.Result;
import com.chenjiang.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.chenjiang.model.constants.Constants.MESSAGE_FAILURE;
import static com.chenjiang.model.constants.Constants.MESSAGE_SUCCESS;


@RestController
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    //1 查询医院设置表所有信息
    @GetMapping("/findAll")
    public Result findAllOrderInfo() {
        List<OrderInfoDto> orderInfoDtos = orderInfoService.selectOrderInfo();
        if (orderInfoDtos != null) {
            return Result.ok(orderInfoDtos);
        }
        return Result.fail(MESSAGE_FAILURE);
    }


    /**
     * 通过订单号获取到订单信息
     *
     * @return
     */
    @PostMapping("/getOrderInfo")
    public Result get(@RequestBody OrderInfo orderInfo) {
        OrderInfoDto orderInfoDto = orderInfoService.selectOrderByOrderNumber(orderInfo.getOrderNumber());
        if (orderInfoDto != null) {
            return Result.ok(orderInfoDto);
        }
        return Result.fail(MESSAGE_FAILURE);
    }

    /**
     * 通过订单编号来取消订单
     * @param orderInfo
     * @return
     */
    @PostMapping("/deleteOrderByOrderNumber")
    public Result deleteOrder(@RequestBody OrderInfo orderInfo) {
        Boolean flag = orderInfoService.deleteOrder(orderInfo.getOrderNumber());
        if (flag) {
            return Result.ok(MESSAGE_SUCCESS);
        }
        return Result.fail(MESSAGE_FAILURE);
    }

    /**
     * 添加订单
     * @param orderInfo
     * @return
     */
    @PostMapping("/saveOrderInfo")
    public Result saveOrderInfo(@RequestBody OrderInfo orderInfo){
        boolean flag = orderInfoService.save(orderInfo);
        if (flag) {
            return Result.ok(MESSAGE_SUCCESS);
        }
        return Result.fail(MESSAGE_FAILURE);
    }

    /**
     * 订单分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/getOrderInfoList/{pageNo}/{pageSize}")
    public Result getOrderInfoList(@PathVariable int pageNo ,@PathVariable int pageSize){
    return Result.ok(orderInfoService.getOrderInfoList(pageNo, pageSize));
}


}
