package com.cloud.study.feigin.hystrix.controller;


import com.cloud.study.entities.CommonResult;
import com.cloud.study.entities.Payment;
import com.cloud.study.feigin.hystrix.payment.FeiginPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "allExceptionMethod")
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



//    @HystrixCommand(fallbackMethod = "getTimeoutService_handler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    @GetMapping("/patment/hystrix/ok/get/{id}")
    @HystrixCommand
    public CommonResult<String> getOkService01(@PathVariable("id") Long id){
//        int a = 10 / 0;
        return new CommonResult<>(200,service.getTimeoutService(id));
    }

    public CommonResult<String> getTimeoutService_handler(@PathVariable("id") Long id){
        return new CommonResult<>(500,"正忙，稍候再试");
    }
    /*
    参数返回还要保持一致
     */
    public CommonResult<String> allExceptionMethod(){
        return new CommonResult<>(500,"全局hystrix异常处理...");
    }

}
