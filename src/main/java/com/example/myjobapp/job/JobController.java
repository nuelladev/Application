package com.example.myjobapp.job;

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
    public Job getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        return job;
    }
}
