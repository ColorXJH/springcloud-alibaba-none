package com.master.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/7 21:50
 */
@RestController
@RefreshScope //支持nacos动态刷新功能
public class NacosConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/getConfigInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
