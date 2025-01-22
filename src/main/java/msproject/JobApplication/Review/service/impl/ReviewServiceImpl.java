package msproject.JobApplication.Review.service.impl;

import msproject.JobApplication.Review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl {
    @Autowired
    private ReviewRepository reviewRepository;
}
