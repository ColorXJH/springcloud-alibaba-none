package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/7 15:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProviderPayment9002 {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProviderPayment9002.class,args);
    }
}
