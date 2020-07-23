package com.cloud.study.feigin.hystrix.controller;


import com.cloud.study.entities.CommonResult;
import com.cloud.study.entities.Payment;
import com.cloud.study.feigin.hystrix.payment.FeiginPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeiginPaymentController {

    @Autowired
    private FeiginPaymentService service;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getFeiginInfo(@PathVariable("id") Long id){
        return service.getPaymentById(id);
    }

    @GetMapping("/patment/timeout/get/{id}")
    public CommonResult<String> getTimeOutService(@PathVariable("id") Long id){
        return new CommonResult<>(200,service.getTimeoutService(id));
    }

    @GetMapping("/patment/ok/get/{id}")
    public CommonResult<String> getOkService(@PathVariable("id") Long id){
       return new CommonResult<>(200,service.getOkService(id));
    }
}
