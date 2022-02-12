package com.example.springaop;

import com.example.springaop.service.FeedbackService;
import com.example.springaop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SpringAopApplication.class);

    private final FeedbackService feedbackService;
    private final UserService userService;

    public SpringAopApplication(FeedbackService feedbackService, UserService userService) {
        this.feedbackService = feedbackService;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info(feedbackService.getSomething());
        logger.info(userService.getSomething());

    }
}
