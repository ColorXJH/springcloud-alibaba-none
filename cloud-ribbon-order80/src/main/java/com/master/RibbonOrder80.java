package com.master;

import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/15 14:42
 */
@SpringBootApplication
@EnableEurekaClient
//配置自己的负载均衡规则
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class RibbonOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(RibbonOrder80.class,args);
    }
}
