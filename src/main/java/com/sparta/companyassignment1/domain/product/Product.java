package com.sparta.companyassignment1.domain.product;

import com.sparta.companyassignment1.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="product")
@NoArgsConstructor
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="reviewCount", nullable = false)
    private Long reviewCount;

    @Column(name="score", nullable = false)
    private Float score;

    public void update(long reviewCount, float reviewScore) {
        this.reviewCount = reviewCount;
        this.score = reviewScore;
    }
}
