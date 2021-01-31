package com.master.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/19 10:43
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLevel(){
        return  Logger.Level.FULL;//打印全部日志
    }
}
