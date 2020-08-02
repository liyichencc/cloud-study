package com.cloud.study.nacos.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/get/port/{id}")
    public String getPort(@PathVariable("id")Long id) {
        return this.port + "id = " + id;
    }
}
