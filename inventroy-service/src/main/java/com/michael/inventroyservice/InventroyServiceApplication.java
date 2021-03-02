package com.michael.inventroyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableEurekaClient
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "com.michael")
public class InventroyServiceApplication {

        public static void main(String[] args) {
                SpringApplication.run(InventroyServiceApplication.class, args);
        }

}
