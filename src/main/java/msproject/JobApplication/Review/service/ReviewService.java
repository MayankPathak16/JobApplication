package msproject.JobApplication.Review.service;

import msproject.JobApplication.Review.entity.Review;

import java.util.List;

public interface ReviewService {
    /**
     * GET/companies/{companyId}/reviews
     * POST/companies/{companyId}/reviews
     * GET/companies/{companyId}/reviews/{reviewId}
     * PUT/companies/{companyId}/reviews/{reviewId}
     * DELETE/companies/{companyId}/reviews/{reviewId}
     */
    //-----------------------------------------------------------------------
    /**
     * Method 01: We need to find all review of company by company id
     */
    List<Review> getAllReviews(Long companyId);
    /**
     *Method 02: Add a review
     */
    boolean addReview(Long companyId, Review review);
    /**
     * Method 03:
     */
    Review getReview(Long companyId,Long reviewId);
    /**
     * Method 04:
     */
    boolean updateReview(Long companyId,Long reviewId,Review review);
    /**
     * Method 05:
     */
    boolean deleteReview(Long companyId,Long reviewId);
}
