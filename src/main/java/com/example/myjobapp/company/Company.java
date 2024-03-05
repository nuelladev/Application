package com.example.myjobapp.company;

import com.example.myjobapp.job.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String description;
    @OneToMany
    private List<Job> jobs;

    public Company(Long id) {
        this.id = id;
    }

    public Company() {
    }

    public Company(Long id, String companyName, String description, List<Job> jobs) {
        this.id = id;
        this.companyName = companyName;
        this.description = description;
        this.jobs = jobs;
    }


}
