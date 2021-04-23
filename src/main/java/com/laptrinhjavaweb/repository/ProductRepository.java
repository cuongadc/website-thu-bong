package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Page<ProductEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    long countByNameContainingIgnoreCase(String name);
    List<ProductEntity> findByProductCategory_Code(String code);
    List<ProductEntity> findByProductHot(Integer code);
}
