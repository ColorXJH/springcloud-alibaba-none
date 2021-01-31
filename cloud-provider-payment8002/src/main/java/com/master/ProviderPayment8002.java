package com.master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/15 15:51
 */
@SpringBootApplication
@MapperScan(basePackages ="com.master.dao" )
@EnableEurekaClient
public class ProviderPayment8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8002.class,args);
    }
}
