package com.cloud.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.study.entities.CommonResult;
import com.cloud.study.entities.Payment;

public class MyHandler {

    public static CommonResult myhandler1(BlockException exception) {
        return new CommonResult(200, "myhandler1-----", new Payment(2020L, "serial001"));
    }

    public static CommonResult myhandler2(BlockException exception) {
        return new CommonResult(200, "myhandler2-----", new Payment(2020L, "serial001"));
    }
}
