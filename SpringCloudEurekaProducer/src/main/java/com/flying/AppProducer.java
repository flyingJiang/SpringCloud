package com.flying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 访问地址http://localhost:8000/
 */
@SpringBootApplication
@EnableEurekaClient
public class AppProducer {
    public static void main(String[] args) {
        SpringApplication.run(AppProducer.class, args);
    }
}
