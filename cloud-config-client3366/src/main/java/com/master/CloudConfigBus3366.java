package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/4 20:07
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudConfigBus3366 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigBus3366.class,args);
    }
}
