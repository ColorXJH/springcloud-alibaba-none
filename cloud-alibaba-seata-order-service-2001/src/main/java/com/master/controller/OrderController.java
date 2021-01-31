package com.master.controller;

import com.master.domain.CommonResult;
import com.master.domain.Order;
import com.master.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/31 9:24
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
