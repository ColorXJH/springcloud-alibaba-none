package com.master.config;

import com.master.lb.CustomerLoadbalance;
import com.master.lb.MyInterceptor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/15 14:45
 */
@Configuration
public class ApplicationContextConfig {
    @Bean("restTemplate")
    @LoadBalanced
    public  RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean("restTemplate2")
    @CustomerLoadbalance
    public  RestTemplate getRestTemplate2(){
        return new RestTemplate();
    }

    //用于设置新的拦截器
    @Autowired(required = false)
    @CustomerLoadbalance
    private List<RestTemplate> restTemplateList= Collections.emptyList();

    //用于设置新的拦截器
    @Bean
    public SmartInitializingSingleton lbInitializing(){
        return new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                for(RestTemplate template:restTemplateList){
                    List<ClientHttpRequestInterceptor> interceptors=template.getInterceptors();
                    //将自定义的拦截器加入到拦截器链条中
                    interceptors.add(new MyInterceptor());
                    template.setInterceptors(interceptors);
                }
            }
        };
    }


}
