package com.sparta.companyassignment1.api.controller;

import com.sparta.companyassignment1.api.request.ReviewRequestDto;
import com.sparta.companyassignment1.api.response.ReviewResponseDto;
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
    public ReviewResponseDto getReviews(Long productId
            , Long cursor
            , @RequestParam(defaultValue = "10") Integer size){
        return reviewService.listRecently(productId, cursor, size);
    }

    @PostMapping
    public String createReview(@PathVariable Long productId
            , @RequestPart("reviewRequest") ReviewRequestDto reviewRequestDto
            , @RequestPart(required = false) MultipartFile image) throws IOException {
        reviewService.createReview(productId, reviewRequestDto, image);
        return "redirect:/";
    }

}
