package com.master.controller;

import com.master.service.PaymentFeignHystrixService;
import com.master.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/19 10:52
 */
@RestController
@Slf4j
//hystrix默认的统一的熔断方法,
//hystrix的熔断方法可以如下全局定义也可以在每个方法上定义，这会带来一个问题就是可能会出现代码膨胀
//并且熔断方法参杂在业务方法之中，所以还有第二种方法就是使用feign的熔断方法，
//详情见下方的PaymentFeignHystrixService接口
@DefaultProperties(defaultFallback ="defaultHystrixFallbackMethod")
public class OrderFeignController {
    @Autowired
    private PaymentFeignService service;
    @Resource
    private PaymentFeignHystrixService hystrixService;

    //当消费者调用服务时，不能因为服务提供者宕机或者服务响应很慢而去等待对方反应，应当自己也有降级处理
    //如果对方宕机了，或者调用很慢，自己不能一直等待，需要有兜底方法快速返回，所以在服务调用方也要有熔断降级处理

    @GetMapping(value="/feign/hystrix/paymentok/{id}")
    @HystrixCommand //注意没有特别指明，就调用统一的熔断方法
    public String paymentOk(@PathVariable("id")Integer id){
        return service.paymentInfoOk(id);
    }

    //服务降级
    @HystrixCommand(fallbackMethod = "specialHystrixFallbackMethod",commandProperties = {
            //设置超时时间
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")
    })
    @GetMapping(value="/feign/hystrix/paymentTimeout/{id}")
    public String paymentTimeout(@PathVariable("id")Integer id){
        return service.paymentInfoTimeout(id);
    }

    @GetMapping(value="/feign/hystrix/paymentBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        return  service.paymentInfoCircuitBreaker(id);
    }

    //定义全局默认的熔断方法
    public String defaultHystrixFallbackMethod(){
        return "这个是定义的全局默认的defaultHystrixFallbackMethod---default";
    }
    //定义指定的熔断方法
    public String specialHystrixFallbackMethod(@PathVariable("id")Integer id){
        return "这个是指定的全局默认的defaultHystrixFallbackMethod---special";
    }


    //一下为feign的服务降级方法
    @GetMapping(value="/feignMethod/hystrix/OK/{id}")
    public String getFeignMethodOK(@PathVariable("id")Integer id){
        return hystrixService.paymentInfoOk(id);
    }

    @GetMapping(value="/feignMethod/hystrix/Timeout/{id}")
    public String getFeignMethodTimeOut(@PathVariable("id")Integer id){
        return hystrixService.paymentInfoTimeout(id);
    }

    @GetMapping(value="/feignMethod/hystrix/Breaker/{id}")
    public String getFeignMethodBreaker(@PathVariable("id")Integer id){
        return hystrixService.paymentInfoCircuitBreaker(id);
    }
}
