package com.sparta.companyassignment1.api.response;

import com.sparta.companyassignment1.domain.review.Review;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewDto{
    private Long id;
    private Long userId;
    private Float score;
    private String content;
    private String imageUrl;
    private LocalDateTime createdAt;

    public ReviewDto(Review review){
        this.id = review.getId();
        this.userId = review.getUserId();
        this.score = review.getScore();
        this.content = review.getContent();
        this.imageUrl = review.getImageUrl();
        this.createdAt = review.getCreatedAt();
    }
}
