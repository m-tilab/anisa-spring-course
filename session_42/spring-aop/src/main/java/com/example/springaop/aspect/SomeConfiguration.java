package com.example.springaop.aspect;

import com.example.springaop.repository.FeedbackRepository;
import com.example.springaop.service.FeedbackService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Configuration
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class SomeConfiguration {

    private final FeedbackRepository feedbackRepository;

    public SomeConfiguration(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Bean
    public FeedbackService logicUnderWeaving() {
        return new FeedbackService(feedbackRepository);
    }

}