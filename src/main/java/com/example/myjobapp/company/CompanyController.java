package com.example.myjobapp.company;

import com.example.myjobapp.job.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany) {
        boolean isUpdated = companyService.updateCompany(updatedCompany, id);
        if (isUpdated) {
            return ResponseEntity.ok("Company updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("congratulations! Company added successfully!", HttpStatus.CREATED) ;
    }

    @GetMapping
    public ResponseEntity <List<Company>> findAll(){

        return  ResponseEntity.ok(companyService.getAllCompany());
    }
}
