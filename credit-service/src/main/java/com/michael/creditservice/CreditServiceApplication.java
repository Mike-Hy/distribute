package com.michael.creditservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.michael")
public class CreditServiceApplication {

        public static void main(String[] args) {
                SpringApplication.run(CreditServiceApplication.class, args);
        }

}
