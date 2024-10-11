package com.sparta.companyassignment1;

import com.sparta.companyassignment1.domain.review.Review;
import com.sparta.companyassignment1.domain.review.ReviewService;
import com.sparta.companyassignment1.domain.review.repository.ReviewRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ReviewCreateTest {

    @Autowired
    ReviewService reviewService;
    @Autowired
    ReviewRepository reviewRepository;

    @Test
    @Transactional
    @DisplayName("이미지 없는 리뷰 등록")
    void createWithoutImage(){

        Review review = Review.builder()
                .productId(1l)
                .userId(1l)
                .score(3.0f)
                .content("짱짱")
                .build();
    }
}
