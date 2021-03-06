package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/28 10:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9003App {
    public static void main(String[] args) {
        SpringApplication.run(Payment9003App.class,args);
    }
}
