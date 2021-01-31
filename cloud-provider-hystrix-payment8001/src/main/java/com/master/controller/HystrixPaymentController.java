package com.master.controller;

import com.master.service.HystrixPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/18 15:37
 */
@RestController
@Slf4j
public class HystrixPaymentController {
    @Resource
    private HystrixPaymentService service;

    @Value("${server.port}")
    private String serverPort;


    //如果使用apache-jmeter压力测试工具来高并发测试（下载jmeter,打开bin/下面的jmeter.bat）


    @GetMapping("payment/hystrix/ok/{id}")
    //服务降级
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutException1",commandProperties = {
            //设置超时时间
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfoOk(@PathVariable("id")Integer id){
        String result=service.paymentInfoOk(id);
        log.info("------------result:="+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id")Integer id){
        String result=service.paymentInfoTimeout(id);
        log.info("-----------result:="+result);
        return result;
    }

    //服务熔断
    @GetMapping("/payment/hystrix/circuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        String result=service.paymentCircuitBreaker(id);
        log.info("------------------result:="+result);
        return result;
    }


    public String paymentInfoTimeOutException1(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"8001系统繁忙或者运行出错，请稍后再尝试  "+id;
    }

}
