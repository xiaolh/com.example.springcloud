package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther xiaolh
 * @create 2021-7-14
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain.class,args);
    }

}
