package com.master.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/21 10:49
 */
@Component
@Slf4j
//生命周期 pre/post 两个
//GlobalFilter为全局filter,单一filter为GatewayFilter 两个
//作用：全局日志记录/网关权限...
public class MyLogGatewayFilter  implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("---------come in to myLogGatewayFilter------------"+new Date());
        String username=exchange.getRequest().getQueryParams().getFirst("uname");
        if(username==null){
            log.info("用户名为null");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
