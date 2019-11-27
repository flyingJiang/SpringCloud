package com.flying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class AppZKC {
    public static void main(String[] args) {
        SpringApplication.run(AppZKC.class,  args);
    }
}
