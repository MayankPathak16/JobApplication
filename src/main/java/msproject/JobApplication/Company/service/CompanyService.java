package msproject.JobApplication.Company.service;

import msproject.JobApplication.Company.entity.Company;

import java.util.List;

public interface CompanyService {
    /**
     * Method 01: Get All Companies
     */
    List<Company> getAllCompanies();

    /**
     * Method 02: Get Company By Id
     */
    Company getCompanyById(Long id);
    /**
     * Method 03: Create Company
     */
    Company createCompany(Company company);
    /**
     * Method 04: Update the company
     */
    Company updateCompany(Company company, Long id);
}
