package com.example.springcloud.service;

import com.example.springcloud.entity.Payment;

/**
 * @auther xiaolh
 * @create 2021-7-17
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
