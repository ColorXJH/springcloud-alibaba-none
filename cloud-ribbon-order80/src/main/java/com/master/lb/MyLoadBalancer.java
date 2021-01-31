package com.master.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/15 14:47
 */
public interface MyLoadBalancer {
    ServiceInstance instances(List<ServiceInstance> instances);
}
