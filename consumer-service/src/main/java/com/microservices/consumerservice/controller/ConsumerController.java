package com.microservices.consumerservice.controller;

import com.microservices.consumerservice.configuration.ConsumerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerConfiguration configuration;

    @GetMapping("/consumers")
    public int getConsumers(){
        return configuration.getConsumer();
    }
}
