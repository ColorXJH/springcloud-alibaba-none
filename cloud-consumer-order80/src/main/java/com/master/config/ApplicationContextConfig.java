package com.master.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/23 11:29
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //如果不自定义负载均衡器需要加上这个注解
    //@LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//applicationContext.xml <bean id="" class="">