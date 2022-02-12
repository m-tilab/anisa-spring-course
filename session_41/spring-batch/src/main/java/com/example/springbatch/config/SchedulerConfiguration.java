package com.example.springbatch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableScheduling
@Slf4j
public class SchedulerConfiguration {

    private final JobLauncher jobLauncher;

    private final Job job;

    public SchedulerConfiguration(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @Scheduled(fixedDelay = 10000)
    public void scheduleLoadFileTask() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        Map<String, JobParameter> parameterMap = new HashMap<>();
        parameterMap.put("time", new JobParameter(System.currentTimeMillis()));

        JobParameters jobParameters = new JobParameters(parameterMap);

        JobExecution jobExecution = jobLauncher.run(job, jobParameters);

        log.info("jobExecution status:" + jobExecution.getStatus());

        log.info("Batch is Running...");
        while (jobExecution.isRunning()) {

            System.out.println("...");
        }
    }
}
