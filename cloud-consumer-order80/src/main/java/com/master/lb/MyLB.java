package com.master.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/** 自定义负载均衡器
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/23 15:34
 */
@Component
public class MyLB implements LoadBanlancer{


    private AtomicInteger atomicInteger=new AtomicInteger(0);
    private final int getAndIncrement(){
        int current;
        int next;
        do{current=this.atomicInteger.get();next=current>=2147483647 ? 0 : current + 1;}
        while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("-------------第几次访问，次数next: "+next);
        return next;

    }

    //负载均衡算法，rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标，每次服务重启后rest接口数从1开始
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index=getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
