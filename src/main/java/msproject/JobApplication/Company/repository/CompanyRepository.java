package msproject.JobApplication.Company.repository;

import msproject.JobApplication.Company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
