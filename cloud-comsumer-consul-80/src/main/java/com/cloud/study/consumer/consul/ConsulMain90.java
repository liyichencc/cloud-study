package com.cloud.study.consumer.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulMain90 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulMain90.class,args);
    }
}
