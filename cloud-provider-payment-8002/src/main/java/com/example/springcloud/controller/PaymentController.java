package com.example.springcloud.controller;

import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther xiaolh
 * @create 2021-7-17
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/create")
    public CommonResult create(Payment payment){
        int success = paymentService.create(payment);
        if (success == 1){
            return CommonResult.success(null);
        }else {
            return CommonResult.fail("E001","操作失败！");
        }
    }

    @GetMapping("/get/{paymentId}")
    public CommonResult getPaymentById(@PathVariable("paymentId") Long id){
        return CommonResult.success(paymentService.getPaymentById(id));
    }

    @GetMapping("/index")
    public CommonResult index(){
        return CommonResult.success(serverPort);
    }

}
