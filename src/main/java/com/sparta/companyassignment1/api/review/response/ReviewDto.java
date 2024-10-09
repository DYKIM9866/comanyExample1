package com.sparta.companyassignment1.api.review.response;

import com.sparta.companyassignment1.domain.review.Review;

public record ReviewDto(Long id,
                        Long userId,
                        Float score,
                        String content,
                        String createdAt) {
    public ReviewDto{
    }

    public ReviewDto(Review review){
        this(review.getId()
                , review.getUserId()
                ,review.getScore()
                ,review.getContent()
                ,review.getCreatedAt().toString());
    }
}
