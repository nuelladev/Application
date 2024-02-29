package com.example.myjobapp.job;

import java.util.List;

public interface JobService {
  List<Job> findAll();
  void createJob();

}
