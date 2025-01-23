package msproject.JobApplication.Review.controller;

import msproject.JobApplication.Review.entity.Review;
import msproject.JobApplication.Review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    //
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
    //
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review){
      boolean isReviewSaved =  reviewService.addReview(companyId,review);
      if(isReviewSaved){
          return new ResponseEntity<>("Review added successfully",HttpStatus.OK);
      }else{
          return new ResponseEntity<>("Review not saved",HttpStatus.NOT_FOUND);
      }

    }

}
