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
    public ResponseEntity <List<Job>> findAll(){

        return  ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping("/jobs")
    public ResponseEntity<String> createJobs(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("congratulations! Job added successfully!", HttpStatus.CREATED) ;
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
