package com.sparta.companyassignment1.domain.review;

import com.sparta.companyassignment1.domain.BaseTimeEntity;
import jakarta.persistence.*;
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
    private float score;
    @Column(name = "contents", nullable = false, length = 1000)
    private String content;
    @Column(name = "photoUrl")
    private String photoUrl;
}
