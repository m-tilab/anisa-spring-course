package com.example.springaop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class FeedbackRepository {

    public String retrieveFeedBack() {

        return "feedback";
    }

}
