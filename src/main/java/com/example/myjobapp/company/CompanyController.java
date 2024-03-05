package com.example.myjobapp.company;

import com.example.myjobapp.job.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    public List <Company> getAllCompany(){
        return companyService.getAllCompany();
    }
@PutMapping
    public ResponseEntity <String> updateCompany(PathVariable Long id, @RequestBody Company updatedCompany){
        return companyService.company();
    }
}
