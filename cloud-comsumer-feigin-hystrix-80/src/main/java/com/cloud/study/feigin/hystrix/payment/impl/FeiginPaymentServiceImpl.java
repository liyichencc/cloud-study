package com.cloud.study.feigin.hystrix.payment.impl;

import com.cloud.study.entities.CommonResult;
import com.cloud.study.entities.Payment;
import com.cloud.study.feigin.hystrix.payment.FeiginPaymentService;
import org.springframework.stereotype.Component;

@Component
public class FeiginPaymentServiceImpl implements FeiginPaymentService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(500,"接口实现总兜底.------getPaymentById");
    }

    @Override
    public String getTimeoutService (Long id) {
        return  "接口实现总兜底.------getTimeoutService";
    }

    @Override
    public String getOkService(Long id) {
        return "接口实现总兜底.------getOkService";
    }
}
