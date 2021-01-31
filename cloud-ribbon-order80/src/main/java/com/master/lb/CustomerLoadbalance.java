package com.master.lb;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;
/**
 * @description: 自定义我的负载均衡器注解，生效的关键在于@Qualifier注解
 * @author: ColorXJH
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface CustomerLoadbalance {

}
