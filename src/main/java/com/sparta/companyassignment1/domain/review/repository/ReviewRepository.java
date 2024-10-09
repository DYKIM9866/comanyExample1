package com.sparta.companyassignment1.domain.review.repository;

import com.sparta.companyassignment1.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByProductIdOrderByCreatedAtDesc(Long productId);
}
