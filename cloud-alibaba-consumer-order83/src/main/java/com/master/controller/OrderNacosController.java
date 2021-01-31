package com.master.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/7 16:20
 */
@RestController
@Slf4j
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String serverPort;
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    //重复请求，naco轮询同一服务的多个实例
    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id")String id ){
        return restTemplate.getForObject(serviceUrl+"/payment/nacos/"+id,String.class);

    }
}
