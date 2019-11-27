package com.flying.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

public class OrderApiController {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    // 订单服务调用会员服务
    @RequestMapping("/getOrder")
    public String getOrder() {
        // 有两种方式，一种是采用服务别名方式调用，另一种是直接调用 使用别名去注册中心上获取对应的服务调用地址
        String serviceUrl = getServiceUrl("consul-member") + "/getMember";
        String result = restTemplate.getForObject(serviceUrl, String.class);
        System.out.println("订单服务调用会员服务result:" + result);
        return result;
    }

    public String getServiceUrl(String name) {
        List<ServiceInstance> list = discoveryClient.getInstances(name);
        if (list != null && !list.isEmpty()) {
            return list.get(0).getUri().toString();
        }
        return null;
    }

    @RequestMapping("/getServiceUrl")
    public List<String> getServiceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("zk-member");
        List<String> services = new ArrayList<>();
        for (ServiceInstance serviceInstance : list) {
            if (serviceInstance != null) {
                services.add(serviceInstance.getUri().toString());
            }
        }
        return services;
    }


}
