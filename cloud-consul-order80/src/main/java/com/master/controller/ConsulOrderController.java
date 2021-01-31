package com.master.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/30 18:41
 */
@RestController
public class ConsulOrderController {
    private static final String URL="http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/consul/payment/order")
    public String getConsulPayment(){
        return restTemplate.getForObject(URL+"/consul/payment",String.class);
    }
}
