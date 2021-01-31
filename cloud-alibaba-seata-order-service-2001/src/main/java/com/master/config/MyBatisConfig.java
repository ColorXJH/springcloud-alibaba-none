package com.master.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/31 2:28
 */
@Configuration
@MapperScan({"com.master.dao"})
public class MyBatisConfig {
}
