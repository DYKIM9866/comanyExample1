package com.sparta.companyassignment1.api.review.request;

public record ReviewRequestDto(Long productId,
                               Integer cursor,
                               Integer size){

}
