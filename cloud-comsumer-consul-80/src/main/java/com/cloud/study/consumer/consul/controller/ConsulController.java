package com.cloud.study.consumer.consul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsulController {

    public static final String URL = "http://consul-privider-payment";


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        String forObject
                = restTemplate.getForObject(URL + "/payment/consul", String.class);
        return forObject;
    }
}
