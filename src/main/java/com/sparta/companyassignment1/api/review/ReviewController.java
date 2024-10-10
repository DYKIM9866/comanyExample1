package com.sparta.companyassignment1.api.review;

import com.sparta.companyassignment1.api.review.response.ReviewResponseDto;
import com.sparta.companyassignment1.domain.review.ReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/{productId}/reviews")
public class ReviewController {

    private static final int DEFAULT_SIZE = 10;

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ReviewResponseDto getReviews(Long productId, Long cursor, Integer size){
        if(size == null) size = DEFAULT_SIZE;
        return reviewService.listRecently(productId, cursor, size);
    }

    @PostMapping
    public void createReview(@PathVariable long productId){

    }

}
