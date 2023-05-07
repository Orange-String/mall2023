package com.ddq.ddqmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.ddq.ddqmall.product.dao")
public class DdqmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdqmallProductApplication.class, args);
    }

}
