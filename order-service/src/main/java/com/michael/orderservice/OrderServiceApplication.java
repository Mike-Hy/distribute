package com.michael.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.michael.orderservice")
@EnableEurekaClient
@EnableFeignClients
public class OrderServiceApplication {

        public static void main(String[] args) {
                SpringApplication.run(OrderServiceApplication.class, args);
        }

}