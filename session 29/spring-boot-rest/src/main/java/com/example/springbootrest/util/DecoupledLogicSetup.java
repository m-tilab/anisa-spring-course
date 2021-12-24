package com.example.springbootrest.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DecoupledLogicSetup {

    private final SpringResourceTemplateResolver springResourceTemplateResolver;

    public DecoupledLogicSetup(SpringResourceTemplateResolver springResourceTemplateResolver) {
        this.springResourceTemplateResolver = springResourceTemplateResolver;
    }

    @PostConstruct
    public void init() {

        this.springResourceTemplateResolver.setUseDecoupledLogic(true);

        log.info("Decouple Template logic enabled");
    }
}
