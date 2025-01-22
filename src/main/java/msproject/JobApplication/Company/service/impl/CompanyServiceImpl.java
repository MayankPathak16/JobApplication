package msproject.JobApplication.Company.service.impl;

import msproject.JobApplication.Company.entity.Company;
import msproject.JobApplication.Company.repository.CompanyRepository;
import msproject.JobApplication.Company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    /**
     * Method 01: Get All Companies
     */
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    /**
     * Method 02: Get Company By Id
     *
     * @param id
     */
    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    /**
     * Method 03: Create Company
     *
     * @param company
     */
    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    /**
     * Method 04: Update the company
     *
     * @param company
     */
    @Override
    public Company updateCompany(Company company, Long id) {
        Company existingCompany = companyRepository.findById(id).orElse(null);
        if(existingCompany != null) {
            existingCompany.setId(company.getId());
            existingCompany.setName(company.getName());
            existingCompany.setDescription(company.getDescription());
        }


        return companyRepository.save(existingCompany);
    }

}
