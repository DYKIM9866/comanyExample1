package com.sparta.companyassignment1.api.review.response;

import com.sparta.companyassignment1.domain.review.Review;
import lombok.Getter;

@Getter
public class ReviewDto{
    private Long id;
    private Long userId;
    private Float score;
    private String content;
    private String imageUrl;
    private String createdAt;

    public ReviewDto(Review review){
        this.id = review.getId();
        this.userId = review.getUserId();
        this.score = review.getScore();
        this.content = review.getContent();
        this.imageUrl = review.getImageUrl();
        this.createdAt = review.getCreatedAt().toString();
    }
}
