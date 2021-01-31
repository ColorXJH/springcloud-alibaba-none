package com.master.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/17 14:28
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        //配置feign日志打印级别：默认NONE,还有BASIC,HEADERS,FULL
        return Logger.Level.FULL;
    }
}
