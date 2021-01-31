package com.master.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/30 18:12
 */
@RestController
public class ConsulController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/consul/payment")
    public String getServerPort(){
        return serverPort;
    }


}
