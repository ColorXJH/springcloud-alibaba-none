package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/19 10:56
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix //消费者端开启hystrix，与服务提供者（生产者端）不一样
public class FeignHystrixOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrder80.class,args);
    }
}
