package com.cloud.study.provider.controller;

import com.cloud.study.service.PaymentService;
import com.cloud.study.entities.CommonResult;
import com.cloud.study.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;
    @PostMapping("/payment/insert")
    public CommonResult insert(@RequestBody Payment payment) {
        int status = paymentService.save(payment);
        log.info("-----插入结果----" + status);
        if (status > 0) {
            return new CommonResult(200,"插入成功,"+port,null);
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
}
