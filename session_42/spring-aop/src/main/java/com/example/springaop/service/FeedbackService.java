package com.example.springaop.service;

import com.example.springaop.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;



    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public String getSomething() {

        callPrivate();

        return feedbackRepository.retrieveFeedBack();
    }

    private void callPrivate() {
        System.out.println("HI");
    }
}
