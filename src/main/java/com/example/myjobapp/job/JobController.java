package com.example.myjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class JobController {
    private JobService jobService;
    public JobController(JobService jobservice) {
        this.jobService = jobservice;
    }

    @GetMapping("/jobs")
    public List<Job>findAll(){

        return jobService.findAll();
    }
    @PostMapping("/jobs")
    public String createJobs(@RequestBody Job job){
        jobService.createJob(job);
        return "congratulations! Job added successfully!";
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
