package com.sparta.companyassignment1.domain.review.component;

import com.sparta.companyassignment1.domain.review.Review;
import com.sparta.companyassignment1.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReviewManager {

    private final ReviewRepository reviewRepository;

    public List<Review> reviewListRecently(Long productId){
        return reviewRepository.findAllByProductIdOrderByCreatedAtDesc(productId);
    }
}
