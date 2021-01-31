package com.master.service;

import com.master.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/28 10:54
 */
@FeignClient(value="nacos-provider-payment",fallback =PaymentFallBackService.class)
//feign远程调用客户端接口，调用远程微服务提供者微服务名称
public interface PaymentService {
    @GetMapping("/payment/getById/{id}")
    public Payment getPaymentById(@PathVariable("id")String id);
}
