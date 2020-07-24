package com.cloud.study.controller;

import com.cloud.study.entities.CommonResult;
import com.cloud.study.entities.Payment;
import com.cloud.study.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    这段注释只在test上独有
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String port;
    @PostMapping("/payment/insert")
    public CommonResult insert(@RequestBody Payment payment) {
        int status = paymentService.save(payment);
        log.info("-----插入结果----" + status);
        if (status > 0) {
            return new CommonResult(200,"插入成功"+port,null);
        } else {
            return new CommonResult(500,"插入失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult get( @PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("-----查询结果----" + paymentById);
        if (paymentById != null ) {
            return new CommonResult(200,"查询成功"+port,paymentById);
        } else {
            return new CommonResult(500,"没有对应的记录",null);
        }
    }

    @GetMapping("payment/descovery")
    public Object descover() {
        List<String> services = discoveryClient.getServices();

        for (String s : services) {
            log.info("-----service:"+s);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance s : instances) {
            log.info(s.getHost()+"----"+s.getPort()+"-----"+s.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("payment/hystrix/ok/{id}")
    public String normalService(@PathVariable("id")Long id ) {

        return "success"+Thread.currentThread().getName()+"id"+id;
    }


    @GetMapping("payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod="timeOUtServcie_handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String timeOUtServcie(@PathVariable("id")Long id ) {
//        int a = 10/0;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success"+Thread.currentThread().getName()+"id"+id+"耗时:"+3;
    }

    public String timeOUtServcie_handler(@PathVariable("id")Long id ) {
        return "兜底方案,o(╥﹏╥)o";
    }

    // 服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: " + result);
        return result;
    }
}
