package com.microservices.limitservice.controller;

import com.microservices.limitservice.beans.Limits;
import com.microservices.limitservice.configuration.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private LimitsConfiguration limitsConfiguration;

    @GetMapping("/limits")
    public Limits getlimits(){
        return new Limits(limitsConfiguration.getMinimum(),limitsConfiguration.getMaximum());
        //return new Limits(1,1000);
    }
}
