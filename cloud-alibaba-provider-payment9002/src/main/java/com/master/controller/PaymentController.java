package com.master.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/7 15:15
 */
@RestController
@RefreshScope //支持nacos动态刷新功能
public class PaymentController {
        @Value("${server.port}")
        private String serverPort;

        @Value("${myBServer.name}")
        private String myServerName;

        @GetMapping("/payment/nacos/{id}")
        public String getPayment(@PathVariable("id")String id){
            return "nacos registry, serverPort: "+ serverPort+"\t id"+id
                    +" and the nginx nacos config:"+myServerName;
        }
}
