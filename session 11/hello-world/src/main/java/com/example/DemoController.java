package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("/demo")
    public String demo() {

        log.info("demo method called");

        return "Hello Spring Boot";
    }


}
