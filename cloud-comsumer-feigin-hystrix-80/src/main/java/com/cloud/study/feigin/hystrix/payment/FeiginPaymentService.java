package com.cloud.study.feigin.hystrix.payment;

import com.cloud.study.entities.CommonResult;
import com.cloud.study.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service-hystrix")
public interface FeiginPaymentService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("payment/hystrix/timeout/{id}")
    String getTimeoutService(@PathVariable("id") Long id);

    @GetMapping("payment/hystrix/ok/{id}")
    String getOkService(@PathVariable("id") Long id);
}
