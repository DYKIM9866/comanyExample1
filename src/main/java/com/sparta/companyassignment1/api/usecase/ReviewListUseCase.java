package com.sparta.companyassignment1.api.usecase;

import com.sparta.companyassignment1.api.review.request.ReviewRequestDto;
import com.sparta.companyassignment1.api.review.response.ReviewDto;
import com.sparta.companyassignment1.api.review.response.ReviewResponseDto;
import com.sparta.companyassignment1.domain.review.component.ReviewManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReviewListUseCase {

    private final ReviewManager reviewManager;

    public ReviewResponseDto listRecently(ReviewRequestDto reviewRequestDto){
        //
        List<ReviewDto> reviewDtos = reviewManager.reviewListRecently(reviewRequestDto.productId())
                .stream().map(ReviewDto::new).toList();

        int size = reviewDtos.size();
        double score = reviewDtos.stream()
                .mapToDouble(ReviewDto::score)
                .sum();
        int cursor = reviewRequestDto.cursor();

        return new ReviewResponseDto(size, (float) score, cursor, reviewDtos);
    }
}
