package msproject.JobApplication.Review.repository;

import msproject.JobApplication.Review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
