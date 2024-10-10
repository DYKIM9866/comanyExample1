package com.sparta.companyassignment1.domain.review;

import com.sparta.companyassignment1.api.review.request.ReviewRequestDto;
import com.sparta.companyassignment1.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "review")
@NoArgsConstructor
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "productId", nullable = false)
    private Long productId;
    @Column(name = "userId", nullable = false)
    private Long userId;
    @Column(name = "score", nullable = false)
    private Float score;
    @Column(name = "content", nullable = false, length = 1000)
    private String content;
    @Column(name = "imageUrl")
    private String imageUrl;

    @Builder
    public Review(Long productId, Long userId, Float score, String content, String imageUrl) {
        this.productId = productId;
        this.userId = userId;
        this.score = score;
        this.content = content;
        this.imageUrl = imageUrl;
    }
}
