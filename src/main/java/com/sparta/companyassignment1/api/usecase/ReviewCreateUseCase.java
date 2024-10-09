package com.sparta.companyassignment1.api.usecase;

import com.sparta.companyassignment1.domain.review.component.ReviewManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReviewCreateUseCase {

    private final ReviewManager reviewManager;

    public void createReview(long productId) {
        reviewManager.
    }
}
