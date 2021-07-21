package com.example.springcloud.controller;

import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @auther xiaolh
 * @create 2021-7-17
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_SERVER_NAME = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/create")
    public CommonResult create(Payment payment) throws Exception{
        return restTemplate.getForObject(PAYMENT_URL + "/payment/create?serial=" + payment.getSerial(),CommonResult.class);
    }

    @GetMapping("/get/{paymentId}")
    public CommonResult getPaymentById(@PathVariable("paymentId") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

    @GetMapping("/index")
    public CommonResult index(){
        return restTemplate.getForObject(PAYMENT_SERVER_NAME + "/payment/index",CommonResult.class);
    }

    @GetMapping("/discovery")
    public CommonResult discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element: "+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return CommonResult.success(discoveryClient);
    }

}
