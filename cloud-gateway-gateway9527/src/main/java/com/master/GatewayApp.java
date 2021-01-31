package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/19 16:33
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApp {
    //springCloudGateway使用了webflux中的reactor-netty相应式编程组件，底层使用了netty通讯框架
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class,args);
    }
}
