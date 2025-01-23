package msproject.JobApplication.Review.repository;

import msproject.JobApplication.Review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    //If there is not any pre method in jpaRepo then we can create one
    //Jpa will handle this on runtime
    List<Review> findByCompanyId(Long companyId);
}
