package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/4 17:39
 */

@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClient3355 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3355.class,args);
    }
}
