package com.master.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/18 15:37
 */
@Service
public class HystrixPaymentService {
    /**
     * @description:  正常访问肯定ok
     * @method: paymentInfoOk
     * @param: [id]
     * @return: java.lang.String
     */
    public String paymentInfoOk(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfoOk----id: "+id;
    }

    //服务降级
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutException",commandProperties = {
            //设置超时时间
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfoTimeout(Integer id){
        //程序异常或者超时，线程池信号量打满，服务熔断等都会触发降级
        //int age=10/0;
        try {
            //hystrix的默认超时时间为1秒
           Thread.sleep(3000);
            //TimeUnit.MICROSECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"id: "+id+" 耗时(秒): ";
    }

    public String paymentInfoTimeOutException(Integer id){
            return "线程池:"+Thread.currentThread().getName()+"8001系统繁忙或者运行出错，请稍后再尝试  "+id;
    }


    //服务熔断
    @HystrixCommand(fallbackMethod="paymentCirCuitBreakerException",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")//失败率达到多少后开始跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if(id<0){
            throw new RuntimeException("----------------id不能为负数-----------");
        }
        String serialsNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功！流水号："+serialsNumber;

    }

    public  String paymentCirCuitBreakerException(@PathVariable("id")Integer id){
        return "id 不能为负数，请稍后再尝试 "+id;
    }
}
