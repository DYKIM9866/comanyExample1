package com.sparta.companyassignment1.api.review;

import com.sparta.companyassignment1.api.review.request.ReviewRequestDto;
import com.sparta.companyassignment1.api.review.response.ReviewResponseDto;
import com.sparta.companyassignment1.api.usecase.ReviewCreateUseCase;
import com.sparta.companyassignment1.api.usecase.ReviewListUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/{productId}/reviews")
public class ReviewController {

    private ReviewListUseCase reviewListUseCase;
    private ReviewCreateUseCase reviewCreateUseCase;

    @GetMapping
    public ReviewResponseDto getReviews(@ModelAttribute ReviewRequestDto reviewRequestDto){
        return reviewListUseCase.listRecently(reviewRequestDto);
    }

    @PostMapping
    public void createReview(@PathVariable long productId){
        reviewCreateUseCase.createReview(productId);
    }

}
