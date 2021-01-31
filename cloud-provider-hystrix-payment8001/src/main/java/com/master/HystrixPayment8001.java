package com.master;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/18 15:33
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //启用服务熔断降级
public class HystrixPayment8001 {

    //服务降级-》服务熔断-》回复链路调用
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001.class,args);
    }
    /**
     此配置是为了服务监控而配置，与服务容错本身无关，springCloud升级后的坑
     ServletRegistrationBean因为springboot的默认路径不是“/hystrix.stream”
     只要在自己的项目上配置下面的servlet即可
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet=new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");//访问路径
        registrationBean.setName("hystrix.stream");
        return registrationBean;
    }
}
