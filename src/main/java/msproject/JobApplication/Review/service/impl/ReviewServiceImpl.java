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

    /**
     * Method 03:
     *
     * @param companyId
     * @param reviewId
     */
    @Override
    public Review getReview(Long companyId, Long reviewId) {
       List<Review> reviews =  reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).
                findFirst().orElse(null);

    }

    /**
     * Method 04:
     *
     * @param companyId
     * @param reviewId
     * @param review
     */
    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getCompanyById(companyId)!=null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Method 05:
     *
     * @param companyId
     * @param reviewId
     */
    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) !=null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(company,companyId);
            reviewRepository.deleteById(reviewId);
            return true;

        }
        return false;
    }
}
