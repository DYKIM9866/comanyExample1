package com.sparta.companyassignment1.api.review.response;

import com.sparta.companyassignment1.domain.review.Review;
import lombok.RequiredArgsConstructor;

import java.util.List;

public record ReviewResponseDto(Integer totalCount,
                                Float score,
                                Integer cursor,
                                List<ReviewDto> reviews) {

}
