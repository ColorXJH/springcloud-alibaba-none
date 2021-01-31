package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/31 2:17
 */
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) ////取消数据源的自动创建
//启动类配置  新版已支持自动代理，不需要自己手动配置datasoure代理了
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderMain2001App {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain2001App.class,args);
    }
}
