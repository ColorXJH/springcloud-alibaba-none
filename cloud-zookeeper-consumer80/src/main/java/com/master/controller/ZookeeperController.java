package com.master.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/30 13:23
 */
@RestController
public class ZookeeperController {
    private static  final String URL="http://cloud-provider-payment8004";

    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/zookeeper/consumer/payment/ZK")
    public String paymentInfo(){
        String  result=restTemplate.getForObject(URL+"/paymentZK",String.class);
        return result;
    }
}
