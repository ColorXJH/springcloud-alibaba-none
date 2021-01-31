package com.master.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/19 11:32
 */
@Component
@FeignClient(value="cloud-provider-hystrix-payment8001",fallback =PaymentFeignHystrixFallback.class )
//这个调用接口上有feiginFallback方法，他是一个兜底方法，feign中包含了hystrix,这是它的熔断降级方法
public interface PaymentFeignHystrixService {

    @GetMapping(value="/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id")Integer id);

    @GetMapping(value="/payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id")Integer id);

    @GetMapping(value="/payment/hystrix/circuitBreaker/{id}")
    String paymentInfoCircuitBreaker(@PathVariable("id")Integer id);
}
