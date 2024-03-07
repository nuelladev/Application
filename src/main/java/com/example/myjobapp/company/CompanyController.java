package com.example.myjobapp.company;


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

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteCompanyById(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompanyById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Company successfully deleted!",HttpStatus.OK );
        } else {
            return new ResponseEntity<>("Error! Company was not found!", HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Company>getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
}
