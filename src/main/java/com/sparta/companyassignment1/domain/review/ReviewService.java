package com.sparta.companyassignment1.domain.review;

import com.sparta.companyassignment1.api.review.response.ReviewDto;
import com.sparta.companyassignment1.api.review.response.ReviewResponseDto;
import com.sparta.companyassignment1.domain.product.Product;
import com.sparta.companyassignment1.domain.product.repository.ProductRepository;
import com.sparta.companyassignment1.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewResponseDto listRecently(Long productId, Long cursor, Integer size){
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException());

        List<Review> reviews;

        PageRequest pageRequest = PageRequest.of(0,size, Sort.by("createdAt").descending());

        if(cursor == null){
            reviews = reviewRepository.findTopByProductIdOrderByCreatedAtDesc(productId, pageRequest);
        }else{
            reviews = reviewRepository.findByProductIdAndIdLessThanOrderByCreatedAtDesc(productId,cursor, pageRequest);
        }

        List<ReviewDto> list = reviews.stream().map(ReviewDto::new).toList();

        return new ReviewResponseDto(product.getReviewCount()
                , product.getScore()
                , getNextCursor(reviews)
                , list);
    }

    private Long getNextCursor(List<Review> reviews) {
        if(reviews.isEmpty()){
            return null;
        }
        return reviews.get(reviews.size()-1).getId();
    }

}
