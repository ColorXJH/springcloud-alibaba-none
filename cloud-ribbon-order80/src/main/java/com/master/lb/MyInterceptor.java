package com.master.lb;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/15 20:01
 */
public class MyInterceptor  implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        System.out.println("这是自定义的拦截器：+++++++++++++=====");
        System.out.println("旧的url=："+httpRequest.getURI());
        HttpRequest newRequest=new MyRequest(httpRequest);
        System.out.println("新的url:"+newRequest.getURI());
        return clientHttpRequestExecution.execute(newRequest,bytes);
    }
}
