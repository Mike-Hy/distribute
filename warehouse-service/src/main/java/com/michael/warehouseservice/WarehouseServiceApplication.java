package com.michael.warehouseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.michael")
public class WarehouseServiceApplication {

        public static void main(String[] args) {
                SpringApplication.run(WarehouseServiceApplication.class, args);
        }

}
