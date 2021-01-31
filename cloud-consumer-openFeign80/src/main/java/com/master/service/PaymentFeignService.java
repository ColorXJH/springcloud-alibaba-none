package com.master.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/17 11:31
 */
@Component  //注意此接口上注解组件实例，单独将httpclient服务抽取出来，对应各方服务的调用  ，openFeign集成ribbon支持负载均衡
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
//feign在消费端使用
public interface PaymentFeignService {
    @GetMapping("/payment/query/{id}")
    public List<Map>queryById(@PathVariable("id")String id);

    @GetMapping("/payment/getPort")
    public String getPaymentPort();

}
