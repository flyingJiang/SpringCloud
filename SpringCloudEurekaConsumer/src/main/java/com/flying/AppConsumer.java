package com.flying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class AppConsumer {
    public static void main(String[] args) {
        SpringApplication.run(AppConsumer.class, args);
    }

    // 如果使用rest方式以别名方式进行调用,依赖ribbon负载均衡器 @LoadBalanced
    // @LoadBalanced就能让这个RestTemplate在请求时拥有客户端负载均衡的能力
    // 解决RestTemplate 找不到原因 应该把restTemplate注册SpringBoot容器中 @bean
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
