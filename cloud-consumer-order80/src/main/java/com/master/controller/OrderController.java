package com.master.controller;

import com.master.lb.LoadBanlancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/23 11:31
 */
@RestController
@Slf4j
public class OrderController {
    /**
     * @description: 微服务调用地址
     * @author: ColorXJH
     * @date: 2020/11/23 11:33
     */
    //注意在restTemplate上使用@LoadBalanced注解时需要使用服务名而不能用ip:port形式
    //因为Ribbon会根据服务名[serviceId]去获取所有实例，然后进行负载均衡
    //public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    public static final String PAYMENT_URL="http://localhost:8001";

    //spring_web模块自带了resttemplate,若是简单使用，可以直接引用，无需自定义bean
    @Resource
    private RestTemplate restTemplate;
    //自定义负载均衡器
    @Resource
    private LoadBanlancer loadBalanced;
    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/get/{id}")
    public Object queryPayment(@PathVariable("id")String id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/query/"+id,Object.class);
    }

    //远程调用获取服务提供方的端口（集群条件下获取的不同的端口号，集群策略见lb配置）
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance>instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance=loadBalanced.instances(instances);
        URI url=instance.getUri();
        return restTemplate.getForObject(url+"/payment/getPort",String.class);
    }





}
