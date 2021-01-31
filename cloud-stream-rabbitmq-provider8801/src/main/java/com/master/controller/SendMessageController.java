package com.master.controller;

import com.master.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/6 15:12
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider provider;
    @GetMapping("/sendMessage")
    public String sendMessgae(){
        return provider.send();
    }
}
