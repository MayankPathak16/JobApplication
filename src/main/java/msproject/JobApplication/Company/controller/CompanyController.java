package msproject.JobApplication.Company.controller;

import msproject.JobApplication.Company.entity.Company;
import msproject.JobApplication.Company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    //Method 01: Get All companies
    @GetMapping("/allCompanies")
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    //Method 02: Get company by id
    @GetMapping("/findCompany/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable("id") Long id){
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    //Method 03: Create company
    @PostMapping("/addCompany")
    public ResponseEntity<Company> saveCompany(Company company){
        Company savedCompany = companyService.createCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompany);
    }

    //Method 04: Update the company
    @PutMapping("/updateCompany")
    public ResponseEntity<Company> updateCompany(Company company,Long id){
        return ResponseEntity.ok(companyService.updateCompany(company,id));
    }
}
