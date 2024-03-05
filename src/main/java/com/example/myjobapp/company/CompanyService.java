package com.example.myjobapp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();
    boolean updateCompany(Company updatedCompany, Long id);
}
