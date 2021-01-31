package com.master.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ColorXJH
 * @version 1.0
 * @description  服务限流
 * @date 2021/1/21 11:25
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "---------testA----------";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "--------testB");
        return "-----------testB---------------";
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        log.info("testD异常比例");
        int age = 0 / 10;
        Thread.sleep(1000);
        return "--------------testD-----------";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_hotKey")//资源唯一名称，默认请求路径
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "----------------testHotKey--------------";
    }



    public String deal_hotKey(String p1, String p2, BlockException exception){
            return "-----------deal_hotkey----------";//sentinel系统默认的提示：blocked by sentinel (flow limiting)
    }


    /*
     * 资源名：唯一名称，默认请求路径
     * 针对来源：sentinel可以针对调用者进行限流，填写微服务名，默认default(不区分来源)
     * 阈值类型/单机阈值
     *  QPS:每秒钟请求数量，当调用api达到阈值的时候，进行限流
     *  线程数： 当调用api的线程数达到阈值的时候，进行限流
     *是否集群：不需要集群
     * 流控模式：
     *  直接：api达到限流条件时，直接限流
     *  关联：当关联的资源达到阈值时，就限流自己
     *  链路：只记录指定链路上的流量（指定资源从入口资源进来的流量，如果达到阈值，就进行限流），api级别的针对来源
     * 流控效果：
     *  快速失败:直接失败，抛出异常
     *  warm up:根据codeFactor（冷加载因子，默认为3）的值，从阈值/codeFactor,经过预热时长，才达到设定的qps阈值
     *  排队等待：匀速排队，让请求以匀速的速度通过，阈值类型必须设置为QPS,否则无效
     */
}