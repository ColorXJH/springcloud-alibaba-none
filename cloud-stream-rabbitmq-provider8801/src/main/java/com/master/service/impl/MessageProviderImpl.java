package com.master.service.impl;

import com.master.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/6 14:58
 */
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl  implements IMessageProvider {
    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String uuid= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println( "消息发送=====+uuid:"+uuid);
        return uuid;
    }
}
