package com.master.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.master.myhandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ColorXJH
 * @version 1.0
 * @description  服务降级
 * @date 2021/1/21 11:26
 */
@RestController
@Slf4j
public class RateLimitController {
    /* 降级规则
     *  hystrix断路器是有半开状态的，sentinel断路器没有半开状态
     *
     *  RT:平均响应时长，最大4900，更大需要通过-Dcsp.sentinel.statistic.max.rt=xxx
     *  1秒内有5个请求，对应的平均相应时长为1/5，如果超过阈值，则做降级处理。窗口期结束后，关闭降级
     *
     *  异常比例：当每秒的异常数占每秒总数的比例达到了阈值，打开断路器，触发降级，异常比例的阈值范围为【0.0-1.0】
     *
     *  异常数：统计窗口是分钟级别的，在该时间段内，异常数超过了阈值后就会进行熔断降级处理，注意时间窗口期一定要大于60秒！
     *
     *  热点key资源处理
     *
     **/



    //设置流控规则，在sentinel上配置，每秒钟限制次数
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException1")
    public String byResource(){
        return "------------资源按照名称限流测试ok-----------";
    }

    public String handlerException1(BlockException exception){
        return "-----------服务限流不可用----------";
    }

    @GetMapping("/byUrl")
    @SentinelResource(value="byUrl")
    public String byUrl(){
        return "---------按照url限流测试-----------";
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public String customerBlockHandler(){
        return "-----------用户自定义限流处理----------";
    }
}
