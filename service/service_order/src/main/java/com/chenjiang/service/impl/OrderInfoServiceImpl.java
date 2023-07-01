package com.chenjiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenjiang.mapper.OrderInfoMapper;
import com.chenjiang.model.doctor.Doctor;
import com.chenjiang.model.dto.OrderInfoDto;
import com.chenjiang.model.order.OrderInfo;
import com.chenjiang.model.user.Patient;
import com.chenjiang.service.OrderInfoService;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    /**
     * 通过订单编号来查找订单信息
     * @param orderNumber
     * @return
     */
    @Override
    public OrderInfoDto selectOrderByOrderNumber(String orderNumber) {
        MPJLambdaWrapper<OrderInfo> wrapper = new MPJLambdaWrapper<OrderInfo>()
                .selectAll(OrderInfo.class)
                .selectAll(Patient.class)
                .select(Doctor::getDoctor,Doctor::getDoctor,Doctor::getLocation,Doctor::getSkills)
                .leftJoin(Patient.class, Patient::getIdCard, OrderInfo::getIdCard)
                .leftJoin(Doctor.class, Doctor::getDoctorCode, OrderInfo::getDoctorCode)
                .eq(OrderInfo::getOrderNumber,orderNumber);
       OrderInfoDto orderInfoDto = orderInfoMapper.selectJoinOne(OrderInfoDto.class,wrapper);
        System.out.println(orderInfoDto);

         return orderInfoDto;
    }

    /**
     * 查询所有的订单
     * @return
     */
    @Override
    public List<OrderInfoDto> selectOrderInfo() {
        MPJLambdaWrapper<OrderInfo> wrapper = new MPJLambdaWrapper<OrderInfo>()
                .selectAll(OrderInfo.class)
                .selectAll(Patient.class)
                .select(Doctor::getDoctor,Doctor::getDoctor,Doctor::getLocation,Doctor::getSkills)
                .leftJoin(Patient.class, Patient::getIdCard, OrderInfo::getIdCard)
                .leftJoin(Doctor.class, Doctor::getDoctorCode, OrderInfo::getDoctorCode);

        List<OrderInfoDto> orderInfoDtos = orderInfoMapper.selectJoinList(OrderInfoDto.class, wrapper);

        return orderInfoDtos;
    }

    /**
     * 通过订单编号取消订单
     * @return
     */
    @Override
    public Boolean deleteOrder(String orderNumber){
        boolean flag = false;
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
         queryWrapper.eq("orderNumber", orderNumber);
        Integer i = orderInfoMapper.delete(queryWrapper);
       if (i >0 ){
           return true;
       }
       return flag;
    }

    /**
     * 分页功能
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public IPage<OrderInfoDto> getOrderInfoList(int pageNo, int pageSize) {

        MPJLambdaWrapper mpjLambdaWrapper= new MPJLambdaWrapper<OrderInfoDto>()
                .selectAll(OrderInfo.class)
                .selectAll(Patient.class)
                .select(Doctor::getDoctor,Doctor::getDoctor,Doctor::getLocation,Doctor::getSkills)
                .leftJoin(Patient.class, Patient::getIdCard, OrderInfo::getIdCard)
                .leftJoin(Doctor.class, Doctor::getDoctorCode, OrderInfo::getDoctorCode);
        Page<OrderInfoDto> pages = new Page<>(pageNo,pageSize);
        IPage<OrderInfoDto> page = orderInfoMapper.selectJoinPage(pages, OrderInfoDto.class,mpjLambdaWrapper);
        return page;


    }


}
