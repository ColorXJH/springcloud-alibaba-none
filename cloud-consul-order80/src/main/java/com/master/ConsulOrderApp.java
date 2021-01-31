package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/30 18:37
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderApp.class,args);
    }
}
