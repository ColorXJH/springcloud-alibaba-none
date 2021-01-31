package com.master.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/28 10:27
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    private static HashMap<String,Payment> payments=new HashMap<>();

    static {
        payments.put("1",new Payment("xjh",27));
        payments.put("2",new Payment("kcy",28));
        payments.put("3",new Payment("wxy",29));
    }

    @GetMapping("/payment/getById/{id}")
    public Payment getPaymentById(@PathVariable("id")String id){
        System.out.println("-----------this id is :"+id+"------and this serverPort is "+serverPort);
        return payments.get(id);
    }
}
