package com.example.myjobapp.company;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List getAllCompany() {
        return companyRepository.findAll();
    }
}
