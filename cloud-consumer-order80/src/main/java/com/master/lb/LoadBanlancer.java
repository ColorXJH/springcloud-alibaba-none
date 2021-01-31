package com.master.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/23 15:32
 */
public interface LoadBanlancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
