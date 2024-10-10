package com.sparta.companyassignment1.api.review;

import com.sparta.companyassignment1.api.review.request.ReviewRequestDto;
import com.sparta.companyassignment1.api.review.response.ReviewResponseDto;
import com.sparta.companyassignment1.domain.review.ReviewService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public String createReview(@PathVariable Long productId
            , @RequestPart("reviewRequest") ReviewRequestDto reviewRequestDto
            , @RequestPart(required = false) MultipartFile image) throws IOException {
        reviewService.create(productId, reviewRequestDto, image);
        return "redirect:/";
    }

}
