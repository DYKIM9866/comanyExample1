package com.sparta.companyassignment1.domain.product.repository;

import com.sparta.companyassignment1.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
