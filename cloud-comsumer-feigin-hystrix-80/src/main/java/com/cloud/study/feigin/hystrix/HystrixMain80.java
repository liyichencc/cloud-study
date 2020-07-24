package com.cloud.study.feigin.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient
@EnableHystrix
public class HystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixMain80.class,args);
    }
}
