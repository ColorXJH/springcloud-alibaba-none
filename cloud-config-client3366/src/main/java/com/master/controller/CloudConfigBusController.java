package com.master.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/4 20:07
 */
@RestController
@RefreshScope
public class CloudConfigBusController {
    @Value("${server.port}")
    private String port;
    @Value("${config.name}")
    private String configName;

    //也可以配置多个客户端，利用消息总线触发一个客户端的/bus/refresh,而刷新所有的客户端配置
    //亦可以利用消息总线触发一个服务端的/bus/refresh端点，而刷新所有的客户端配置（更加推荐）

    //添加完消息总线支持后，修改github资源内容，发送post请求刷新服务端节点
    //curl -X POST "localhost:3344/actuator/bus-refresh"
    //一次发送，处处生效，3355.3366都生效了
    //注意客户端都是bootstrap.yml引导配置文件

    //如果只想通知3355,不想通知3366 http://localhost:配置中心端口号/actuator/bus-refresh/{destination}
    //eg： curl -X POST "localhost:3344/actuator/bus-refresh/cloud-config-client-3355:3355"
    @GetMapping("/getConfigNameByBus")
    public String getConfigName(){
        return port+"=============="+configName;
    }
}
