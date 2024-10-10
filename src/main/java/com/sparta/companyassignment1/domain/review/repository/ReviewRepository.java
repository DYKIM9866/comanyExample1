package com.sparta.companyassignment1.domain.review.repository;

import com.sparta.companyassignment1.domain.review.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findTopByProductIdOrderByCreatedAtDesc(Long productId, Pageable pageable);

    List<Review> findByProductIdAndIdLessThanOrderByCreatedAtDesc(Long productId, Long cursor, Pageable pageable);

    @Query("SELECT sum(r.score) FROM Review r WHERE r.productId = :productId")
    Float sumScoreByProductId(Long productId);
}