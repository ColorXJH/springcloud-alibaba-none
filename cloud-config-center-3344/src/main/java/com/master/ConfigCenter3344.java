package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/23 16:59
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344.class,args);
        //启动项目，访问localhost:3344/master/config-dev.yml查看github上的内容
    }
}
