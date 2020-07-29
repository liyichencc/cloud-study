package com.cloud.study.configcenter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class ConfigCenterController {

    @Value("${version.info}")
    private String configInfo;

    @GetMapping("/versionInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
