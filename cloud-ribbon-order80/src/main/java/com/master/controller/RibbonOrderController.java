package com.master.controller;

import com.master.lb.CustomerLoadbalance;
import com.master.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
 * @date 2020/12/15 14:44
 */
@RestController
@Slf4j
public class RibbonOrderController {

    public final static String REMOTE_URL="http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    //此时得restTemlate已经使用了自己的IRule了，在springboot启动类上方已经注册过了
    @Resource(name="restTemplate")
    private RestTemplate restTemplate;
    //自定义的@MyLoadBalancer需要更进一步注册金springboot,并被重写拦截，这里只是重写其负载均衡算法
    //并没有使用，如果需要使用自定义得负载均衡器，需要进一步书写（参考百度），这里只是使用了自己得自定义规则IRule
    //并且需要在自己的restTemplate上方注解@LoadBalanced,这样才能被标记识别，才可以使用服务名而不是ip去配合
    //restTemplate远程调用服务接口

    //自定义的负载均衡器
    @Resource(name="restTemplate2")
    @CustomerLoadbalance
    private RestTemplate restTemplate2;

    @Resource
    private MyLoadBalancer myLoadBalancer;
    @Resource
    private EurekaDiscoveryClient discoveryClient;

    //java.net.UnknownHostException: CLOUD-PAYMENT-SERVICE
    @GetMapping("ribbon/consumer/payment/get/{id}")
    public Object queryPayment(@PathVariable("id")String id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/query/"+id,Object.class);
    }
    //获取不同服务实例得端口号
    @GetMapping("ribbon/consumer/payment")
    public Object queryPaymentPort(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPort",Object.class);
    }

    //远程调用获取服务提供方的端口（集群条件下获取的不同的端口号，集群策略见lb配置）
    @GetMapping("ribbon/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance=myLoadBalancer.instances(instances);
        URI url=instance.getUri();
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPort",String.class);
    }

    @GetMapping("ribbon/consumer/payment2/get/{id}")
    public String queryPayment2(@PathVariable("id")String id){
        return restTemplate2.getForObject(PAYMENT_URL+"/payment/query/"+id,String.class);
    }

    @GetMapping("ribbon/status")
    public String showStatus(){
        return "success";
    }


}
