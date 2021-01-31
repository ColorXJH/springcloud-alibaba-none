package com.master.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/19 10:43
 */
@Component
@FeignClient(value="cloud-provider-hystrix-payment8001")
public interface PaymentFeignService {
    @GetMapping(value="/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id")Integer id);

    @GetMapping(value="/payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id")Integer id);

    @GetMapping(value="/payment/hystrix/circuitBreaker/{id}")
    String paymentInfoCircuitBreaker(@PathVariable("id")Integer id);
}
