package com.example.springbatch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/load")
@Slf4j
public class LoadController {

    private final JobLauncher jobLauncher;

    private final Job job;

    public LoadController(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @GetMapping
    public BatchStatus load() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        Map<String, JobParameter> parameterMap = new HashMap<>();
        parameterMap.put("time", new JobParameter(System.currentTimeMillis()));

        JobParameters jobParameters = new JobParameters(parameterMap);

        JobExecution jobExecution = jobLauncher.run(job, jobParameters);

        log.info("jobExecution status:" + jobExecution.getStatus());

        log.info("Batch is Running...");
        while (jobExecution.isRunning()) {

            System.out.println("...");
        }

        return jobExecution.getStatus();
    }
}
