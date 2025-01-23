package msproject.JobApplication.Review.service.impl;

import msproject.JobApplication.Company.entity.Company;
import msproject.JobApplication.Company.service.CompanyService;
import msproject.JobApplication.Review.entity.Review;
import msproject.JobApplication.Review.repository.ReviewRepository;
import msproject.JobApplication.Review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CompanyService companyService;

    /**
     * Method 01: We need to find all review of company by company id
     *
     * @param companyId
     */
    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    /**
     * Method 02: Add a review
     *
     * @param companyId
     * @param review
     */
    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else{
            return false;
        }
    }
}
