package com.flying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 打开地址127.0.0.1:8200
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEurekaSlave {
    public static void main(String[] args) {
        SpringApplication.run(AppEurekaSlave.class, args);
    }
}
