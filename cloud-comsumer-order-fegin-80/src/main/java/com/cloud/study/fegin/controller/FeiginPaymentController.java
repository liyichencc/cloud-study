package com.cloud.study.fegin.controller;


import com.cloud.study.entities.CommonResult;
import com.cloud.study.entities.Payment;
import com.cloud.study.fegin.service.payment.FeiginPaymentService;
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
}
