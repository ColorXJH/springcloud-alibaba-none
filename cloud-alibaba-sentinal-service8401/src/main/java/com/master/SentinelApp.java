package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/21 11:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelApp {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApp.class,args);
    }
}
