package com.example.limitservice.controller;

import com.example.limitservice.configuration.LimitConfiguration;
import com.example.limitservice.domain.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final LimitConfiguration limitConfiguration;

    @Autowired
    public LimitsController(LimitConfiguration limitConfiguration) {
        this.limitConfiguration = limitConfiguration;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits() {

        return new Limits(limitConfiguration.getMinimum(), limitConfiguration.getMaximum());
    }
}
