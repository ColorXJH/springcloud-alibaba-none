package com.master.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.master.bean.Payment;
import com.master.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/28 11:04
 */
@RestController
@Slf4j
public class ConsumerInvokerController {

    public static final String SERVICE_URL="http://nacos-provider-payment";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") //配置流控规则
    //@SentinelResource(value="fallback",fallback = "handleFallback") //fallback只负责业务异常
    //@SentinelResource(value="fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",fallback = "handleFallback",blockHandler = "blockHander",exceptionsToIgnore = {IllegalArgumentException.class})
    //加入报该IllegalArgumentException异常，不再有fallback方法兜底，没有降级效果了
    //fallback，blockHandler都进行了配置，则被限流降级而抛出BlockException异常时只会进入blockHander处理逻辑
    public Payment fallbackExample(@PathVariable("id")String id){
        Payment payment=restTemplate.getForObject(SERVICE_URL+"/payment/getById/"+id,Payment.class,id);
        if(id.equals("error")){
            throw  new IllegalArgumentException("非法参数异常");
        }
        return payment;
    }

    //handleFallback
    public Payment handleFallback(@PathVariable("id")String id, Throwable e){
        Payment payment=new Payment("兜底异常handleFallback，exception内容 "+ e.getMessage(),404404);
        return payment;
    }

    //blockHandler
    public Payment blockHander(@PathVariable("id")String id, BlockException e){
        Payment payment=new Payment("sentinel异常blockHandler，exception内容 "+ e.getMessage(),404404);
        return payment;
    }


    //该方法调用了open-feign的异常处理方法
    @GetMapping("/consumer/invoker/payment/{id}")
    public Payment getPaymentById(@PathVariable("id")String id){
            return paymentService.getPaymentById(id);
    }


}
