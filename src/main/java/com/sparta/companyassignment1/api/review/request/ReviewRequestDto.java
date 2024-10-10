package com.sparta.companyassignment1.api.review.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReviewRequestDto {
    private Long productId;
    private Integer cursor;
    private Integer size;

}
