package com.master.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/27 17:47
 */

@RestController
public class ZookeeperController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/paymentZK")
    public String paymentZK(){
        return "springcloud-with-zookeeper,serverPort: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
