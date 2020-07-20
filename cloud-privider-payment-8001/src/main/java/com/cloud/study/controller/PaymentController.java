package com.cloud.study.controller;

import com.cloud.study.entities.Payment;
import com.cloud.study.service.PaymentService;
import com.cloud.study.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/insert")
    public CommonResult insert(@RequestBody  Payment payment) {
        int status = paymentService.save(payment);
        log.info("-----插入结果----" + status);
        if (status > 0) {
            return new CommonResult(200,"插入成功",null);
        } else {
            return new CommonResult(500,"插入失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult get( @PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("-----查询结果----" + paymentById);
        if (paymentById != null ) {
            return new CommonResult(200,"查询成功",paymentById);
        } else {
            return new CommonResult(500,"没有对应的记录",null);
        }
    }
}
