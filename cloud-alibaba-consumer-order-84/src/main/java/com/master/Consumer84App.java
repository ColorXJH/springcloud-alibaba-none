package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/28 10:49
 */
@SpringBootApplication
@EnableDiscoveryClient //作为服务注册发现客户端
@EnableFeignClients   //作为feign远程调用接口客户端
public class Consumer84App {
    public static void main(String[] args) {
        SpringApplication.run(Consumer84App.class,args);
    }
}
