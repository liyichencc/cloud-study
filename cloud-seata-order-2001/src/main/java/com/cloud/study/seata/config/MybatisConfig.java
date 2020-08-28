package com.cloud.study.seata.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cloud.study.seata.dao")
public class MybatisConfig {

}
