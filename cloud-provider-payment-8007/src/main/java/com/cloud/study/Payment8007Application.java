package com.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment8007Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8007Application.class,args);
    }
}
