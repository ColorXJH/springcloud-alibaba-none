package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/19 14:53
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard {
    public static void main(String[] args) {
        //注意在使用仪表盘监控的时候，所有的服务提供类都需要监控依赖配置--springboot-starter-actuator
        SpringApplication.run(HystrixDashboard.class,args);
    }
}
