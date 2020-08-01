package com.cloud.study.stream.controller;


import com.cloud.study.stream.service.IMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {

    @Autowired
    private IMessageSender iMessageSender;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return iMessageSender.send();
    }
}
