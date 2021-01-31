package com.master.lb;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/15 20:05
 */
public class MyRequest  implements HttpRequest {
    HttpRequest sourceRequest;
    public MyRequest(HttpRequest sourceRequest){
        this.sourceRequest=sourceRequest;
    }
    @Override
    public HttpMethod getMethod() {
        return sourceRequest.getMethod();
    }

    @Override
    public String getMethodValue() {
        return sourceRequest.getMethodValue();
    }

    @Override
    public URI getURI() {
        try {
            //URI uri=new URI("http://localhost:80/ribbon/status");
            //URI uri=new URI("http://localhost:8001/payment/getPort");
            URI uri=new URI("http://localhost:8001/payment/query/5");
            //URI uri=new URI("http://CLOUD-PAYMENT-SERVICE/payment/query/5"); 不能再使用服务名了
            return uri;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return sourceRequest.getURI();
    }

    @Override
    public HttpHeaders getHeaders() {
        return sourceRequest.getHeaders();
    }
}
