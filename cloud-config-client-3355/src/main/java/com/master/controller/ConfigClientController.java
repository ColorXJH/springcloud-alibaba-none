package com.master.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/4 17:40
 */
@RestController
@RefreshScope
//添加actuator依赖以及暴露端口，同时需要使用post请求刷新3355客户端，使其从github上拉去最新信息
//curl -X POST "http://localhost:3355/actuator/refresh"
public class ConfigClientController {
    @Value("${config.name}")
    private String configName;

    //实现了客户端3355访问springcloud-config3344,通过github获取配置
    @GetMapping("/getConfigName")
    public String getConfigName(){
        return configName;
    }

}
