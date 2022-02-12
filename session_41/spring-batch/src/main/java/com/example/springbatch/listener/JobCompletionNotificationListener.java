package com.example.springbatch.listener;

import com.example.springbatch.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private final UserRepository userRepository;

    public JobCompletionNotificationListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

            userRepository.findAll().forEach(user -> log.info("found" + user + " in db"));
        }
    }
}
