package com.ddq.ddqmall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DdqmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdqmallCouponApplication.class, args);
    }

}
