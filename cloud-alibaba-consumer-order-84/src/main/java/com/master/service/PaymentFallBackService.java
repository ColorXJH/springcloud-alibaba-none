package com.master.service;

import com.master.bean.Payment;
import org.springframework.stereotype.Component;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/28 10:57
 */
@Component
public class PaymentFallBackService implements PaymentService{
    @Override
    public Payment getPaymentById(String id) {
        System.out.println("------sentinel服务降级返回------");
        return new Payment("error",404);
    }
}
