package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
    ProductCategoryEntity findOneByCode(String code);
}
