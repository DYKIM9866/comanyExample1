package com.sparta.companyassignment1.api.review.response;

import java.util.List;

public class ReviewResponseDto {
    private Integer totalCount;
    private Float score;
    private Integer cursor;
    private List<ReviewDto> reviews;

    public ReviewResponseDto(Integer totalCount, Float score, Integer cursor, List<ReviewDto> reviews) {
        this.totalCount = totalCount;
        this.score = score;
        this.cursor = cursor;
        this.reviews = reviews;
    }
}
