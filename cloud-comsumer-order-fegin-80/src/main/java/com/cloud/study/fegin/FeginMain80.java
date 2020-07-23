package com.cloud.study.fegin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeginMain80 {

    public static void main(String[] args) {
        SpringApplication.run(FeginMain80.class,args);
    }
}
