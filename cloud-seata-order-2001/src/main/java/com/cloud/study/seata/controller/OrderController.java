package com.cloud.study.seata.controller;

import com.cloud.study.entities.CommonResult;
import com.cloud.study.seata.domain.Order;
import com.cloud.study.seata.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建完成");
    }



}
