package com.cloud.study.service;

import com.cloud.study.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
