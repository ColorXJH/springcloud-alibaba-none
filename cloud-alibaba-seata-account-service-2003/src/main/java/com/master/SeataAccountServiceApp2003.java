package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/31 10:21
 */
@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
public class SeataAccountServiceApp2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountServiceApp2003.class,args);
    }
}
