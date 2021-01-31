package com.master.service;

import org.springframework.stereotype.Component;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/19 11:34
 */
@Component
public class PaymentFeignHystrixFallback  implements PaymentFeignHystrixService{

    @Override
    public String paymentInfoOk(Integer id) {
        return "-----PaymentFeignHystrixService fall back-paymentInfoOk ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "-----PaymentFeignHystrixService fall back-paymentInfoTimeout ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoCircuitBreaker(Integer id) {
        return "-----PaymentFeignHystrixService fall back-paymentInfoCircuitBreaker ,o(╥﹏╥)o";
    }

}
