package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/23 15:55
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myrule(){
        return new RandomRule();//定义为随机
    }
}
