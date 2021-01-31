package com.master.controller;

import com.master.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/17 11:40
 */
@RestController
@Slf4j
public class OpenFeignController {
    //可按name/type注入，默认反射按照name注入，可以定义该bean的name
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public List<Map> queryById(@PathVariable("id")String id){
        return paymentFeignService.queryById(id);
    }

    @GetMapping("/consumer/getPort")
    public  String getPort(){
        //openFeign默认等待1秒钟
        return paymentFeignService.getPaymentPort();
    }
}



