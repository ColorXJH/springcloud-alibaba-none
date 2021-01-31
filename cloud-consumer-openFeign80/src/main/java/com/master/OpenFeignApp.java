package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/17 11:29
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApp.class,args);
    }
}
