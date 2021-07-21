package com.example.springcloud.controller;

import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther xiaolh
 * @create 2021-7-17
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://localhost:8001";

    @GetMapping("/create")
    public CommonResult create(Payment payment) throws Exception{
        return restTemplate.getForObject(PAYMENT_URL + "/payment/create?serial=" + payment.getSerial(),CommonResult.class);
    }

    @GetMapping("/get/{paymentId}")
    public CommonResult getPaymentById(@PathVariable("paymentId") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

}
