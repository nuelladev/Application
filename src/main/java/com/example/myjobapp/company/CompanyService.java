package com.example.myjobapp.company;

import com.example.myjobapp.job.Job;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();
    boolean updateCompany(Company updatedCompany, Long id);

    void createCompany(Company company);

    boolean deleteCompany(Company company);
}
