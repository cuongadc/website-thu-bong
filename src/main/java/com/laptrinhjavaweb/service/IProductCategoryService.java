package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ProductCategoryDTO;

import java.util.List;
import java.util.Map;

public interface IProductCategoryService {
    Map<String, String> getCategories();
    List<ProductCategoryDTO> findAll();
    ProductCategoryDTO findById(long id);
    ProductCategoryDTO findByCode(String code);
    ProductCategoryDTO insert(ProductCategoryDTO productCategoryDTO);
    ProductCategoryDTO update(ProductCategoryDTO productCategoryDTO);
    void deleteProductCategory(long[] ids);
}
