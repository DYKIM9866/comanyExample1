package com.sparta.companyassignment1.api.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReviewRequestDto {
    private Long userId;
    private Float score;
    private String content;

}
