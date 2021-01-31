package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/7 21:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClient3377 {
    public static void main(String[] args) {
        //如果启动报错 /api//nacos/v1/ns/instance after all servers([192.168.1.3:8848]) tried: server is DOWN now, please t
        //可能是nacos服务器过载，删除掉nacos文件夹下的data文件夹再重新启动nacos服务器即可解决
        SpringApplication.run(NacosConfigClient3377.class,args);
    }
}
