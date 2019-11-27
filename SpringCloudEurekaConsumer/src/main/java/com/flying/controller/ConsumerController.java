package com.flying.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getIndex")
    public String getIndex(){
        String url = "http://app-producer/getIndex";
        String re = restTemplate.getForObject(url, String.class);
        System.out.println("re = " + re);
        return re;
    }
}
