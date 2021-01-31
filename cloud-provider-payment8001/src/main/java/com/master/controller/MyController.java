package com.master.controller;

import com.master.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/18 16:59
 */
@RestController
@Slf4j
public class MyController {
    @Resource
    private MyService myService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @GetMapping(value="/payment/query/{id}")
    public List<Map>queryById(@PathVariable("id") String id){
        List<Map> result=new ArrayList<>();
        result=myService.querySomeThing(id);
        return result;
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        List<String> services=discoveryClient.getServices();
        for(String s:services){
            System.out.println(s);
        }
       List<ServiceInstance> instance= discoveryClient.getInstances("cloud-payment-service");
        for(ServiceInstance info:instance){
            log.info(info.getServiceId()+"\t"+info.getHost()+"\t"+info.getPort()+"\t"+info.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/getPort")
    public String getPaymentPort(){
        return serverPort;
    }
}
