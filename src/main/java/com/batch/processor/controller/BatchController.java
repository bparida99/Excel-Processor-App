package com.batch.processor.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobs")
public class BatchController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    @GetMapping("/processCSV")
    public ResponseEntity<String> processCSV(){
        JobParameters jobParameters = new JobParametersBuilder().
                addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(job,jobParameters);
            return new ResponseEntity<>("CSV processing completed successfully!", HttpStatus.OK) ;
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }
}
