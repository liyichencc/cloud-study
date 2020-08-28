package com.cloud.study.account.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cloud.study.account.dao")
public class MybatisConfig {

}
