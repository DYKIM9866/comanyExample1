package com.sparta.companyassignment1.domain.review;

import com.sparta.companyassignment1.api.request.ReviewRequestDto;
import com.sparta.companyassignment1.api.response.ReviewDto;
import com.sparta.companyassignment1.api.response.ReviewResponseDto;
import com.sparta.companyassignment1.domain.product.Product;
import com.sparta.companyassignment1.domain.product.repository.ProductRepository;
import com.sparta.companyassignment1.domain.review.repository.ReviewRepository;
import com.sparta.companyassignment1.util.ImageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewResponseDto listRecently(Long productId, Long cursor, Integer size){
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("해당 상품이 존재 하지 않습니다."));

        PageRequest pageRequest = PageRequest.of(0,size, Sort.by("createdAt").descending());
        List<Review> reviews = reviewRepository.findByProductIdAndIdLessThanOrderByCreatedAtDesc(productId,cursor, pageRequest);

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

    @Transactional
    public void createReview(Long productId, ReviewRequestDto reviewRequestDto, MultipartFile image) throws IOException {
        //상품 조회
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("해당 상품이 존재하지 않습니다."));

        //이미지 저장
        ImageHandler imageHandler = new ImageHandler();
        String saveFile = imageHandler.save(image);

        //request -> Entity
        Review review = Review.builder()
                .productId(productId)
                .userId(reviewRequestDto.getUserId())
                .score(reviewRequestDto.getScore())
                .content(reviewRequestDto.getContent())
                .imageUrl(saveFile)
                .build();

        //저장
        reviewRepository.save(review);

        float sumScore = reviewRepository.sumScoreByProductId(productId);
        float newScore = sumScore /(product.getReviewCount()+1);

        //상품 리뷰 개수와 score 업데이트
        product.update(product.getReviewCount() + 1, newScore);
    }
}
