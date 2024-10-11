package com.sparta.companyassignment1.api.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ReviewResponseDto {
    private Long totalCount;
    private Float score;
    private Long cursor;
    private List<ReviewDto> reviews;

    public ReviewResponseDto(Long totalCount, Float score, Long cursor, List<ReviewDto> reviews) {
        this.totalCount = totalCount;
        this.score = score;
        this.cursor = cursor;
        this.reviews = reviews;
    }
}
